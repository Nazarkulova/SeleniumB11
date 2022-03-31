package WindowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class SwitchWindow {
    @Test
    public void practice(){
        //it is failing bcs my driver is pointing the last tab, it throws the nosuchelement exception
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement clickHere = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHere.click();
        WebElement getTitle = driver.findElement(By.xpath("//h3[.='New Window']"));
        System.out.println(getTitle.getText());

    }
    @Test
    public void switchingWindow(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        System.out.println(driver.getWindowHandle());
        WebElement clickHere = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHere.click();
        System.out.println(driver.getWindowHandles());
       // WebElement getTitle = driver.findElement(By.xpath("//h3[.='New Window']"));
        String mainPageId= driver.getWindowHandle();
        Set<String> allPagesId= driver.getWindowHandles();


        WebElement header = driver.findElement(By.xpath("//h3[.='New Window']"));
        System.out.println(header.getText());
        String actualText= header.getText();
        String expectedText="New Window";
        Assert.assertEquals(actualText,expectedText);


    }
}
