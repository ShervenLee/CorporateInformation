package cn.xdf.mapper;


import cn.xdf.entry.RelatedCoursesRecommend;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * classname RelatedCoursesRecommendMapper
 * Description 关联接口推荐接口
 */
@Mapper
public interface RelatedCoursesRecommendMapper {

    @Select("select a.Nschoolid,b.coursecode ,a.sstudentcode\n" +
            "                   from ods.ods_bs_roster a\n" +
            "                   inner join ods.ods_bs_class b on a.nschoolid=b.nschoolid and a.sclasscode=b.scode\n" +
            "                   where  a.bvalid=1 and a.sstudentcode=(#{dt}) and a.nschoolid=()       -- 学生code  学校id    \n" +
            "                   order by a.dtindate desc limit 1")
    List<RelatedCoursesRecommend> findAllByOneDate(String dt);
}
