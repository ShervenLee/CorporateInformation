package com.vojs.web.controller;

import com.vojs.bean.Response;
import com.vojs.bean.domain.*;
import com.vojs.bean.exception.VOJSException;
import com.vojs.bean.form.*;
import com.vojs.bean.response.BaseResponse;
import com.vojs.bean.response.DataResponse;
import com.vojs.bean.response.UserListResponse;
import com.vojs.bean.response.UserResponse;
import com.vojs.common.SMS;
import com.vojs.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 陈云杰 on 16/4/7.
 */
@Api(value = "/users", description = "用户操作", position = 5)
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SMS sms;

    /**
     * 用户注册
     * @param userRegisterForm
     * @return
     */
    @RequestMapping(value = "" ,method = RequestMethod.POST)
    @ApiOperation(value = "用户注册", httpMethod = "POST", response = UserResponse.class)
    public @ResponseBody
    Map<String, Object> index(@ModelAttribute UserRegisterForm userRegisterForm) throws Exception {

        UserResponse userResponse = new UserResponse();

        try {
            userRegisterForm.decode();   

            User user = new User();
 
            BeanUtils.copyProperties(userRegisterForm, user);

            WXUnion union = null;
            if (StringUtils.isNotBlank(userRegisterForm.getWxUnionId())) {
                union = new WXUnion(userRegisterForm.get_id());
                union.setUnionId(userRegisterForm.getWxUnionId());
                if (StringUtils.isNotBlank(userRegisterForm.getWxOpenId()) && StringUtils.isNotBlank(userRegisterForm.getWxPublicAccount())) {
                    union.addWXAccount(new WXAccount(userRegisterForm.getWxUnionId(), userRegisterForm.getWxOpenId(), userRegisterForm.getWxPublicAccount()));
                }
            }
            user.setRegisterTime(System.currentTimeMillis());
            User registeredUser = userService.registerUser(user, union);
            userService.addLoginRecord(registeredUser.getUuid());
            userResponse.setUser(registeredUser);
            userResponse.setSuccess(true);
        } catch (VOJSException e) {
            userResponse.setSuccess(false);
            userResponse.setError(e.getMessage());
        } catch (Exception e) {
            userResponse.setSuccess(false);
            userResponse.setError("注册失败");
        }
        return userResponse.map();
    }

    /**
     * 用户登录
     * @param request
     * @return
     */
    @ApiOperation(value = "用户登录", httpMethod = "POST", response = UserResponse.class)
    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    public @ResponseBody
    Map<String,Object> login(@ModelAttribute UserLoginForm loginForm, HttpServletRequest request) throws Exception {

        UserResponse response = new UserResponse();

        try {
            loginForm.decode();

            User user = userService.checkWxLogin(loginForm.getWxUnionId(), loginForm.getWxPublicAccount(), loginForm.getWxOpenId());

            if (user == null) {
                user = userService.checkQQLogin(loginForm.getQqAppId(), loginForm.getQqOpenId());
                if (user == null) {
                    user = userService.checkUserPassword(loginForm.getMobile(), loginForm.getPassword());
                }
            }

            if (user == null) {
                response.setError("登录失败");
                response.setSuccess(false);
            } else {
                userService.addLoginRecord(user.getUuid());
                response.setUser(user);
                response.setSuccess(true);
            }

        } catch (VOJSException e) {
            response.setSuccess(false);
            response.setError(e.getMessage());
        } catch (Exception e) {
            response.setSuccess(false);
            response.setError("登录出现异常");
        }
        return response.map();
    }

    /**
     *  发送短信验证码
     * @param request
     * @return
     */
    @ApiOperation(value = "发送短信登录验证码", httpMethod = "POST", response = BaseResponse.class)
    @RequestMapping(value = "/smscode", method = RequestMethod.POST)
    public @ResponseBody
    Map<String,Object> sendSMS(@ModelAttribute SMSCodeForm smsCodeForm, HttpServletRequest request) throws Exception {

        BaseResponse response = new BaseResponse();
        try {
            smsCodeForm.decode();
            String code = randomString(6);

            String mobile = smsCodeForm.getMobile();

            response.setSuccess(sms.sendPasswordCode(mobile, code));

        } catch (Exception e) {
            response.setSuccess(false);
            response.setError("短信验证码发送失败");
        }
        return response.map();
    }

    /**
     * 获取用户信息
     * @return
     */
    @ApiOperation(value = "根据用户id获取用户信息", httpMethod = "GET", response = UserResponse.class)
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getUser(@ModelAttribute @PathVariable("id") String id) throws Exception {

        UserResponse response = new UserResponse();

        try {
            User user = userService.getUser(id);

            if (user != null) {
                response.setSuccess(true);
                response.setUser(user);
            } else {
                response.setSuccess(false);
            }
        } catch (VOJSException e) {
            response.setSuccess(false);
            response.setError(e.getMessage());
        } catch (Exception e) {
            response.setSuccess(false);
            response.setError("查询用户信息失败");
        }

        return response.map();
    }

    /**
     * 合并用户
     * @return
     */
    @ApiOperation(value = "合并用户", httpMethod = "POST", response = UserResponse.class)
    @RequestMapping(value = "{id}/merge", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> mergeUser(@ModelAttribute @PathVariable("id") String id,@ModelAttribute UserMergeForm userMergeForm, HttpServletRequest request) throws Exception {

        UserResponse response = new UserResponse();

        try {
            userMergeForm.decode();
            User pUser = userService.mergeUser(userMergeForm, id);
            response.setUser(pUser);
            response.setSuccess(true);
        } catch (VOJSException e) {
            response.setSuccess(false);
            response.setError(e.getMessage());
        } catch (Exception e) {
            response.setSuccess(false);
            response.setError("合并用户信息失败");
        }
        return response.map();
    }

    /**
     * 更新用户信息
     *
     * @return
     */
    @ApiOperation(value = "根据用户id更新用户信息", httpMethod = "PUT", response = UserResponse.class)
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public @ResponseBody Map<String,Object> updateUser(@ModelAttribute UserUpdateForm userUpdateForm, @PathVariable("id") String id) throws Exception {
        UserResponse response = new UserResponse();
        try {
        	
            userUpdateForm.decode();
            User user = userService.updateUser(userUpdateForm, id);

            response.setUser(user);
            response.setSuccess(true);
        } catch (VOJSException e) {
            response.setError(e.getMessage());
            response.setSuccess(false);

        } catch (Exception e) {
            response.setError("更新用户信息失败");
            response.setSuccess(false);
        }
        return  response.map();
    }

    /**
     * 根据各种条件查询用户信息
     * @return
     */
    @ApiOperation(value = "根据各种条件查询用户信息", httpMethod = "GET", response = UserListResponse.class)
    @RequestMapping(value = "", method = RequestMethod.GET)
    public @ResponseBody
    Map<String,Object> getUserByCondition(HttpServletRequest request) throws Exception {

        UserListResponse userListResponse = new UserListResponse();

        try {
            userListResponse.setUsers(userService.getUserList(showParams(request)));
            userListResponse.setSuccess(true);
        } catch (VOJSException e) {
            userListResponse.setSuccess(false);
            userListResponse.setError(e.getMessage());
        } catch (Exception e) {
            userListResponse.setError("查询用户信息异常");
            userListResponse.setSuccess(false);
        }
        return userListResponse.map();
    }

    /**
     * 添加标签
     *
     * @param addUserTagForm
     * @return
     */
    @ApiOperation(value = "新增用户标签", httpMethod = "POST", response = BaseResponse.class)
    @RequestMapping(value = "/tag", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> addTag(@ModelAttribute AddUserTagForm addUserTagForm) throws Exception {

    	DataResponse response = new DataResponse();

        addUserTagForm.decode();

        try {
            this.checkUserExists(addUserTagForm.getUuid());
            Tag tag = new Tag();
            BeanUtils.copyProperties(addUserTagForm, tag);

            Tag tag1 = userService.addTag(tag);
            
            response.setData(tag1);
            response.setSuccess(true);
            
        } catch (VOJSException ve) {
            response.setSuccess(false);
            response.setError(ve.getMessage());
        } catch (Exception e) {
            response.setSuccess(false);
            response.setError("新增用户标签出现异常");
        }

        return response.map();

    }

    /**
     * 新增活动联系方式
     *
     * @param addUserActivityContactForm
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "新增用户活动联系方式", httpMethod = "POST", response = BaseResponse.class)
    @RequestMapping(value = "/contact", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> addUserContact(@ModelAttribute AddUserActivityContactForm addUserActivityContactForm) throws Exception {

        DataResponse response = new DataResponse();

        addUserActivityContactForm.decode();
        try {
            this.checkUserExists(addUserActivityContactForm.getUuid());
            Contact contact = userService.addContact(addUserActivityContactForm);
            response.setData(contact);
            response.setSuccess(true);
        } catch (VOJSException ve) {
            response.setSuccess(false);
            response.setError(ve.getMessage());
        } catch (Exception e) {
            response.setSuccess(false);
            response.setError("新增用户活动联系方式失败");
        }
        return response.map();

    }
    
    
    /**
     * 新增活动联系方式
     *
     * @param addUserActivityContactForm
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "查询用户活动联系方式", httpMethod = "GET", response = BaseResponse.class)
    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> getUserContact(@ModelAttribute AddUserActivityContactForm addUserActivityContactForm) throws Exception {

        DataResponse response = new DataResponse();

        addUserActivityContactForm.decode();
        try {
            this.checkUserExists(addUserActivityContactForm.getUuid());
            Contact contact = userService.getContact(addUserActivityContactForm);
            response.setData(contact);
            response.setSuccess(true);
        } catch (VOJSException ve) {
            response.setSuccess(false);
            response.setError(ve.getMessage());
        } catch (Exception e) {
            response.setSuccess(false);
            response.setError("新增用户活动联系方式失败");
        }
        return response.map();

    }
    
    /**
     * 用户注册
     * @param userRegisterForm
     * @return
     */
    @RequestMapping(value = "/wxAccount" ,method = RequestMethod.POST)
    @ApiOperation(value = "补全微信账户信息 openid等", httpMethod = "POST", response = UserResponse.class)
    public @ResponseBody
    Map<String, Object> index2(@ModelAttribute UserRegisterForm userRegisterForm) throws Exception {

        UserResponse userResponse = new UserResponse();

        try {
            userRegisterForm.decode();   

            User user = new User();
 
            BeanUtils.copyProperties(userRegisterForm, user);

            WXUnion union = null;
            
            if (StringUtils.isNotBlank(userRegisterForm.getWxUnionId()) && StringUtils.isNotBlank(userRegisterForm.getWxOpenId()) && StringUtils.isNotBlank(userRegisterForm.getWxPublicAccount())) {
                union = new WXUnion();
                union.setUnionId(userRegisterForm.getWxUnionId());
            	union.addWXAccount(new WXAccount(userRegisterForm.getWxUnionId(), userRegisterForm.getWxOpenId(), userRegisterForm.getWxPublicAccount()));
            	if(userService.existsWxAccount(union.getWxAccounts())){
               	 	userResponse.setSuccess(false);
                    userResponse.setError("该微信账户已存在");
                }else{
                	userService.addWXAccount(union.getWxAccounts(),union.getUnionId());
                	userResponse.setSuccess(true);
                }
            	
            }else{
            	 userResponse.setSuccess(false);
                 userResponse.setError("补充微信信息失败");
            }
            
            
        } catch (VOJSException e) {
            userResponse.setSuccess(false);
            userResponse.setError(e.getMessage());
        } catch (Exception e) {
            userResponse.setSuccess(false);
            userResponse.setError("补充微信信息失败");
        }
        return userResponse.map();
    }

    private Map showParams(HttpServletRequest request) {
        Map map = new HashMap();
        Enumeration paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = (String) paramNames.nextElement();
            String[] paramValues = request.getParameterValues(paramName);
            if (paramValues.length == 1) {
                String paramValue = paramValues[0];
                if (paramValue.length() != 0) {
                    paramValue = paramValue.replaceAll(" ", "+");
                    map.put(paramName, paramValue);
                }
            }
        }
        return map;
    }


    private String randomString(int length) {
        String value = "";
        for(int i=0;i<length;i++) {
            value += String.valueOf(java.util.concurrent.ThreadLocalRandom.current().nextInt(10));
        }
        return value;
    }

    protected void checkUserExists(String uuid) throws VOJSException {

        try {
            User user = userService.getUser(uuid);

            if (user == null) {
                throw new VOJSException("未能找到相应到用户");
            }
        } catch (VOJSException e) {
            throw new VOJSException("未能找到相应到用户");
        }

    }
    
    
    
    
}
