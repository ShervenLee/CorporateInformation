package cn.xdf.mapper;

import cn.xdf.entry.LoyaltyIndex;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * classname LoyaltyIndexMapper
 * Description 忠诚度计算接口
 */
@Mapper
public interface LoyaltyIndexMapper {

        @Select("select a.sstudentcode,max(a.nschoolid) as schoolid ,sum(a.dpay) as pay_sum,count(a.dpay) as pay_count,max(a.dpay) as pay_max from ods.ods_bs_roster a      \n" +
                "   where a.bvalid=1 and a.sstudentcode in ( #{dt} )\n" +
                "   group by sstudentcode")
        List<LoyaltyIndex> findAllByOneDate(String dt);
    }

