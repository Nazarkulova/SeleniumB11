package Project1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Task1 {
    @Test
    public void SumOfAllPrices() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");


        WebElement validateCart = driver.findElement(By.xpath("//a[@title='View my shopping cart']"));
        System.out.println(validateCart.getText());
        String actualCartText = validateCart.getText();
        String expectedCarttext = "Cart (empty)";
        Assert.assertEquals(actualCartText,expectedCarttext);

        List<WebElement> prices = driver.findElements(By.xpath("//div//span [@class='price product-price']"));
      List<WebElement> displayedPrices = new ArrayList<>();

        System.out.println(prices.size());
        double total = 0;
        String temp="";
        for (int i=1;i<prices.size();i++) {
            if(prices.get(i).isDisplayed()){
            temp=(prices.get(i).getText().replace("$","").trim());

            total+=Double.parseDouble(temp);
            displayedPrices.add(prices.get(i));

            }
        }
      //  System.out.println(Collections.sort(displayedPrices));

        Assert.assertTrue(total==196.38);

  /*      List<WebElement> prices = driver.findElements(By.xpath("//div//span [@class='price product-price']"));
//        List<WebElement> displayedPrices = new ArrayList<>();
//        System.out.println(prices.size());
        double total = 0;
        String temp = "";
        for (int i = 1; i < prices.size()-14; i+=2) {
//            if (prices.get(i).isDisplayed()) {
            temp = prices.get(i).getText().replace("$", "").trim();
            total += Double.parseDouble(temp);
//            displayedPrices.add(prices.get(i));
//            }
        }
        Assert.assertTrue(total==196.38);*/

    }
    @Test
    public void CheapestPrice() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        WebElement CheapProduct = driver.findElement(By.xpath("//div//span [@class='price product-price']"));

        List<WebElement> prices = driver.findElements(By.xpath("//div//span [@class='price product-price']"));

        double total = 0;
        double temp = Double.parseDouble(prices.get(1).getText().replace("$","").trim());
        for (int i = 1; i < prices.size()-14; i+=2) {
            if (Double.parseDouble(prices.get(i).getText().replace("$","").trim())<temp){
                temp=Double.parseDouble(prices.get(i).getText().replace("$","").trim());
            }
        }
        Assert.assertTrue(temp==16.40);

    }
    @Test
    public void ValidateColor() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);
        WebElement first = driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[1]/div/a[1]/img"));
        WebElement addCart = driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[1]/span"));
        actions.contextClick(first).perform();
        Thread.sleep(1000);
        actions.click(addCart).perform();
        Thread.sleep(1000);
        WebElement success = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/h2"));
        Assert.assertEquals(success.getText().trim(), "Product successfully added to your shopping cart");
        String actualColor = success.getCssValue("color");
        String expectedColor = "rgba(70, 167, 78, 1)";
        Assert.assertEquals(actualColor,expectedColor);
    }
    @Test
    public void addingToCard() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
    //    WebElement womenButton= driver.findElement(By.xpath("//li/a[.='Women']"));
    //    womenButton.click();
        Actions actions = new Actions(driver);
        WebElement women = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a"));
        actions.clickAndHold(women).perform();
        Thread.sleep(1000);
        WebElement summerDress = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[2]/ul/li[3]/a"));
        summerDress.click();
        String expected=driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[1]/span[1]")).getText();
        WebElement first = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img"));
        WebElement addCart = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[1]/span"));
        actions.contextClick(first).perform();
        Thread.sleep(1000);
        actions.click(addCart).perform();
        Thread.sleep(1000);
        String actual=driver.findElement(By.xpath("//*[@id=\"layer_cart_product_price\"]")).getText();
        Assert.assertEquals(actual,expected);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"layer_cart_product_quantity\"]")).getText(),"1");
        WebElement continueShopping = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span/span"));
        continueShopping.click();
        WebElement card = driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a/span[1]"));
        Assert.assertEquals(card.getText().trim(),"1");

    }


    }
    


