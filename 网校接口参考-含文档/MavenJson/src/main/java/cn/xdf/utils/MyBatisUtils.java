package cn.xdf.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtils {
    private static SqlSessionFactory sessionFactory;

    public static SqlSessionFactory getSessionFactory(){

        if (sessionFactory == null) {
            String resource = "SqlMapConfig.xml";
            InputStream resourceAsStream;
            try {
                resourceAsStream = Resources.getResourceAsStream(resource);
                sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
