import java.util.*;
import java.util.stream.*;

public class Ex82StreamCollectMethod{
public static void main(String[]args){
ArrayList<String> l = new ArrayList<String>();
l.add("Pavan");
l.add("Ravi Teja");
l.add("Chiranjeevi");
l.add("Venkatesh");
l.add("Nagarjuna");

System.out.println(l);

//Creating a new list using filter method for all string having length greater than 9
List<String> l1 = l.stream().filter(s -> s.length() >= 9).collect(Collectors.toList());

//Creating a new list using map method coverting all string to UpperCase
List<String> l2 = l.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());
System.out.println(l1);
System.out.println(l2);
}
}