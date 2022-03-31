package TESTNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestNGPracticeWithRealWebsite {
    @Test // I am testing website if it is correct
    public void validateWebsite(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        String actualWebsite = driver.getCurrentUrl();
        String expectedWebsite ="https://demo.opencart.com/admin/";
        Assert.assertEquals(actualWebsite,expectedWebsite);
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

    }
    @Test
    public void validateCatalogisDisplayed(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        WebElement catalogBar= driver.findElement(By.id("menu-catalog"));
        boolean ActualCatalog= catalogBar.isDisplayed();
        boolean expectedCatalog =true;
        Assert.assertEquals(ActualCatalog,expectedCatalog,"catalog is not there");
    }
@Test
    public void validateProductisDisplayed() throws InterruptedException {
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://demo.opencart.com/admin/");

    WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
    loginButton.click();
    WebElement catalogBar= driver.findElement(By.id("menu-catalog"));
    catalogBar.click();

    WebElement productBar = driver.findElement(By.xpath("//a[.='Categories']"));
    Thread.sleep(1000);
    productBar.click();
    List<WebElement> boxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
    for(int i = 1;i<boxes.size();i++) {
        Thread.sleep(500);//this for me to see each click
        boxes.get(i).click();
        boolean ActualboxValidation = boxes.get(i).isDisplayed();
        boolean ExpectedboxValidation = true;
        Assert.assertEquals(ActualboxValidation, ExpectedboxValidation);
        boolean ActualBoxValidationIsSelected = boxes.get(i).isSelected();
        boolean ExpectedBoxValidationIsSelected = true;
        Assert.assertEquals(ActualBoxValidationIsSelected, ExpectedBoxValidationIsSelected);
    }


}
@Test
    public void MoveByOffSet(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        WebElement slider = driver.findElement(By.xpath("//input"));
    Actions actions = new Actions(driver);
    actions.clickAndHold(slider).moveByOffset(-30,0).perform();
}
}
