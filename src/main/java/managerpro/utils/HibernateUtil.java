package managerpro.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final Logger LOGGER = LogManager.getLogger(HibernateUtil.class);

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                configuration.configure("/hibernate.cfg.xml");

                sessionFactory = configuration.buildSessionFactory();
            } catch (Exception e) {
                e.printStackTrace();
                LOGGER.error(e);
            } finally {
                LOGGER.info("\u001B[33mSession Factory Built\u001B[0m");
            }
        }
        return sessionFactory;
    }

    public static void shutdown() {
        if (!sessionFactory.isClosed()) {
            sessionFactory.close();
        }
        LOGGER.info("\u001B[33mSession Factory Closed\u001B[0m");
    }

}
