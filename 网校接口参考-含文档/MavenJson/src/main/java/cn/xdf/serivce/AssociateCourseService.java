package cn.xdf.serivce;

import cn.xdf.query.AssociateCourseQuery;
import cn.xdf.mapper.AssociateCourseMapper;
import cn.xdf.util.MsgResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@Service
public class AssociateCourseService {
    @Autowired
    private AssociateCourseMapper mapper;

//    public MsgResponse associateCourse(String json) {
//        MsgResponse msg = MsgResponse.success();
//        ObjectMapper jsonMapper = new ObjectMapper();
//        try {
//            List<AssociateCourseQuery> list = jsonMapper.readValue(json, new TypeReference<List<AssociateCourseQuery>>() {
//            });
//
//            for (AssociateCourseQuery item : list) {
//                AssociateCourseQuery result = mapper.associateCourse(item.getCoursecode(),item.getSchoolid());
//                msg.add("coursecode",result.getCoursecode());
//                msg.add("schoolid", result.getSchoolid());
//                msg.add("sstudentcode", result.getSstudentcode());
//                msg.add("relation",result.getRelation());
//            }
//        } catch (IOException e) {
//            msg = MsgResponse.fail();
//            msg.setMsg("json 转换异常");
//            e.printStackTrace();
//
//        }
//        return msg;
//    }
}
