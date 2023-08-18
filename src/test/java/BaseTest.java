import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver driver;

    public BaseTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterTest
    public void pageClose(){
        driver.close();
    }
}
