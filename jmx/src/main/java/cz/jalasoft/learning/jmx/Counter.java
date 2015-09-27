package cz.jalasoft.learning.jmx;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 8/10/15.
 */
public class Counter {

    private int value;

    public Counter(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void decrement() {
        this.value--;
    }
}
