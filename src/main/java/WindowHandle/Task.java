package WindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class Task {
    @Test
    public void WindowHandlePractice2(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        String mainpageId= driver.getWindowHandle();
        WebElement openNewTab= driver.findElement(By.xpath("//div[3]//button[@class='whButtons']"));
        openNewTab.click();
        BrowserUtils.SwitchOnlyFor2Tabs(driver,mainpageId);

       /*
        Set<String> allPagesID= driver.getWindowHandles();

       for (String id: allPagesID){
           if (!id.equals(mainPageId)){
               driver.switchTo().window(id);
           }
       }
        */
        WebElement AlertDemo= driver.findElement(By.xpath("//div[@class='post-head']//h1"));
        System.out.println(AlertDemo.getText());
        String actualAlert = BrowserUtils.getTextMethod(AlertDemo);
        String expectedAlert ="AlertsDemo";
        Assert.assertEquals(actualAlert,expectedAlert);

        WebElement firstClick = driver.findElement(By.id("alertBox"));
        firstClick.click();
    }
}
