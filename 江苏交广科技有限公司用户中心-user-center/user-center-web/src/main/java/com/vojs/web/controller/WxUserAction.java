package com.vojs.web.controller;

import com.vojs.bean.Response;
import com.vojs.bean.UcUser;
import com.vojs.ucenter.client.util.POST;
import com.vojs.ucenter.client.util.PostData;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 微信授权 用户中心 操作类
 * @author junjie
 *
 */
public class WxUserAction extends UserAction{
	private Logger log = LoggerFactory.getLogger(this.getClass());
	protected String appType = PostData.APP_NAME_WX;
	
	/**
	 * 微信登录
	 */
	public Response login(String wxPublicAccount, String wxOpenId) {
		log.info("参数-wxPublicAccount:"+wxPublicAccount+"  wxOpenId:"+wxOpenId);
		UcUser user = new UcUser();
    	user.setWxPublicAccount(wxPublicAccount);
    	user.setWxOpenId(wxPublicAccount+wxOpenId);
    	String res = HttpUtil.post(POST.UC_LOGIN, user,this.appType);
    	log.info("返回："+res);
    	Object  response = JSONObject.toBean(JSONObject.fromObject(res), Response.class);
    	
    	if(response instanceof Response)
    		return (Response)response;
		return null;
	}

	/**
	 * 微信唯一id登录
	 * @param wxUnionId 
	 * @return {@link Response}
	 */
	public Response login(String wxUnionId) {
		log.info("参数-wxUnionId:"+wxUnionId);
		UcUser user = new UcUser();
    	user.setWxUnionId(wxUnionId);
    	
    	String res = HttpUtil.post(POST.UC_LOGIN, user,this.appType);
    	log.info("返回："+res);
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

	public Response register(String wxUnionId, int age, String nickname,
			String gender, String portrait,String province,String city) {
		super.appType = this.appType;											
		return super.register(wxUnionId, age, nickname, gender, portrait,province,city);
	}
	
	public Response register(String wxOpenId,String wxUnionId, int age, String nickname,
			String gender, String portrait,String province,String city) {
		super.appType = this.appType;											
		return super.register(wxOpenId,wxUnionId, age, nickname, gender, portrait,province,city);
	}
	
}
