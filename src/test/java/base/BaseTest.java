package base;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class BaseTest {
    protected Logger log = Logger.getLogger(this.getClass());
    private SessionFactory sessionFactory;

    public BaseTest() {
        //其中.configure()默认去根目录下hibernate.cfg.xml文件
        final ServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
            log.error(e.getMessage());
        }
    }

    //开启Session
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    //关闭session
    public void closeSession(Session session) {
        if (session != null) {
            session.close();
        }
    }
}
