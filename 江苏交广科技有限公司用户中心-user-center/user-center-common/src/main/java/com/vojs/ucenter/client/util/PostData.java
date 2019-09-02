package com.vojs.ucenter.client.util;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class PostData {
	public static final String APP_NAME_WX = "wx";
	public static final String APP_NAME_APP = "wbapp";
	public static final String APP_NAME_TIEBA = "tieba";
	
	private static Map<String, String> keyMap = new HashMap<String, String>();
	
	static {
		keyMap.put("tieba", "RMgtxJl85HJkjO3sbHwXwd8aiIUWIoYi");
		keyMap.put("wbapp", "wX380Jgl4Utd6WsjLPHC3rraJGyFh1EQ");
		keyMap.put("wx", "uaiq2PZ1AsPmwabDsDD77W8egBo6wZb8");
	}
	
	public static String authData(String appname,String data){
		if(data.equals("{}")){
			data = "";
		}
		String str = "appname"+"="+appname+"&appcode="+URLEncoder.encode(Authcode.authcodeEncode(URLEncoder.encode(data),keyMap.get(appname)))+"&urlencoded=true";
//		System.out.println(data);
//		System.out.println("");
//		System.out.println(URLEncoder.encode(data));
//		System.out.println("");
//		System.out.println(str);
		return str;
	}
	
	public static String authDataforGet(String appname,String data){
		return Authcode2.authcodeEncode(data,keyMap.get(appname));
	}
	
}
