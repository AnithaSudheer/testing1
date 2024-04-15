import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class FirstTest {
    public static void main(String[] args){
        System.setProperty("Webdriver.chrome.driver", "C:\\Users\\tamta\\Downloads\\chromedriver-win64.zip\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://practice.expandtesting.com");

        WebElement linktext = driver.findElement(By.partialLinkText("Radio"));
        linktext.click();

        String expextedUrl = "https://practice.expandtesting.com/radio-buttons";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expextedUrl));

        String currentUrl = driver.getCurrentUrl();

        if(currentUrl.equals(expextedUrl)){
            System.out.println("navigated to the page was successful");
        }else{
            System.out.println("navigated to the page was failed");
        }

        driver.quit();

    }
}
