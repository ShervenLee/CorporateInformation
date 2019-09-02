package cn.sherven.mapper;

import cn.sherven.query.LoyaltyIndexQuery;
import cn.sherven.query.result.CoursesRecommendResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CoursesRecommendMapper {

    @Select("with roster as (select * from ods.ods_bs_roster aa where    aa.nschoolid= #{nschoolid} and aa.sstudentcode=#{sstudentcode} and  aa.dtindate  >=date_add(from_unixtime(unix_timestamp(),'yyyy-MM-dd HH:mm:ss'),-360) " +
            "   order by aa.dtindate desc limit 1)," +
            "student as (select * from ods.ods_bs_student bb where  bb.NSCHOOLID= #{nschoolid} and bb.scode= #{sstudentcode} )" +
            "SELECT a.nschoolid ,c.coursecode ,(month(from_unixtime(unix_timestamp(),'yyyy-MM-dd HH:mm:ss'))+3)%12 as predictmonth" +
            "       ,year(b.dtbirthday) as birthday,b.ngender as gender  " +
            "       ,month(c.dtbegindate) as begainmonth,month(c.dtenddate) as endmonth ,c.nlesson,c.nnormalcount,c.bvip,c.bIsResideClass  " +
            "       ,d.leaf1,d.leaf3,d.english,regexp_replace(d.steplevel,'Level','') as steplevel,month(a.dtindate) as enrollmonth,a.sstudentcode,c.sAreaCode,regexp_replace(c.sclasstime,',','_') as sclasstime,a.bvalid" +
            "        FROM roster a  " +
            "      tinner join student b on a.sstudentcode =b.scode " +
            "       inner join  ods.ods_bs_class c on a.sclasscode=c.scode  and a.nschoolid=c.nschoolid   " +
            "       inner join dw.ml_catalog d on a.nschoolid =d.schoolid and c.coursecode = d.code " +
            "        where     c.coursecode is not null ")
    CoursesRecommendResult executeQuert(String sstudentcode,String nschoolid);
}
