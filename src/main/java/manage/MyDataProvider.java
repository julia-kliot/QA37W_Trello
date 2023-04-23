package manage;

import model.Board;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {

@DataProvider
    public static Iterator<Object[]>boardData(){
    List<Object[]> list = new ArrayList<>();
    list.add(((new Object[]{"testqa37w1"})));
    list.add(((new Object[]{"testqa37w2"})));
   // list.add(((new Object[]{"testqa37w3"})));


    return  list.iterator();
}

@DataProvider
    public static Iterator<Object[]>boardModelData(){
    List<Object[]> list = new ArrayList<>();
    list.add(new Object[]{Board.builder().title("testqa37m1").build()});
    list.add(new Object[]{Board.builder().title("testqa37m2").build()});

    return  list.iterator();
}
}
