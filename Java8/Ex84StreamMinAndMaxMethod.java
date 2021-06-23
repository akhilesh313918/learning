import java.util.List;
import java.util.ArrayList;
import java.util.stream.*;

public class Ex84StreamMinAndMaxMethod{
	
public static void main(String [] args){
	
ArrayList<Integer> l1 = new ArrayList<Integer>();
l1.add(0);
l1.add(10);
l1.add(15);
l1.add(5);
l1.add(20);
l1.add(25);

System.out.println(l1);
//Sorting in natural order
Integer min = l1.stream().min((i1,i2) -> i1.compareTo(i2)).get();
System.out.println("Min number: "+min);

//Sorting in descending/reverse order
Integer max = l1.stream().max((i1,i2) -> i1.compareTo(i2)).get();
System.out.println("Max number: "+max);
}
}