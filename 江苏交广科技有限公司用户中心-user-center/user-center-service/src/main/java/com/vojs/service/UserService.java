package com.vojs.service;

import com.alibaba.fastjson.JSON;
import com.vojs.bean.domain.*;
import com.vojs.bean.exception.VOJSException;
import com.vojs.bean.form.AddUserActivityContactForm;
import com.vojs.bean.form.UserMergeForm;
import com.vojs.bean.form.UserUpdateForm;
import com.vojs.common.constants.AppConstants;
import com.vojs.dao.UserMapper;
import com.vojs.ucenter.client.util.Authcode;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.util.*;


/**
 * 用户服务
 *
 * Created by apple on 16/5/1.
 */

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 注册用户
     *
     * @param user
     * @param wxUnion
     * @return
     */
    public User registerUser(User user, WXUnion wxUnion) throws VOJSException {

        //判断条件不确定,需要确定是根据email 手机  还是username来判断
        if (StringUtils.isNotBlank(user.getMobile()) && userMapper.getUserCountByMobile(user.getMobile()) > 0) {
            throw new VOJSException("该手机号码已注册");
        }
        user.doPasswordSaltMD5();
        user.set_id(UUID.randomUUID().toString());
        user.setUuid(user.get_id());
        //是否存在微信注册信息
        if (wxUnion != null) {
            List<WXUnion> wxUnions = userMapper.getWXUnionList(wxUnion);

            if (wxUnions != null && wxUnions.size() > 0) {
                throw new VOJSException("微信用户已被绑定");
            }

            if (StringUtils.isBlank(wxUnion.getUnionId())) {
                throw new VOJSException("微信注册信息有误");
            }

            userMapper.insertUser(user);
            wxUnion.setUserId(user.getUuid());
            addWxUnion(wxUnion);
        } else {
            userMapper.insertUser(user);
        }
        return getUser(user.getUuid());
    }

    /**
     * 根据用户编号查询
     * @param _id
     * @return
     */
    public User getUser(String _id) throws VOJSException {

        try {
            User u = new User(_id);
            List<User> users = userMapper.getUser(u);

            if (users != null && users.size() > 0) {
                User user = users.get(0);

                List<WXUnion> wxUnions = userMapper.getWXUnionList(new WXUnion(user.getUuid()));

                for (int i=0;i<wxUnions.size(); i++) {
                    WXUnion wxUnion = wxUnions.get(i);
                    List<WXAccount> accounts = userMapper.getWXUserInfoByUnionId(wxUnion.getUnionId());
                    wxUnion.addWXAccount(accounts);
                }

                if (wxUnions.size() > 0) {
                    WXUnion wxUnion = wxUnions.get(0);
                    user.setWxUnionId(wxUnion.getUnionId());

                    if (wxUnion.getWxAccounts().size() > 0) {
                        WXAccount account = wxUnion.getWxAccounts().get(0);
                        user.setWxPublicAccount(account.getWxPublicAccount());
                        user.setWxOpenId(account.getWxOpenId());
                    }
                }

                user.getWxOpenUserList().addAll(wxUnions);
                return user;
            }
        } catch (Exception e) {
            throw new VOJSException("获取用户信息失败");
        }
        return null;
    }


    /**
     * 使用微信登录
     *
     * @param wxUnionId
     * @param wxPublicAccount
     * @param openId
     * @return
     */
    public User checkWxLogin(String wxUnionId, String wxPublicAccount, String openId) throws Exception {
        if (StringUtils.isNotBlank(wxUnionId)) {

            User user = null;
            List<User> users = userMapper.getUserByUnion(wxUnionId);
            if (users != null && users.size() > 0) {
                user = getUser(users.get(0).getUuid());
            }

            if (user != null) {
                if (StringUtils.isNotBlank(wxPublicAccount) && StringUtils.isNotBlank(openId)) {
                    List<User> newUsers = userMapper.getUserByUnionOpenIdAndAccount(wxUnionId, wxPublicAccount, openId);

                    if (newUsers != null && newUsers.size() > 0) {
                        return getUser(users.get(0).getUuid());
                    } else {
                        throw new VOJSException("微信登录失败,信息不匹配");
                    }
                } else {
                    return user;
                }
            } else  {
                throw new VOJSException("找不到微信用户");
            }
        }
        return null;
    }

    /**
     * qq登录
     *
     * @param qqAppId
     * @param qqOpenId
     * @return
     */
    public User checkQQLogin(String qqAppId, String qqOpenId) {
        if (StringUtils.isNotBlank(qqAppId) && StringUtils.isNotBlank(qqOpenId)) {
            List<User> users = userMapper.getUserByQQ(qqAppId, qqOpenId);
            return users.get(0);
        }

        return null;
    }

    /**
     * 用户名密码登录
     * @param mobile
     * @param password
     * @return
     */
    public User checkUserPassword(String mobile, String password) throws VOJSException {

        if (StringUtils.isNotBlank(mobile)) {
            User u = new User();
            u.setMobile(mobile);
            List<User> users = userMapper.getUser(u);
            if (users != null && users.size() > 0) {
                User user = users.get(0);
                String hashedPassword = user.doPasswordSaltMD5(password);
                if (StringUtils.isNotBlank(hashedPassword) && hashedPassword.equalsIgnoreCase(user.getHashedPassword())) {
                    return user;
                } else {
                    throw new VOJSException("用户名或密码不正确");
                }
            } else {
                throw new VOJSException("用户不存在");
            }
        }
        return null;
    }

    /**
     * 更新用户信息
     *
     * @param form
     * @return
     * @throws Exception
     */
    public User updateUser(UserUpdateForm form, String id) throws VOJSException {

        if (StringUtils.isBlank(id)) {
            throw new VOJSException("用户编号不能为空");
        }
        try {
            User updateUser = getUser(id);
            BeanUtils.copyProperties(updateUser, form);
            updateUser.set_id(id);//xujunjie add
            updateUser.doPasswordSaltMD5();
            int count = userMapper.updateUser(updateUser);
            if (count == 0) {
                throw new VOJSException("用户信息更新失败");
            }



            return getUser(id);
        } catch (Exception e) {
            throw new VOJSException("用户信息更新失败");
        }
    }

    public void addWxUnion(WXUnion wxUnion) throws VOJSException {

        String unoinOverride = AppConstants.configProperties.getProperty("vojs.wx.union.override");

        String wxAccountOverride = AppConstants.configProperties.getProperty("vojs.wx.union.account.override");
        if (unoinOverride.equals("1")) {
            //删除原有绑定,建立新绑定
            try {
				userMapper.updateUnionByUserIdForDelete(wxUnion.getUserId());

				userMapper.insertUnion(wxUnion);

				addWXAccount(wxUnion.getWxAccounts(), wxUnion.getUnionId());
			} catch (Exception e) {
				e.printStackTrace();
			}

        } else {
            //新增关联关系
            List<WXUnion> wxUnions = userMapper.getWXUnionList(wxUnion);
            if (wxUnions == null || wxUnions.size() == 0) {
                userMapper.insertUnion(wxUnion);
                addWXAccount(wxUnion.getWxAccounts(), wxUnion.getUnionId());
            } else {
                if (wxAccountOverride.equals("1")) {
                    //覆盖
                    WXUnion existUnion = wxUnions.get(0);

                    userMapper.updateWXOpenUserByUnionIdForDelete(existUnion.getUnionId());

                    addWXAccount(wxUnion.getWxAccounts(), existUnion.getUnionId());

                } else {
                    //新增
                    addWXAccount(wxUnion.getWxAccounts(), wxUnion.getUnionId());
                }
            }
        }
    }

    public void addWXAccount(List<WXAccount> wxAccounts, String unionId) {
        if (wxAccounts == null || wxAccounts.size() == 0) {
            return;
        }
        for (WXAccount wxAccount : wxAccounts) {
            wxAccount.setWxUnionId(unionId);
        }

        userMapper.batchInsertWXOpenUser(wxAccounts);
    }

    /**
     * 根据各种条件获取用户列表
     *
     * @return
     * @throws Exception
     */
    public List<User> getUserList(Map params) throws Exception, VOJSException {

        String appcode = String.valueOf(params.get("appcode"));

        String key = AppConstants.configProperties.getProperty("source." + params.get("appname") + ".key");
        String stringJSONValue;
        try {
            stringJSONValue = Authcode.authcodeDecode(appcode, key);

            stringJSONValue = URLDecoder.decode(stringJSONValue, "UTF-8");
        } catch (Exception e) {
            throw new VOJSException("解密信息错误");
        }

        User object = JSON.parseObject(stringJSONValue, User.class);

        BeanUtils.copyProperties(this, object);

        List<User> userList = userMapper.getUser(object);

        List<User> responseUserList = new ArrayList<User>();
        for (User user : userList) {

            User u = getUser(user.getUuid());
            responseUserList.add(u);

        }

        return responseUserList;
    }

    /**
     * 合并用户
     * @param form
     * @throws VOJSException
     */
    public User mergeUser(UserMergeForm form,String pid) throws Exception {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("mobile", 1);
        map.put("email", 1);
        map.put("nickname", 0);
        map.put("wxUnionId", 1);
        map.put("wxPublicAccount", 1);
        map.put("wxOpenId", 1);
        map.put("qqAppId", 1);
        map.put("qqOpenId", 1);
        map.put("gender", 0);
        map.put("age", 0);
        map.put("portrait", 0);

        if (StringUtils.isNotBlank(form.getPassword()) && form.getPassword().equals("1")) {

            map.put("salt", 0);
            map.put("hashedPassword", 0);

            form.setSalt("1");
            form.setHashedPassword("1");
        }
        //查询父级用户
        User u = new User(pid);
        List<User> users = userMapper.getUser(u);

        if (users.size() > 0) {
            User pUser = users.get(0);

            List<User> childUsers = userMapper.getUser(new User(form.get_id()));
            if (childUsers != null && childUsers.size() > 0) {

                User child = childUsers.get(0);

                Set<String> keyset = map.keySet();

                for(String key : keyset) {

                    Object formFieldValue = get(form, key);
                    Object pFieldValue = get(pUser, key);
                    Object cFieldValue = get(child, key);

                    if (formFieldValue == null) {
                        continue;
                    }
                    if (formFieldValue.equals("1") ||
                            ((pFieldValue == null || pFieldValue.toString().equals("")) && (cFieldValue != null && !cFieldValue.toString().equals("")))) {
                        set(pUser, key, cFieldValue);

//                        if (map.get(key).toString().equals("1")) {
//                            set(child, key, "");
//                        }
                    }

                }

                //微信信息特殊处理
                if ((map.get("wxUnionId") != null && map.get("wxUnionId").toString().equals("1"))) {
                    List<WXUnion> wxUnions = userMapper.getWXUnionList(new WXUnion(child.getUuid()));

                    List<WXUnion> parentUnions = userMapper.getWXUnionList(new WXUnion(pid));

                    List<WXUnion> needAddUnionList = new ArrayList<WXUnion>();
                    for (WXUnion union : wxUnions) {
                        //判断主账户是否已经存在该union

                        if (existsUnion(parentUnions, union.getUnionId())) {
                            continue;
                        }

                        //挂到主账户
                        union.setUserId(pid);

                        needAddUnionList.add(union);
                    }

                    //新增主账户挂载
                    if (needAddUnionList != null && needAddUnionList.size() > 0) {
                        userMapper.batchInsertUnion(needAddUnionList);
                    }
                }

                child.setParentId(pUser.getUuid());
                //更新信息
                child.setDeleteFlag("1");//伪删除

                try {
                    userMapper.updateUser(child);
                    userMapper.updateUser(pUser);
                } catch (Exception e) {
                    throw new VOJSException("合并用户信息失败");
                }
                return pUser;
            } else {
                throw new VOJSException("找不到需要合并的账号信息");
            }
        } else {
            throw new VOJSException("找不到需要合并的主账号信息");
        }
    }


    public Tag addTag(Tag tag) throws VOJSException {
        if (StringUtils.isEmpty(tag.getTagContent())) {
            throw new VOJSException("标签名称不能为空");
        }

        if (StringUtils.isEmpty(tag.getUuid())) {
            throw new VOJSException("用户编号不能为空");
        }

        try {
            int count = userMapper.insertTag(tag);

            if (count == 0) {
                throw new VOJSException("标签添加失败");
            }
        } catch (Exception e) {
            throw new VOJSException("添加标签出现异常");
        }
        return tag;
    }

    public Contact addContact(AddUserActivityContactForm contact) throws VOJSException {
        if (contact.getActivityCode() == 0) {
            throw new VOJSException("活动编号不能为空");
        }

        if (StringUtils.isEmpty(contact.getUuid())) {
            throw new VOJSException("用户编号不能为空");
        }

        if (StringUtils.isEmpty(contact.getContact())) {
            throw new VOJSException("联系方式不能为空");
        }

        Contact contactObject = new Contact();

        try {
            BeanUtils.copyProperties(contactObject, contact);

            int count = userMapper.insertContact(contactObject);

            if (count == 0) {
                throw new VOJSException("活动联系方式添加失败");
            }
        } catch (Exception e) {
            throw new VOJSException("活动联系方式添加失败");
        }

        return contactObject;
    }

    public Contact getContact(AddUserActivityContactForm contact) throws VOJSException {
    	if (contact.getActivityCode() == 0) {
            throw new VOJSException("活动编号不能为空");
        }

        if (StringUtils.isEmpty(contact.getUuid())) {
            throw new VOJSException("用户编号不能为空");
        }

        if (contact.getActivityType()==0) {
            throw new VOJSException("活动类型不能为空");
        }

        Contact contactObject = new Contact();

        try {
            BeanUtils.copyProperties(contactObject, contact);

            contactObject = userMapper.queryContact(contactObject);

            if (contactObject == null) {
                throw new VOJSException("活动联系方式查询失败");
            }
        } catch (Exception e) {
            throw new VOJSException("活动联系方式查询失败");
        }

        return contactObject;
	}
    

    public boolean existsUnion(List<WXUnion> wxUnions, String unionId) {

        if (wxUnions == null) {
            return false;
        }

        if (StringUtils.isNotBlank(unionId)) {
            for (int i=0; i<wxUnions.size(); i++) {
                if (unionId.equals(wxUnions.get(i).getUnionId())) {
                    return true;
                }
            }
        }

        return false;
    }
    
    public boolean existsWxAccount(List<WXAccount> wxAccounts) {
    	  if (wxAccounts == null) {
              return false;
          }
    	  
    	  for (int i=0; i<wxAccounts.size(); i++) {
    		  List<WXAccount> accounts = userMapper.getWxAccount(wxAccounts.get(i).getWxPublicAccount(),wxAccounts.get(i).getWxUnionId());
    		  if(accounts.size() > 0){
    			  return true;
    		  }
          }
		
		return false;
	}

    /**
     * 新增登陆记录
     *
     * @param uuid
     */
	public void addLoginRecord(String uuid) {

        try {
            int count = userMapper.queryLoginByUuid(uuid);
            //当日去重
            if (count == 0) {
                userMapper.insertLoginRecord(uuid);
            }

        } catch (Exception e) {
            //忽略插入失败情况，不影响主流程
        }
    }


    private Object get(Object o, String fieldName) throws Exception {
        Field field = o.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        Object value = ReflectionUtils.getField(field, o);
        return value;
    }

    private void set(Object o, String fieldName, Object value) throws Exception{
        Field field = o.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);

        ReflectionUtils.setField(field, o, value);
    }


}
