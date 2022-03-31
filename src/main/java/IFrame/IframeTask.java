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

public class IframeTask {
    @Test
    public void iframeActiontask() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.get("https://skpatro.github.io/demo/iframes/");
        WebElement pavilion = driver.findElement(By.linkText("Pavilion"));
        pavilion.click();
        Thread.sleep(1000);
        BrowserUtils.switchByTitle(driver,"Home - qavalidation");
        WebElement selenium=driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium']//.."));
        Actions action = new Actions(driver);
        action.moveToElement(selenium).perform();
      //  Thread.sleep(1000);
        WebElement seleniumJava=driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium-Java']//.."));
       // seleniumJava.click();
        action.click(seleniumJava).perform();
        WebElement header= driver.findElement(By.tagName("h1"));
        String actualHeader = BrowserUtils.getTextMethod(header);
        String expectedHeader="Selenium-Java Tutorial – Basic to Advance";
        Assert.assertEquals(actualHeader,expectedHeader);
        BrowserUtils.switchByTitle(driver,"iframes"); //switching to main page
        driver.switchTo().frame("Frame1");
        WebElement category1= driver.findElement(By.xpath("//a[.='Category1']"));
        category1.click();
        BrowserUtils.switchByTitle(driver,"qavalidation");
        Assert.assertTrue(driver.getTitle().endsWith("qavalidation"));
        Thread.sleep(2000);
        BrowserUtils.switchByTitle(driver,"iframes");
        driver.switchTo().frame("Frame2");
        WebElement category3= driver.findElement(By.xpath("//a[.='Category3']"));
        Thread.sleep(2000);
        category3.click();
        BrowserUtils.switchByTitle(driver,"SoftwareTesting Archives");
        Assert.assertTrue(driver.getCurrentUrl().equals("https://qavalidation.com/category/softwaretesting/"));
        Thread.sleep(2000);


    }
}
