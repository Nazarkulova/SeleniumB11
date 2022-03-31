package SEleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathPractice {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("file:///Users/atyranazarkulova/Downloads/Techtorial%20(2).html");

        WebElement xpath = driver.findElement(By.xpath("//a[@href='https://www.techtorialacademy.com/']"));
        xpath.click();

    }
}
