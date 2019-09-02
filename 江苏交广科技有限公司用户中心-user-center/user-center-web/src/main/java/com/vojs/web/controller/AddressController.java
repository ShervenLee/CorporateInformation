package com.vojs.web.controller;

import com.vojs.bean.domain.Address;
import com.vojs.bean.domain.User;
import com.vojs.bean.exception.VOJSException;
import com.vojs.bean.form.AddUserTagForm;
import com.vojs.bean.form.AddressForm;
import com.vojs.bean.form.DeleteAddressForm;
import com.vojs.bean.response.BaseResponse;
import com.vojs.bean.response.DataResponse;
import com.vojs.bean.response.UserResponse;
import com.vojs.service.AddressService;
import com.vojs.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by chenyunjie on 2017/4/28.
 */
@Api(value = "/address", description = "用户地址操作", position = 5)
@Controller
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "" ,method = RequestMethod.POST)
    @ApiOperation(value = "用户地址添加", httpMethod = "POST", response = DataResponse.class)
    public @ResponseBody
    Map<String, Object> add(@ModelAttribute AddressForm addressForm) throws Exception {

        DataResponse response = new DataResponse();

        addressForm.decode();
        try {
            this.checkUserExists(addressForm.getUuid());
            Address address = new Address();

            BeanUtils.copyProperties(addressForm, address);

            Address resultAddress = addressService.addAddress(address);

            response.setData(resultAddress);
            response.setSuccess(true);
        } catch (VOJSException e) {
            response.setSuccess(false);
            response.setError(e.getMessage());
        } catch (Exception e) {
            response.setSuccess(false);
            response.setError(e.getMessage());
        }

        return response.map();
    }

    @RequestMapping(value = "" ,method = RequestMethod.GET)
    @ApiOperation(value = "用户地址列表", httpMethod = "GET", response = BaseResponse.class)
    public @ResponseBody
    Map<String, Object> list(@ModelAttribute AddressForm addressForm) throws Exception {

        DataResponse response = new DataResponse();

        addressForm.decode();

        try {
            this.checkUserExists(addressForm.getUuid());
            Address address = new Address();
            BeanUtils.copyProperties(addressForm, address);
            List<Address> addresses = addressService.list(address);
            response.setSuccess(true);
            response.setData(addresses);
        } catch (VOJSException e) {
            response.setSuccess(false);
            response.setError(e.getMessage());
        } catch (Exception e) {
            response.setSuccess(false);
            response.setError("获取用户地址失败");
        }
        return response.map();
    }

    @RequestMapping(value = "/delete" ,method = RequestMethod.POST)
    @ApiOperation(value = "用户地址删除", httpMethod = "POST", response = BaseResponse.class)
    public @ResponseBody
    Map<String, Object> delete(@ModelAttribute DeleteAddressForm deleteAddressForm) throws Exception {

        DataResponse response = new DataResponse();

        deleteAddressForm.decode();

        try {
            this.checkUserExists(deleteAddressForm.getUuid());
            addressService.deleteAddress(deleteAddressForm.getId(), deleteAddressForm.getUuid());
            response.setSuccess(true);
        } catch (VOJSException e) {
            response.setSuccess(false);
            response.setError(e.getMessage());
        } catch (Exception e) {
            response.setSuccess(false);
            response.setError("删除用户地址出现异常");
        }

        return response.map();
    }

    @RequestMapping(value = "" ,method = RequestMethod.PUT)
    @ApiOperation(value = "用户地址更新", httpMethod = "PUT", response = BaseResponse.class)
    public @ResponseBody
    Map<String, Object> update(@ModelAttribute AddressForm addressForm) throws Exception {

        DataResponse response = new DataResponse();

        addressForm.decode();

        try {
            this.checkUserExists(addressForm.getUuid());
            Address address = new Address();

            BeanUtils.copyProperties(addressForm, address);

            Address resultAddress = addressService.updateAddress(address);

            response.setData(resultAddress);
            response.setSuccess(true);

        } catch (VOJSException e) {
            response.setSuccess(false);
            response.setError(e.getMessage());
        } catch (Exception e) {
            response.setSuccess(false);
            response.setError("用户地址更新出现异常");
        }

        return response.map();
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
