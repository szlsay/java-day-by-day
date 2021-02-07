package cn.st.test;

import cn.st.domain.User;
import cn.st.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: st
 * @create: 2021-02-07 10:37
 **/

public class MapperTest {
    @Test
    public void test1() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //模拟条件user
        User condition = new User();
//        condition.setId(1);
//        condition.setUsername("xxx");
        condition.setPassword("123");

        List<User> userList = mapper.findByCondition(condition);

        //模拟ids的数据
//        List<Integer> ids = new ArrayList<Integer>();
//        ids.add(1);
//        ids.add(2);
//
//        List<User> userList = mapper.findByIds(ids);
        System.out.println(userList);
    }
}
