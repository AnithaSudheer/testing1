package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

private static WebDriver driver;

@Before
public void setUp(){
    System.setProperty("webdriver.chrome.driver",  "C:\\Users\\tamta\\Downloads\\chromedriver-win32 (1)\\chromedriver-win32\\chromedriver.exe");
    driver = new ChromeDriver();

  }

  @After
    public void  teardown()
            {
      driver.close();
  }

  public static WebDriver getDriver(){
      return driver;
  }

}
