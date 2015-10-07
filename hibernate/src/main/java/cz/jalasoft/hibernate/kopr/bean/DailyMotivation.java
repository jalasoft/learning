package cz.jalasoft.hibernate.kopr.bean;

import java.time.LocalDate;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 10/7/15.
 */
public final class DailyMotivation {

    private int id;
    private Shovel shovel;
    private LocalDate date;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public MotivationIndex getIndex() {
        return index;
    }

    public void setIndex(MotivationIndex index) {
        this.index = index;
    }
}
