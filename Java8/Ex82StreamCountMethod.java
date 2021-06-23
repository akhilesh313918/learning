import java.util.*;
import java.util.stream.*;

public class Ex82StreamCountMethod{
public static void main(String [] args){
ArrayList<String> l = new ArrayList<String>();
l.add("Pavan");
l.add("Ravi Teja");
l.add("Chiranjeevi");
l.add("Venkatesh");
l.add("Nagarjuna");

System.out.println(l);

long count = l.stream().filter(s -> s.length() >=9).count();
System.out.println("The no. of string whose length is >=9 is: "+count);

}
}