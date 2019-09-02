package cn.xdf.test;

import cn.xdf.entry.CoursesRecommend;
import cn.xdf.mapper.CoursesRecommendMapper;
import cn.xdf.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class Main {
    public static void main(String[] args){
        SqlSession openSession = MyBatisUtils.getSessionFactory().openSession();
        CoursesRecommendMapper mapper = openSession.getMapper(CoursesRecommendMapper.class);
        List<CoursesRecommend> dt = mapper.findAllByOneDate("dt");


        System.out.println("start------");
        for (CoursesRecommend item : dt){
            System.out.println(item);
        }
        System.out.println("end-----");
        
        
        openSession.commit();
        openSession.close();
        
        
    }
}
