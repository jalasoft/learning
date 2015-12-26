package cz.jalasoft.test;

import org.testng.annotations.Test;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 12/21/15.
 */
public class TestSParametrem {

    @Test(alwaysRun = true)
    public void testik(String hovinko) {
        System.out.println("prdelka a " + hovinko);
    }
}
