package manage;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class ApplicationManager {
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    WebDriver wd;

    UserHelper user;
    BoardHelper board;
    ListHelper list;
    CardHelper card;
    AtlassianHelper atlassian;

    public void init(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        wd = new ChromeDriver(options);
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //wd= new ChromeDriver();
        wd.navigate().to("https://trello.com/");

          user = new UserHelper(wd);
          board= new BoardHelper(wd);
          list= new ListHelper(wd);
          card= new CardHelper(wd);
          atlassian = new AtlassianHelper(wd);
          user.login("juliakliot.jk@gmail.com","misha240613");


    }

    public UserHelper getUser() {
        return user;
    }

    public BoardHelper getBoard() {
        return board;
    }

    public ListHelper getList() {
        return list;
    }

    public CardHelper getCard() {
        return card;
    }

    public AtlassianHelper getAtlassian() {
        return atlassian;
    }

    public String getUrl(){
        return  wd.getCurrentUrl();
    }

    public void quit(){
        wd.close();
        wd.quit();
    }


}
