package cz.jalasoft.hibernate.kopr.bean;

import java.util.Date;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 10/7/15.
 */
public final class DailyMotivation {

    private int id;
    private Shovel shovel;
    private Date day;
    private MotivationIndex index;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Shovel getShovel() {
        return shovel;
    }

    public void setShovel(Shovel shovel) {
        this.shovel = shovel;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public MotivationIndex getIndex() {
        return index;
    }

    public void setIndex(MotivationIndex index) {
        this.index = index;
    }
}
