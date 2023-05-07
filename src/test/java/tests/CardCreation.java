package tests;

import manage.MyDataProvider;
import model.Card;
import org.testng.annotations.Test;

public class CardCreation extends TestBase{

    @Test(groups = "group")
    public void cardCreation(){
        Card card = Card.builder().cardName("testqa37").color("green").build();

        app.getBoard().clickTheFirstBoard();
        app.getBoard().pause(3000);
        app.getList().createList("test37");
        app.getList().pause(2000);
        app.getCard().initCardCreation();
        app.getCard().fillInCardCreationForm(card);
        app.getCard().submitCardCreation();
        app.getBoard().returnToHomePage();
    }

    @Test(dataProvider = "dataCardCSV", dataProviderClass = MyDataProvider.class)
    public void cardCreation2(Card card){
       // Card card = Card.builder().cardName("testqa37").color("green").build();

        app.getBoard().clickTheFirstBoard();
        app.getBoard().pause(3000);
        app.getList().createList("test37");
        app.getList().pause(2000);
        app.getCard().initCardCreation();
        app.getCard().fillInCardCreationForm(card);
        app.getCard().submitCardCreation2();
        app.getBoard().returnToHomePage();
    }
}
