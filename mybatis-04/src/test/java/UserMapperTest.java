import com.q.dao.UserMapper;
import com.q.pojo.User;
import com.q.utils.mybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {
    @Test
    public void test() {
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //        System.out.println(mapper.getUserById(1));
        //
        //        List<User> user = mapper.getUser();
        //        System.out.println(user);
        //
        ////        /*1.��ԃ��������
        //        List<User> userById = mapper.getUser();
        //        for (User user : userById) {
        //            System.out.println(user);
        //
        //        }
        ////         2.��ѯidΪ1������
        //        User userById1 = mapper.getUserById(1);
        //        System.out.println(userById1);
        ////         2.����
        //        mapper.addUser(new User(20, "hello", "123534"));
        ////         3.ɾ��
        //        mapper.deleteUser(3);

        //         4.�޸�
        //        int i = mapper.updateUser(new User(1, "hello1", "1346"));
        //        if (i > 0) {
        //            System.out.println("�ɹ��޸�");
        //        } else {
        //            System.out.println("�޸�ʧ��");
        //        }

        List<User> o = mapper.selectUser("%l%");
        for (User user : o) {
            System.out.println(user);

        }
        sqlSession.close();
        //

    }
}
