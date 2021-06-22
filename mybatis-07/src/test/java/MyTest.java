import com.q.dao.BlogMapper;
import com.q.pojo.Blog;
import com.q.utlis.IdUtlis;
import com.q.utlis.mybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MyTest {
    @Test
    public void test() {
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IdUtlis.getId());
        blog.setTitle("Mybatis");
        blog.setAuthor("leslie");
        blog.setCreate_time(new Date());
        blog.setViews(9999);

        mapper.addBook(blog);

        blog.setId(IdUtlis.getId());
        blog.setTitle("Java");
        mapper.addBook(blog);

        blog.setId(IdUtlis.getId());
        blog.setTitle("Spring");
        mapper.addBook(blog);

        blog.setId(IdUtlis.getId());
        blog.setTitle("微服务");
        mapper.addBook(blog);

        sqlSession.close();
    }

    @Test
    public void testSelect() {
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap<String, Object> map1 = new HashMap<>();
        map1.put("title", "Java");
        map1.put("author", "leslie");
        List<Blog> blogs = mapper.QueryBlog(map1);
        System.out.println(blogs);
    }

    @Test
    public void testChoose() {
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap<Object, Object> map = new HashMap<>();
//        map.put("title", "Java");
        map.put("author", "leslie");
        map.put("views", 9999);
        List<Blog> blogs = mapper.QueryBlogChoose(map);
        System.out.println(blogs);
    }

    @Test
    public void test3() {
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
//        创建一个map来存数据
        HashMap<Object, Object> map = new HashMap<>();

        map.put("title", "Java123434324");
//        map.put("author", "狂神说22");
        map.put("id", "1");
        mapper.upDateTest(map);
        sqlSession.close();
    }

    @Test
    public void test4() {
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap<Object, Object> map = new HashMap<>();
        ArrayList<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(3);

        map.put("ids", ids);
        List<Blog> blogs = mapper.selectBlog(map);
        for (Blog blog : blogs) {
            System.out.println(blog);

        }
        sqlSession.close();
    }

    //测试<bind>标签
    @Test
    public void test011() {
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        List<Blog> selectBlogByName = mapper.selectBlogByName("a");
        for (Blog blog : selectBlogByName) {
            System.out.println(blog);

        }
        sqlSession.close();
    }
}
