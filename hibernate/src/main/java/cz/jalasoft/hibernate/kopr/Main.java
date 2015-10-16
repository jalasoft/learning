package cz.jalasoft.hibernate.kopr;

import cz.jalasoft.hibernate.kopr.bean.MotivationIndex;
import cz.jalasoft.hibernate.kopr.h2.H2MotivationDao;
import cz.jalasoft.hibernate.kopr.h2.TransactionalMotivationDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Collection;
import java.util.List;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 10/7/15.
 */
public class Main {


    public static void main(String[] args) {
        Main m = new Main();
        m.newIndex(100, "Totlani depka");
        m.printAllIndexes();

        /*
        SessionFactory sessionFactory = new Configuration()
                        .configure("hibernate.cfg.xml")
                        .buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction t1 = session.getTransaction();
*/
/*
       try {
            t1.begin();
            session.save(index(5, 1, "I feel good"));
            session.save(index(6, 2, "Don't look at me"));
            t1.commit();
        } catch (Exception e) {
            t1.rollback();
         //  throw e;
        }

  */
       /* t1.begin();

        try {
            List<MotivationIndex> jeden = session.createQuery("from MotivationIndex m where m.value = 0").list();

            MotivationIndex i = jeden.get(0);

            i.setName("Prdel");
            t1.commit();
        } catch (Exception e) {
            t1.rollback();
            throw new RuntimeException(e);
        }



        List<MotivationIndex> nn = session.createQuery("from MotivationIndex").list();

        System.out.println(nn);


        //try {
            //t2.begin();
            Collection<MotivationIndex> indexes = session.createQuery("from MotivationIndex").list();
            System.out.println(indexes);
       // }

        session.close();
        sessionFactory.close();*/
    }

    private static MotivationIndex index(int id, int value, String name) {
        MotivationIndex i1 = new MotivationIndex();
        i1.setValue(value);
        i1.setName(name);
        //i1.setId(id);

        return i1;
    }


    private final MotivationDao dao = new TransactionalMotivationDao(new H2MotivationDao());

    public void newIndex(int value, String name) {
        dao.newMotivation(value, name);
    }

    public void printAllIndexes() {
        Collection<MotivationIndex> i = dao.allMotivations();

        System.out.println(i);
    }
}
