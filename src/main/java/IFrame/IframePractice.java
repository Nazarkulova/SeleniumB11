package IFrame;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IframePractice {
    @Test
    public void Iframe(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.manage().window().maximize();
        driver.switchTo().frame("mce_0_ifr");
        WebElement writingBox= driver.findElement(By.id("tinymce"));
        writingBox.clear();
        writingBox.sendKeys("I love Selenium");
        driver.switchTo().parentFrame();
        WebElement header = driver.findElement(By.tagName("h3"));
        String actualHeader = BrowserUtils.getTextMethod(header);
        String expectedHeader ="An iFrame containing the TinyMCE WYSIWYG Editor";
        Assert.assertEquals(actualHeader,expectedHeader);

    }
}
