//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactPage;


public class ContactPageTest {
    WebDriver driver;

    ContactPage contactPage;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tamta\\Downloads\\chromedriver-win32 (1)\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qaroutingtest.ccbp.tech/");
        contactPage = new ContactPage(driver);
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void checkingTheContactImgHeading(){
        contactPage.clickingTheContactEl();


        Assert.assertTrue(contactPage.contactImgDisplayed(), "Home image is not displayed");

        String expectedText = "Contact";
        String actualText = contactPage.checkContactHeading();
        Assert.assertEquals(actualText, expectedText, "Heading text does not match");
    }

}
