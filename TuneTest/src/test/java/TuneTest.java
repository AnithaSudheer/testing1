import org.openqa.selenium.WebDriver;
import  org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.time.Duration;


public class TuneTest {
    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tamta\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://qatunes.ccbp.tech/");

        //Selct the value pop;
        WebElement selectDropdown = driver.findElement(By.xpath("//select[@id='genre']"));
        Select selectEl = new Select(selectDropdown);
        selectEl.selectByValue("pop");

        WebElement button = driver.findElement(By.xpath("//button[@id = 'getButton']"));
        button.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class = 'song-title']")));

        List<WebElement> elementslist = driver.findElements(By.xpath("//li[@class='song-title']"));

        if(elementslist.size()>0){
            System.out.println(elementslist.size()+" Songs Displayed");
        }


        //Selct the value Rock;

        selectEl.selectByValue("rock");

        button.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class = 'song-title']")));

        if(elementslist.size()>0){
            System.out.println(elementslist.size()+" Songs Displayed");
        }

        driver.quit();








    }
}
