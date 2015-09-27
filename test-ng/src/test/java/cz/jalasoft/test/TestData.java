package cz.jalasoft.test;

import org.testng.annotations.DataProvider;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 8/19/15.
 */
public class TestData {

    @DataProvider
    public static Object[][] data() {
        return new Object[][] {
                { "Kolin" },
                { "Kutna Hora" },
                { "Praha" }
        };
    }
}
