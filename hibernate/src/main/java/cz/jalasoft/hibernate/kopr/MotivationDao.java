package cz.jalasoft.hibernate.kopr;

import cz.jalasoft.hibernate.kopr.bean.MotivationIndex;

import java.util.Collection;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 10/10/15.
 */
public interface MotivationDao {

    Collection<MotivationIndex> allMotivations();

    void newMotivation(int value, String name);
}
