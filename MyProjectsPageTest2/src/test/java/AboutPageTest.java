import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AboutPage;

import java.time.Duration;


public class AboutPageTest {
    WebDriver driver;
    //WebDriverWait wait;
   AboutPage aboutPage;


   @BeforeMethod
   public void setUp(){
      System.setProperty("webdriver.chrome.driver", "C:\\Users\\tamta\\Downloads\\chromedriver-win32 (1)\\chromedriver-win32\\chromedriver.exe");
      driver = new ChromeDriver();
      driver.get("https://qaroutingtest.ccbp.tech/");
      aboutPage = new AboutPage(driver);
      aboutPage.clickTheAboutLink();
   }

   @AfterMethod
   public void tearDown(){
      driver.close();
   }

   @Test
   public void checkingTheAboutPage(){
      aboutPage.clickTheAboutLink();
      Assert.assertTrue(aboutPage.aboutImgDisplayed(), "Home image is not displayed");

      String expectedHeading = "About";
      String actualHeading = aboutPage.checkAboutHeading();
      Assert.assertEquals(expectedHeading,actualHeading,"Heading does not match");

      String expectedDis = "I love to create! I am a frontend web developer";
      String actualdiscription = aboutPage.checkAboutDis();
      Assert.assertEquals(expectedDis,actualdiscription,"Discription does not match");



   }

}
