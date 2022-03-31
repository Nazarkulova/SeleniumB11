package Homework.Homework5.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class homework12345 {
    /*
    1-task
Navigate to "https://www.audiusa.com/"
Click SUVs & Wagons
 Get all the product prices for SUVs & Wagons
Select 2022 Q5
 Validate the car year and Q5 is matching
 Click Build button
Validate starting price is "44,100"
     */
    /*
    2-task
    Select Premium Plus 45 TFSI
 Click View "View key MSRP info" button
 Validate MSRP is $44,100
Validate Additional Options is $595
     */
    /*
    task-3
    Highlight District Green metallic
 Validate color name is "District Green metallic"
Validate exterior color price is "$595"
 Click District Green metallic color
 Validate total price is equals to Color Price+MSRP+Destination
     */
    /*
    task-4
    Add Convenience package
Validate Remove text is displayed
Click Add for Rear side thoracic airbags
 Verify it is selected
 Verify Optional Equipment price is equals to Color Price
+ Black Option Package Price +  Convenience package +

Rear Side Airbags
 Verify Total price is equals to MSRP+Optional
Equipment + Destination Charge
     */
    /*
    Validate MSRP price is matching under Selected Feature
and Inside the Summary
Validate Total of selected Equipment price is equals to
Color Price+ Wheel Price + Airbag + Convenience package
Validate total price is equals to MSRP + Equipment price +
Destination Charge
     */
    @Test
    public void navigateWebPage(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.audiusa.com/");
        WebElement cookies= driver.findElement(By.xpath("//button[@id='onetrust-pc-btn-handler']"));
        cookies.click();
        WebElement acceptcookies= driver.findElement(By.xpath("//button[@class='save-preference-btn-handler onetrust-close-btn-handler']"));
        acceptcookies.click();
       // WebElement xbutton= driver.findElement(By.xpath("//area[@href='javascript:ipe123930.clWin()']"));
      //  xbutton.click();
        WebElement suvAndwagon= driver.findElement(By.xpath("//div[@class='nm-model-band-stripe'] //span[contains(text(),'SUVs & Wagons')]"));
        suvAndwagon.click();
    }
}
