package com.vojs.ucenter.client.util;

public interface POST {
	
	public static final String UC_REGISTER = "/users";
	
	public static final String UC_LOGIN = "/users/login";
	
	public static final String UC_SMS = "/users/smscode";
	
	public static final String UC_INFO_ID = "/users/:id";
	
	public static final String UC_MODIFY_ID = "/users/{id}";
	
	public static final String UC_HOST = "http://127.0.0.1:8080/user-center";//"http://114.215.200.51:8888/user-center";// "http://uc.vojs.tv";//"http://http://218.94.59.188:8080  192.168.20.35";
	
	public static final String UC_MERGE_USER = "/users/:id/merge";
	
	public static final String GET_USER_BY_MOBILE = "/users";

	public static final String USER_ACTIVITY_CONTACT_ADD = "/users/contact";

	public static final String USER_ACTIVITY_TAG_ADD = "/users/tag";

	public static final String ADDRESS_ACTIVITY_ADD = "/address";

	public static final String ADDRESS_ACTIVITY_LIST = "/address";
	public static final String ADDRESS_ACTIVITY_DELETE = "/address";
}
