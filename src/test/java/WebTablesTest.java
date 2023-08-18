import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.List;

public class WebTablesTest extends  BaseTest{

    @Test
    public void sellingCarsTable(){
        driver.navigate().to("http://techcanvass.com/Examples/webtable.html");
        WebElement webTable=driver.findElement(By.xpath("//*[@id=\"t01\"]/tbody"));
        List<WebElement> rows = webTable.findElements(By.tagName("tr"));
        for (int i = 0; i < rows.size(); i++) {
            List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
            for (int j = 0; j < columns.size() ; j++) {
                WebElement compareElement = driver.findElement(By.xpath("//*[@id=\"t01\"]/tbody/tr[4]/td[3]"));
                if(columns.get(j).equals(compareElement))
                    System.out.println("Honda Price is : " + columns.get(j).getText());
            }
        }

    }


    @AfterTest
    public void pageClose(){
        driver.close();
    }

}