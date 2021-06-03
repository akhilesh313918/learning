import java.util.function.Predicate;
import java.util.ArrayList;

//java program to check empty and null value in an array.
public class Ex32PredicateToCheckNullAndEmpty{
public static void main(String [] args){

String [] names = {"Durga", "", "Akhilesh", null, "Priyanka", ""};
Predicate<String> p = s -> s != null && s.length()!=0;
ArrayList<String> al = new ArrayList<String>();
for(String s : names){
if(p.test(s)){
al.add(s);
}
}
System.out.println(al);
}

}