package cz.jalasoft.hibernate.kopr.h2;

import cz.jalasoft.hibernate.kopr.MotivationDao;
import cz.jalasoft.hibernate.kopr.bean.MotivationIndex;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Collection;
import java.util.function.Supplier;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 10/10/15.
 */
public class TransactionalMotivationDao implements MotivationDao {

    private final MotivationDao decorated;

    public TransactionalMotivationDao(MotivationDao decorated) {
        this.decorated = decorated;
    }

    @Override
    public Collection<MotivationIndex> allMotivations() {
        return inTransaction((Supplier<Collection<MotivationIndex>>)decorated.allMotivations());
    }

    @Override
    public void newMotivation(final int value, final String name) {
        inTransaction(() -> decorated.newMotivation(value, name));
    }

    private void inTransaction(Block block) {
        inTransaction(() -> {
            block.execute();
            return null;
        });
    }

    private <T> T inTransaction(Supplier<T> supplier) {
        Session session = SessionFactoryHolder.sessionFactory().getCurrentSession();

        Transaction transaction = session.getTransaction();
        transaction.begin();

        try {

            T result = supplier.get();
            transaction.commit();
            return result;
        } catch (Exception exc) {
            transaction.rollback();
            throw new RuntimeException(exc);
        }
    }


    private interface Block {
        void execute();
    }

}
