package cn.xdf.serivce;

import cn.xdf.query.UserSimilarityQuery;
import cn.xdf.mapper.UserSimilarityMapper;
import cn.xdf.util.MsgResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@Service
public class UserSimilarityService {
    @Autowired
    private UserSimilarityMapper mapper;

//    public MsgResponse associateCourse(String json) {
//        MsgResponse msg = MsgResponse.success();
//        ObjectMapper jsonMapper = new ObjectMapper();
//        try {
//            List<UserSimilarityQuery> list = jsonMapper.readValue(json, new TypeReference<List<UserSimilarityQuery>>() {
//            });
//
//            for (UserSimilarityQuery item : list) {
//                UserSimilarityQuery result = mapper.userSimilarity(item.getSstudentcode(), item.getNschoolid());
//
//                msg.add("nschoolid", result.getNschoolid());
//                msg.add("sstudentcode", result.getSstudentcode());
//                msg.add("courseCount", result.getCourseCount());
//                msg.add("dtbirthday", result.getDtbirthday());
//                msg.add("ngender", result.getNgender());
//                msg.add("badult", result.isBadult());
//                msg.add("sname", result.getSname());
//                msg.add("similarity",result.getSimilarity());
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
