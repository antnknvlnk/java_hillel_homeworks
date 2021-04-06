package lesson_eight.util;

import lesson_eight.model.Account;
import lesson_eight.model.Client;
import lesson_eight.model.Status;
import lesson_eight.service.AccountServiceImpl;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    static Logger logger = Logger.getLogger(HibernateUtil.class);

    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Client.class);
                configuration.addAnnotatedClass(Account.class);
                configuration.addAnnotatedClass(Status.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                logger.error("Session factory Error: ", e);
            }
        }
        return sessionFactory;
    }
}
