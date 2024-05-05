import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

public class HomePageTest {

    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tamta\\Downloads\\chromedriver-win32 (1)\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void checkTheHeadingEl(){
        WebElement homeEl = driver.findElement(By.xpath("//a[text()='Home']"));

    }

}
