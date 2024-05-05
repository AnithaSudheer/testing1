package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class RegistrationFunctionalitySteps {

    WebDriver driver = Hooks.getDriver();

    @Given("Iam on the login page")
    public void iamOnTheLoginPage(){
        driver.get("https://qameetup.ccbp.tech/");
    }

    @When("I Click on the Register button")
    public void iClickOnTheRegisterButton(){
        driver.findElement(By.id("registerButton")).click();
    }

    @And("I click on the Register Now button")
    public void iclickOnTheRegisterNowButton(){
        driver.findElement(By.xpath("//button[text()='Register Now']")).click();
    }

    @Then("an error message 'Please enter your name' should be visible")
    public void errorMessage(){
        String errorText = driver.findElement(By.xpath("//p[text()='Please enter your name']")).getText();
        Assert.assertEquals(errorText, "Please enter your name");
    }

    @And("I enter valid input and select 'Games option' from the dropdown list")
    public void iEnterValidInput(){
        driver.findElement(By.id("name")).sendKeys("Jack");
        WebElement dropDownEl = driver.findElement(By.id("topic"));
        Select gamesOptionEl = new Select(dropDownEl);
        gamesOptionEl.selectByValue("GAMES");

    }

    @Then("I should be redirected to the Home page")
    public void iShouldBeRedirectedToTheHomePage(){
        String expectedUrl = "https://qameetup.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl, "urls do not match");
    }

}
