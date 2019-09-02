package cn.sherven.mapper;

import cn.sherven.query.LoyaltyIndexQuery;
import cn.sherven.query.result.LoyaltyIndexResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoyaltyIndexMapper {
    @Select("select a.sstudentcode,max(a.nschoolid) as schoolid ,sum(a.dpay) as pay_sum,count(a.dpay) as pay_count,max(a.dpay) as pay_max from ods.ods_bs_roster a " +
            "   where a.bvalid=1 and a.sstudentcode in ( #{sstudentcode} ) " +
            "   group by sstudentcode ")
    LoyaltyIndexResult executeQuert(String sstudentcode);
}
