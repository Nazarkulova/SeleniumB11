package com.test.orangehrm.tests;

import com.test.orangehrm.DataForLoginNegativeTest;
import com.test.orangehrm.pages.AdminPage;
import com.test.orangehrm.pages.LoginPage;
import com.test.orangehrm.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminTest extends TestBase {

    @Test
    public void validateTheCreationOfEmployeeMessage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickAdminButton();
        AdminPage adminPage = new AdminPage(driver);
        adminPage.sendingAllInfoForEmployee();
        Assert.assertTrue(adminPage.ValidationTheEmployeeIsCreated("atyra"));

    }

    }
