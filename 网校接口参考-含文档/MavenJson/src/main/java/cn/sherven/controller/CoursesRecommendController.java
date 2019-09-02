package cn.sherven.controller;

import cn.sherven.mapper.CoursesRecommendMapper;
import cn.sherven.query.CoursesRecommendQuery;
import cn.sherven.query.result.CoursesRecommendResult;
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
public class CoursesRecommendController {
    @Autowired
    private CoursesRecommendMapper mapper;
    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping(value = "CoursesRecommend", method = RequestMethod.POST)
    @ResponseBody
    public MsgResponse index(@RequestBody List<CoursesRecommendQuery> reqList) throws JsonProcessingException {

        String url = "http://xxxx:9000/CoursePredict";

        List<CoursesRecommendResult> queryList = new ArrayList<>(reqList.size());

        for (CoursesRecommendQuery item : reqList) {
            CoursesRecommendResult coursesRecommendResult = mapper.executeQuert(item.getSstudentcode(),item.getSchoolid());

            if (null == coursesRecommendResult.getBirthday()) {
                coursesRecommendResult.setBirthday(1970);
            }
            if (null == coursesRecommendResult.getGender()) {
                coursesRecommendResult.setGender(0);
            }
            if (null == coursesRecommendResult.getBegainmonth()) {
                coursesRecommendResult.setBegainmonth(1);
            }
            if (null == coursesRecommendResult.getEndmonth()) {
                coursesRecommendResult.setEndmonth(1);
            }
            if (null == coursesRecommendResult.getNlesson()) {
                coursesRecommendResult.setNlesson(15);
            }
            if (null == coursesRecommendResult.getNnormalcount()) {
                coursesRecommendResult.setNnormalcount(20);
            }
            if (null == coursesRecommendResult.getBvip()) {
                coursesRecommendResult.setBvip(0);
            }

            if (null == coursesRecommendResult.getEnrollmonth()) {
                coursesRecommendResult.setEnrollmonth(1);
            }
            if (null == coursesRecommendResult.getSclasstime()) {
                coursesRecommendResult.setSclasstime(17);
            }

            queryList.add(coursesRecommendResult);
        }


        String queryStr = objectMapper.writeValueAsString(queryList);

        Map<String, String> param = new HashMap<>();
        param.put("json", queryStr);
        String result = HttpClientUtil.doPost(url, param);
        return new MsgResponse(result);
    }
}
