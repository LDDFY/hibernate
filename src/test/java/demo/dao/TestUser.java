package demo.dao;

import com.hibernate.demo.vo.User;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.junit.Before;
import org.junit.Test;

public class TestUser {
    private static final Logger log = Logger.getLogger(TestUser.class);
    private SessionFactory sessionFactory;

    @Before
    public void setUp() throws Exception {
        //其中.configure()默认去根目录下hibernate.cfg.xml文件
        final ServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
            log.error(e.getMessage());
        }
    }

    @Test
    public void testInit() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User u = new User();
        u.setId(1);
        u.setName("AA");
        session.save(u);
        session.getTransaction().commit();
        session.close();
    }

}
