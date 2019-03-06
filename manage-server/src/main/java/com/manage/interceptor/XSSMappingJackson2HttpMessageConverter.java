package com.manage.interceptor;

import java.io.IOException;
import java.lang.reflect.Type;


import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;


import com.fasterxml.jackson.databind.JavaType;

public class XSSMappingJackson2HttpMessageConverter extends MappingJackson2HttpMessageConverter {


   @Override
    public Object read(Type type, Class<?> contextClass,
                       HttpInputMessage inputMessage) throws IOException,
            HttpMessageNotReadableException {
        JavaType javaType = getJavaType(type, contextClass);
        Object obj = readJavaType(javaType, inputMessage);
        //暂不启用不含null序列化
        //super.getObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String json = super.getObjectMapper().writeValueAsString(obj);
        String result = cleanXSS(json.toString());
        Object resultObj = super.getObjectMapper().readValue(result, javaType);
        return resultObj;
    }


    // 这个就是父类的readJavaType方法，由于父类该方法是private的，所以我们copy一个用
    private Object readJavaType(JavaType javaType, HttpInputMessage inputMessage) {
        try {
            return super.getObjectMapper().readValue(inputMessage.getBody(),
                    javaType);
        } catch (IOException ex) {
            throw new HttpMessageNotReadableException("Could not read JSON: "
                    + ex.getMessage(), ex);
        }
    }


    // 重写writeInternal方法，在返回内容前首先进行加密
    @Override
    protected void writeInternal(Object object, HttpOutputMessage outputMessage)
            throws IOException, HttpMessageNotWritableException {
// 使用Jackson的ObjectMapper将Java对象转换成Json String
        String json = super.getObjectMapper().writeValueAsString(object);
        String result = cleanXSS(json.toString());
// 输出
        outputMessage.getBody().write(result.getBytes());
    }


/*   private String cleanXSS(String value) {
       return HtmlUtils.htmlEscape(value);
   }*/

   private String cleanXSS(String value) {
        return value.replace("<", "&lt;")
                .replace(">", "&gt;");
        //return Jsoup.clean(value.toString(), Whitelist.relaxed());
   }

}