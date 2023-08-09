import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.testng.annotations.Test;

public class CommandsTest  {


    @Test
    public void testing() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //driver.get("https://the-internet.herokuapp.com/");
        //driver.manage().window().maximize();
        driver.navigate().to("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement button = driver.findElement(By.xpath("//*[@id=\"input-example\"]/button"));
        WebElement  input = driver.findElement(By.xpath("//*[@id=\"input-example\"]/input"));

        Thread.sleep(2000);
        button.click();
        if(input.isEnabled()){
                System.out.println("Is Enabled");

        }
        else {
                System.out.println("Not Enabled");
             }

        Thread.sleep(4000);

        WebElement textOfEnable = driver.findElement(By.xpath("//*[@id=\"message\"]"));
        if(textOfEnable.isDisplayed()){
                System.out.println("Display");
        }
        else {
                System.out.println("Not Display");
             }

        Thread.sleep(2000);

            if(button.getText().equals("Disable") ){
                System.out.println("It is Disable!");
            }
            else {
                System.out.println("Not Disable");
            }
            input.sendKeys("Bootcamp");
            Thread.sleep(2000);
            input.clear();


        Thread.sleep(3000);
        driver.navigate().to(" http://the-internet.herokuapp.com/drag_and_drop");

        WebElement elementA= driver.findElement(By.id("column-a"));
        WebElement elementB= driver.findElement(By.id("column-b"));

        Point point = elementA.getLocation();
        Point point1 = elementB.getLocation();
        if (point.y == point1.y){
            System.out.println("Y cordinate Of Element A : " + point.y +
                               " is same To" + " Y cordinate Of Element B : " + point1.y);
        }
        else{
            System.out.println("Is Not Same!");
        }








    }



}
