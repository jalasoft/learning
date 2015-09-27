package cz.jalasoft.test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 8/18/15.
 */
public class MyFirstTest {

    @Parameters({ "street" })
    @Test(invocationCount = 5, threadPoolSize = 5, groups = { "funkcni", "checkin" })
    public void testStreet(String street) {
        System.out.println("Testing street: " + street);
    }

    @Test(
            groups = { "funkcni" },
            dependsOnMethods = { "testStreet" },
            dataProvider = "data",
            dataProviderClass = TestData.class,
            invocationCount = 10,
            threadPoolSize = 5
    )
    public void testPlace(String place) {
        System.out.println("Testing place: " + place + " in thread " + Thread.currentThread().getName());
    }
}
