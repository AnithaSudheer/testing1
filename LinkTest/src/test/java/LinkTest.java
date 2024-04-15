import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LinkTest {
    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tamta\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://qabloglist.ccbp.tech/");

        // Navigation to About page
        WebElement about = driver.findElement(By.linkText("About"));
        about.click();

        String aboutExpextedUrl = "https://qabloglist.ccbp.tech/about";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(aboutExpextedUrl));

        String aboutCuurentUrl = driver.getCurrentUrl();

        if(aboutCuurentUrl.equals(aboutExpextedUrl)){
            System.out.println("Navigated to About Page");
        }else{
            System.out.println("Navigation to About Page was failed");
        }

        // Navigation to Contact page
        WebElement contact = driver.findElement(By.linkText("Contact"));
        contact.click();
        String contactExpextedUrl ="https://qabloglist.ccbp.tech/contact";

        wait.until(ExpectedConditions.urlToBe(contactExpextedUrl));
        String ContactCurrentUrl = driver.getCurrentUrl();

        if(contactExpextedUrl.equals(ContactCurrentUrl)){
            System.out.println("Navigated to Contact Page");
        }else{
            System.out.println("Navigation to Contact Page was failed");
        }


        // Navigation to Home page
        WebElement home = driver.findElement(By.linkText("Home"));
        home.click();
        String hometExpextedUrl ="https://qabloglist.ccbp.tech/";

        wait.until(ExpectedConditions.urlToBe(hometExpextedUrl));

        String homeCurrentUrl= driver.getCurrentUrl();

        if(hometExpextedUrl.equals(homeCurrentUrl)){
            System.out.println("Navigated to Home Page");
        }else{
            System.out.println("Navigation to Home Page was failed");
        }


        driver.quit();

    }
}
