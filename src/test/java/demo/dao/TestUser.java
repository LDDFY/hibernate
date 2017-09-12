package demo.dao;

import base.BaseTest;
import com.hibernate.demo.vo.User;
import org.hibernate.Session;
import org.junit.Test;

public class TestUser extends BaseTest {

    @Test
    public void testInit() {
        Session session = getSession();
        session.beginTransaction();
        User u = new User();
        u.setId(1);
        u.setName("AA");
        session.save(u);
        session.getTransaction().commit();
        closeSession(session);
        log.info("插入信息成功！");
    }

}
