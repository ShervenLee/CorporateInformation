package com.vojs.web.controller;

import com.vojs.bean.Response;
import com.vojs.bean.UcUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONObject;

import com.vojs.ucenter.client.util.POST;
import com.vojs.ucenter.client.util.PostData;

/**
 * APP 用户中心 操作类
 * @author junjie
 *
 */
public class AppUserAction extends UserAction{

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	protected String appType = PostData.APP_NAME_WX;
	
	/**
	 * 用户名密码登录
	 * @param mobile 手机号码
	 * @param password 密码
	 * @return {@link Response}
	 */
	public Response login(String mobile, String password) {
		log.info("参数- mobile:"+mobile+" password:"+password);
		UcUser user = new UcUser();
    	user.setMobile(mobile);
    	user.setPassword(password);
    	
    	String res = HttpUtil.post(POST.UC_LOGIN, user,this.appType);
    	log.info("返回："+res);
    	Object  response = JSONObject.toBean(JSONObject.fromObject(res), Response.class);
    	
    	if(response instanceof Response)
    		return (Response)response;
		return null;
	}

	
	/**
	 * 微信授权unionId登录
	 * @param wxUnionId  微信唯一id
	 * @return {@link Response}
	 */
	public Response login(String wxUnionId) {
		log.info("参数- wxUnionId"+wxUnionId);
		UcUser user = new UcUser();
    	user.setWxUnionId(wxUnionId);
    	
    	String res = HttpUtil.post(POST.UC_LOGIN, user,this.appType);
    	log.info("返回： "+res);
    	Object  response = JSONObject.toBean(JSONObject.fromObject(res), Response.class);
    	
    	if(response instanceof Response)
    		return (Response)response;
		return null;
	}

	/**
	 * QQ授权登录
	 * @param qqAppId
	 * @param qqOpenId
	 * @param args
	 * @return
	 */
	public Response login(String qqAppId,String qqOpenId,String[] args) {
		log.info("参数- qqAppId："+qqAppId+" qqOpenId:"+qqOpenId+" args:"+args);
		UcUser user = new UcUser();
    	user.setQqAppId(qqAppId);
    	user.setQqOpenId(qqOpenId);
    	
    	String res = HttpUtil.post(POST.UC_LOGIN, user,this.appType);
    	
    	Object  response = JSONObject.toBean(JSONObject.fromObject(res), Response.class);
    	
    	if(response instanceof Response)
    		return (Response)response;
		return null;
	}


	@Override
	public Response sendCode(String mobile) {
		super.appType = this.appType;
		return super.sendCode(mobile);
	}


	@Override
	public Response getUserById(String userId) {
		super.appType = this.appType;
		return super.getUserById(userId);
	}


	@Override
	public Response modifyUserById(UcUser user) {
		super.appType = this.appType;
		return super.modifyUserById(user);
	}


	@Override
	public Response register(String wxUnionId, int age, String nickname,
			String gender, String portrait,String province,String city) {
		super.appType = this.appType;
		return super.register(wxUnionId, age, nickname, gender, portrait,province,city);
	}
	
}
