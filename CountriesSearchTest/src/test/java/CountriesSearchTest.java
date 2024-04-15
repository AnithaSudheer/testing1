import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;



public class CountriesSearchTest {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tamta\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://qasearchpage.ccbp.tech/");

        WebElement searchEl = driver.findElement(By.id("searchInput"));
        searchEl.sendKeys("India");

        searchEl.clear();

        searchEl.sendKeys("United States");

        driver.quit();



    }
}
