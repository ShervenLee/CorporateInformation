package cn.xdf.serivce;

import cn.xdf.query.TimingPredictQuery;
import cn.xdf.mapper.TimingPredictMapper;
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
public class TimingPredictService {
    @Autowired
    private TimingPredictMapper mapper;

//    public MsgResponse associateCourse(String json) {
//        MsgResponse msg = MsgResponse.success();
//        ObjectMapper jsonMapper = new ObjectMapper();
//        try {
//            List<TimingPredictQuery> list = jsonMapper.readValue(json, new TypeReference<List<TimingPredictQuery>>() {
//            });
//
//            for (TimingPredictQuery item : list) {
//                TimingPredictQuery result = mapper.timingPredict(item.getLeaf1(),item.getLeaf3(),item.getEnglish(),item.getSteplevel());
//                if (result == null) {
//                    msg.add("nschoolid", item.getNschoolid());
//                    msg.add("coursecode", item.getCoursecode());
//                    msg.add("predictmonth", (item.getPredictmonth()+3)%12);
//                    msg.add("birthday", "1970");
//                    msg.add("gender", "0");
//                    msg.add("begainmonth", (item.getPredictmonth()+1)%12);
//                    msg.add("endmonth", (item.getPredictmonth()+2)%12);
//                    msg.add("nlesson", "15");
//                    msg.add("nnormalcount", "20");
//                    msg.add("bvip", "0");
//                    msg.add("bIsResideClass", item.getbIsResideClass());
//                    msg.add("leaf1", item.getLeaf1());
//                    msg.add("leaf3", item.getLeaf3());
//                    msg.add("english", item.getEnglish());
//                    msg.add("steplevel", item.getSteplevel());
//                    //文档大写Enrollmonth，此处应该是enrollmonth
//                    msg.add("enrollmonth", item.getPredictmonth()%12);
//                    msg.add("sstudentcode", item.getSstudentcode());
//                    msg.add("sAreaCode", item.getsAreaCode());
//                    msg.add("sclasstime", "17");
//                    msg.add("bvalid", item.getBvalid());
//
//                } else {
//                    msg.add("nschoolid", result.getNschoolid());
//                    msg.add("coursecode", result.getCoursecode());
//                    msg.add("predictmonth", result.getPredictmonth());
//                    msg.add("birthday", result.getBirthday());
//                    msg.add("gender", result.getGender());
//                    msg.add("begainmonth", result.getBegainmonth());
//                    msg.add("endmonth", result.getEndmonth());
//                    msg.add("nlesson", result.getNlesson());
//                    msg.add("nnormalcount", result.getNnormalcount());
//                    msg.add("bvip", result.getBvip());
//                    msg.add("bIsResideClass", result.getbIsResideClass());
//                    msg.add("leaf1", result.getLeaf1());
//                    msg.add("leaf3", result.getLeaf3());
//                    msg.add("english", result.getEnglish());
//                    msg.add("steplevel", result.getSteplevel());
//                    //文档大写Enrollmonth，此处应该是enrollmonth
//                    msg.add("enrollmonth", result.getEnrollmonth());
//                    msg.add("sstudentcode", result.getSstudentcode());
//                    msg.add("sAreaCode", result.getsAreaCode());
//                    msg.add("sclasstime", result.getSclasstime());
//                    msg.add("bvalid", result.getBvalid());
//                }
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
