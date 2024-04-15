import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class XpathLoginTesst {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tamta\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://qaebank.ccbp.tech/ebank/login");

        //Login process
        WebElement userName = driver.findElement(By.xpath("/html/body/div/div/div/div/form/div[1]/input"));
        userName.sendKeys("142420");

        WebElement passWord = driver.findElement(By.xpath("/html/body/div/div/div/div/form/div[2]/input"));
        passWord.sendKeys("231225");

        WebElement buttonE = driver.findElement(By.xpath("/html/body/div/div/div/div/form/button"));
        buttonE.click();


        String loginExpextedUrl = "https://qaebank.ccbp.tech/";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(loginExpextedUrl));

        String loginCuurentUrl = driver.getCurrentUrl();

        if (loginCuurentUrl.equals(loginExpextedUrl)) {
            System.out.println("Logged in successfully");
            System.out.println(driver.getTitle());
        } else {
            System.out.println("Navigation to Login Page was failed");
        }

        //Logout process
        WebElement logOut = driver.findElement(By.xpath("/html/body/div/div/div[1]/button"));
        logOut.click();

        String logOutExpextedUrl = "https://qaebank.ccbp.tech/ebank/login";

        wait.until(ExpectedConditions.urlToBe(logOutExpextedUrl));

        String logOutCuurentUrl1 = driver.getCurrentUrl();

        if (logOutCuurentUrl1.equals(logOutExpextedUrl)) {
            System.out.println("Logged out successfully");
        }
        driver.quit();
    }
}
