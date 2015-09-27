package cz.jalasoft.learning.jmx;

import cz.jalasoft.learning.jmx.dynamicmbean.MyDynamic;
import cz.jalasoft.learning.jmx.standardmbean.Monitoring;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 8/10/15.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        MBeanServer mserver = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("cz.jalasoft.learning.jmx:type=Monitoring");

        //Monitoring mbean = new Monitoring(30);

        Counter counter = new Counter(40);
        MyDynamic dbean = new MyDynamic(counter);

        mserver.registerMBean(dbean, name);

        while(true) {

            Thread.sleep(1000);

            if (counter.value() <= 0) {
                break;
            }
            System.out.println("Counting down: " + counter.value());
            counter.decrement();
        }
    }
}
