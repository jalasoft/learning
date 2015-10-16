package cz.jalasoft.learning.spring.ws;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.PrintStream;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 10/16/15.
 */
@RestController
@SpringBootApplication
public class Main {

    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
    public String hello(@PathVariable("name") String name) {
        return "hello <b>" + name + "</b>";
    }

    public static void main(String[] args) {

        SpringApplication app = new SpringApplicationBuilder(Main.class)
                .build();

        app.run(args);
    }
}
