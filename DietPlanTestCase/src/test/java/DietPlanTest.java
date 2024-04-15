import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;


public class DietPlanTest {
    public static void main(String[] args){

        System.setProperty("Webdriver.chrome.driver", "C:\\Users\\tamta\\Downloads\\chromedriver-win64.zip\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://dietplantest.ccbp.tech/");

        WebElement breakfastEl = driver.findElement(By.id("oatmeal"));
        breakfastEl.click();

        WebElement snackEl = driver.findElement(By.id("yogurt"));
        snackEl.click();

        WebElement lunchel = driver.findElement(By.id("chicken"));
        lunchel.click();

        WebElement snacEl2 = driver.findElement(By.id("proteinShake"));
        snacEl2.click();

        WebElement dinnerEl = driver.findElement(By.id("salmon"));
        dinnerEl.click();

        WebElement snackEl3 = driver.findElement(By.id("fruits"));
        snackEl3.click();

        driver.quit();

    }

}
