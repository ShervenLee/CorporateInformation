package com.vojs.web.controller;

import com.vojs.bean.Response;
import com.vojs.bean.UcUser;
import com.vojs.bean.form.AddUserActivityContactForm;
import com.vojs.bean.form.AddUserTagForm;
import com.vojs.bean.form.AddressForm;
import com.vojs.bean.form.DeleteAddressForm;
import org.apache.commons.httpclient.HttpMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONObject;
import com.vojs.ucenter.client.util.POST;
import com.vojs.ucenter.client.util.PostData;

import java.util.Date;

/**
 * 贴吧 用户中心 操作类
 * @author junjie
 *
 */
public class TiebaUserAction extends UserAction{
	private Logger log = LoggerFactory.getLogger(this.getClass());
	protected String appType = PostData.APP_NAME_TIEBA;
	
	/**
	 * 用户名密码登录
	 * @param mobile 手机号码
	 * @param password 密码
	 * @return {@link Response}
	 */
	public Response login(String mobile, String password) {
		log.info("参数- mobile："+mobile+" password"+password);
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
	 * 微信unionId登录
	 * @param wxUnionId  微信唯一id
	 * @return {@link Response}
	 */
	public Response login(String wxUnionId) {
		log.info("参数- wxUnionId"+wxUnionId);
		UcUser user = new UcUser();
    	user.setWxUnionId(wxUnionId);
    	
    	String res = HttpUtil.post(POST.UC_LOGIN, user,this.appType);
    	log.info("返回："+res);
    	Object  response = JSONObject.toBean(JSONObject.fromObject(res), Response.class);
    	
    	if(response instanceof Response)
    		return (Response)response;
		return null;
	}

	/**
	 * 用户名密码注册
	 * @param mobile  11位手机号码
	 * @param password 密码
	 * @param age 年龄
	 * @param nickname 昵称
	 * @param gender 性别 ： 1表示男   0表示女
	 * @param portrait  头像url
	 * @return {@link Response}
	 */
	public Response register(String mobile,String password,int age,String nickname,String gender,String portrait){
		log.info("参数- mobile:"+mobile+" password:"+password+" age:"+age+" nickname:"+nickname+" gender:"+gender+" portrait:"+portrait);
		UcUser user = new UcUser();
		user.setMobile(mobile);
		user.setPassword(password);
		user.setAge(age);
		user.setNickname(nickname);
		user.setGender(gender);
		user.setPortrait(portrait);
		
		String res = HttpUtil.post(POST.UC_REGISTER, user,this.appType);
		log.info("返回："+res);
		Object response = JSONObject.toBean(JSONObject.fromObject(res),
				Response.class);

		if (response instanceof Response)
			return (Response) response;
		return null;
		
	}


    public Response e(String unionId) {
        UcUser user = new UcUser();
        user.setWxUnionId(unionId);
        String res = HttpUtil.post(POST.UC_REGISTER, user,this.appType);
        log.info("返回："+res);
        Object response = JSONObject.toBean(JSONObject.fromObject(res),
                Response.class);

        if (response instanceof Response)
            return (Response) response;
        return null;
    }

    public String addContact() {
		AddUserActivityContactForm form = new AddUserActivityContactForm();
		form.setActivityCode(12345678);
		form.setActivityType((short) 1);
		form.setContact("陈云杰");
		form.setTitle("12312312312");
		form.setUuid("1231231231");
		form.setDatetime(123123123123L);
		String result = HttpUtil.http(POST.USER_ACTIVITY_CONTACT_ADD, form, "POST", this.appType);

		return result;
	}

	public String addTag() {

		AddUserTagForm tagForm = new AddUserTagForm();
		tagForm.setUuid("123123123");
		tagForm.setTagContent("足球");

		tagForm.setTagTime(new Date().getTime());

		String result = HttpUtil.http(POST.USER_ACTIVITY_TAG_ADD, tagForm, "POST", this.appType);

		return result;
	}

	public void addAddress() {

		AddressForm addressForm = new AddressForm();

		addressForm.setUuid("2e0990c5-d918-451f-ae00-05f5035e8532");
		addressForm.setCity("南京");
		addressForm.setContact("18652016815");
		addressForm.setDetail("软件大道118号");
		addressForm.setDistrict("雨花台区");
		addressForm.setProvince("江苏省");
		addressForm.setMobile("18652016815");

		HttpUtil.http(POST.ADDRESS_ACTIVITY_ADD, addressForm, "POST", this.appType);

	}

	public void listAddress() {
		AddressForm addressForm = new AddressForm();

		addressForm.setUuid("111");

		HttpUtil.http(POST.ADDRESS_ACTIVITY_LIST, addressForm, "GET", this.appType);
	}

	public void deleteAddress() {

		DeleteAddressForm deleteAddressForm = new DeleteAddressForm();

		deleteAddressForm.setId(5);
		deleteAddressForm.setUuid("2e0990c5-d918-451f-ae00-05f5035e8532");

		HttpUtil.http(POST.ADDRESS_ACTIVITY_DELETE, deleteAddressForm, "DELETE", this.appType);
	}

	public void updateAddress() {

		AddressForm addressForm = new AddressForm();

		addressForm.setId(5);
		addressForm.setDistrict("鼓楼区");
		addressForm.setUuid("2e0990c5-d918-451f-ae00-05f5035e8532");

		HttpUtil.http(POST.ADDRESS_ACTIVITY_DELETE, addressForm, "PUT", this.appType);
	}

}
