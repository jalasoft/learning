package cz.jalasoft.hibernate.kopr.bean;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 10/7/15.
 */
public class MotivationIndex {

    private String description;
    private int value;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return new StringBuilder("MotivationIndex[")
                .append(getValue())
                .append(": ")
                .append(getDescription())
                .append("]")
                .toString();
    }
}
