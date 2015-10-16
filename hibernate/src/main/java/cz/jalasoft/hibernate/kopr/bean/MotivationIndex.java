package cz.jalasoft.hibernate.kopr.bean;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 10/7/15.
 */
public class MotivationIndex {

    private Integer id;
    private int value;
    private String name;

    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new StringBuilder("MotivationIndex[")
                .append(getValue())
                .append(": ")
                .append(getName())
                .append("]")
                .toString();
    }
}
