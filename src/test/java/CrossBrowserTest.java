import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class CrossBrowserTest {
    WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setup(/*@Optional("Opera")*/ String browser) throws Exception{


        if(browser.equalsIgnoreCase("Edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        else if(browser.equalsIgnoreCase("Opera")){
            //System.setProperty("webdriver.firefox.driver", "C:\\Users\\99559\\IdeaProjects\\selenium-homework\\src\\main\\resources\\operadriver.exe");
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();

        }
        else{

            throw new Exception("Browser is not correct");
        }
    }




    @Test
    public void textBox(){
        driver.manage().window().maximize();
        driver.navigate().to("http://webdriveruniversity.com/Scrolling/index.html");
        WebElement element = driver.findElement(By.id("zone2"));
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String expText =  "1 Entries";
        String actText = js.executeScript("return arguments[0].innerText;", element).toString();
        if(actText.equals(expText)) System.out.println("Validation Successful");
        else System.out.println("Validation Error");



    }





    @AfterTest
    public void closePage(){
        driver.close();
    }

}
