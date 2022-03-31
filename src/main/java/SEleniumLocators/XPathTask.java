package SEleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathTask {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");

        WebElement title= driver.findElement(By.xpath("//h3"));
        System.out.println(title.getText());
        WebElement paragragh = driver.findElement(By.xpath("//h4[@class='subheader']"));
        System.out.println(paragragh.getText());

        //contains:
        WebElement containsMethod = driver.findElement(By.xpath("//h3[contains(text(),'Horizontal Slider')]"));
        System.out.println(containsMethod.getText());
    }
}
