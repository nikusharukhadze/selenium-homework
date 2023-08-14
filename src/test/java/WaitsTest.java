import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WaitsTest extends BaseTest {



    @Test
    public void progressBar(){
        driver.navigate().to("https://demoqa.com/progress-bar");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement startButton =  driver.findElement(By.xpath("//*[@id=\"startStopButton\"]"));
        startButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 6);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"progressBar\"]/div[text()='100%']")));
        System.out.println(driver.findElement(By.xpath("//div[text()='100%']")).getText());

    }

    @AfterMethod
    public void pageClose(){
           driver.close();
    }
}
