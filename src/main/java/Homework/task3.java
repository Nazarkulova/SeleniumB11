package Homework;

import Utils.BrowserUtils;
import com.github.dockerjava.api.model.Link;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.common.value.qual.EnsuresMinLenIf;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.LinkedHashSet;
import java.util.List;

public class task3 {
    @Test
    public void validateShiromi() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-\n" +
                "ui/websushi#");
        WebElement shiromi = driver.findElement(By.xpath("//a[@href='#/menu/8']"));
        shiromi.click();
        WebElement arrownext= driver.findElement(By.id("navigate-next"));
        arrownext.click();
        Thread.sleep(2000);
        WebElement tekkaMaki= driver.findElement(By.xpath("//h1[contains(text(),'Tekka maki')]"));
        String acctualTekka=BrowserUtils.getTextMethod(tekkaMaki);
        String expectedTekka ="Tekka maki";
        Assert.assertEquals(acctualTekka,expectedTekka);
        WebElement prevArrow= driver.findElement(By.id("navigate-prev"));
        prevArrow.click();
        WebElement backshiromi = driver.findElement(By.xpath("//h1[.='Shiromi']"));
        String actualShiromi=BrowserUtils.getTextMethod(backshiromi);
        String expectedShirommi="Shiromi";
        Assert.assertEquals(actualShiromi,expectedShirommi);
        Thread.sleep(1000);
        WebElement shoppingCard= driver.findElement(By.xpath("//a[@id='cart-info']"));
        shoppingCard.click();
        WebElement item= driver.findElement(By.xpath("//span//span[@data-bind='text: cart.contentsCount']"));
        String actualItem=BrowserUtils.getTextMethod(item);
        String expectedItem="0";
        Assert.assertEquals(actualItem,expectedItem);

    }
    @Test
    public void EdametoCard(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-\n" +
                "ui/websushi#");
        WebElement edamame = driver.findElement(By.xpath("//a[@href='#/menu/4']"));
        edamame.click();
        WebElement addToCard= driver.findElement(By.xpath("//button[@class='buy']"));
        addToCard.click();
        WebElement numberItem=driver.findElement(By.id("cart-info"));
        WebElement numeberone= driver.findElement(By.xpath("//span[@data-bind='text: cart.contentsCount']"));
        String actualNumber=BrowserUtils.getTextMethod(numeberone);
        String expectedNumber="1";
        Assert.assertEquals(actualNumber,expectedNumber);
        WebElement total= driver.findElement(By.xpath("//p[@data-bind='html: totalPrice']"));
        String actualtotal=BrowserUtils.getTextMethod(total);
        String expectedtotal="$4.00";
        Assert.assertEquals(actualtotal,expectedtotal);
        WebElement emptycardClick= driver.findElement(By.xpath("//div//a[@id='empty-cart']"));
        emptycardClick.click();
        WebElement emptyCard= driver.findElement(By.xpath("//span[@data-bind='text: cart.contentsCount']"));

        String actualemptycard=BrowserUtils.getTextMethod(emptyCard);
        String expecetdemptycard="0";
        Assert.assertEquals(actualemptycard,expecetdemptycard);

    }
    @Test
    public void salmonTerayaki(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-\n" +
                "ui/websushi#");
        WebElement salmonTerayaki= driver.findElement(By.xpath("//a[@href='#/menu/16']"));
        salmonTerayaki.click();
        WebElement addSalmon= driver.findElement(By.xpath("//button[@class='buy']"));
        addSalmon.click();
        addSalmon.click();
        WebElement totalInCard= driver.findElement(By.xpath("//p[.='$26.00']"));
        String actualTotal=BrowserUtils.getTextMethod(totalInCard);
        String expectedTodal="$26.00";
        Assert.assertEquals(actualTotal,expectedTodal);
        WebElement itemone= driver.findElement(By.xpath("//span[@data-bind='text: cart.contentsCount']"));
        String actualItem=BrowserUtils.getTextMethod(itemone);
        String expecetdItem="1";
        Assert.assertEquals(actualItem,expecetdItem);
        WebElement prevButton= driver.findElement(By.id("navigate-next"));
       prevButton.click();
       WebElement Gohan= driver.findElement(By.xpath("//h1[contains(text(),'Gohan')]"));
       WebElement buyGohan= driver.findElement(By.xpath("//button[@class='buy']"));
       buyGohan.click();
       WebElement TotalCard= driver.findElement(By.xpath("//p[.='$29.00']"));
       String actualTotalOfTwo=BrowserUtils.getTextMethod(TotalCard);
       String expectedTotalOfTwo="$29.00";
       Assert.assertEquals(actualTotalOfTwo,expectedTotalOfTwo);
       WebElement totalItem= driver.findElement(By.xpath("//div[@id='header']//span[.='2']"));
       String actualTotalItem=BrowserUtils.getTextMethod(totalItem);
       String expectedTotalItem="2";
       Assert.assertEquals(actualTotalItem,expectedTotalItem);

    }
    @Test
    public void validateAllItems() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/websushi#");
        WebElement Allmenu = driver.findElement(By.xpath("//ul[@id='main']"));


        List<WebElement> allPrice = driver.findElements(By.xpath("//span[@class='price']"));
        Boolean validation = false;
        for (WebElement price : allPrice) {
            if (Double.parseDouble(price.getText().replace("$", "")) < 25.0) {
                validation = true;
            } else {
                validation = false;
            }
            Assert.assertTrue(validation);

        }
    }
   @Test
    public void validateNumberX() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-\n" +
                "ui/websushi#");
        driver.manage().window().maximize();
        WebElement Sushimi= driver.findElement(By.xpath("//strong[contains(text(),'Sashimi salad')]"));
        Sushimi.click();
        WebElement addSushimi= driver.findElement(By.xpath("//button[@class='buy']"));
        addSushimi.click();
       WebElement arrownext= driver.findElement(By.id("navigate-next"));
       arrownext.click();
       WebElement shirashi= driver.findElement(By.xpath("//h1[contains(text(),'Chirashi sushi')]"));
       Thread.sleep(1000);
       WebElement addShirashi= driver.findElement(By.xpath("//button[@class='buy']"));
       addShirashi.click();
       WebElement  nextpage= driver.findElement(By.xpath("//a[@id='navigate-next']"));
       nextpage.click();
       Thread.sleep(1000);
       WebElement seaWeed = driver.findElement(By.xpath("//h1[.='Seaweed salad']"));
       WebElement addSeaWeed= driver.findElement(By.xpath("//button[@class='buy']"));
       addSeaWeed.click();
       WebElement cardBar= driver.findElement(By.xpath("//div[@class='k-listview-content']"));
       cardBar.click();
       WebElement images = driver.findElement(By.xpath("//div[@tabindex='-1']//a[@data-bind='click: removeFromCart']"));
       images.click();
       Thread.sleep(1000);
       WebElement itemInCards= driver.findElement(By.xpath("//span[@data-bind='text: cart.contentsCount']"));
       String actualItem=BrowserUtils.getTextMethod(itemInCards);
       String expecItem="2";
       Assert.assertEquals(actualItem,expecItem);

   }
   @Test
    public void validatecheckout() throws InterruptedException {
       WebDriverManager.chromedriver().setup();
       WebDriver driver = new ChromeDriver();
       driver.get("https://demos.telerik.com/kendo-ui/websushi#");
       WebElement shiromi = driver.findElement(By.xpath("//a[@href='#/menu/8']"));
       shiromi.click();
       WebElement addshiromi = driver.findElement(By.xpath("//button[@class='buy']"));
       addshiromi.click();
       Thread.sleep(1000);
       driver.get("https://demos.telerik.com/kendo-ui/websushi#");
       WebElement ebiRoll= driver.findElement(By.xpath("//Strong[.='Ebi rolls']"));
       ebiRoll.click();
       WebElement addEbi= driver.findElement(By.xpath("//button[@class='buy']"));
       addEbi.click();
   }

    }






