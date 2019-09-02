package cn.sherven.controller;

import cn.sherven.mapper.LoyaltyIndexMapper;
import cn.sherven.query.LoyaltyIndexQuery;
import cn.sherven.query.result.LoyaltyIndexResult;
import cn.sherven.response.MsgResponse;
import cn.sherven.util.HttpClientUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoyaltyIndexController {
    @Autowired
    private LoyaltyIndexMapper mapper;
    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping(value = "LoyaltyIndex", method = RequestMethod.POST)
    @ResponseBody
    public MsgResponse index(@RequestBody List<LoyaltyIndexQuery> reqList) throws JsonProcessingException {

        String url = "http://xxxx:9000/loyallevel";

        List<LoyaltyIndexResult> queryList = new ArrayList<>(reqList.size());
        for (LoyaltyIndexQuery item : reqList) {
            queryList.add(mapper.executeQuert(item.getSchoolid()));
        }
        String queryStr = objectMapper.writeValueAsString(queryList);
        Map<String, String> param = new HashMap<>();
        param.put("json", queryStr);
        String result = HttpClientUtil.doPost(url, param);
        return new MsgResponse(result);
    }
}
