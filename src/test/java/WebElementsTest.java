import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class WebElementsTest {
    WebDriver driver;
    //WebDriverWait wait;

    public WebElementsTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //wait =  new WebDriverWait (driver, 2);
    }



    @Test
    public void clickAndPrint() {
        driver.navigate().to("http://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/button"));

        for (int i = 1; i <= 3; i++) {
            addButton.click();
            System.out.println(i + "times");
        }
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("added-manually")));

        WebElement deleteButton = driver.findElement(By.cssSelector("#elements > button:last-child"));
        System.out.println("With last-child : " + deleteButton.getText());

        List<WebElement> deleteButtons = driver.findElements(By.cssSelector("button[class^='added']"));
        System.out.println("Last Delete Button Start With  \"added\" word : " + deleteButtons.get(deleteButtons.size() - 1).getText());

        WebElement deleteButton1 = driver.findElement(By.xpath("//button[3][contains(@class,'manually') and text()='Delete']"));
        System.out.println("Last Delete Button with contains and text methods : " + deleteButton1.getText());


    }



    @Test
    public void navigateAndPrint(){
        driver.navigate().to("http://the-internet.herokuapp.com/challenging_dom");
        WebElement element = driver.findElement(By.xpath("//td[text()='Apeirian9']/preceding-sibling::td"));
        WebElement element1 =  driver.findElement(By.xpath("//table/tbody/tr[10]/td/following-sibling::td"));
        System.out.println(element.getText());
        System.out.println(element1.getText());

        driver.close();

    }



}
