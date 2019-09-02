package cn.sherven.mapper;

import cn.sherven.query.result.UserSimilarityRecommendResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserSimilarityRecommendMapper {
    @Select("with temp as (     select * from (" +
            "                   select a.Nschoolid ,b.coursecode,b.sareacode,a.sstudentcode" +
            "                   from ods.ods_bs_roster a " +
            "                   inner join ods.ods_bs_class b on a.nschoolid=b.nschoolid and a.sclasscode=b.scode" +
            "                   where  a.bvalid=1 and a.sstudentcode='#{sstudentcode}' and a.nschoolid='#{nschoolid}'                                     --传入参数学生code,学校id  例如 where  a.bvalid=1 and a.sstudentcode='NC127730' and a.nschoolid='35'  " +
            "                   order by a.dtindate desc)" +
            "                   limit 5)" +
            "       " +
            "      " +
            "       select  aaa1.*,  from_unixtime(cast(ccc1.dtbirthday as bigint  ),'yyyy-mm-dd')  as dtbirthday,ccc1.ngender,ccc1.badult ,ccc1.sname" +
            "       from (" +
            "              select aa1.Nschoolid  ,sstudentcode,count(coursecode) as course_count  from temp aa1 group by Nschoolid,sstudentcode)aaa1 " +
            "       inner join ods.ods_bs_student ccc1 on aaa1.sstudentcode =ccc1.scode and aaa1.Nschoolid=ccc1.nschoolid " +
            "                   " +
            "                  " +
            "       union all" +
            "       " +
            "       " +
            "       " +
            "       select aaa.*, from_unixtime(cast(ccc.dtbirthday as bigint)  ,'yyyy-mm-dd')   as dtbirthday,ccc.ngender,ccc.badult ,ccc.sname from (" +
            "       select aa.Nschoolid,aa.sstudentcode, count(aa.sstudentcode)  as course_count  from  ods.ods_bs_roster aa inner join " +
            "       ods.ods_bs_class bb on aa.nschoolid=bb.nschoolid and aa.sclasscode=bb.scode" +
            "       " +
            "       inner join temp cc on" +
            "       " +
            "        aa.nschoolid=cc.Nschoolid and bb.coursecode =cc.coursecode and bb.sareacode=cc.sareacode" +
            "       group by  aa.Nschoolid,aa.sstudentcode" +
            "       order by  count(aa.sstudentcode) desc limit 30 )aaa inner join  ods.ods_bs_student ccc on aaa.sstudentcode =ccc.scode and aaa.Nschoolid=ccc.nschoolid   where aaa.sstudentcode <>'#{sstudentcode}'   --传入参数学生code 例如：    where aaa.sstudentcode <>'NC127730'")
    UserSimilarityRecommendResult executeQuert(String sstudentcode,String nschoolid);

}
