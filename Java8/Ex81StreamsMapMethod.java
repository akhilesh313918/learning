import java.util.*;
import java.util.stream.*;

public class Ex81StreamsMapMethod{
public static void main(String [] args){
ArrayList<Integer> l1 = new ArrayList<Integer>();
l1.add(0);
l1.add(10);
l1.add(15);
l1.add(5);
l1.add(20);
l1.add(25);

System.out.println(l1);

List<Integer> l2 = l1.stream().map(i -> i*2).collect(Collectors.toList());

System.out.println(l2);
}
}