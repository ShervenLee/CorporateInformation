package cn.xdf.mapper;

import cn.xdf.entry.CoursesRecommend;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * classname CoursesRecommendMapper
 * Description 课程推荐接口
 */

    @Mapper
    public interface CoursesRecommendMapper {

        @Select("select a.sstudentcode,max(a.nschoolid) as schoolid ,sum(a.dpay) as pay_sum,count(a.dpay) as pay_count,max(a.dpay) as pay_max from ods.ods_bs_roster a      \n" +
                "   where a.bvalid=1 and a.sstudentcode in ( #{dt} )\n" +
                "   group by sstudentcode")
        List<CoursesRecommend> findAllByOneDate(String dt);
    }
