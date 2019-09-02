package cn.xdf.mapper;

import cn.xdf.entry.UserSimilarityRecommend;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * classname TimeSeriesRecommendMapper
 * Description 相似用户推荐
 */
@Mapper
public interface UserSimilarityRecommendMapper {
    @Select("        with temp as (     select * from (\n" +
            "                   select a.Nschoolid ,b.coursecode,b.sareacode,a.sstudentcode\n" +
            "                   from ods.ods_bs_roster a\n" +
            "                   inner join ods.ods_bs_class b on a.nschoolid=b.nschoolid and a.sclasscode=b.scode\n" +
            "                   where  a.bvalid=1 and a.sstudentcode='?' and a.nschoolid='?'                                     --传入参数学生code,学校id  例如 where  a.bvalid=1 and a.sstudentcode='NC127730' and a.nschoolid='35'  \n" +
            "                   order by a.dtindate desc)\n" +
            "                   limit 5)\n" +
            "       \n" +
            "\n" +
            "\n" +
            "      \n" +
            "       select  aaa1.*,  from_unixtime(cast(ccc1.dtbirthday as bigint  ),'yyyy-mm-dd')  as dtbirthday,ccc1.ngender,ccc1.badult ,ccc1.sname\n" +
            "       from (\n" +
            "              select aa1.Nschoolid  ,sstudentcode,count(coursecode) as course_count  from temp aa1 group by Nschoolid,sstudentcode)aaa1\n" +
            "       inner join ods.ods_bs_student ccc1 on aaa1.sstudentcode =ccc1.scode and aaa1.Nschoolid=ccc1.nschoolid\n" +
            "                   \n" +
            "                  \n" +
            "       union all\n" +
            "       \n" +
            "       \n" +
            "       \n" +
            "       select aaa.*, from_unixtime(cast(ccc.dtbirthday as bigint)  ,'yyyy-mm-dd')   as dtbirthday,ccc.ngender,ccc.badult ,ccc.sname from (\n" +
            "       select aa.Nschoolid,aa.sstudentcode, count(aa.sstudentcode)  as course_count  from  ods.ods_bs_roster aa inner join\n" +
            "       ods.ods_bs_class bb on aa.nschoolid=bb.nschoolid and aa.sclasscode=bb.scode\n" +
            "       \n" +
            "       inner join temp cc on\n" +
            "       \n" +
            "        aa.nschoolid=cc.Nschoolid and bb.coursecode =cc.coursecode and bb.sareacode=cc.sareacode\n" +
            "       group by  aa.Nschoolid,aa.sstudentcode\n" +
            "       order by  count(aa.sstudentcode) desc limit 30 )aaa inner join  ods.ods_bs_student ccc on aaa.sstudentcode =ccc.scode and aaa.Nschoolid=ccc.nschoolid   where aaa.sstudentcode <>'?'   --传入参数学生code 例如：    where aaa.sstudentcode <>'NC127730'")
    List<UserSimilarityRecommend> findAllByOneDate(String dt);
}
