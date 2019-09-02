package cn.xdf.mapper;

import cn.xdf.query.AssociateCourseQuery;
import org.apache.ibatis.annotations.Mapper;

/**
 * 关联课程推荐
 */
@Mapper
public interface AssociateCourseMapper {
    // TODO: 2018/9/14  
    AssociateCourseQuery associateCourse(String sstudentcode , int schoolid);
}
