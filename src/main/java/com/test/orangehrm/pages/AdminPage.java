package com.test.orangehrm.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AdminPage {
    public AdminPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(id="btnAdd")
    WebElement addButton;
    @FindBy(id="systemUser_userType")
    WebElement userRole;
    @FindBy(id="systemUser_employeeName_empName")
    WebElement employeeName;
    @FindBy(xpath = "//input[@id='systemUser_userName']")
    WebElement userName;
    @FindBy(id="systemUser_status")
    WebElement status;
    @FindBy(name="systemUser[password]")
    WebElement password;
    @FindBy(name="systemUser[confirmPassword]")
    WebElement confirmPassword;
    @FindBy(id="btnSave")
    WebElement saveButton;
    @FindBy(xpath = "//tr//a[contains(@href,'saveSystemUser')]")
    List<WebElement> allUsernames;


    public void sendingAllInfoForEmployee() throws InterruptedException {
             addButton.click();
             BrowserUtils.selectBy(userRole,"Admin","text");
             employeeName.sendKeys("Alice Duval");
             userName.sendKeys("atyra");
             BrowserUtils.selectBy(status,"0","value");
             password.sendKeys("12345678");
             confirmPassword.sendKeys("12345678");
             Thread.sleep(1000);
             saveButton.click();
        Thread.sleep(1000);


    }
    public boolean ValidationTheEmployeeIsCreated(String Username){
        for (WebElement name : allUsernames){
            if (name.getText().trim().equals(Username)){
                return true;
            }
        }
        return false;
    }

}
