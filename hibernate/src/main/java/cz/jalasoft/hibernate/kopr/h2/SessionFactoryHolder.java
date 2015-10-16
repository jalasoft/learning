package cz.jalasoft.hibernate.kopr.h2;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 10/10/15.
 */
public class SessionFactoryHolder {

    private static SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .buildSessionFactory();

    static SessionFactory sessionFactory() {
        return sessionFactory;
    }
}
