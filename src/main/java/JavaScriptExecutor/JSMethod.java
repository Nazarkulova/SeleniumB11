package JavaScriptExecutor;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JSMethod {
    //whenever normal methods are not working last decision go with javascript
    @Test
    public void TitleMethod(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle()+" from driver");

     //   JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
      //  String title =javascriptExecutor.executeScript("return document.title").toString();

    String actualTitle = BrowserUtils.GetTittleWithJavaScript(driver);
    String expectedTitle ="Home Page - Techtorial";
        Assert.assertEquals(actualTitle,expectedTitle);
    }

@Test // i use this method often.
    public void ClickWithJS(){
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get("http://www.techtorialacademy.com/");
    WebElement browserCourse = driver.findElement(By.xpath("//a[.='Browse Course']"));
   // JavascriptExecutor javascriptExecutor=(JavascriptExecutor) driver;
   // javascriptExecutor.executeScript("arguments[0].click()",browserCourse);
    BrowserUtils.ClickWithJS(driver,browserCourse);

}
@Test
    public void ClickWithJsPractice(){
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get("http://www.techtorialacademy.com/");
    WebElement studentLogin= driver.findElement(By.xpath("//div[@class='navigation hidden-xs']//a[.='Student login']"));
    BrowserUtils.ClickWithJS(driver,studentLogin);

}
@Test
    public void ScrollIntoView(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");
        WebElement copyright= driver.findElement(By.xpath("//p[contains(text(),' Copy')]"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",copyright);

}
@Test
    public void getStartedMethod(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");
        WebElement browserButton = driver.findElement(By.xpath("//a[contains(text(),'Browse Course')]"));
        BrowserUtils.ClickWithJS(driver,browserButton);
        WebElement scrollDownToStart = driver.findElement(By.xpath("//h4[.='On-Campus Course']//..//a"));
   //     JavascriptExecutor js = (JavascriptExecutor) driver;
   //      js.executeScript("arguments[0].scrollIntoView(true)",scrollDownToStart);

        BrowserUtils.ScrollWithJS(driver,scrollDownToStart);
        BrowserUtils.ClickWithJS(driver,scrollDownToStart);
}
@Test
    public void ScroolWithXandYCordinantTest(){
        // This is on INterview question(point this)
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get("http://www.techtorialacademy.com/");
    WebElement copyright= driver.findElement(By.xpath("//p[contains(text(),' Copy')]"));
 /*   JavascriptExecutor js = (JavascriptExecutor) driver;
    Point location = copyright.getLocation();
    System.out.println(location.getX());
    System.out.println(location.getY());
    int xCord =location.getX();
    int yCord =location.getY();
    js.executeScript("window.scrollTo("+xCord+","+yCord+")");

  */
    BrowserUtils.ScrollWithXandYcord(driver,copyright);
}

}
