import java.util.ArrayList;
import java.util.stream.*;

public class Ex85StreamtoArrayMethod{
public static void main(String [] args){
ArrayList<Integer> l1 = new ArrayList<Integer>();
l1.add(0);
l1.add(10);
l1.add(15);
l1.add(5);
l1.add(20);
l1.add(25);
System.out.println(l1);

//Forming a new array using combination of toArray() and :: double colon operator
Integer[] array = l1.stream().toArray(Integer[]::new);
for(Integer x : l1){
	System.out.println(x);
}
}
}