package manage;

import model.Board;
import model.Card;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
@DataProvider
public static Iterator<Object[]>dataCardCSV() throws IOException {
    List<Object[]> list = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/dataCard.csv")));
String line = reader.readLine();
while (line!=null) {
    String[] split = line.split(",");
    list.add(new Object[]{Card.builder().cardName(split[0]).color(split[1]).build()});
    line = reader.readLine();
}
    return  list.iterator();

}
}
