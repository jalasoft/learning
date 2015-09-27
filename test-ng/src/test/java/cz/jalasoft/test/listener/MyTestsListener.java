package cz.jalasoft.test.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 8/19/15.
 */
public class MyTestsListener implements ITestListener {

    public void onTestStart(ITestResult iTestResult) {
        System.out.println("\t*test startuje na ." + iTestResult.getTestName());
    }

    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("\t*test succeeded: " + iTestResult.getTestName());
    }

    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("\t*test failed: " + iTestResult.getTestName());
    }

    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("\t*test failed: " + iTestResult.getTestName());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("\t*test failed but with success percentage: " + iTestResult.getTestName());
    }

    public void onStart(ITestContext iTestContext) {
        System.out.println("\t*testing is starting: " + iTestContext.getName());
    }

    public void onFinish(ITestContext iTestContext) {
        System.out.println("\t*testing is finishing: " + iTestContext.getName());
    }
}
