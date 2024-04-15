import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RadioBuutonTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tamta\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://qatraveldest.ccbp.tech/");

        WebElement beachE = driver.findElement(By.tagName("input"));
        beachE.click();

        WebElement adventurE = driver.findElement(By.id("adventure"));
        adventurE.click();

        WebElement cityE = driver.findElement(By.id("city"));
        cityE.click();

        WebElement culturalE = driver.findElement(By.id("cultural"));
        culturalE.click();

        driver.quit();



    }
}

