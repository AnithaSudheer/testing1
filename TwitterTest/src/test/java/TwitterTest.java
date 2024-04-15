import org.testng.Assert;
import org.testng.annotations.Test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TwitterTest {



        // This is a TestNG test method, denoted by the @Test annotation
        @Test
        public void titleTest() {

            // Set the system property to specify the location of the ChromeDriver executable
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\tamta\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");

            // Create a new instance of the ChromeDriver
            WebDriver driver = new ChromeDriver();

            // Navigate to the Twitter website
            driver.get("https://twitter.com");

            // Define the expected title of the Twitter website's login page
            String expectedTitle = "Log in to Twitter / Twitter";

            // Get the current title of the web page opened by the driver
            String actualTitle = driver.getTitle();

            // Assert that the actual title matches the expected title
            Assert.assertEquals(expectedTitle, actualTitle, "Twitter page title does not match");

            // Quit the WebDriver instance
            driver.quit();
        }
    }

