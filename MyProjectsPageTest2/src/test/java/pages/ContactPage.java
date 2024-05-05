package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ContactPage {
    WebDriver driver;
    WebDriverWait wait;

    public ContactPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "contact-img")
    WebElement contactImgEl;

    @FindBy(className = "contact-heading")
    WebElement contactHeadingEl ;

    @FindBy(linkText = "Contact")
    WebElement contactEl;

    public void  clickingTheContactEl(){
        contactEl.click();
    }

    public boolean contactImgDisplayed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("contact-img")));
        return  contactImgEl.isDisplayed();
    }

   public String checkContactHeading(){
        return contactHeadingEl.getText();
   }
}
