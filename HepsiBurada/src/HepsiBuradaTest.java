import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(HepsiBuradaListener.class)
public class HepsiBuradaTest extends BaseTestClass{

    String FirstItemName=null;
    String SecondItemName=null;
    String ThirdItemName=null;

    @BeforeClass
    @Parameters({"browser","url"})
    public void SetupUrl(String browserType,String urlAddress){

        Initializations(browserType,urlAddress);
        Wait(10);
    }
    @Test(priority = 1)
    public void CheckTheHomePage(){
        WebElement logo=FindElement(By.className("OldHeader-1NFKi"));
        Assert.assertTrue(logo.isDisplayed(),"Sayfa açılamadı");
        System.out.println("Sayfa kontrolü yapılacak");
    }
    @Test(priority = 2)
    public void ClickLoginButton(){
        HoverElement(By.id("myAccount"));
        Wait(10);
        HoverElement(By.id("login"));
        Wait(10);
        ClickElement(By.id("login"));

    }
    @Test(priority = 3)
    public void CheckTheLoginPage(){
        Assert.assertTrue(FindElement(By.className("box-header-title")).isDisplayed(),"Üye Girişi Sayfası Yüklenemedi!!");
    }
    @Test(priority = 4)
    @Parameters({"UserEmail","UserPassword"})
    public void LoginProcess(String email, String password){
        SetText(By.id("email"),email);
        Wait(10);
        SetText(By.id("password"),password);
        Wait(10);
        ClickElement(By.xpath("//*[@class='btn full btn-login-submit']"));
        Wait(10);
    }
    @Test(priority = 5)
    public void CheckSuccessLogin(){
        Assert.assertTrue(FindElement(By.xpath("//span/a[@title='Hesabım']")).isDisplayed());
    }
    @Test(priority = 6)
    public void SearchFirstProduct(){
        SetText(By.className("desktopOldAutosuggestTheme-input"),"Diş fırçası");
        ClickElement(By.className("SearchBoxOld-buttonContainer"));
        Wait(10);
        ClickElement(By.xpath("(//*[@class='product-detail'])[1]"));
        FirstItemName=FindElement(By.id("product-name")).getText();
    }

    @Test(priority = 7)
    public void SearchSecondProduct(){
        SetText(By.className("desktopOldAutosuggestTheme-input"),"Kitaplık");
        Wait(10);
        ClickElement(By.className("SearchBoxOld-buttonContainer"));
        Wait(10);
        ClickElement(By.xpath("(//*[@class='product-detail'])[1]"));
         SecondItemName=FindElement(By.id("product-name")).getText();
    }
    @Test(priority = 8)
    public void SearchThirdProduct(){
        SetText(By.className("desktopOldAutosuggestTheme-input"),"Saksı");
        ClickElement(By.className("SearchBoxOld-buttonContainer"));
        ClickElement(By.xpath("(//*[@class='product-detail'])[1]"));
        ThirdItemName=FindElement(By.id("product-name")).getText();
    }

    @Test(priority = 9)
    public void OpenShoppingCard(){
        ClickElement(By.id("shoppingCart"));
    }

    @Test(priority = 10)
    public void CheckShoppingCardIsEmpty(){
        Assert.assertTrue(FindElement(By.className("empty-cart-icon-container")).isDisplayed());
    }

    @AfterClass
    public  void CloseBrowser()
    {
        TearDown();
    }


}
