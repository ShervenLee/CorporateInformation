package cn.xdf.mapper;

import cn.xdf.query.CoursePredictQuery;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CoursePredictMapper {
    // TODO: 2018/9/14
    CoursePredictQuery coursePredict(String sstudentcode , int schoolid);
}
