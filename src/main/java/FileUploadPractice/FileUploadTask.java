package FileUploadPractice;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTask {
    @Test
    public void validateTask() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/upload/");
        WebElement chooseFile = driver.findElement(By.id("uploadfile_0"));
        chooseFile.sendKeys("/Users/atyranazarkulova/Desktop/USAflag.png");

        WebElement checkBox= driver.findElement(By.id("terms"));

        checkBox.click();
        Thread.sleep(1000);
        Assert.assertTrue(checkBox.isSelected());
        WebElement summit = driver.findElement(By.id("submitbutton"));
        summit.click();
        WebElement meassage = driver.findElement(By.xpath("//h3//center"));
        String actualMessage = BrowserUtils.getTextMethod(meassage);
        String expecterMessage ="1 file\n" +
                "has been successfully uploaded.";
        Assert.assertEquals(actualMessage,expecterMessage);

    }
}
