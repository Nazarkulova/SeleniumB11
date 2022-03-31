package Projects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Task5 {
    @Test
    public void dropDown() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        // Why do we use backslash in string?
        // \n -> next line
        // \" -> to add " (double quotes) in to string.
        driver.get("https://demoqa.com/select-menu");

        WebElement searchFieldForTitle = driver.findElement(By.cssSelector("#react-select-3-input"));
        searchFieldForTitle.sendKeys("Other", Keys.ENTER);
        WebElement searchFieldForValue= driver.findElement(By.xpath("//input[@id=\"react-select-2-input\"]"));
        searchFieldForValue.sendKeys("Group 2, option 1",Keys.ENTER);
        Select selectColor = new Select(driver.findElement(By.xpath("//select[@id=\"oldSelectMenu\"]")));
        // How many ways can we chose with select class?
        // visibleText, index, value
        selectColor.selectByValue("red");
        WebElement searchFieldForSelect= driver.findElement(By.xpath("//input[@id=\"react-select-4-input\"]"));

        searchFieldForSelect.sendKeys("black",Keys.ENTER);
        Thread.sleep(2000);
        driver.manage().window().maximize();

// control + shift + r -> runs the code

        Actions actions = new Actions(driver);
        WebElement elementToCloseDropDownSelect = driver.findElement(By.xpath("//*[.='Multiselect drop down']"));
        actions.click(elementToCloseDropDownSelect).build().perform();
    }
    }

