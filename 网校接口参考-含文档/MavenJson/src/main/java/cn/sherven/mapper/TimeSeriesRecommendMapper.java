package cn.sherven.mapper;

import cn.sherven.query.result.LoyaltyIndexResult;
import cn.sherven.query.result.TimeSeriesRecommendResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TimeSeriesRecommendMapper {
    @Select("select d.leaf1,d.leaf3,d.english,regexp_replace(d.steplevel,'Level','') as steplevel from dw.ml_catalog d where  a.nschoolid =#{nschoolid} and c.coursecode = #{coursecode}")
    TimeSeriesRecommendResult executeQuert(int nschoolid , String coursecode);
}
