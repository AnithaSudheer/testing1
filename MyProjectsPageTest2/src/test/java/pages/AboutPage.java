package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AboutPage {
    WebDriver driver;
    WebDriverWait wait;

    public AboutPage(WebDriver driver){
        this.driver  = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    @FindBy(linkText="About")
    WebElement aboutEl;

    @FindBy(className = "about-img")
    WebElement aboutImgEl;

    @FindBy(className = "about-heading")
    WebElement aboutHeadingEl;

    @FindBy(className = "about-paragraph")
    WebElement aboutDiscriptionEl;

    public void clickTheAboutLink(){
        aboutEl.click();
    }

    public boolean aboutImgDisplayed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("about-img")));
        return aboutImgEl.isDisplayed();
    }

    public String checkAboutHeading(){
        return aboutHeadingEl.getText();
    }

    public  String checkAboutDis(){
        return aboutDiscriptionEl.getText();
    }
}
