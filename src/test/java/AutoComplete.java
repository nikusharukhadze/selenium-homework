import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class AutoComplete {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\99559\\IdeaProjects\\selenium-homework\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
    }


    @Test
    public void searchBox() throws InterruptedException {
        driver.navigate().to("https://www.google.com/");
        WebElement search = driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"));
        search.sendKeys("Automation");
        WebDriverWait wait =  new WebDriverWait (driver, 4);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"Alh6id\"]/div[1]/div/ul[@class='G43f7e' and @jsname='bw4e9b']")));
        List<WebElement> values = driver.findElements(By.xpath("//*[@id=\"Alh6id\"]/div[1]/div/ul[@class='G43f7e' and @jsname='bw4e9b']/li"));
        Integer lastIndex = values.size() - 1;
        for (int i = 0; i < values.size(); i++) {
            System.out.println(i + " : " + values.get(i).getText());
        }
        values.get(lastIndex).click();



    }

    @AfterTest
    public void closePage(){
        driver.close();
    }

}
