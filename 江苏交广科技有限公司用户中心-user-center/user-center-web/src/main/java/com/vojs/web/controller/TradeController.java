package com.vojs.web.controller;

import com.vojs.bean.domain.User;
import com.vojs.bean.exception.VOJSException;
import com.vojs.bean.form.AddTradeForm;
import com.vojs.bean.response.BaseResponse;
import com.vojs.bean.response.UserResponse;
import com.vojs.service.TradeService;
import com.vojs.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 *
 */
@Api(value = "/trade", description = "用户支付订单信息")
@Controller
@RequestMapping("/trade")
public class TradeController {

    @Autowired
    private UserService userService;

    @Autowired
    private TradeService tradeService;

    @ApiOperation(value = "新增支付信息", httpMethod = "POST", response = BaseResponse.class)
    @RequestMapping(value = "", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> addTradeInfo(@ModelAttribute AddTradeForm addTradeForm) throws Exception {

        BaseResponse baseResponse = new BaseResponse();

        try {
        	addTradeForm.decode();
            User user = userService.getUser(addTradeForm.getUuid());
            
            if (user == null) {
                baseResponse.setSuccess(false);
                baseResponse.setError("未能找到用户");
            } else {
            	addTradeForm.setAge(user.getAge());
            	addTradeForm.setAvatar(user.getPortrait());
            	addTradeForm.setNickName(user.getNickname());
            	addTradeForm.setSex(Integer.parseInt(user.getGender()==null ?"0":user.getGender()));
            	addTradeForm.setUnionId(user.getWxUnionId());
                tradeService.addTrade(addTradeForm);
                baseResponse.setError("增加支付信息成功!");
                baseResponse.setSuccess(true);
            }
        } catch (VOJSException e) {
            baseResponse.setError(e.getMessage());
            baseResponse.setSuccess(false);
        }

        return baseResponse.map();
    }
}
