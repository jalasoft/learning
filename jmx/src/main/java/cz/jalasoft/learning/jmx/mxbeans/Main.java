package cz.jalasoft.learning.jmx.mxbeans;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.timer.Timer;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.util.Date;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 8/11/15.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        MBeanServer mserver = ManagementFactory.getPlatformMBeanServer();
        mserver.registerMBean(new TransportMXBean(), new ObjectName("cz.jalasoft.learning:type=Transport"));

        for(int i=100;i>0;i--) {
            System.out.println(i);
            Thread.sleep(1000);
        }

        System.out.println("Konec");
    }
}
