package com.test.Sanifugo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageSenTR {
    //constructor
    public LoginPageSenTR(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    // we are going to store our element locations and methods here

    // new version
    @FindBy(xpath = "//input[@id='username']")
    WebElement username;
    @FindBy(xpath = "//input[@id='password']")
    WebElement password;
    @FindBy(id = "loginsubmit")
    WebElement loginButton;

  /*  public void login(){
        username.sendKeys("EM01");
        password.sendKeys("sentrifugo");
        loginButton.click();
    }

   */
    public void dynamicLogin(String username, String password){
         this.username.sendKeys(username);
         this.password.sendKeys(password);
         loginButton.submit();
    }


}
