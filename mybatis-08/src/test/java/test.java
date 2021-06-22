import com.q.dao.User_Mapper;
import com.q.pojo.User;
import com.q.utlis.mybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class test {
    @Test
    public void test1() {
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        SqlSession sqlSession1 = mybatisUtils.getSqlSession();

        //一级缓存作用域只是在sqlSession作用域 用同一个mapper做就一样
        User_Mapper mapper = sqlSession.getMapper(User_Mapper.class);
        User_Mapper mapper1 = sqlSession1.getMapper(User_Mapper.class);
        User user = mapper.secretUser(1);
        System.out.println(user);
        System.out.println("============");
        User user1 = mapper1.secretUser(1);
        System.out.println(user == user1);
        sqlSession.close();
    }

    @Test
    public void test02() {
//       一级缓存  作用域就是一个sqlSession
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        SqlSession sqlSession1 = mybatisUtils.getSqlSession();

        User_Mapper mapper = sqlSession.getMapper(User_Mapper.class);
        User_Mapper mapper1 = sqlSession.getMapper(User_Mapper.class);
//        User_Mapper mapper1 = sqlSession1.getMapper(User_Mapper.class);
        User user = mapper.secretUser(1);
        User user1 = mapper1.secretUser(1);
        System.out.println(user == user1);

    }
}
