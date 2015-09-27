package cz.jalasoft.learning.jmx.mxbeans;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 8/11/15.
 */
public class TransportMXBean implements Transport {

    public String getPosition() {
        return "Kolin";
    }

    public int getSpeed() {
        return 45;
    }

    public TransportDescriptor getDescriptor() {
        return new TransportDescriptor("Hasek", "R864");
    }

}
