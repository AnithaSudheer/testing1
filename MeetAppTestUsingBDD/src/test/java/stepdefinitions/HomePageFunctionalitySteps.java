package stepdefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePageFunctionalitySteps {
    WebDriver driver = Hooks.getDriver();

    @Then("I can view with the login name")
    public void iCanViewTheLoginName(){
        String expectedName = "Hello Jack";
        String actualName = driver.findElement(By.xpath("//h1[text()='Hello Jack']")).getText();
        Assert.assertEquals(expectedName, actualName, "Names are Do not match");

        String expectedText = "Welcome to Games";
        String actualText = driver.findElement(By.xpath("//p[text()='Welcome to Games']")).getText();
        Assert.assertEquals(expectedText, actualText, "texts are do not match");
    }
}
