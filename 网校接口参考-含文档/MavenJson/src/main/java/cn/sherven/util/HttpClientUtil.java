package cn.sherven.util;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

import java.util.Map;

public class HttpClientUtil {
    public static String doPost(String url) {
        return doPost(url, null);
    }

    public static String doPost(String url, Map<String, String> param) {

        try {
            HttpClient client = new HttpClient();
            PostMethod method = new PostMethod(url);

            if (param != null) {
                for (Map.Entry<String, String> entry : param.entrySet()) {
                    method.addParameter(entry.getKey(), entry.getValue());
                }
            }


            int i = client.executeMethod(method);
            return new String(method.getResponseBody(), "utf-8");
        } catch (Exception e) {
            return null;
        }
    }
}
