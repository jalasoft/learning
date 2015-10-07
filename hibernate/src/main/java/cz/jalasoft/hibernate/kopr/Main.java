package cz.jalasoft.hibernate.kopr;

import cz.jalasoft.hibernate.kopr.bean.MotivationIndex;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Collection;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 10/7/15.
 */
public class Main {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                        .configure("hibernate.cfg.xml")
                        .buildSessionFactory();

        Session session = sessionFactory.openSession();
        /*Transaction t1 = session.getTransaction();

        try {
            t1.begin();
            session.save(index(1, "I feel good"));
            session.save(index(2, "Don't look at me"));
            t1.commit();
        } catch (Exception e) {
            t1.rollback();
        }*/

        //try {
            //t2.begin();
            Collection<MotivationIndex> indexes = session.createQuery("from MotivationIndex").list();
            System.out.println(indexes);
       // }

        session.close();
        sessionFactory.close();
    }

    private static MotivationIndex index(int value, String descr) {
        MotivationIndex i1 = new MotivationIndex();
        i1.setValue(value);
        i1.setDescription(descr);

        return i1;
    }
}
