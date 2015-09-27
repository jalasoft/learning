package cz.jalasoft.learning.jmx.mxbeans;

import javax.management.openmbean.CompositeData;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 8/11/15.
 */
public class TransportDescriptor {

    public static TransportDescriptor from(CompositeData data) {
        Object nameObj = data.get("name");
        Object number = data.get("number");

        return new TransportDescriptor((String)nameObj, (String)number);
    }

    private final String name;
    private final String number;

    TransportDescriptor(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }
}
