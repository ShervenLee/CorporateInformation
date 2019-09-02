package cn.sherven.controller;

import cn.sherven.mapper.CoursesRecommendMapper;
import cn.sherven.mapper.LoyaltyIndexMapper;
import cn.sherven.mapper.TimeSeriesRecommendMapper;
import cn.sherven.query.CoursesRecommendQuery;
import cn.sherven.query.LoyaltyIndexQuery;
import cn.sherven.query.TimeSeriesRecommendQuery;
import cn.sherven.query.result.CoursesRecommendResult;
import cn.sherven.query.result.LoyaltyIndexResult;
import cn.sherven.query.result.TimeSeriesRecommendResult;
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
public class TimeSeriesRecommendController {
    @Autowired
    private TimeSeriesRecommendMapper timeMapper;

    @Autowired
    private CoursesRecommendMapper coursesMapper;
    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping(value = "TimeSeriesRecommend", method = RequestMethod.POST)
    @ResponseBody
    public MsgResponse index(@RequestBody List<CoursesRecommendQuery> reqList) throws JsonProcessingException {
        String url = "http://xxxx:9000/CoursePredict";
        List<CoursesRecommendResult> coursesList = new ArrayList<>(reqList.size());
        List<CoursesRecommendResult> coursesQuery = new ArrayList<>(reqList.size());
        for (CoursesRecommendQuery item : reqList) {
            CoursesRecommendResult courses = coursesMapper.executeQuert(item.getSstudentcode(), item.getSchoolid());

            TimeSeriesRecommendQuery timeQuery = new TimeSeriesRecommendQuery();
            timeQuery.setCoursecode(courses.getCoursecode());
            timeQuery.setNschoolid(courses.getNschoolid());

            TimeSeriesRecommendResult timeResult = timeMapper.executeQuert(timeQuery.getNschoolid(), timeQuery.getCoursecode());


            courses.setPredictmonth((courses.getPredictmonth() + 3) % 12);
            courses.setBegainmonth((courses.getPredictmonth() + 1) % 12);
            courses.setEndmonth((courses.getPredictmonth() + 2) % 12);
            courses.setLeaf1(timeResult.getLeaf1());
            courses.setLeaf3(timeResult.getLeaf3());
            courses.setEnglish(timeResult.getEnglish());
            courses.setSteplevel(timeResult.getSteplevel());
            courses.setEnrollmonth(courses.getPredictmonth() % 12);

            coursesQuery.add(courses);

        }

        String queryStr = objectMapper.writeValueAsString(coursesQuery);
        Map<String, String> param = new HashMap<>();
        param.put("json", queryStr);
        String result = HttpClientUtil.doPost(url, param);
        return new MsgResponse(result);
    }
}
