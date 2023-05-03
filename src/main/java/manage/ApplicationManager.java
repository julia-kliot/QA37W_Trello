package manage;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
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
    String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init(){
        if(browser.equals(Browser.CHROME.browserName())){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            wd = new ChromeDriver(options);
            logger.info("Tests run in Chrome browser");
        }
        else if (browser.equals(Browser.EDGE.browserName())){
            wd= new EdgeDriver();
            logger.info("Tests run in Edge browser");
        }

        WebDriverListener listener = new MyListener();
        wd= new EventFiringDecorator<>(listener).decorate(wd);
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
