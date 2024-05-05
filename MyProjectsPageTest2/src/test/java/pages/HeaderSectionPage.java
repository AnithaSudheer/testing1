package pages;
//import org.openqa.selenium.By;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;


public class HeaderSectionPage {
    @FindBy(how = How.CLASS_NAME, using="logo")
    WebElement logoElement;

    @FindBy(linkText="Home")
    WebElement homeElement;

    @FindBy(linkText="About")
    WebElement aboutElement;

    @FindBy(linkText="Contact")
    WebElement contactElement;

    @FindBy(className = "title")
    WebElement titleElement;


    WebDriver driver;
    WebDriverWait wait;

    public HeaderSectionPage(WebDriver driver){

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public boolean checkingLogo(){
        return  logoElement.isDisplayed();
    }

    public String chekingTheText(){

        return  titleElement.getText();
    }

    public void clickingtheAbout(){
       aboutElement.click();

    }

    public void clickingtheContact(){
        contactElement.click();
    }

    public void clickingtheHomet(){
        aboutElement.click();
        homeElement.click();
    }




}
