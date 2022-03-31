package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeSeleniumBasic {
    public static void main(String[] args) throws InterruptedException {
        // Task: go to the 3 website.
        //Get the title, currentUrl,forward with lastly refresh and quit
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver drive = new ChromeDriver();
        drive.get("https://www.etsy.com/");
        drive.manage().window().maximize();
        System.out.println(drive.getTitle());
        System.out.println(drive.getCurrentUrl());
        drive.navigate().to("https://www.amazon.com/");
        Thread.sleep(3000);
        System.out.println(drive.getTitle());
        System.out.println(drive.getCurrentUrl());
        drive.navigate().back();
        drive.navigate().forward();
        Thread.sleep(3000);
        drive.navigate().refresh();
        drive.quit();
    }
}
