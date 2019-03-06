package com.manage.commom.cipher.rsa;

import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * CreateSecrteKey
 * Description 生成公钥私钥
 * Copyrigth(C),2017,lx86468@126.com.com
 * Date 2017/6/14
 *
 * @author lixiao on 2017/6/14.
 * @version 1.0
 */
public class CreateSecrteKey {
    public class Keys {

    }
    public static final String KEY_ALGORITHM = "RSA";
    //public static final String SIGNATURE_ALGORITHM = "MD5withRSA";
    private static final String PUBLIC_KEY = "RSAPublicKey";
    private static final String PRIVATE_KEY = "RSAPrivateKey";

    //获得公钥
    public static String getPublicKey(Map<String, Object> keyMap) throws Exception {
        //获得map中的公钥对象 转为key对象
        Key key = (Key) keyMap.get(PUBLIC_KEY);
        //byte[] publicKey = key.getEncoded();
        //编码返回字符串
        return encryptBASE64(key.getEncoded());
    }

    //获得私钥
    public static String getPrivateKey(Map<String, Object> keyMap) throws Exception {
        //获得map中的私钥对象 转为key对象
        Key key = (Key) keyMap.get(PRIVATE_KEY);
        //byte[] privateKey = key.getEncoded();
        //编码返回字符串
        return encryptBASE64(key.getEncoded());
    }

    //解码返回byte
    public static byte[] decryptBASE64(String key) throws Exception {
        return (new BASE64Decoder()).decodeBuffer(key);
    }

    //编码返回字符串
    public static String encryptBASE64(byte[] key) throws Exception {
        return (new BASE64Encoder()).encodeBuffer(key);
    }

    //map对象中存放公私钥
    public static Map<String, Object> initKey() throws Exception {
        //获得对象 KeyPairGenerator 参数 RSA 1024个字节
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        keyPairGen.initialize(1024);
        //通过对象 KeyPairGenerator 获取对象KeyPair
        KeyPair keyPair = keyPairGen.generateKeyPair();

        //通过对象 KeyPair 获取RSA公私钥对象RSAPublicKey RSAPrivateKey
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        //公私钥对象存入map中
        Map<String, Object> keyMap = new HashMap<String, Object>(2);
        keyMap.put(PUBLIC_KEY, publicKey);
        keyMap.put(PRIVATE_KEY, privateKey);
        return keyMap;
    }

//    public static void main(String[] args) {
//        Map<String, Object> keyMap;
//        try {
//            keyMap = initKey();
//            String publicKey = getPublicKey(keyMap);
//            System.out.println("测试公钥"+publicKey);
//            String privateKey = getPrivateKey(keyMap);
//            System.out.println("测试私钥"+privateKey);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

/*    public static void main(String[] args) throws Exception {
        String str = "test123李筱";
        String publickey="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDTqFniLrFoZpZAYzkZdF6JoGP4EXDIC4nw454gDSMeWLX6uocSKKYYS4xCZTpui5+OHCLEMn1k5PahNxbbnhjMjkyztZXRndI0AgOkzKdQPRArHoSp3xPhl1hQ+1r1eLO6YKpr5Jga0YGlFgmuyJg2RhlBbJFF660xxkk5DwGziwIDAQAB";
        String privatekey = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBANOoWeIusWhmlkBjORl0XomgY/gRcMgLifDjniANIx5Ytfq6hxIophhLjEJlOm6Ln44cIsQyfWTk9qE3FtueGMyOTLO1ldGd0jQCA6TMp1A9ECsehKnfE+GXWFD7WvV4s7pgqmvkmBrRgaUWCa7ImDZGGUFskUXrrTHGSTkPAbOLAgMBAAECgYBbkLlR4GFfiQH3WPWazX0YjQqyhtkDsfo6/D2sIALRXg9cKNXGRU+Vsxk6oBBnQoAEOqfPuQgGXgdUN0DsQbj3/CzU3j9mKGFMyLFgRbydJ5SkRS1HULT/kxzgU41CHZziYFUmIJY/5zC9vb8IkNsa3NuO/DogxcZfkzoL2UIAAQJBAOta7Sq9JB+bTA3+uxHOj0oGGJLBkj8f4XLz/umB5k0yfDsXaP+/CT/53cMJajcRJKUScHUFtsQAPNy8KgQeigECQQDmOUdPJFcHrp/qyi1r/pQgPfl2zM2ssyGV+hq76QtQyXpFbx/hadKaVlNUL5jLkjtPDe7NRxuUioZOcsYOOsWLAkAlHWavSbqLnXLl9hjMGxXvp3xykEIe4EkuVpoJeum1nNOIgg2V3yt3QlEdc7ujSXnM6lZ/rdH/oMX4TVgW5DYBAkAaaOuzOnn5WaDisDqxrsyTPkjFxgy6CPqLV9uFPuCbbeFm4a6Ijzknl0uL1sHyaF4BXZnNVqDlU1bA3Q23SCqtAkA+qSMc4Xf2CFqcq3aCn9eLKjK6Eag2a5uPgATDyMm61RxzKzF8fCez6HTTArD4Va+JQX4HxyLiQ46huXmIMmQP";
        String encrypt = RSAUtils.encrypt(str, publickey);
        System.out.println("加密后："+encrypt);
        String decrypt = RSAUtils.decrypt(encrypt, privatekey);
        System.out.println("解密后："+decrypt);
    }*/
}