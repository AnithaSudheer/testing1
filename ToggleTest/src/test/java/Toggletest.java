

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Toggletest {
    public static  void main(String[] args){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tamta\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        // Navigate to the login page
        driver.get("https://qaebank.ccbp.tech/ebank/login");

        // Find the username input element
        WebElement usernameEl = driver.findElement(By.id("userIdInput"));

        // Enter the username
        usernameEl.sendKeys("142420");
        System.out.println("Username entered");

        // Find the password input element
        WebElement passwordEl = driver.findElement(By.id("pinInput"));

        // Enter the password
        passwordEl.sendKeys("231225");
        System.out.println("Password entered");

        // Find the submit button element
        WebElement submitButtonEl = driver.findElement(By.className("login-button"));

        // Submit the login form
        submitButtonEl.submit();
        System.out.println("Submitted login details");

        // Quit the browser
        driver.quit();
    }
}
