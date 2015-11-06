package cz.jalasoft.spring.jmx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.*;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 11/6/15.
 */
@ManagedResource(objectName = "cz.jalasoft.jmx:type=counter")
@Component
public class ClickCounter {

    private final AtomicLong counter;

    @Autowired
    public ClickCounter(AppSetting setting) {
        counter = new AtomicLong(setting.getInitcount());
    }

    @ManagedOperation
    public void increment() {
        counter.incrementAndGet();
    }

    @ManagedAttribute
    public long getCounter() {
        return counter.get();
    }

    @ManagedAttribute
    public void setCounter(long counter) {
        this.counter.set(counter);
    }

}
