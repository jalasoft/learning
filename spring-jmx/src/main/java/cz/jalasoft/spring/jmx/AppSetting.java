package cz.jalasoft.spring.jmx;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 11/4/15.
 */
@Component
@ConfigurationProperties(prefix = "app")
public class AppSetting {

    private int initcount;

    public int getInitcount() {
        return initcount;
    }

    public void setInitcount(int initcount) {
        this.initcount = initcount;
    }
}
