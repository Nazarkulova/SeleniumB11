package com.test.orangehrm.tests;

import Utils.ConfigReader;
import com.test.orangehrm.DataForLoginNegativeTest;
import com.test.orangehrm.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{
    LoginPage loginPage;
@BeforeMethod
public void initializePage(){
    loginPage=new LoginPage(driver);
}
    @Test
    public void validateLoginPositive(){

     //   LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ConfigReader.readProperty("orangehrmusername"),ConfigReader.readProperty("orangehrmpassword"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/index.php/dashboard");
    }


    @Test(dataProvider = "LoginNegativeTest",dataProviderClass = DataForLoginNegativeTest.class)
    public void validateNegativeLogin1(String username, String password, String expectedMessage){

   //     LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username,password);
        Assert.assertEquals(loginPage.getErrorMessage(),expectedMessage);

    }
    // 2more negative scenarios(wrong username, correct password, message)


  /*  @Test
    public void validateLoginNegative2(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("","");
        String actualErrorMessage = loginPage.getErrorMessage();
        String expectedErrorMessage ="Username cannot be empty";
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
        String actualColorErrorSms= loginPage.getColorOftheErrorSms();
        String expecetdColorErrorSms="rgba(221, 119, 0, 1)";
        Assert.assertEquals(actualColorErrorSms,expecetdColorErrorSms);
    }

   */
//TASK: modify this page
}
