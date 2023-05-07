package tests;

import model.Board;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreation2 extends TestBase{

    @Test
    public void boardCreation8() {
        Board board = Board.builder().title("qa37").build();

        logger.info("Board creation---"+board.getTitle());
        app.getBoard().initBoardCreationFromHeader();
        app.getBoard().fillInBoardCreationForm(board);
        //  app.getBoard().scrollDownTheForm();
        app.getBoard().pause(2000);
        app.getBoard().submitBoardCreation();
        app.getBoard().pause(2000);

        Assert.assertTrue(app.getBoard().isCreated());
        logger.info("Created");
        app.getBoard().pause(2000);
        app.getBoard().returnToHomePage();

    }

    @Test
    public void boardCreation9(){
        Board board = Board.builder().title("qa37new").build();
        app.getBoard().startBoardCreation();
        app.getBoard().pause(2000);
        app.getBoard().fillInBoardCreationForm(board);
        // app.getBoard().pause(2000);
        //app.getBoard().scrollDownTheForm();
        app.getBoard().pause(2000);
        app.getBoard().submitBoardCreation();
        app.getBoard().pause(2000);
        //app.getBoard().isCreated();

        Assert.assertTrue(app.getBoard().isCreated());
    }

}
