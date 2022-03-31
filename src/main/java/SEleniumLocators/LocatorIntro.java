package SEleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorIntro {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("file:///Users/atyranazarkulova/Downloads/Techtorial%20(2).html");
      // LOCATOR: ID
       // getText()-> it gives you the text of the element
        WebElement header = driver.findElement(By.id("techtorial1"));
       String actualText = header.getText(); // from the system
       String expectedText ="Techtorial Academy"; // from the business requirement
       if (actualText.equals(expectedText)){
           System.out.println("passed");
       }else{
           System.out.println("failed");
       }

    WebElement header1 = driver.findElement(By.id("details2"));
        System.out.println(header1.getText());
       /* if (header1.getText().equals("To create your account, \n" +
                "        we'll need some basic information about you. This information will be \n" +
                "        used to send reservation confirmation emails, mail tickets when needed \n" +
                "        and contact you if your travel arrangements change. Please fill in the \n" +
                "        form completely.")){
            System.out.println("passed"); }*/
            // LOCATOR: ClassName
            WebElement tools = driver.findElement(By.className("group_checkbox"));
            System.out.println(tools.getText());

           // Locator: Name
            WebElement firstName=driver.findElement(By.name("firstName"));
            firstName.sendKeys("Atyra");

            //LOCATOR:Lastname;
            WebElement LastName= driver.findElement(By.name("lastName"));
            LastName.sendKeys("Nazarkulova");

            //Locator:phone
           WebElement phone = driver.findElement(By.name("phone"));
           phone.sendKeys("345-566-7564");

           // Locator: email
        WebElement email = driver.findElement(By.name("userName"));
        email.sendKeys("Atyra.nazar@gmail.com");

        // Locator: ID
        WebElement JavaBox = driver.findElement(By.id("cond1"));
        JavaBox.click();
        System.out.println(JavaBox.isDisplayed());
        System.out.println(JavaBox.isSelected());

        WebElement TestNG = driver.findElement(By.id("cond3"));
        TestNG.click();
        System.out.println(TestNG.isDisplayed());
        System.out.println(TestNG.isSelected());
        WebElement Cucumber = driver.findElement(By.id("cond4"));
        Cucumber.click();
        System.out.println(Cucumber.isDisplayed());
        System.out.println(Cucumber.isSelected());

    }
}
