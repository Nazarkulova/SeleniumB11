package ActionClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionKeys {
    @Test
    public void keys(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);
        WebElement googleSearchBox = driver.findElement(By.name("q"));
        actions.moveToElement(googleSearchBox)
                .click().keyDown(Keys.SHIFT)
                .sendKeys("s")
                .keyUp(Keys.SHIFT)
                .sendKeys("elenium")
                .doubleClick().keyDown(Keys.COMMAND)
                .sendKeys("c")
                .keyUp(Keys.COMMAND)
                .sendKeys(Keys.ARROW_RIGHT)
                .keyDown(Keys.COMMAND)
                .sendKeys("v")
                .keyUp(Keys.COMMAND)
                .sendKeys(Keys.RETURN) .perform(); /// Keys.ENTER
    }

    @Test
    public void KeyPractice(){
        /*
        1)navigate to the Website "https://text-compare.com/"
2)Type with the Keys --> "Good Bye Keys"
3)with CTRL(COMMAND)+A --> select all text
4)Copy this text CTRL(COMMAND) + C --> it will copy the text
5)Go to the second box and paste CTRL(COMMAND) + V-->it will paste the text
6) Validate this two boxes text are matching
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://text-compare.com/");
        Actions actioins = new Actions(driver);
        WebElement typingBox= driver.findElement(By.name("text1"));
        WebElement copyBox= driver.findElement(By.name("text2"));
        actioins.moveToElement(typingBox)
                .click().keyDown(Keys.SHIFT)
                .sendKeys("G")
                .keyUp(Keys.SHIFT)
                .sendKeys("ood")
                .keyUp(Keys.SHIFT)
                .sendKeys(" ")
                .keyUp(Keys.SHIFT)
                .sendKeys("B")
                .keyUp(Keys.SHIFT)
                .sendKeys("ye")
                .keyUp(Keys.COMMAND)
                .sendKeys(Keys.ENTER)
                .click().keyDown(Keys.SHIFT)
                .sendKeys(Keys.COMMAND)
                .sendKeys("a")
                .sendKeys(Keys.COMMAND)
                .sendKeys("c");
        actioins.dragAndDrop(typingBox,copyBox)
                .sendKeys(Keys.COMMAND)
                .sendKeys("v")
                .sendKeys(Keys.ENTER).perform();





    }
}
