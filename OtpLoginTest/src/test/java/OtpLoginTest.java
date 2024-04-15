
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OtpLoginTest {
    public static void main(String[] args) {

        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tamta\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");

        // Launch Chrome Browser
        WebDriver driver = new ChromeDriver();

        // Navigate to the Email verification page
        driver.get("https://qaotploginpage.ccbp.tech");

        // Find the username input element
        WebElement usernameEl = driver.findElement(By.id("email"));

        // Enter the username
        usernameEl.sendKeys("example@gmail.com");
        System.out.println("Email address entered");

        // Find the Send OTP button element
        WebElement sendOtpCodeEl = driver.findElement(By.className("send-otp-btn"));

        // Submit the Send OTP button
        sendOtpCodeEl.click();

        // Define the expected page title of the OTP verification page
        String expectedPageTitle = "OTP Verification";

        // Get the current url after email address validation
        String currentPageTitle = driver.getTitle();

        // Verify Successful email address validation
        if (currentPageTitle.equals(expectedPageTitle)) {
            System.out.println("OTP sent successfully");
            System.out.println(driver.getTitle());
        }

        // Find the OTP input element
        WebElement otpCodeEl = driver.findElement(By.id("otp"));

        // Enter the OTP
        otpCodeEl.sendKeys("123456");
        System.out.println("OTP entered");

        // Find the verify OTP buttom element
        WebElement verifyCodeButtonEl = driver.findElement(By.id("verifyOtpBtn"));

        // Submit the Verify OTP button
        verifyCodeButtonEl.click();

        // Define the expected URL of the home page
        String expectedUrl = "https://qaotploginpage.ccbp.tech/home";

        // Wait for the expected URL to be loaded
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        // Get the current URL after login
        String currentUrl = driver.getCurrentUrl();

        // Verify successful login
        if (currentUrl.equals(expectedUrl)) {
            System.out.println("Logged in successfully");
            System.out.println(driver.getTitle());
        }

        // Quit the WebDriver instance
        driver.quit();

    }
}
