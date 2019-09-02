package cn.sherven.controller;

import cn.sherven.mapper.LoyaltyIndexMapper;
import cn.sherven.mapper.UserSimilarityRecommendMapper;
import cn.sherven.query.LoyaltyIndexQuery;
import cn.sherven.query.UserSimilarityRecommendQuery;
import cn.sherven.query.result.LoyaltyIndexResult;
import cn.sherven.query.result.UserSimilarityRecommendResult;
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
public class UserSimilarityRecommendController {
    @Autowired
    private UserSimilarityRecommendMapper mapper;
    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping(value = "UserSimilarityRecommend", method = RequestMethod.POST)
    @ResponseBody
    public MsgResponse index(@RequestBody List<UserSimilarityRecommendQuery> reqList) throws JsonProcessingException {

        String url = "http://xxxx:9000/UserSimilarity";

        List<UserSimilarityRecommendResult> queryList = new ArrayList<>(reqList.size());

        for (UserSimilarityRecommendQuery item : reqList) {
            queryList.add(mapper.executeQuert(item.getSstudentcode(),item.getSchoolid()));
        }

        String queryStr = objectMapper.writeValueAsString(queryList);
        Map<String, String> param = new HashMap<>();
        param.put("json", queryStr);
        String result = HttpClientUtil.doPost(url, param);
        return new MsgResponse(result);
    }
}
