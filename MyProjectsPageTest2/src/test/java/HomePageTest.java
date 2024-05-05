import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;


public class HomePageTest {
    WebDriver driver;
    HomePage homePage;

   @BeforeMethod
    public void setUp(){
       System.setProperty("webdriver.chrome.driver", "C:\\Users\\tamta\\Downloads\\chromedriver-win32 (1)\\chromedriver-win32\\chromedriver.exe");
       driver = new ChromeDriver();
       driver.get("https://qaroutingtest.ccbp.tech/");
       homePage = new HomePage(driver);
   }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void checkingTheHomeImgHeading(){
        Assert.assertTrue(homePage.homeImgDisplayed(), "Home image is not displayed");

        String expectedText = "Home";
        String actualText = homePage.checkingHomeHeading();
        Assert.assertEquals(actualText, expectedText, "Heading text does not match");
    }

}
