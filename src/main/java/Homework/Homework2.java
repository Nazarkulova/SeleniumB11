package Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Homework2 {
    @Test
    public void sortOrder() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();
        WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        WebElement catalogBar=driver.findElement(By.id("menu-catalog"));
        catalogBar.click();
        Thread.sleep(500);
        WebElement optionButton = driver.findElement(By.xpath("//a[.='Options']"));
        optionButton.click();

        WebElement sortbutton = driver.findElement(By.xpath("//a[.='Sort Order']"));
        sortbutton.click();
        List<WebElement> descendingOrder = driver.findElements(By.xpath("//tbody/tr/td[3]"));
        List<Integer> actualDescendingOrder= new LinkedList<>();
        List<Integer> expectedDescendingOrder = new LinkedList<>();
        Actions sort = new Actions(driver);
        for (int i = 0; i < descendingOrder.size(); i++){
            sort.moveToElement(descendingOrder.get(i)).perform();
           
        }
        Collections.sort(actualDescendingOrder);
        System.out.println(descendingOrder);
        Assert.assertEquals(actualDescendingOrder,expectedDescendingOrder);

        }

    }

