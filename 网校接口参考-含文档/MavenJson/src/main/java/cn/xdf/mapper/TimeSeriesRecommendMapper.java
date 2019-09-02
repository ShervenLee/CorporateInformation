package cn.xdf.mapper;

import cn.xdf.entry.TimeSeriesRecommend;
import cn.xdf.entry.UserSimilarityRecommend;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * classname UserSimilarityRecommendMapper
 * Description 时序推荐接口
 */
@Mapper
public interface TimeSeriesRecommendMapper {
    @Select("select d.leaf1,d.leaf3,d.english,regexp_replace(d.steplevel,'Level','') as steplevel from dw.ml_catalog d where  a.nschoolid = (?) and c.coursecode = (?)")
    List<TimeSeriesRecommend> findAllByOneDate(String dt);

}