package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "home-img")
    WebElement homeImgEl;

    @FindBy(className = "home-heading")
    WebElement homeHeadingEl ;

    public boolean homeImgDisplayed(){
        return  homeImgEl.isDisplayed();
    }

    public String checkingHomeHeading(){
        return homeHeadingEl.getText();
    }
}
