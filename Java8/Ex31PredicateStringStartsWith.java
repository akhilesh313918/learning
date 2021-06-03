import java.util.function.Predicate;

class Ex31PredicateStringStartsWith {
public static void main(String [] args){
String [] str = {"Kajal","Mallika","Katrina","Sunny","Kareen","Kaira"};
Predicate<String> p = s -> s.startsWith("K");
for(String s1: str){
if(p.test(s1)){
System.out.println(s1);
}
}
}
}