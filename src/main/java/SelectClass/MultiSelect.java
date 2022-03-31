package SelectClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Locale;

public class MultiSelect {
    @Test
    public void multipleSelectAndFirstSelectPractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("file:///Users/atyranazarkulova/Downloads/ss.html");
        driver.manage().window().maximize();
        WebElement header = driver.findElement(By.id("techtorial1"));
        BrowserUtils.getTextMethod(header);// header.getText().trim();
        WebElement multiSelectBox = driver.findElement(By.xpath("//select[@class='select']"));
        BrowserUtils.selectBy(multiSelectBox,"Two","text");
        BrowserUtils.selectBy(multiSelectBox,"3","index");
        BrowserUtils.selectBy(multiSelectBox,"1","value");

        Select select = new Select(multiSelectBox); /// after selecting boxes, will deselect
        Thread.sleep(2000);
        select.deselectByIndex(3);
      //  select.selectByValue("1");
       // select.deselectAll();
// trim()-> it removes the space from both side of the string.
        WebElement countryList = driver.findElement(By.name("country"));
        Select country = new Select(countryList);
        Thread.sleep(2000);
    //    String actualFirstSElectedOption =country.getFirstSelectedOption().getText().trim();
       String actualFirstSElectedOption=BrowserUtils.getTextMethod(country.getFirstSelectedOption());
        String expectedFirstSelectedOption="UNITED STATES";
        Assert.assertEquals(actualFirstSElectedOption,expectedFirstSelectedOption);


    }
}
