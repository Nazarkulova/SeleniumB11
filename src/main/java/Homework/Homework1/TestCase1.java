package Homework.Homework1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase1 {
    public static void main(String[] args) throws InterruptedException {
        // WebDriver is a connection between webpage and your system
        // we need it to manipulate the webpage element on HTML
        // first step of starting automation should be reading the test case
        // step by step implement the requirements
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();
        WebElement fullname = driver.findElement(By.xpath("//input[@id='userName']"));
        fullname.sendKeys("atyra");
        WebElement email = driver.findElement(By.xpath("//input[@id='userEmail']"));
        email.sendKeys("atyra.nazar@gmail.com");
        WebElement currentAddress = driver.findElement(By.xpath("//textarea[@placeholder='Current Address']"));
        currentAddress.sendKeys("768 cotton drive");
        WebElement permanantAddress = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanantAddress.sendKeys("768 cotton drive");

       // WebElement submit = driver.findElement(By.xpath("//button[@id='submit']"));
       // submit.click();  // it didn't work bcs of advertisement
        WebElement button= driver.findElement(By.xpath("//button[@id='submit']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        Thread.sleep(500);

        button.click();

        WebElement nameValidation= driver.findElement(By.xpath("//p[@id='name']"));
        System.out.println(nameValidation.getText());
        String expectedValidation ="Name:atyra";
        String actualValidation = nameValidation.getText();
        if (expectedValidation.equals(actualValidation)){
            System.out.println("passed");
        }





    }
}
