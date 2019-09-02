/**
 * 
 */
package com.vojs.web.controller;

import com.vojs.bean.UcUser;
import com.vojs.ucenter.client.util.POST;
import com.vojs.ucenter.client.util.PostData;
import net.sf.json.JSONObject;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author junjie
 *
 */
public class HttpUtil {
	private static Logger log = LoggerFactory.getLogger(HttpUtil.class);
	
	public static String post(String uri, UcUser user, String type){
		HttpClient client = new HttpClient();
		log.info("http post url:"+POST.UC_HOST+uri +"\n参数：user："+user+" type:"+type);
		PostMethod method = new PostMethod(POST.UC_HOST+uri);
        try
        {
	        StringRequestEntity requestEntity = new StringRequestEntity(PostData.authData(type, user.toString()));
	        method.setRequestEntity(requestEntity);
	        method.setRequestHeader("Content-type", "application/x-www-form-urlencoded;charset=UTF-8");
            client.executeMethod(method);
            String response = method.getResponseBodyAsString();
            return response;
        }
        catch (HttpException e)
        {
        	log.error("HttpException",e);
        }
        catch (IOException e)
        {
        	log.error("IOException",e);
        }
        return null;
	}

	public static String http(String uri,Object o, String method,String appname) {
        HttpClient client = new HttpClient();
        HttpMethodBase httpMethod = new PostMethod(POST.UC_HOST+uri);

        if (method.equalsIgnoreCase("GET")) {
            httpMethod = new GetMethod(POST.UC_HOST+uri);
        } else if (method.equalsIgnoreCase("PUT")) {
            httpMethod = new PutMethod(POST.UC_HOST+uri);
        } else if (method.equalsIgnoreCase("DELETE")){
            httpMethod = new DeleteMethod(POST.UC_HOST+uri);
        }

        try
        {
            StringRequestEntity requestEntity = new StringRequestEntity(PostData.authData(appname, o.toString()));

            if (method.equalsIgnoreCase("GET")) {
                String value = PostData.authData(appname, o.toString());
                httpMethod = new GetMethod(POST.UC_HOST+uri + "?" + value);
            } else if (method.equalsIgnoreCase("DELETE")) {
                String value = PostData.authData(appname, o.toString());
                httpMethod = new DeleteMethod(POST.UC_HOST+uri + "?" + value);
            } else {
                ((EntityEnclosingMethod)httpMethod).setRequestEntity(requestEntity);
            }

            httpMethod.setRequestHeader("Content-type", "application/x-www-form-urlencoded;charset=UTF-8");
            client.executeMethod(httpMethod);
            String response = httpMethod.getResponseBodyAsString();
            return response;
        }
        catch (HttpException e)
        {
            log.error("HttpException",e);
        }
        catch (IOException e)
        {
            log.error("IOException",e);
        }

        return null;

    }
	//合并用户用
	public static String post(String uri,String _id,String oldid,String type){
		HttpClient client = new HttpClient();
		String newuri = uri.replace(":id", _id);
		PostMethod method = new PostMethod(POST.UC_HOST+newuri);
		JSONObject user = new JSONObject();
		user.put("_id",oldid);
		user.put("mobile",true);
		user.put("password",true);
//		user.put("nickname", true);
		
		log.info("http post url:"+POST.UC_HOST+newuri +"\n参数：_id："+_id+" oldid:"+oldid+" type:"+type+"\n加密后参数："+PostData.authData(type, user.toString()));
        
		try
        {
//	        ByteArrayRequestEntity requestEntity = new ByteArrayRequestEntity(PostData.authData(type, user.toString()).getBytes("UTF-8"));
//	/        method.setRequestEntity(requestEntity);
//	        method.setRequestHeader("Content-type", "application/json;charset=UTF-8");
           
            
            StringRequestEntity requestEntity = new StringRequestEntity(PostData.authData(type, user.toString()));
	        method.setRequestEntity(requestEntity);
	        method.setRequestHeader("Content-type", "application/x-www-form-urlencoded;charset=UTF-8");
	        client.executeMethod(method);
	        
            String response = method.getResponseBodyAsString();
            return response;
        }
        catch (HttpException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
	}
	
	@SuppressWarnings("deprecation")
	public static String get(String uri,UcUser user,String type){
		String newuri = uri.replace(":id", user.get_id());
		HttpClient client = new HttpClient();
		GetMethod method = new GetMethod(POST.UC_HOST+newuri+"?appname="+type+"&appcode="+URLEncoder.encode(PostData.authDataforGet(type,"")));
		log.info("http get url:"+POST.UC_HOST+newuri+"?appname="+type+"&appcode="+URLEncoder.encode(PostData.authDataforGet(type,"")));
        
		try
        {
            client.executeMethod(method);
            String response = method.getResponseBodyAsString();
            return response;
        }
        catch (HttpException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
	}
	
	@SuppressWarnings("deprecation")
	public static String get(String uri,JSONObject args,String type){
		args.put("skip", 0);
		args.put("limit", 1);
		HttpClient client = new HttpClient();
		GetMethod method = new GetMethod(POST.UC_HOST+uri+"?appname="+type+"&appcode="+URLEncoder.encode(PostData.authDataforGet(type,args.toString())));
		log.info("http get url:"+POST.UC_HOST+uri+"?appname="+type+"&appcode="+URLEncoder.encode(PostData.authDataforGet(type,args.toString())));

		try
        {
            client.executeMethod(method);
            String response = method.getResponseBodyAsString();
            return response;
        }
        catch (HttpException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
	}
	
	@SuppressWarnings("deprecation")
	public static String put(String uri,UcUser user,String type){
		String newuri = uri.replace("{id}", user.get_id());
		user.set_id(null);
		String arg = PostData.authData(type, user.toString());
		String resStr = null;  
        HttpClient htpClient = new HttpClient();  
        
        log.info("http put url:"+POST.UC_HOST+newuri+" \n参数："+user+" \ntype:"+type);

        PutMethod putMethod = new PutMethod(POST.UC_HOST+newuri);  
        putMethod.addRequestHeader( "Content-Type","application/x-www-form-urlencoded;charset=UTF-8" );  
//        putMethod.getParams().setParameter( HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8" );  
//        putMethod.setRequestBody(arg);  
        StringRequestEntity requestEntity = new StringRequestEntity(arg);
        putMethod.setRequestEntity(requestEntity);
        try{  
            int statusCode = htpClient.executeMethod( putMethod );  
            log.info("http put statusCode:"+statusCode);  
            if(statusCode != HttpStatus.SC_OK){  
                log.error("Method failed: "+putMethod.getStatusLine());  
                return null;  
            }    
            byte[] responseBody = putMethod.getResponseBody();           
            resStr = new String(responseBody,"UTF-8");  
        }catch(Exception e){  
        	log.error("http put error",e);
        }finally{  
            putMethod.releaseConnection();  
        }  
        return resStr;  
	}

    public static String getParams(String method,Map<String, Object> paramValues)
    {
        String params="";
        Set<String> key = paramValues.keySet();
        String beginLetter="";
        if (method.equalsIgnoreCase("get"))
        {
            beginLetter="?";
        }

        for (Iterator<String> it = key.iterator(); it.hasNext();) {
            String s = (String) it.next();
            if (params.equals(""))
            {
                params += beginLetter + s + "=" + paramValues.get(s);
            }
            else
            {
                params += "&" + s + "=" + paramValues.get(s);
            }
        }
        return params;
    }
}
