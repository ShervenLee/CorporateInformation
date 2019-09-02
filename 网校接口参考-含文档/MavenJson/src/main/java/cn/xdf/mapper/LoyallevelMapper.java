package cn.xdf.mapper;

import cn.xdf.query.LoyallevelQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache   .ibatis.annotations.Select;

@Mapper
public interface LoyallevelMapper {
    // TODO: 2018/9/14
    @Select("这里就是粘贴文档里的语句")
     LoyallevelQuery loyallevel(LoyallevelQuery loyallevelQuery);
}
