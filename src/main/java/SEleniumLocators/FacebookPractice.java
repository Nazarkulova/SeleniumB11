package SEleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.facebook.com");
        System.out.println(driver.getCurrentUrl());
        driver.manage().window().maximize();
        String actualURL= driver.getCurrentUrl();
        String expectedURL="https://www.facebook.com/";
        if(actualURL.equals(expectedURL)){
            System.out.println("The website is correct");
        }else{
            System.out.println("The website is wrong");
        }
        WebElement createAccountButton=driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
        boolean validationButton=createAccountButton.isDisplayed();
        boolean expectedValidationButton=true;
        if(validationButton==expectedValidationButton){
            System.out.println("Button is displayed");
        }else{
            System.out.println("Button is not displayed");
        }
        createAccountButton.click();
        Thread.sleep(1000);
        WebElement firstname = driver.findElement(By.name("firstname"));
        firstname.sendKeys("Atyra");
        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("Nazar");
        WebElement email = driver.findElement(By.name("reg_email__"));
        email.sendKeys("nazar@gmail.com");
        WebElement confirmationEmail=driver.findElement(By.name("reg_email_confirmation__"));
        confirmationEmail.sendKeys("Baldir@gmail.com");
        WebElement password= driver.findElement(By.name("reg_passwd__"));
        password.sendKeys("ahmet1234");
        WebElement month= driver.findElement(By.id("month"));
        month.sendKeys("Aug");
        WebElement day=driver.findElement(By.name("birthday_day"));
        day.sendKeys("3");
        WebElement  year = driver.findElement(By.name("birthday_year"));
        year.sendKeys("1991");
        WebElement gender= driver.findElement(By.xpath("//input[@name='sex' and @value='2'] "));
        gender.click();
        WebElement signupbutton = driver.findElement(By.name("websubmit"));
        signupbutton.click();

    }






}

