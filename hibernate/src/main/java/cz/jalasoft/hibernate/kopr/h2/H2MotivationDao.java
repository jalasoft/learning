package cz.jalasoft.hibernate.kopr.h2;

import cz.jalasoft.hibernate.kopr.MotivationDao;
import cz.jalasoft.hibernate.kopr.bean.MotivationIndex;
import org.hibernate.Session;

import java.util.Collection;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 10/10/15.
 */
public class H2MotivationDao implements MotivationDao {

    @Override
    public Collection<MotivationIndex> allMotivations() {
        Collection<MotivationIndex> result = session().createQuery("from MotivationIndex ").list();
        return result;
    }

    @Override
    public void newMotivation(int value, String name) {
        MotivationIndex index = new MotivationIndex();
        index.setValue(value);
        index.setName(name);

        session().save(index);
    }

    private Session session() {
        return SessionFactoryHolder.sessionFactory().getCurrentSession();
    }
}
