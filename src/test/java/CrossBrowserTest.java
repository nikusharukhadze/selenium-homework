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


        if(browser.equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\99559\\IdeaProjects\\selenium-homework\\src\\main\\resources\\chromedriver.exe");
            driver = new ChromeDriver();
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




    @Test(priority = 0)
    public void toDoList(){
        driver.navigate().to("http://webdriveruniversity.com/To-Do-List/index.html");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"container\"]/ul/li[text()=' Practice magic']"));
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();

        WebElement deleteBtn = driver.findElement(By.xpath("//*[@id=\"container\"]/ul/li[text()=' Practice magic']/span/i"));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click();", deleteBtn);
    }

    @Test(priority = 1)
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

    @Test(priority = 2)
    public void TimeOutException(){
        driver.navigate().to("https://demoqa.com/alerts ");
        WebElement clickMeBTn = driver.findElement(By.id("timerAlertButton"));
        clickMeBTn.click();

        try {
            new WebDriverWait(driver,3).until(ExpectedConditions.alertIsPresent());
        }
        catch (TimeoutException e){
            System.out.println(e.getMessage());
        }

        System.out.println("///////////////////////////////////////////////////////////////");
    }

    @Test(priority = 3)
    public void NoAlertPresentException(){
        try {

            driver.switchTo().alert().accept();
        }
        catch(NoAlertPresentException e){
            System.out.println(e.getMessage());
        }
        System.out.println("///////////////////////////////////////////////////////////////");
    }

    @Test(priority = 4)
    public void StaleElementReferenceException(){
        WebElement clickMeBTn = driver.findElement(By.id("timerAlertButton"));
        driver.navigate().refresh();
        try {
            clickMeBTn.click();
        }
        catch(StaleElementReferenceException e){
            System.out.println(e.getMessage());
        }
    }

    @AfterTest
    public void closePage(){
        driver.close();
    }

}
