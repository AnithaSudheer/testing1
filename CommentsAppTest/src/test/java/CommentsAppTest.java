
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class CommentsAppTest {

    public WebDriver driver;
    public  int commentsCount;

    public Object[][] dataset= {
            {"John","Innovative and interconnected systems"},
            {"Alice",	"Smart factories, improved efficiency."},
            {"Robert",	"AI-powered automation, limitless potential."},
            {"Harry",	"Data-driven decision-making, game-changer."},
            {"Bob",	"IoT revolutionizing daily life."}

    };

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tamta\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://qacommentsapp.ccbp.tech/");
        commentsCount = 0;
    }

    @AfterMethod
            public void tearDown(){
        driver.quit();
    }

    @DataProvider
    public Object[][] commentsdata(){
            return dataset;
    }

    public void addcomment(String name, String comment){
        WebElement nameEl = driver.findElement(By.className("name-input"));
        nameEl.sendKeys(name);

        WebElement comentEl = driver.findElement(By.className("comment-input"));
        comentEl.sendKeys(comment);

        WebElement addcommentEl = driver.findElement(By.className("add-button"));
        addcommentEl.click();

        commentsCount++;
    }

    public void addcommentsdata(){
        for(Object[] data:dataset){
            String name = String.valueOf(data[0]);

            String coment = String.valueOf(data[1]);

            addcomment(name, coment);
        }
    }

    @Test(priority = 1)
    public void testCommentsCount(){
        for(Object[] data:dataset){
            String name = String.valueOf(data[0]);

            String coment = String.valueOf(data[1]);

            addcomment(name, coment);

            WebElement countEl = driver.findElement(By.className("comments-count"));
            int count = Integer.parseInt(countEl.getText());

            Assert.assertEquals(count,commentsCount, "Comments count do not match" );

        }
    }

    @Test(priority = 2, dataProvider = "commentsdata")
    public void testCommentsInitia(String name, String comment){
           addcomment(name, comment);

           WebElement initialEl = driver.findElement(By.className("initial"));
           String intialLetter = initialEl.getText();

        Assert.assertEquals(intialLetter, name.substring(0,1).toUpperCase(), "Initial do not match");

    }

    @Test(priority = 3)
    public void testCommentsAndOrder(){
        addcommentsdata();

        List<WebElement> usernameElsList =  driver.findElements(By.className("username"));

        List<WebElement> commentsElList = driver.findElements(By.className("comment"));

        for(int i=0; i<dataset.length;i++){

            Object data[] = dataset[i];

            String username = String.valueOf(data[0]);

            String comment = String.valueOf(data[1]);

            WebElement userEl = usernameElsList.get(i);

            WebElement commentEl = commentsElList.get(i);

            Assert.assertEquals(username, userEl.getText(), "Order does not match");

            Assert.assertEquals(comment, commentEl.getText(), "Comment does not correspond to the username");

        }




    }

    @Test(priority = 4)
    public void testCommentLikes(){
        addcommentsdata();

        int likesCount =0 ;

        List<WebElement> likedEls = driver.findElements(By.xpath("//button[text() = 'Like']"));

        for(WebElement likedbutton : likedEls){
            likedbutton.click();

            likesCount++;

            List<WebElement> likedElCount = driver.findElements(By.className("active"));

            Assert.assertEquals(likedElCount.size(), likesCount, "Likes count do not match");
        }

    }

    @Test(priority = 5)
    public void testCommentDeletes(){
       addcommentsdata();

       List<WebElement>deletedEl = driver.findElements(By.xpath("//img[@class = 'delete']/parent::button"));

       for(WebElement delEl :deletedEl){
           delEl.click();

           commentsCount--;

           List<WebElement> deleted = driver.findElements(By.className("comment-item"));

           Assert.assertEquals(deleted.size(), commentsCount,"Comments count do not match");
       }
    }

}
