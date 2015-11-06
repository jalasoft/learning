package cz.jalasoft.spring.jmx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableMBeanExport;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 11/4/15.
 */
@EnableMBeanExport
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
