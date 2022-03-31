package SelectClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectClassWithExample {
    @Test
    public void ValidationTripButton(){
        WebDriverManager.chromedriver().setup();//please get used to this process
        WebDriver driver=new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");
        WebElement onewayButton=driver.findElement(By.xpath("//input[@value='oneway']"));
        onewayButton.click();
        Assert.assertTrue(onewayButton.isDisplayed());//it must be true to pass the assertion
        Assert.assertTrue(onewayButton.isSelected());
        WebElement roundTripButton=driver.findElement(By.xpath("//input[@value='roundtrip']"));
        Assert.assertFalse(roundTripButton.isSelected());
        Assert.assertTrue(roundTripButton.isDisplayed());
    }
    @Test
    public void SelectMethods(){
        WebDriverManager.chromedriver().setup();//please get used to this process
        WebDriver driver=new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");
        WebElement onewayButton=driver.findElement(By.xpath("//input[@value='oneway']"));
        onewayButton.click();
        WebElement passengerCount=driver.findElement(By.name("passCount"));
        passengerCount.click();
      //  BrowserUtils.selectBy(passengerCount,"2");
        WebElement departfrom = driver.findElement(By.name("fromPort"));
        Select depart= new Select(departfrom);
        depart.selectByValue("Sydney");
        WebElement month=driver.findElement(By.name("fromMonth"));
        Select mnth=new Select(month);
        mnth.selectByVisibleText("April");

    }
    @Test
    public void anotheway(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");
        driver.manage().window().maximize();
        WebElement trip = driver.findElement(By.xpath("//input[@value='oneway']"));
        trip.click();
        WebElement passenger = driver.findElement(By.name("passCount"));
        BrowserUtils.selectBy(passenger,"2","value");
        WebElement departingFrom = driver.findElement(By.name("fromPort"));
        BrowserUtils.selectBy(departingFrom,"Paris","text");
        WebElement frommonth = driver.findElement(By.name("fromMonth"));
        BrowserUtils.selectBy(frommonth,"7","index");
        WebElement fromday = driver.findElement(By.name("fromDay"));
        BrowserUtils.selectBy(fromday,"13","value");
        WebElement arrivingIn = driver.findElement(By.name("toPort"));
        BrowserUtils.selectBy(arrivingIn,"Sydney","text");
        WebElement tomonth = driver.findElement(By.name("toMonth"));
        BrowserUtils.selectBy(tomonth,"9","index");
        WebElement toDay = driver.findElement(By.name("toDay"));
        BrowserUtils.selectBy(toDay,"3","value");
        WebElement Services = driver.findElement(By.xpath("//input[@value='First']"));
        Services.click();
        WebElement airlines = driver.findElement(By.name("airline"));
        Select airline = new Select(airlines);
        List<WebElement> allairlines = airline.getOptions();
        List<String> actualAirlines = Arrays.asList("No Preference", "Blue Skies Airlines", "Unified Airlines", "Pangea Airlines");
        List<String> expectedairlines = new ArrayList<>();
        for (WebElement line : allairlines) {
            expectedairlines.add(line.getText().trim());
        }
        Assert.assertEquals(actualAirlines, expectedairlines);
        WebElement continueButton = driver.findElement(By.name("findFlights"));
        continueButton.click();
        WebElement message = driver.findElement(By.xpath("//font[@face='Arial, Helvetica, sans-serif']//font[@size='4']"));
        String actual = message.getText().trim();
        String expected = "After flight finder - No Seats Available";
        Assert.assertEquals(actual, expected);
    }
    }


