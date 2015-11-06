package cz.jalasoft.learning.spring.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 10/29/15.
 */
@RestController
@RequestMapping("/play/")
public class MyController {

    @Value("${honza.value1}")
    private String myProperty;

    @RequestMapping(value = "/player/{name}", method = RequestMethod.PUT)
    public void addPlayer(@PathVariable String name) {
        System.out.println("Player " + name + " has jut been added");
        System.out.println("Value of my property is " + myProperty);
    }
}
