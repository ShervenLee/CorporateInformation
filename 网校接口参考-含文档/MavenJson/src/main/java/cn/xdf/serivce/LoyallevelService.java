package cn.xdf.serivce;

import cn.xdf.mapper.CoursePredictMapper;
import cn.xdf.mapper.LoyallevelMapper;
import cn.xdf.query.CoursePredictQuery;
import cn.xdf.query.LoyallevelQuery;
import cn.xdf.util.MsgResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@Service
public class LoyallevelService {
    private LoyallevelMapper mapper;

//    public MsgResponse associateCourse(String json) {
//        MsgResponse msg = MsgResponse.success();
//        ObjectMapper jsonMapper = new ObjectMapper();
//        try {
//            List<LoyallevelQuery> list = jsonMapper.readValue(json, new TypeReference<List<LoyallevelQuery>>() {
//            });
//
//            for (LoyallevelQuery item : list) {
//                LoyallevelQuery result = mapper.loyallevel(item);
//                    msg.add("sstudentcode", result.getSstudentcode());
//                    msg.add("schoolid", result.getSchoolid());
//                    msg.add("pay_sum", result.getPay_sum());
//                    msg.add("pay_count", result.getPay_count());
//                    msg.add("pay_max", result.getPay_sum());
//                    msg.add("result", result.getResult());
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
