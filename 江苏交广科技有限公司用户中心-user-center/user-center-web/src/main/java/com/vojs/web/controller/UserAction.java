package com.vojs.web.controller;

import com.vojs.bean.Response;
import com.vojs.bean.UcUser;
import com.vojs.ucenter.client.util.POST;
import com.vojs.ucenter.client.util.PostData;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URLEncoder;

abstract class UserAction {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	protected String appType = PostData.APP_NAME_TIEBA;


	public abstract Response login(String mobile, String password);

	public abstract Response login(String wxUnionId);

	/**e
	 * 发送动态密码
	 * @param mobile  手机号码
	 * @return {@link Response}
	 */
	public Response sendCode(String mobile) {
		log.info("参数- mobile:"+mobile);
		UcUser user = new UcUser();
		user.setMobile(mobile);

		String res = HttpUtil.post(POST.UC_SMS, user,this.appType);
		log.info("返回："+res);
		Object response = JSONObject.toBean(JSONObject.fromObject(res),
				Response.class);

		if (response instanceof Response)
			return (Response) response;
		return null;
	}

	/**
	 * 根据userId查询用户详情
	 * @param userId  用户id _id
	 * @return {@link Response}
	 */
	public Response getUserById(String userId) {
		log.info("参数- userId:"+userId);
		UcUser user = new UcUser();
		user.set_id(userId);

		String res = HttpUtil.get(POST.UC_INFO_ID, user,this.appType);
		log.info("返回："+res);
		Object response = JSONObject.toBean(JSONObject.fromObject(res),
				Response.class);

		if (response instanceof Response)
			return (Response) response;
		return null;
	}

	/**
	 * 根据id 修改用户信息
	 * @param user  用户对象   user对象的_id属性必传   需要修改的属性 查哪个
	 * @return {@link Response}
	 */
        public Response modifyUserById(UcUser user) {
		log.info("参数- user:"+user);
		String _id = user.get_id();
		String res = HttpUtil.put(POST.UC_MODIFY_ID, user,this.appType);
		log.info("修改用户信息返回："+res);
		//{"success":false,"error":[{"fields":["mobile"],"user":{"_id":"552d1114ab3a6ede1d50fbcf","mobile":"15380939133","nickname":"赌王","gender":false,"portrait":"http://wx.vojs.cn/squpload/22254024-88b8-4f14-a7e6-31604bd869e8-fb607e18-9423-4f3d-8610-e8e36ec582f6.jpg","age":22,"regTime":"2015-04-24T13:51:22.581Z"}}]}
		JSONObject json = JSONObject.fromObject(res);
		if(json.get("success").toString().equals("true")){//判断是否修改成功
			log.info("修改用户信息成功!");
			Object response = JSONObject.toBean(JSONObject.fromObject(res),
					Response.class);

			if (response instanceof Response)
				return (Response) response;
		}else{//合并用户
			log.info("修改用户信息失败! 进行合并用户操作!");
			try {
				JSONArray arr = JSONArray.fromObject(json.get("error"));
				for(int i=0;i<arr.size();i++){
					JSONArray fileds = JSONArray.fromObject(arr.getJSONObject(i).get("fields"));
					for(int j=0;j<fileds.size();j++){
						if(fileds.getString(j).equals("mobile")){
							UcUser olduser = (UcUser) JSONObject.toBean((JSONObject) arr.getJSONObject(i).get("user"),UcUser.class);
							res = HttpUtil.post(POST.UC_MERGE_USER,_id, olduser.get_id(), this.appType);
							log.info("合并账户 返回："+res);
							json = JSONObject.fromObject(res);
							if(json.get("success").toString().equals("true")){//判断是否修改成功
								log.info("合并账户 成功!");
								Object response = JSONObject.toBean(JSONObject.fromObject(res),
										Response.class);

								if (response instanceof Response)
									return (Response) response;
							}else{
								Response response = new Response();
								log.error("绑定账户错误!");
								response.setError("绑定账户错误!");
								response.setSuccess("false");
								return response;
							}
						
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				Response response = new Response();
				response.setError("修改信息错误!");
				response.setSuccess("false");
				return response;
			}
		}
		
		return null;
	}

	/**
	 * 微信注册
	 * @param wxUnionId  微信unionId
	 * @param age 年龄
	 * @param nickname 昵称
	 * @param gender 性别 ： 1表示男   0表示女
	 * @param portrait  头像url
	 * @param province  省会
	 * @param city  城市
	 * @return {@link Response}
	 */
	public Response register(String wxUnionId,int age,String nickname,String gender,String portrait,String province,String city){
		log.info("参数- wxUnionId:"+wxUnionId+" age:"+age+" nickname:"+nickname+" gender:"+gender+" portrait:"+portrait+" province:"+province+" city:"+city);
		UcUser user = new UcUser();
		user.setWxUnionId(wxUnionId);
		user.setAge(age);
		user.setNickname(nickname);
		user.setGender(gender);
		user.setPortrait(portrait);
		user.setProvince(province);
		user.setCity(city);
		
		String res = HttpUtil.post(POST.UC_REGISTER, user, this.appType);
		log.info("返回："+res);
		Object response = JSONObject.toBean(JSONObject.fromObject(res),
				Response.class);

		if (response instanceof Response)
			return (Response) response;
		return null;
		
	}
	
	public Response register(String wxOpenId,String wxUnionId,int age,String nickname,String gender,String portrait,String province,String city){
		log.info("参数- wxUnionId:"+wxUnionId+" age:"+age+" nickname:"+nickname+" gender:"+gender+" portrait:"+portrait+" province:"+province+" city:"+city);
		UcUser user = new UcUser();
		user.setWxOpenId(wxOpenId);
		user.setWxUnionId(wxUnionId);
		user.setAge(age);
		user.setNickname(nickname);
		user.setGender(gender);
		user.setPortrait(portrait);
		user.setProvince(province);
		user.setCity(city);
		
		String res = HttpUtil.post(POST.UC_REGISTER, user, this.appType);
		log.info("返回："+res);
		Object response = JSONObject.toBean(JSONObject.fromObject(res),
				Response.class);

		if (response instanceof Response)
			return (Response) response;
		return null;
		
	}
	
	public Response getUserByMobile(String mobile){
		log.info("参数- mobile:"+mobile);
		JSONObject json = new JSONObject();
		json.put("mobile", mobile);
        json.put("skip", 0);
        json.put("limit", 1);
		String res = HttpUtil.get(POST.GET_USER_BY_MOBILE, json, this.appType);
		log.info("返回："+res);
		
		Object response = JSONObject.toBean(JSONObject.fromObject(res),
				Response.class);

		if (response instanceof Response)
			return (Response) response;
		
		return null;
	}
	
	public Response getUserByNickname(String nickname){
		log.info("参数- nickname:"+nickname);
		JSONObject json = new JSONObject();
		json.put("nickname", URLEncoder.encode(nickname));
        json.put("skip", 0);
        json.put("limit", 1);
		String res = HttpUtil.get(POST.GET_USER_BY_MOBILE, json, this.appType);
		log.info("返回："+res);
		Object response = JSONObject.toBean(JSONObject.fromObject(res),
				Response.class);

		if (response instanceof Response)
			return (Response) response;
		
		return null;
	}
}
