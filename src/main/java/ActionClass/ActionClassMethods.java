package ActionClass;

import Utils.BrowserUtils;
import com.sun.deploy.association.AssociationService;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ActionClassMethods {
    @Test
    public void ContextClick(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();


    }
    @Test
    public void doubleclick(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demo.guru99.com/test/simple_context_menu.html");
        WebElement doubleClickButton = driver.findElement(By.tagName("button"));
        Actions action = new Actions(driver);
      //  action.doubleClick(doubleClickButton).perform();
      //  WebElement rightClick = driver.findElement(By.tagName("//span[.='right click me']"));


    }
    @Test
    public void doubleClickPrac(){
       WebDriverManager.chromedriver().setup();
       WebDriver driver = new ChromeDriver();
       driver.navigate().to("https://demo.guru99.com/test/simple_context_menu.html");
       WebElement rightClick = driver.findElement(By.tagName("span"));
       Actions action= new Actions(driver);
       action.doubleClick(rightClick).perform();
    }
    @Test
    public void dragAndDrop() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        driver.manage().window().maximize();
        WebElement cookies= driver.findElement(By.id("onetrust-accept-btn-handler"));
        Thread.sleep(3000);
        cookies.click();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN);
        for (int i=0; i<5;i++){
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        WebElement dragable = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement orangeBox= driver.findElement(By.xpath("//div[@class='test2']"));
        String actualMessage = BrowserUtils.getTextMethod(orangeBox);
        String expectedMessage ="... Or here.";
        Assert.assertEquals(actualMessage,expectedMessage);

        actions.dragAndDrop(dragable,orangeBox).perform();
        Thread.sleep(2000);
        orangeBox= driver.findElement(By.xpath("//div[@class='test2']"));
        String actualAfterDragAndDrop =BrowserUtils.getTextMethod(orangeBox);
        String expectedAfterDragAndDrop ="You did great!";
        Assert.assertEquals(actualAfterDragAndDrop,expectedAfterDragAndDrop);
        String actualCssValue =orangeBox.getCssValue("background-color");
        String expectedCssValue ="#rgba(238, 111, 11, 1)";
        Assert.assertEquals(actualCssValue,expectedCssValue);
    }
@Test
    public void ClickAndHold() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        driver.manage().window().maximize();
        WebElement blueBox = driver.findElement(By.xpath("//div[@class='test1']"));
        String actualBoxMessage = BrowserUtils.getTextMethod(blueBox);
        String expectedBoxMessage ="Drag the small circle here ...";
        Assert.assertEquals(actualBoxMessage,expectedBoxMessage);
        WebElement cookies= driver.findElement(By.id("onetrust-accept-btn-handler"));
        Thread.sleep(3000);
         cookies.click();
         WebElement dragable = driver.findElement(By.xpath("//div[@id='draggable']"));
         Actions actions = new Actions(driver);

         actions.clickAndHold(dragable).moveToElement(blueBox).release().perform();


}
@Test
public void MoveByOFFSet(){
    WebDriverManager.chromedriver().setup();
    WebDriver driver=  new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://the-internet.herokuapp.com/horizontal_slider");
    WebElement slider = driver.findElement(By.xpath("//input"));
    Actions actions= new Actions(driver);
    //x--> horizontol, y--> vertical
    actions.clickAndHold(slider).moveByOffset(40,20);
}
@Test
    public void sliderShortCut(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=  new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        WebElement siler = driver.findElement(By.xpath("//input"));
        WebElement range = driver.findElement(By.xpath("//span[@id='range']"));
        String myRange="5";
        while (!range.getText().trim().equals("5")){
            siler.sendKeys(Keys.ARROW_RIGHT);
        }

}
@Test
    public void MoveOffSet(){
        //by using move by off set and point class.
    // click contact Us
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get("http://www.techtorialacademy.com/");
    WebElement contactBottun = driver.findElement(By.xpath("//div[@class='navigation hidden-xs']//a[.='Contact Us']"));
    Point coordinatesOfContactUs = contactBottun.getLocation();
    int xCoord = coordinatesOfContactUs.getX();
    int yCoord = coordinatesOfContactUs.getY();
    Actions actions = new Actions(driver);
    actions.moveByOffset(xCoord,yCoord).click().perform();
}
}
