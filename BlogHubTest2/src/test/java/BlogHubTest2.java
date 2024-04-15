import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BlogHubTest2 {

    public WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tamta\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://qabloghub.ccbp.tech/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("blog-item")));

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1)
    public void HomePageTest(){

        int listEl = 10;

        List<WebElement> numberOfListEl = driver.findElements(By.className("blog-item"));

        Assert.assertEquals(listEl, numberOfListEl.size(), "Few blogs are missing..");

    }

    @Test(priority = 2)
    public void testBlogTitles(){

        int listEl = 10;

        List<WebElement> blogTitles = driver.findElements(By.cssSelector("img[class $= 'image'] + div > h1"));


        String expectedBlogTitles[] = {
                "React v16.9.0 and the Roadmap Update",
                "React v16.7: No, This Is Not the One With Hooks",
                "Building Great User Experiences with Concurrent Mode and Suspense",
                "Introducing The Problem Solver React v17.0",
                "What about the React v16.13.0 That we Developed",
                "React v16.4.2: Server-side vulnerability fix",
                "Introducing Zero-Bundle-Size React Server Components",
                "Introducing the New JSX Transform",
                "Introducing the New React DevTools",
                "Sneak Peek: Beyond React 16" };

        for(int i=0; i<10;i++){

            WebElement actual = blogTitles.get(i);

            Assert.assertEquals(expectedBlogTitles[i], actual.getText(), "Mismatch found in blog titles");
        }

    }

}
