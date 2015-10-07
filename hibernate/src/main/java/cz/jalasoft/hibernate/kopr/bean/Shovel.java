package cz.jalasoft.hibernate.kopr.bean;

import java.util.Collection;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 10/7/15.
 */
public class Shovel {

    private int id;
    private String name;
    private String email;
    private Collection<DailyMotivation> indexes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<DailyMotivation> getIndexes() {
        return indexes;
    }

    public void setIndexes(Collection<DailyMotivation> indexes) {
        this.indexes = indexes;
    }
}
