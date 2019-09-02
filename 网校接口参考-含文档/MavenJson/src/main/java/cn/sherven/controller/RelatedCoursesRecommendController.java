package cn.sherven.controller;

import cn.sherven.mapper.LoyaltyIndexMapper;
import cn.sherven.query.LoyaltyIndexQuery;
import cn.sherven.query.RelatedCoursesRecommendQuery;
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
public class RelatedCoursesRecommendController {
    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping(value = "RelatedCoursesRecommend", method = RequestMethod.POST)
    @ResponseBody
    public MsgResponse index(@RequestBody List<RelatedCoursesRecommendQuery> reqList) throws JsonProcessingException {

        String url = "http://xxxx:9000/AssociateCourse";

        String queryStr = objectMapper.writeValueAsString(reqList);

        Map<String, String> param = new HashMap<>();
        param.put("json", queryStr);
        String result = HttpClientUtil.doPost(url, param);
        return new MsgResponse(result);
    }
}
