import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Exceptions {

    WebDriver driver;
    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\99559\\IdeaProjects\\selenium-homework\\src\\main\\resources\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);

    }
    @Test(priority = 0)
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

    @Test(priority = 1)
    public void NoAlertPresentException(){
        try {

            driver.switchTo().alert().accept();
        }
        catch(NoAlertPresentException e){
            System.out.println(e.getMessage());
        }
        System.out.println("///////////////////////////////////////////////////////////////");
    }

    @Test(priority = 2)
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
}
