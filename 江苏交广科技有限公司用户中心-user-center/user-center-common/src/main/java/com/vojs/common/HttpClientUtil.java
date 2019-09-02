package com.vojs.common;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

/**
 * http工具类
 */
@SuppressWarnings("ALL")
public class HttpClientUtil {
    private static Logger logger = LoggerFactory.getLogger("error_log");

    private static HttpParams httpParams;

    /**
     * 最大连接数
     */
    private final static int MAX_TOTAL_CONNECTIONS = 100;

    /**
     * 获取连接的最大等待时间
     */
    private final static int WAIT_TIMEOUT = 10000;

    /**
     * 每个路由最大连接数
     */
    private final static int MAX_ROUTE_CONNECTIONS = 50;

    /**
     * 连接超时时间
     */
    private final static int CONNECT_TIMEOUT = 10000;

    /**
     * 读取超时时间
     */
    private final static int READ_TIMEOUT = 30000;

    static {
        httpParams = new BasicHttpParams();
        // 设置最大连接数
        ConnManagerParams.setMaxTotalConnections(httpParams, MAX_TOTAL_CONNECTIONS);
        // 设置获取连接的最大等待时间
        ConnManagerParams.setTimeout(httpParams, WAIT_TIMEOUT);
        // 设置每个路由最大连接数
        ConnPerRouteBean connPerRoute = new ConnPerRouteBean(MAX_ROUTE_CONNECTIONS);
        ConnManagerParams.setMaxConnectionsPerRoute(httpParams, connPerRoute);
        // 设置连接超时时间
        HttpConnectionParams.setConnectionTimeout(httpParams, CONNECT_TIMEOUT);
        // 设置读取超时时间
        HttpConnectionParams.setSoTimeout(httpParams, READ_TIMEOUT);
        SchemeRegistry registry = new SchemeRegistry();
        registry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        registry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
    }

    public static HttpClient getHttpClient() {
        return new DefaultHttpClient(httpParams);
    }

    /**
     * POST请求数据
     *
     * @param url        请求URL
     * @param requestMap 请求参数
     * @param coding     编码
     * @return
     * @throws Exception
     */
    public static String post(String url, HashMap<String, String> requestMap, String coding) throws IOException {
        Long startTimeMills = System.currentTimeMillis();
        String returnMsg = "";
        HttpClient httpClient = getHttpClient();
        try {
            HttpPost httpPost = new HttpPost(url);
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            Set<Entry<String, String>> entrys = requestMap.entrySet();
            for (Entry<String, String> entry : entrys) {
                nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }

            httpPost.setEntity(new UrlEncodedFormEntity(nvps, coding));
            httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
            httpPost.addHeader("Accept-Language", "zh-cn");

            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            if (httpEntity != null) {
                returnMsg = EntityUtils.toString(httpEntity);
                EntityUtils.consume(httpEntity);
            }
            httpPost.abort();
        } finally {
            httpClient.getConnectionManager().shutdown();
            Long endTimeMills = System.currentTimeMillis();
            Long dotimes = endTimeMills - startTimeMills;
            if (dotimes > 1000) {
                StringBuffer buffer = new StringBuffer();
                buffer.append(dotimes)
                        .append(" Mills! httpclient call times more than 1000Millis, url = ")
                        .append(url)
                        .append(", param = ")
                        .append(requestMap.toString())
                ;
                logger.warn(buffer.toString());
            }
        }
        return returnMsg;
    }

    /**
     * get请求数据
     *
     * @param url        请求URL
     * @param requestMap 请求参数
     * @param coding     请求编码
     * @return
     * @throws Exception
     */
    public static String get(String url, HashMap<String, String> requestMap, String coding) throws IOException {
        Long startTimeMills = System.currentTimeMillis();
        String returnMsg = "";
        HttpClient httpClient = getHttpClient();
        try {
            Set<Entry<String, String>> entrys = requestMap.entrySet();
            StringBuilder params = new StringBuilder();
            boolean first = true;
            for (Entry<String, String> entry : entrys) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (value == null) {
                    value = "";
                }
                if (first) {
                    params.append(key)
                            .append("=")
                            .append(value);
                    first = false;
                } else {
                    params.append("&")
                            .append(key)
                            .append("=")
                            .append(value);
                }
            }
            HttpGet httpGet = new HttpGet(url + "?" + params.toString());
            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            if (httpEntity != null) {
                returnMsg = EntityUtils.toString(httpEntity);
                EntityUtils.consume(httpEntity);
            }
            httpGet.abort();
        } finally {
            httpClient.getConnectionManager().shutdown();
            Long endTimeMills = System.currentTimeMillis();
            Long dotimes = endTimeMills - startTimeMills;
            if (dotimes > 1000) {
                StringBuffer buffer = new StringBuffer();
                buffer.append(dotimes)
                        .append(" Mills! httpclient call times more than 1000Millis, url = ")
                        .append(url)
                        .append(", param = ")
                        .append(requestMap.toString())
                ;
                logger.warn(buffer.toString());
            }
        }
        return returnMsg;
    }


    /**
     * POST请求数据
     *
     * @param url        请求URL
     * @param requestMap 请求参数
     * @param coding     编码
     * @return
     * @throws Exception
     */
    public static String post(String url, JSONObject paramter) throws IOException {
        Long startTimeMills = System.currentTimeMillis();
        String returnMsg = "";
        HttpClient httpClient = getHttpClient();
        try {
            HttpPost httpPost = new HttpPost(url);
            String postBody = paramter.toString();
            httpPost.setHeader("User-Agent", "Mozilla/5.0");
            StringEntity se = new StringEntity(postBody, "UTF-8");

            httpPost.setEntity(se);

            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            if (httpEntity != null) {
                returnMsg = EntityUtils.toString(httpEntity);
                EntityUtils.consume(httpEntity);
            }
            httpPost.abort();
        } finally {
            httpClient.getConnectionManager().shutdown();
            Long endTimeMills = System.currentTimeMillis();
            Long dotimes = endTimeMills - startTimeMills;
            if (dotimes > 1000) {
                StringBuffer buffer = new StringBuffer();
                buffer.append(dotimes)
                        .append(" Mills! httpclient call times more than 1000Millis, url = ")
                        .append(url)
                        .append(", param = ")
                        .append(paramter.toString())
                ;
                logger.warn(buffer.toString());
            }
        }
        return returnMsg;
    }
}
