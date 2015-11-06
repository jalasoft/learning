package cz.jalasoft.spring.jmx;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 11/4/15.
 */
@RestController
public class MyService {

    private ClickCounter counter;

    @Autowired
    public MyService(ClickCounter counter) {
        this.counter = counter;
    }

    @RequestMapping(value = "/increment/", method = RequestMethod.GET)
    public CounterValue increment() {
        counter.increment();

        return new CounterValue(counter.getCounter());
    }

    public static final class CounterValue {

        private final long value;

        public CounterValue(long value) {
            this.value = value;
        }

        @JsonProperty("value")
        public long value() {
            return value;
        }
    }
}
