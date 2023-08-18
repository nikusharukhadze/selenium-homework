import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static java.util.concurrent.TimeUnit.SECONDS;

public class SwitchToTest extends  BaseTest{

    @Test(priority = 0)
    public void switchToFrame() throws InterruptedException {
        driver.navigate().to("http://the-internet.herokuapp.com/iframe");
        driver.manage().timeouts().implicitlyWait(8, SECONDS);
        //WebElement frame = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(0);
        WebElement textField = driver.findElement(By.xpath("//*[@id=\"tinymce\"]"));
        textField.clear();
        textField.sendKeys(" Here Goes ");
        driver.switchTo().defaultContent();
        WebElement alignCenterBtn = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[1]/div[1]/div[2]/div/div[4]/button[contains(@title,'Align center')]"));
        alignCenterBtn.click();

    }


    @Test(priority = 1)
    public void alertClick(){
        driver.navigate().to("https://demoqa.com/alerts");
        WebElement alertBtn = driver.findElement(By.xpath("//*[@id=\"alertButton\"]"));
        alertBtn.click();
        driver.switchTo().alert().accept();
    }



    @AfterTest
    public void pageClose(){
        driver.close();
    }

}
