package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasics {
    public static void main(String[] args) {
        // STEP1: We need to define the chrome driver into the
        // project as a property.
        System.setProperty("webdriver.chrome.driver","chromedriver");
        // STEP2: We need to instantiate or declare our driver.
        WebDriver driver= new ChromeDriver();
        // NOTE: Driver is a reference name. WebDriver->Interface
        // new ChromeDriver()->new Object.
        // INTERVIEW:
        // Where do u use polymorphism in your testing framework?
        // I use it to instantiate my driver like
        // WebDriver driver= new ChromeDriver();
        // 2-INTERVIEW
        // Can you instantiate your driver like
        //  WebDriver driver= new WebDriver(); -NO

        // First Method:
        // Get()--> methods navigates to the given url.
        System.out.println(driver.getTitle()+"before");
        driver.get("https://www.techtorialacademy.com/");
        // getTITLE()-> method get the title of the page
        String title = driver.getTitle();
        System.out.println(title);
        if (title.equals("Home Page - Techtorial")){
            System.out.println("Your test is passed");
        }else{
            System.out.println("Your test is failed");
        }
        String actual = driver.getCurrentUrl();
        String expected = "https://www.techtorialacademy.com/";
        if (actual.equals(expected)){
            System.out.println("Your test is passed");
        }else{
            System.out.println("Your test is failed");
        }



    }

}
