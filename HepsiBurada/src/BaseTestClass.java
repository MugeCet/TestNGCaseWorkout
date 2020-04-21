import jdk.jfr.Timespan;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.RemoteWebDriver;


import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BaseTestClass {
    public static WebDriver driver;
    public int counter=0;
    public static void Initializations(String browserType,String urlAddress){

        if(browserType.equalsIgnoreCase("chrome")){

            String driverPath=System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe";
           System.setProperty("webdriver.chrome.driver",driverPath);
            ChromeOptions options=new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("test-type");
            options.addArguments("disable-popup-blocking");
            options.addArguments("ignore-certificate-errors");
            options.addArguments("disable-translate");
            options.addArguments("disable-automatic-password-saving");
            options.addArguments("allow-silent-push");
            options.addArguments("disable-infobars");
            options.addArguments("disable-notifications");
            driver=new ChromeDriver(options);

        } else if(browserType.equalsIgnoreCase("firefox")){

            String driverPath=System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe";
            System.setProperty("webdriver.gecko.driver",driverPath);
            driver=new FirefoxDriver();
        }
       Wait(3);
        driver.get(urlAddress);
    }
    public  void TearDown(){

        driver.manage().deleteAllCookies();
        driver.quit();
    }

    public  void  TakeScreenShot(){

        File scrFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        counter++;
        try {
            String filePath=System.getProperty("user.dir")+"\\Screenshots\\"+"screenshot"+counter+"_"+java.time.LocalDate.now()+".jpg";
            FileUtils.copyFile(scrFile,new File(filePath));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public WebElement FindElement(By by)
    {
        return driver.findElement(by);
    }
    public  void HoverElement(By by){
        Actions hoverAction = new Actions(driver);
        hoverAction.moveToElement(FindElement(by)).build().perform();
    }

    public void ClickElement(By by)
    {
        WebElement element = FindElement(by);
        if (!IsElementDisplayed(by))
        {
            ScrollTo(element.getLocation().x, element.getLocation().y);
        }
        element.click();
    }

    public void SetText(By by,String text){

        FindElement(by).clear();
        FindElement(by).sendKeys(text);
    }

    public Boolean IsElementDisplayed(By by)
    {
        try
        {
            return FindElement(by).isDisplayed();
        }
        catch (Exception ex)
        {
            return false;
        }
    }
    public static void Wait(int sc){

       driver.manage().timeouts().implicitlyWait(sc, TimeUnit.SECONDS);
    }

    public JavascriptExecutor GetScriptExecutor()
    {
        return (JavascriptExecutor) driver;
    }

    public void ScrollTo(int x, int y)
    {
        String jsStmt = String.format("window.scrollTo({0}, {1})", x, y);
        GetScriptExecutor().executeScript(jsStmt, true);
    }

}
