import java.util.ArrayList;
import java.util.stream.*;

public class Ex84StreamForEachMethod{
public static void main(String [] args){
ArrayList<String> l = new ArrayList<String>();
l.add("A");
l.add("BB");
l.add("CCC");

//Using lambda Expression
l.stream().forEach(s -> System.out.println(s));

//Using method reference :: double colon operator
l.stream().forEach(System.out::println);
}
}