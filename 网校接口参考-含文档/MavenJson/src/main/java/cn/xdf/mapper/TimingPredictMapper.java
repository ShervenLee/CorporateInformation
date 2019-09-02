package cn.xdf.mapper;

import cn.xdf.query.TimingPredictQuery;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TimingPredictMapper {
    // TODO: 2018/9/14
    TimingPredictQuery timingPredict(String leaf1, String leaf3, int english, int steplevel);
}
