package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumMethods {
    public static void main(String[] args) throws InterruptedException {
// What is the difference between driver.get
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.amazon.com/");

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
      //  System.out.println(driver.getPageSource()); -> html source of the page
        driver.navigate().to("https://www.google.com/");
    //    Thread.sleep(3000);
         driver.navigate().back(); //
    //    Thread.sleep(3000);
         driver.navigate().forward();
      //   Thread.sleep(3000);
         driver.navigate().refresh();
         driver.close();
         driver.quit();


    }
}
