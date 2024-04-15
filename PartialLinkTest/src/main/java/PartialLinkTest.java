import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;




public class PartialLinkTest {
    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tamta\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://qacompany.ccbp.tech/");


        WebElement home = driver.findElement(By.partialLinkText("Hom"));
        home.click();

        WebElement about = driver.findElement(By.partialLinkText("About u"));
        about.click();

        WebElement service = driver.findElement(By.partialLinkText("Ser"));
        service.click();

        WebElement contact = driver.findElement(By.partialLinkText("Contac"));
        contact.click();

        driver.quit();







    }
}
