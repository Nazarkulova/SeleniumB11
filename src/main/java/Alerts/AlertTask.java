package Alerts;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTask {
    @Test
    public void JSAlertPractice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://sweetalert.js.org/");

        WebElement jsPreview= driver.findElement(By.xpath("//h5[contains(text(),'Normal alert')]//..//button"));
        jsPreview.click();
        Alert alert = driver.switchTo().alert();
        String actualText = alert.getText();
        System.out.println(actualText);
        String expecetdtexted ="Oops, something went wrong!";
        Assert.assertEquals(actualText,expecetdtexted);
        alert.accept();

    }
    @Test
    public void TrialForAlertToHandleHTMLpopup(){
    /* TASK 2 (ALERT CLASS)
     1)Navigate to "https://sweetalert.js.org/"
    2)Click first preview(which is on the bottom right one)
    3)Validate the text on pop-up
    4)Handle the pop up
     */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://sweetalert.js.org/");
        WebElement alertPreview= driver.findElement(By.xpath("//button[contains(@onclick,'swal')]"));
        alertPreview.click();
        Alert alert = driver.switchTo().alert();
        String actualMessage = alert.getText();
        String expecetedMessage ="Something went wrong!";
        Assert.assertEquals(actualMessage,expecetedMessage);
        alert.accept();

    }
    public void HTMLALERT (){
    /*
    TASK 3 (HTML ALERT)
    1)Navigate to "https://sweetalert.js.org/"
    2)Click first preview(which is on the bottom right one)
    3)Validate the text on pop-up
    4)Handle the pop up
     */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://sweetalert.js.org/");
        WebElement HTMLPreview= driver.findElement(By.xpath("//button[contains(@onclick,'swal')]"));
        HTMLPreview.click();
        WebElement html= driver.findElement(By.xpath("//div[.='Something went wrong!']"));
        html.click();
        String actualText= BrowserUtils.getTextMethod(html);
        String expectedText="Something went wrong!";
        Assert.assertEquals(actualText,expectedText);
        WebElement okButton=driver.findElement(By.xpath("//button[.='OK']"));
        okButton.click();



    }

}
