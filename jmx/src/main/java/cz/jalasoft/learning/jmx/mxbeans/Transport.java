package cz.jalasoft.learning.jmx.mxbeans;

import javax.management.MXBean;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 8/11/15.
 */
@MXBean
public interface Transport {

    String getPosition();

    int getSpeed();

    TransportDescriptor getDescriptor();
}
