/**
 * 
 */
package com.vojs.bean;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author junjie
 *
 */
public class UcUser implements Serializable{
	
	private static final long serialVersionUID = -5327216288883743376L;
	/**
	 * 
	 */
	private Logger log = LoggerFactory.getLogger(this.getClass());
	/**
	 * 唯一键
	 */
	private String _id;
	
	/**
	 * 手机号码
	 */
	private String mobile;
	
	private String password;
	
	private String email;
	
	private String qqAppId;
	
	/**
	 * qqAppId+qqOpenId 不能重复
	 */
	private String qqOpenId;
	
	private String wxUnionId;
	
	private String wxPublicAccount;
	
	/**
	 * wxPublicAccount+wxOpenId不能重复
	 */
	private String wxOpenId;
	
	/**
	 * // type : Number
	 */
	private int age;
	
	private String nickname;
	
	/**
	 * type: boolean,  用1，0表示也可以  true和1表示男
	 */
	private String gender;
	
	private String portrait;
	
	private String province;
	
	private String city;

	/**
	 * 手机号码
	 * @return
	 */
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * 邮箱
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * qq的appid
	 * @return
	 */
	public String getQqAppId() {
		return qqAppId;
	}

	public void setQqAppId(String qqAppId) {
		this.qqAppId = qqAppId;
	}

	/**
	 * qq的openid   openid+appid两个属性保证唯一性
	 * @return
	 */
	public String getQqOpenId() {
		return qqOpenId;
	}

	public void setQqOpenId(String qqOpenId) {
		this.qqOpenId = qqOpenId;
	}

	/**
	 * 微信的唯一id   这个是唯一的
	 * @return
	 */
	public String getWxUnionId() {
		return wxUnionId;
	}

	public void setWxUnionId(String wxUnionId) {
		this.wxUnionId = wxUnionId;
	}

	/**
	 * 微信的公众号id
	 * @return
	 */
	public String getWxPublicAccount() {
		return wxPublicAccount;
	}

	public void setWxPublicAccount(String wxPublicAccount) {
		this.wxPublicAccount = wxPublicAccount;
	}

	/**
	 * 微信公众号对应的openid   openid+unionid才能保证唯一
	 * @return
	 */
	public String getWxOpenId() {
		return wxOpenId;
	}

	public void setWxOpenId(String wxOpenId) {
		this.wxOpenId = wxOpenId;
	}

	/**
	 * 年龄
	 * @return
	 */
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * 昵称
	 * @return
	 */
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
//		if(!StringUtil.isChinese(nickname)){
//			try {
//				this.nickname = URLDecoder.decode(nickname,"UTF-8");
//			} catch (UnsupportedEncodingException e) {
//				this.nickname = nickname;
//				e.printStackTrace();
//			}
//		}else{
			this.nickname = nickname;
//		}
		
	}

	/**
	 * 性别   1男   0女
	 * @return
	 */
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * 头像
	 * @return
	 */
	public String getPortrait() {
		return portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	/**
	 * 密码
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString(){
		Method[] methods = UcUser.class.getMethods();
		String json = "";
		for (Method method : methods) {
			if(method.getName().startsWith("get") && !method.getName().equalsIgnoreCase("getClass")){
				try {
					Object value =  method.invoke(this);
					if(null != value && !StringUtils.isEmpty(value.toString())){
						if(value instanceof String){
							if(method.getName().substring(3).equalsIgnoreCase("nickname") || method.getName().substring(3).equalsIgnoreCase("city") || method.getName().substring(3).equalsIgnoreCase("province")){
//								json += ",\""+toLowerCaseFirstOne(method.getName().substring(3))+"\":\""+URLEncoder.encode((String) value,"UTF-8")+"\"";
								json += ",\""+toLowerCaseFirstOne(method.getName().substring(3))+"\":\""+value+"\"";
							}else{
								json += ",\""+toLowerCaseFirstOne(method.getName().substring(3))+"\":\""+value+"\"";
							}
						}else if (value instanceof Integer && Integer.parseInt(value.toString()) != 0){
							json += ",\""+toLowerCaseFirstOne(method.getName().substring(3))+"\":"+value;
						}
					}
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		if(json.length()>0)
			json = json.substring(1,json.length());
		json = "{"+json+"}";
		log.info("UcUser toString:"+json);
		return json;
		
	}
	
	
	public static String toLowerCaseFirstOne(String s)
    {
        if(Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }

	public String getProvince() {
		
		return province;
	}

	public void setProvince(String province) {
//		if(!StringUtil.isChinese(province)){
//			try {
//				this.province = URLDecoder.decode(province,"UTF-8");
//			} catch (UnsupportedEncodingException e) {
//				this.province = province;
//				e.printStackTrace();
//			}
//		}else{
			this.province = province;
//		}
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
//		if(!StringUtil.isChinese(city)){
//			try {
//				this.city = URLDecoder.decode(city,"UTF-8");
//			} catch (UnsupportedEncodingException e) {
//				this.city = city;
//				e.printStackTrace();
//			}
//		}else{
			this.city = city;
//		}
	}
}
