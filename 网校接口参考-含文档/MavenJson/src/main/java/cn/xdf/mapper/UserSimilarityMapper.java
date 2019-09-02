package cn.xdf.mapper;

import cn.xdf.query.UserSimilarityQuery;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserSimilarityMapper {
    // TODO: 2018/9/14
    UserSimilarityQuery userSimilarity(String sstudentcode , int nschoolid);
}
