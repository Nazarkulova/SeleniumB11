package ActionClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task {
    @Test
    public void DragAndDrop(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/droppable");
        driver.manage().window().maximize();
        Actions action= new Actions(driver);
        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));
       String actualDrop = BrowserUtils.getTextMethod(drop);
        String expectedDrop ="Drop here";
        Assert.assertEquals(actualDrop,expectedDrop);
        action.dragAndDrop(drag,drop).perform();
        String cssColor =drop.getCssValue("background-color");
        String color = "rgba(70, 130, 180)";
        Assert.assertEquals(actualDrop,expectedDrop);
    }
    @Test
    public void ClickAndHold() throws InterruptedException {
        /*
        1)Navigate to the website :"https://demoqa.com/droppable"
        2)Click Accept
        3)ClickAndHold notAccepted box and release to Drop box
        4)validate the background is still white and message is still Drop here
        5)ClickAndHold acceptable box and release to Drop box
        6)Validate the background is blue and message is dropped
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/droppable");
        WebElement acceptButton= driver.findElement(By.xpath("//a[@id='droppableExample-tab-accept']"));
        acceptButton.click();
        Actions action1= new Actions(driver);

        WebElement NotExcept= driver.findElement(By.id("notAcceptable"));
        WebElement dropBox = driver.findElement(By.xpath("//div[@class='accept-drop-container']//div[@class='drop-box ui-droppable']//p"));
        action1.clickAndHold(NotExcept).moveToElement(dropBox).release().perform();
        dropBox = driver.findElement(By.xpath("//div[@class='accept-drop-container']//div[@class='drop-box ui-droppable']//p"));
        Thread.sleep(1000);
        String actualCssValue = dropBox.getCssValue("background-color");
        String expectedCssValue ="rgba(0, 0, 0, 0)";
        Assert.assertEquals(actualCssValue,expectedCssValue);

        WebElement isStillDropHere = driver.findElement(By.xpath("//div[@class='accept-drop-container']//div[@class='drop-box ui-droppable']//p"));
        String actText = isStillDropHere.getText().trim();
        String expTest = "Drop here";
        Assert.assertEquals(actText,expTest);

        Thread.sleep(1000);

        WebElement firstBox = driver.findElement(By.xpath("//div[@id='acceptable']"));
        WebElement dropHere1 = driver.findElement(By.xpath("//div[@class='accept-drop-container']//div[@class='drop-box ui-droppable']//p"));
        Actions actions1 = new Actions(driver);
        actions1.clickAndHold(firstBox).moveToElement(dropHere1).release().perform();
        Thread.sleep(1000);

        dropHere1 = driver.findElement(By.xpath("//div[@id='droppable' and @class='drop-box ui-droppable ui-state-highlight']"));

        String actualCssValue1 = dropHere1.getCssValue("background-color");
        String expectedCssValue1 = "rgba(70, 130, 180, 1)";
        Assert.assertEquals(actualCssValue1,expectedCssValue1);
        Thread.sleep(1000);

        WebElement isStillDropedHere1 = driver.findElement(By.xpath("//p[.='Dropped!']"));
        String actText1 = isStillDropedHere1.getText().trim();
        String expTest1 = "Dropped!";
        Assert.assertEquals(actText1,expTest1);


    }
    @Test
    public void preventPropagation() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/droppable");
        driver.manage().window().maximize();
        WebElement preventClick = driver.findElement(By.id("//a[@id='droppableExample-tab-preventPropogation']"));
        preventClick.click();
        Thread.sleep(1000);
        Actions action2 = new Actions(driver);
        WebElement dragMeButton = driver.findElement(By.id("dragBox"));

        WebElement outterDropBox= driver.findElement(By.id("notGreedyDropBox"));
        String actualInnerBox = BrowserUtils.getTextMethod(outterDropBox);
        String expectedInnerBox= "Inner droppable (not greedy)";
        Assert.assertEquals(actualInnerBox,expectedInnerBox);
        action2.dragAndDrop(dragMeButton,outterDropBox).perform();




    }
}
