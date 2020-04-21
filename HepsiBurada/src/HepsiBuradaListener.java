import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

public class HepsiBuradaListener extends BaseTestClass implements ITestListener {

    public void onStart(ITestContext arg) {
        System.out.println("Listeners onStart"+arg.getName());
    }
    public void onFinish (ITestContext arg) {
        System.out.println("Listeners onFinish"+arg.getName());
    }
    public void onTestStart(ITestResult arg) {
        System.out.println("Listeners onTestStart"+arg.getName());
    }
    public void onTestSkipped(ITestResult arg) {
        System.out.println("Listeners onTestSkipped"+arg.getName());
    }
    public void onTestSuccess(ITestResult arg) {
        System.out.println("Listeners onTestSuccess"+arg.getName());
    }
    public void onTestFailure(ITestResult arg) {
        System.out.println("Listeners onTestFailure"+arg.getName());
        TakeScreenShot();
    }
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

}
