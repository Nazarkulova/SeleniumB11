package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.plaf.IconUIResource;
import java.util.List;
import java.util.Locale;

public class FindElementPractice {
    public static void main(String[] args) {
        //Facebook interview question
        //1- navigate to the yahoo.com
        //2-click news
        //3-get all the news headers
        //4-print out only has covid
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.yahoo.com/");
        driver.manage().window().maximize();
        WebElement news = driver.findElement(By.id("root_2"));
        news.click();
        List<WebElement> headers = driver.findElements(By.tagName("h3"));
        int counter=0;
        for (int i=0; i< headers.size();i++ ){
           // System.out.println(headers.get(i).getText());
            if (headers.get(i).getText().toUpperCase(Locale.ROOT).contains("covid")){
                System.out.println(headers.get(i).getText());
                counter++;
            }
        }
        System.out.println(counter);
    }

}
