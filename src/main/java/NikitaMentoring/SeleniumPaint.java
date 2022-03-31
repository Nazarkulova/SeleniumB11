package NikitaMentoring;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SeleniumPaint {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://kleki.com/");
        driver.manage().window().maximize();
        WebElement canvas = driver.findElement(By.xpath("//canvas"));
        Actions action = new Actions(driver);
        action.moveToElement(canvas).clickAndHold().moveByOffset(40,40).perform();
        action.moveToElement(canvas).clickAndHold().moveByOffset(-40,60).perform();
        action.moveToElement(canvas).clickAndHold().moveByOffset(-1,10).perform();
        action.moveToElement(canvas).clickAndHold().moveByOffset(-30,30).perform();
    }
}
