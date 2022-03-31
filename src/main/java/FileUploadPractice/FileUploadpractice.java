package FileUploadPractice;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadpractice {
    @Test
    public void validateFileUpload(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/upload");
        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        chooseFile.sendKeys("/Users/atyranazarkulova/Desktop/USAflag.png");
        WebElement uploadButton= driver.findElement(By.id("file-submit"));
        uploadButton.click(); //submit()--> elment or item has to be under form
        WebElement meassage1= driver.findElement(By.tagName("h3"));
        String actualMessage1= BrowserUtils.getTextMethod(meassage1);
        String expectedMessage1="File Uploaded!";
        Assert.assertEquals(actualMessage1,expectedMessage1);
        WebElement message2 = driver.findElement(By.id("uploaded-files"));
        String actualMess2 = BrowserUtils.getTextMethod(message2);
        String expectedMess2 ="USAflag.png";
        Assert.assertEquals(actualMess2,expectedMess2);

    }
}
