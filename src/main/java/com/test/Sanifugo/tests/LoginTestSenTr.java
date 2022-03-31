package com.test.Sanifugo.tests;

import com.test.Sanifugo.pages.LoginPageSenTR;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestSenTr {
    // old version
  /*  @Test
    public void ValidateSuperAdmin(){
       WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.navigate().to("http://demo.sentrifugo.com/index.php/");
        WebElement userName= driver.findElement(By.xpath("//input[@id='username']"));
        userName.sendKeys("EM01");
        WebElement password= driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("sentrifugo");
        WebElement loginButton = driver.findElement(By.id("loginsubmit"));
        loginButton.submit();

    }
*/
   @Test //9
    public void validateSuperAdmin(){
       WebDriverManager.chromedriver().setup();
       WebDriver driver =new ChromeDriver();
       driver.navigate().to("http://demo.sentrifugo.com/index.php/");
       driver.manage().window().maximize();
       LoginPageSenTR loginPage= new LoginPageSenTR(driver);
       loginPage.dynamicLogin("EM01","loginsubmit");
       String actualURL= driver.getCurrentUrl();
       String expecetdURL ="http://demo.sentrifugo.com/index.php/index/welcome";
       Assert.assertEquals(actualURL,expecetdURL);

   }
   @Test
    public void validateManagement(){
      WebDriverManager.chromedriver().setup();
      WebDriver driver =new ChromeDriver();
      driver.navigate().to("http://demo.sentrifugo.com/index.php/");
      driver.manage().window().maximize();
      LoginPageSenTR loginPage= new LoginPageSenTR(driver);
      loginPage.dynamicLogin("EM02","loginsubmit");
      String actualTitle= driver.getTitle();
      String expecetTitle ="Sentrifugo - Open Source HRMS";
      Assert.assertEquals(actualTitle,expecetTitle);


   }
}
