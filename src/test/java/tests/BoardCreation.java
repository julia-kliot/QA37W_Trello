package tests;

import manage.MyDataProvider;
import model.Board;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreation extends TestBase {


    @Test(dataProvider = "boardModelData", dataProviderClass = MyDataProvider.class)
    public void boardCreation1(Board board) {
        //Board board = Board.builder().title("qa37").build();

        logger.info("Board creation---"+board.getTitle());
        app.getBoard().initBoardCreationFromHeader();
        app.getBoard().fillInBoardCreationForm(board);
      //  app.getBoard().scrollDownTheForm();
        app.getBoard().pause(2000);
        app.getBoard().submitBoardCreation();
        app.getBoard().pause(2000);
        //app.getBoard().isCreated();

        Assert.assertTrue(app.getBoard().isCreated());
        logger.info("Created");
        app.getBoard().pause(2000);
        app.getBoard().returnToHomePage();

        //Assert

    }
    @Test(groups = "group")
    public void boardCreation6() {
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
    public void boardCreation7() {
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
    @Test(dataProvider = "boardData", dataProviderClass = MyDataProvider.class)
    public void boardCreation4(String title) {

        app.getBoard().initBoardCreationFromHeader();
        app.getBoard().fillInBoardCreationForm(title);
        //  app.getBoard().scrollDownTheForm();
        app.getBoard().pause(2000);
        app.getBoard().submitBoardCreation();
        app.getBoard().pause(2000);
        //app.getBoard().isCreated();

        Assert.assertTrue(app.getBoard().isCreated());
        logger.info("Created");
        app.getBoard().pause(2000);
        app.getBoard().returnToHomePage();

        //Assert

    }
    @Test
    public void boardCreation5() {

        logger.info("Board creation qa37w");

        app.getBoard().initBoardCreationFromHeader();
        app.getBoard().fillInBoardCreationForm("qa37w");
        //  app.getBoard().scrollDownTheForm();
        app.getBoard().pause(2000);
        app.getBoard().submitBoardCreation();
        app.getBoard().pause(2000);
        //app.getBoard().isCreated();

        Assert.assertTrue(app.getBoard().isCreated());
        logger.info("Created");
        app.getBoard().pause(2000);
        app.getBoard().returnToHomePage();

        //Assert

    }

    @Test(groups = "group2")
    public void boardCreation2() {

        int boardCountBeforeCreation = app.getBoard().getBoardCount();
        app.getBoard().initBoardCreationFromHeader();
        app.getBoard().fillInBoardCreationForm("qa37");
        app.getBoard().scrollDownTheForm();
        app.getBoard().pause(2000);
        app.getBoard().submitBoardCreation();
        app.getBoard().pause(2000);
        app.getBoard().returnToHomePage();
        app.getBoard().pause(2000);

        int boardCountAfterCreation= app.getBoard().getBoardCount();

        Assert.assertEquals(boardCountAfterCreation,boardCountBeforeCreation+1);


    }

    @Test
    public void boardCreation3(){
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
    @Test
    public void refuseBoardCreation(){
        app.getBoard().initBoardCreationFromHeader();
        app.getBoard().closeCreationWindow();
    }
    @Test
    public void refuseBoardCreation2(){
        app.getBoard().initBoardCreationFromHeader();
        app.getBoard().returnToCreationPage();
    }


}
