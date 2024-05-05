
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.time.Duration;
import java.util.*;

public class LoginPageTest {
    public WebDriver driver;
    public WebDriverWait wait;

    public Object[][] dataset ={
        {"", ""},
        {"rrhul", "rahul@2021"},
        {"rahul", "rahul2021"},
        {"rahul", "rahul@2021"}

    };

   @DataProvider
   public Object[][] loginData(){
       return dataset;
   }

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tamta\\Downloads\\chromedriver-win32 (1)\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
    }

    @Test
    public void checkthelogo() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement logoEl = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login-website-logo")));
        System.out.println(logoEl.isDisplayed());
    }

    @Test
    public void checkTheLoginText() {
        String ExpectedHeading = "Login";
        WebElement headingel = driver.findElement(By.className("sign-in-heading"));
        String Actualheading = headingel.getText();
        Assert.assertEquals(Actualheading, ExpectedHeading, "heading do not match");
        //System.out.println(Actualheading);
    }

    @Test
    public void checkTheUsername(){
    String expectedUsername = "USERNAME";
    WebElement usernamreEl = driver.findElement(By.xpath("//label[text()='USERNAME']"));
    String actualUsername = usernamreEl.getText();
    Assert.assertEquals(actualUsername,expectedUsername,"username do not match");
    System.out.println(actualUsername);
}

    @Test
    public void checkThePassword(){
        String expectedPassword = "PASSWORD";
        WebElement passwordnameEl = driver.findElement(By.xpath("//label[text()='PASSWORD']"));
        String actualPasswoedEl = passwordnameEl.getText();
        Assert.assertEquals(actualPasswoedEl, expectedPassword, "password do not match");
        System.out.println(actualPasswoedEl);
    }

    public void addLoginData(String username, String password){
        WebElement userInput = driver.findElement(By.id("usernameInput"));
        userInput.sendKeys(username);

        WebElement passwordInput = driver.findElement(By.id("passwordInput"));
        passwordInput.sendKeys(password);

        WebElement LoginBtn = driver.findElement(By.className("login-button"));
        LoginBtn.click();
    }

    @Test(dataProvider = "loginData")
    public void  checkTheLoginFunctionalities(String username, String password) {

        addLoginData(username, password);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        if (username == "rahul" && password == "rahul@2021") {

            String expectedUrl = "https://qamoviesapp.ccbp.tech/";
            wait.until(ExpectedConditions.urlToBe(expectedUrl));
            String actualUrl = driver.getCurrentUrl();
            Assert.assertEquals(expectedUrl, actualUrl, "urls do not match");

        } else {

            WebElement errText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));
            WebElement erromsg = driver.findElement(By.className("error-message"));
            String actualErrMsg = erromsg.getText();
            System.out.println(actualErrMsg);
        }

    }

    @AfterMethod
    public void teardown(){

       driver.close();
    }

}
