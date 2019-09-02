package cn.xdf.mapper;

import cn.xdf.query.StudyAbroadQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudyAbroadMapper {
    @Select("select a.nschoolid,a.month, a.coursecode, a.coursename,sum(predict) as predict " +
            "from  dw. dw_predecit_2018   a " +
            "where  nschoolid=#nschoolid{} and a.coursecode=#{coursecode}" +
            "group by a.nschoolid, a.month, a.coursecode, a.coursename")
    List<StudyAbroadQuery> studyAbroad(int nschoolid,String coursecode);
}
