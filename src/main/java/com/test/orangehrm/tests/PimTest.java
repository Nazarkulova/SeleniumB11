package com.test.orangehrm.tests;

import com.test.orangehrm.pages.LoginPage;
import com.test.orangehrm.pages.MainPage;
import com.test.orangehrm.pages.PimPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PimTest extends TestBase {
    LoginPage loginPage;
    MainPage mainPage;
    PimPage pimPage;
    @BeforeMethod
    public void initializingPages(){
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        pimPage = new PimPage(driver);
    }
    @Test
    public void ValidateTheCreationOfEmployee() throws InterruptedException {
        loginPage.login("Admin","admin123");
        mainPage.clickPimButton();
        pimPage.addEmployeeForPIM("atyra1","Nazar","1990","/Users/atyranazarkulova/Desktop/USAflag.png");
        Assert.assertEquals(pimPage.validateFirstName(),"atyra1");
        Assert.assertEquals(pimPage.validateLastName(),"Nazar");
        Assert.assertTrue(pimPage.validateEmployeeId("1990"));
    }
    @Test
    public void ValidatePersonalDetailElements() throws InterruptedException {
        loginPage.login("Admin","admin123");
        mainPage.clickPimButton();
        pimPage.addEmployeeForPIM("atyra","Nazar","1990","/Users/atyranazarkulova/Desktop/USAflag.png");
        pimPage.editsPersonalDetails("kyrgyz","10-22-1990","married");
        Assert.assertEquals(pimPage.validateTheNationality(),"kyrgyz");


    }


    }


