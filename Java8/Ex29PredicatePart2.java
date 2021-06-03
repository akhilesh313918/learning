import java.util.function.Predicate;
import java.util.*;

// To check whether String is greater than 5 or not
public class Ex29PredicatePart2{
public static void main (String [] args){

Predicate<String> p1 = s -> s.length()>5;
System.out.println(p1.test("abc"));
System.out.println(p1.test("abcdef"));

Predicate<Collection> p2 = c -> c.isEmpty();
ArrayList<String> l1 = new ArrayList<String>();
l1.add("test");
System.out.println(p2.test(l1));
ArrayList<String> l2 = new ArrayList<String>();
System.out.println(p2.test(l2));
}
}