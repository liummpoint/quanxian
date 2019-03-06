package com.manage.commom.http;

import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.net.ssl.SSLContext;
import java.util.*;

public class HttpClientUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpClientUtil.class);

    /**
     * POST请求
     *
     * @param url     请求地址
     * @param params  请求参数
     * @param headers 请求头信息
     * @return
     */
    public static String post(String url, List<NameValuePair> params, Map<String, String> headers) {

        CloseableHttpClient client = null;
        CloseableHttpResponse response = null;
        String message = "";
        try {
            boolean safe = false;
            if (url.toLowerCase().startsWith("https")) {
                safe = true;
            }
            client = getHttpClient(safe);
            HttpPost post = new HttpPost(url);
            if (!CollectionUtils.isEmpty(headers)) {
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    post.setHeader(entry.getKey(), entry.getValue());
                }
            }
            if (null != params) {
                UrlEncodedFormEntity form = new UrlEncodedFormEntity(params, "UTF-8");
                post.setEntity(form);
            }
            response = client.execute(post);
            HttpEntity entity = response.getEntity();
            if (null != entity) {
                message = EntityUtils.toString(entity, "UTF-8");
                EntityUtils.consume(entity);
            }
        } catch (Exception e) {
            LOGGER.error("发起请求调用失败", e);
        } finally {
            CloseUtil.close(response, client);
        }
        return message;

    }

    /**
     * POST请求
     *
     * @param url     请求地址
     * @param params  请求参数
     * @param headers 请求头信息
     * @return
     */
    public static String post(String url, Map<String, Object> params, Map<String, String> headers) {

        CloseableHttpClient client = null;
        CloseableHttpResponse response = null;
        String message = "";
        try {
            boolean safe = false;
            if (url.toLowerCase().startsWith("https")) {
                safe = true;
            }
            client = getHttpClient(safe);
            HttpPost post = new HttpPost(url);
            if (!CollectionUtils.isEmpty(headers)) {
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    post.setHeader(entry.getKey(), entry.getValue());
                }
            }
            if (!CollectionUtils.isEmpty(params)) {
                List<NameValuePair> values = new ArrayList<NameValuePair>();
                for (Map.Entry<String, Object> entry : params.entrySet()) {
                    values.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
                }
                UrlEncodedFormEntity form = new UrlEncodedFormEntity(values, "UTF-8");
                post.setEntity(form);
            }
            response = client.execute(post);
            HttpEntity entity = response.getEntity();
            if (null != entity) {
                message = EntityUtils.toString(entity, "UTF-8");
                EntityUtils.consume(entity);
            }
        } catch (Exception e) {
            LOGGER.error("发起请求调用失败", e);
        } finally {
            CloseUtil.close(response, client);
        }
        return message;

    }

    /**
     * POST请求
     *
     * @param url     请求地址
     * @param params  请求参数
     * @param headers 请求头信息
     * @return
     */
    public static String post(String url, String params, Map<String, String> headers) {

        return post(url, params, headers, "application/json; charset=UTF-8");

    }

    /**
     * POST请求
     *
     * @param url
     * @param params
     * @param headers
     * @param contentType
     * @return
     */
    public static String post(String url, String params, Map<String, String> headers, String contentType) {

        CloseableHttpClient client = null;
        CloseableHttpResponse response = null;
        String message = "";
        try {
            boolean safe = false;
            if (url.toLowerCase().startsWith("https")) {
                safe = true;
            }
            client = getHttpClient(safe);
            HttpPost post = new HttpPost(url);
            if (!CollectionUtils.isEmpty(headers)) {
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    post.setHeader(entry.getKey(), entry.getValue());
                }
            }
            if (!StringUtils.isEmpty(params)) {
                StringEntity form = new StringEntity(params, "UTF-8");
                form.setContentType(contentType);
                post.setEntity(form);
            }
            response = client.execute(post);
            HttpEntity entity = response.getEntity();
            if (null != entity) {
                message = EntityUtils.toString(entity, "UTF-8");
                EntityUtils.consume(entity);
            }
        } catch (Exception e) {
            LOGGER.error("发起请求调用失败", e);
        } finally {
            CloseUtil.close(response, client);

        }
        return message;

    }

    /**
     * GET请求
     *
     * @param url     请求地址
     * @param params  请求参数
     * @param headers 请求头信息
     * @return
     */
    public static String get(String url, List<NameValuePair> params, Map<String, String> headers) {

        CloseableHttpClient client = null;
        CloseableHttpResponse response = null;
        String message = "";
        try {
            boolean safe = false;
            if (url.toLowerCase().startsWith("https")) {
                safe = true;
            }
            client = getHttpClient(safe);
            StringBuffer extra = new StringBuffer("?");
            if (null != params && params.size() > 0) {
                for (NameValuePair param : params) {
                    extra.append(param.getName()).append("=").append(param.getValue()).append("&");
                }
            }
            HttpGet get = new HttpGet(url + extra.substring(0, extra.length() - 1));
            if (!CollectionUtils.isEmpty(headers)) {
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    get.setHeader(entry.getKey(), entry.getValue());
                }
            }
            response = client.execute(get);
            HttpEntity entity = response.getEntity();
            if (null != entity) {
                message = EntityUtils.toString(entity, "UTF-8");
                EntityUtils.consume(entity);
            }
        } catch (Exception e) {
            LOGGER.error("发起请求调用失败", e);
        } finally {
            CloseUtil.close(response, client);
        }
        return message;

    }

    /**
     * 获取HTTPCLIENT
     *
     * @param safe 是否HTTPS安全请求
     * @return
     */
    private static CloseableHttpClient getHttpClient(boolean safe) {

        try {
            if (safe) {
                SSLContext context = SSLContextBuilder.create().loadTrustMaterial(null, (chain, authType) -> true).build();
                SSLConnectionSocketFactory factory = new SSLConnectionSocketFactory(context);
                return HttpClients.custom().setSSLSocketFactory(factory).build();
            }
        } catch (Exception e) {
            LOGGER.error("获取HTTPCLIENT失败", e);
        }
        return HttpClients.createDefault();

    }


    public static String doPost(String url, JSONObject json, String charset,Map<String, String> headers) throws Exception {
        HttpClient httpClient = null;
        HttpPost httpPost = null;
        String result = null;
        try {
            boolean safe = false;
            if (url.toLowerCase().startsWith("https")) {
                safe = true;
            }
            httpClient = getHttpClient(safe);
            httpPost = new HttpPost(url);
            // 设置参数
            StringEntity s = new StringEntity(json.toString(),"UTF-8");
            s.setContentEncoding("UTF-8");
            s.setContentType("application/json");
            httpPost.setEntity(s);
            httpPost.setHeader("Content-Type", "application/json");
            if (headers != null) {
                Set<String> keys = headers.keySet();
                for (Iterator<String> i = keys.iterator(); i.hasNext();) {
                    String key = (String) i.next();
                    httpPost.addHeader(key, headers.get(key));

                }
            }


            HttpResponse response = httpClient.execute(httpPost);
            if (response != null) {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    result = EntityUtils.toString(resEntity, charset);
                }
            }
        } catch (Exception ex) {

            ex.printStackTrace();
        }
        return result;
    }

    /**
     * GET请求
     *      httpGet
     * @param url     请求地址
     * @param params  请求参数
     * @param headers 请求头信息
     * @return
     */
    public static String httpGet(String url) {

        CloseableHttpClient client = null;
        CloseableHttpResponse response = null;
        String message = "";
        try {
            boolean safe = false;
            if (url.toLowerCase().startsWith("https")) {
                safe = true;
            }
            client = getHttpClient(safe);
            HttpGet get = new HttpGet(url);
            response = client.execute(get);
            HttpEntity entity = response.getEntity();
            if (null != entity) {
                message = EntityUtils.toString(entity, "UTF-8");
                EntityUtils.consume(entity);
            }
        } catch (Exception e) {
            LOGGER.error("发起请求调用失败", e);
        } finally {
            CloseUtil.close(response, client);
        }
        return message;

    }
}
