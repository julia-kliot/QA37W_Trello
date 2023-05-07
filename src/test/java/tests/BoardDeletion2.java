package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardDeletion2 extends TestBase {


    @Test
    public void boardDeletion1() {
        app.getBoard().clickTheFirstBoard();
        app.getBoard().pause(4000);
        app.getBoard().openSideBar();
        app.getBoard().openMore();
        app.getBoard().closeBoard();
        app.getBoard().deleteBoard();
    }

    @Test
    public void boardDeletion2() {
        int boardCountBeforeDeletion = app.getBoard().getBoardCount();

        app.getBoard().clickTheFirstBoard();
        app.getBoard().pause(4000);
        app.getBoard().openSideBar();
        app.getBoard().openMore();
        app.getBoard().closeBoard();
        app.getBoard().deleteBoard();
        int boardCountAfterDeletion = app.getBoard().getBoardCount();

        Assert.assertEquals(boardCountAfterDeletion, boardCountBeforeDeletion - 1);

    }


}
