import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JSexecutor {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\99559\\IdeaProjects\\selenium-homework\\src\\main\\resources\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);

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


}
