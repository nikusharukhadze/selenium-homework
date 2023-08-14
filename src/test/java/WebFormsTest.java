import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebFormsTest extends  BaseTest {

    @Test(priority = 0)
    public void DropdownMenu () {
        driver.navigate().to("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html ");
        Select prLanguage = new Select(driver.findElement(By.xpath("//*[@id=\"dropdowm-menu-1\"]")));
        prLanguage.selectByVisibleText("SQL");
        WebElement selectedLanguage = prLanguage.getFirstSelectedOption();
        String selectedOption = selectedLanguage.getText();
        System.out.print("Selected element: " + selectedOption + " || ");
        System.out.println(selectedOption.equals("SQL"));


    }



    @Test(priority = 1)
    public void CheckBox() {

        List<WebElement> checkBoxes = driver.findElements(By.xpath("//div[@id='checkboxes']/label"));
        for (WebElement checkBox : checkBoxes) {
            System.out.print("Before : " + checkBox.isSelected() + " ");
            if (!checkBox.isSelected()) checkBox.click();
            System.out.println("After : " + checkBox.isSelected() + " ");
        }

    }


    @Test(priority = 2)
    public void radioButton(){
        WebElement radioBtn = driver.findElement(By.xpath("//*[@id=\"radio-buttons\"]/input[3]"));
        radioBtn.click();


    }

    @Test(priority = 3)
    public  void DropDownVisibility() {

        WebElement orange = driver.findElement(By.xpath("//*[@id=\"fruit-selects\"]/option[2]"));
        if(orange.isEnabled())
            System.out.println("Orange is Enabled");
        else System.out.println("Orange is Disabled");



    }

    @AfterTest
    public void pageClose(){
        driver.close();
    }


}
