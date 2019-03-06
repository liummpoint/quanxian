package com.manage.commom.utils;

import com.alibaba.fastjson.JSON;
import com.manage.commom.cipher.md5.MD5;
import com.manage.commom.cipher.rsa.RSAUtils;
import com.manage.commom.enums.ErrorCode;
import com.manage.commom.exception.CddException;
import com.manage.commom.http.HttpClientUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by 59458 on 2017/5/17.
 */
@Component
@Lazy(false)
public class DataUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataUtil.class);
    public static String privatekey;
    @Value("${private_key}")
    public void setPrivatekey(String privatekey) {
        this.privatekey = privatekey;
    }
    public static String md5Key;
    @Value("${MD5_key}")
    public void setMd5Key(String md5Key) {
        this.md5Key = md5Key;
    }

    public static String publicKey;
    @Value("${public_key}")
    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }


    public static String huashengUrl;
    @Value("${huasheng.url}")
    public void setHuashengUrl(String huashengUrl) { this.huashengUrl = huashengUrl;}

    public static String sendSmsUrl;
    @Value("${send.sms.url}")
    public void setSendSmsUrl(String sendSmsUrl) {
        DataUtil.sendSmsUrl = sendSmsUrl;
    }

    public static String smsMobile;
    @Value("${sms.mobile}")
    public void setSmsMobile(String smsMobile) { this.smsMobile = smsMobile;}

    public static String superAccount;
    @Value("${super.account}")
    public void setSuperAccount(String superAccount) { this.superAccount = superAccount;}

    public static String redEnvelopesAccount;
    @Value("${red.envelopes.account}")
    public void setRedEnvelopesAccount(String redEnvelopesAccount) { this.redEnvelopesAccount = redEnvelopesAccount;}

    public static String superAccountId;
    @Value("${super.account.id}")
    public void setSuperAccountId(String superAccountId) {
        DataUtil.superAccountId = superAccountId;
    }

    public static String fsImageGroup;
    @Value("${fs.image.group}")
    public void setFsImageGroup(String fsImageGroup) {
        DataUtil.fsImageGroup = fsImageGroup;
    }

    public static String fsHttpUrl;
    @Value("${fs.http.url}")
    public void setFsHttpUrl(String fsHttpUrl) {
        DataUtil.fsHttpUrl = fsHttpUrl;
    }


    /**
     * 解密 并转对象
     * @param context
     * @param clazz
     * @return
     * @throws CddException
     */
    public static Object parseStr2Object(String context, Class clazz) throws CddException {
        String str = "";
        try {
            LOGGER.info("解密前信息：" + context);
            str = RSAUtils.decryptByPrivateKey(context, privatekey);
//            str = RSAUtils.decrypt(context, "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAIWuALSzLhgJ0o+09bV91Ha9rq46vQdIucjIFtB9LLI/9oMdxpW7pe6PHy98XlVbw43Cx/WJnG6BNrpoAviiu0BtuCTdOXEVKMihPyXpvyiS5rYZU1hdYh1qElo+/RhuHXaDeoxQKnDDWw5ayZd/e4wdPXvPYW6Edqh+3lWI7lELAgMBAAECgYAXwtsLQ4Ig8bYEpzS5gtk+Fe8ztuscnVewkahEfMtyD56Apc1DliwjYDs51JBr+bijvQiP41rz5XHV5mEI0twXj9qVhNiZo8yY7XQSiS6LbUsi0xW2tydm5bQFWuYCdEw0Kmlv9gYKWfjQeTkug3qbaUn90+Yv+H1AAgu4PAP4OQJBANz87i2DHX0mEv2OSaMNJmr7rB8AnSo/gujgkFVtdeZ3YrBuWusWY4mGYguQ5Q0Am1Mb1t1BhSi+EyDinfgSHoUCQQCa2+2KVARATHIKKmOC/v/aHDgOksYrMv8hjl92M0iNhh0sNqokwQ/AvRU5Atx+t+IAfdTmbtpKLeGS6GTU3y5PAkEAmosn5hwzmzntPfUr+iNQIrEuhd/gCZOw8TtatON/+FS1Z71FR/K4WYzpND14ccdi2JQ3hzQy83M53V2eK8ZAIQJAFRY1dkySd57xOGklO8U1WaHWEEX0LhW3n/4fCZ1aF8tXVZnr+S1A0+HrbePx2l93qtF3mBkoKEmvGa4DbOknCQJAeZqf117w5fn2lxlgCNmrh415gmDcRzm3dfOZVV/SIl6M+e2W+Dg+KwCwQwGuVxpPoJuIl51v7sc3Xa8oIgTUaQ==");
            LOGGER.info("解密后信息：" + str);
            Map<String, Object> stringObjectMap = JsonUtils.parseJSON2Map(str);
            String decrypText = stringObjectMap.get("body").toString();
            String md5Text = MD5.string2MD5(decrypText,md5Key);
//            String md5Text = MD5.string2MD5(decrypText,"cheddd2016");
            if (!stringObjectMap.get("sign").toString().equals(md5Text)) {
                LOGGER.info("签名验证失败---签名前");
                throw new CddException(ErrorCode.BUSSINESS_ERROR_0005);
            }
            return JsonUtils.jsonToObj(decrypText,clazz);
        } catch (Exception e) {
            LOGGER.error("解密失败" , e);
            throw new CddException(ErrorCode.BUSSINESS_ERROR_0001);
        }
    }


    /**
     * 加密
     *
     * @param o
     * @return
     */
    public static String businessEncryption(Object o) throws CddException {
        try {
            //转为json
            String text = JsonUtils.objToJson(o);
            LOGGER.info("加密前---json：" + text);
            //用MD5加签名
            String sign = MD5.string2MD5(text,md5Key);
            Map map = new HashMap();
            map.put("body", text);
            map.put("sign", sign);
            LOGGER.debug("加密签名的值：" + sign);
            LOGGER.debug("加密签名的值：" + publicKey);
            return RSAUtils.encryptByPublicKey(JsonUtils.objToJson(map), publicKey);
        } catch (Exception e) {
            LOGGER.error("加密异常:" , e);
            throw new CddException(ErrorCode.BUSSINESS_ERROR_1000);
        }
    }

    /**
     * 根据key删除redis value
     * @param key
     * @return
     * @throws CddException
     */
    public static int delRedisBykey(String key) throws Exception {
        //调用花生理财删除redis
        Map<String,String> paramMap=new HashMap<>();
        paramMap.put("key",key);
//        String result = HttpClientUtil.post("http://localhost:8080/opr/job/delRedisByKey", JSON.toJSONString(paramMap), null);
        String result = HttpClientUtil.post(DataUtil.huashengUrl+"/opr/job/delRedisByKey", JSON.toJSONString(paramMap), null);
        //取出返回结果 0 代表成功 1代表失败
        Map<String,Object> map= JsonUtils.parseJSON2MapByStep(result);
        String message=map.get("message")==null?"":map.get("message").toString();
        Map<String,Object> param= JsonUtils.parseJSON2MapByStep(message);
        String errorCode=param.get("error_code")==null?"":param.get("error_code").toString();
        //如果删除失败，跑出异常
        if("0".equals(errorCode)){
            return 0 ;
        }
        return 1 ;
    }


//    public static void main(String[] args) {
//        try {
//            delRedisBykey("a");
//        } catch (CddException e) {
//            e.printStackTrace();
//        }
//    }
}
