import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


import pages.HeaderSectionPage;


public class HeaderSectionTest {
    WebDriver driver;

    HeaderSectionPage headerPage;


    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tamta\\Downloads\\chromedriver-win32 (1)\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qaroutingtest.ccbp.tech/");
        headerPage = new HeaderSectionPage(driver);

    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test(priority = 1)
    public void chekingheadeing(){

        Assert.assertTrue(headerPage.checkingLogo(),"Page logo is not displayed" );
        String expectedtext = "Wave";
        String actualText = headerPage.chekingTheText();
        Assert.assertEquals(actualText, expectedtext, "Title text does not match");
    }

    @Test(priority = 2)
    public void navigateTheAboutLink(){
        headerPage.clickingtheAbout();
        String expectedUrl = "https://qaroutingtest.ccbp.tech/about";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl, "urls do not match");
    }

    @Test(priority = 3)
    public void navigateTheContacttLink(){
        headerPage.clickingtheContact();
        String expectedUrl = "https://qaroutingtest.ccbp.tech/contact";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl, "urls do not match");
    }

    @Test(priority = 4)
    public void navigateTheHometLink(){
        headerPage.clickingtheHomet();
        String expectedUrl = "https://qaroutingtest.ccbp.tech/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl, "urls do not match");
    }

}