import java.util.function.Function;
import java.util.Scanner;

public class Ex46UserAuthUsingFunctionChaning{
public static void main(String [] args){
Scanner sc = new Scanner(System.in);
System.out.println("Enter username");
String username = sc.next();
System.out.println("Enter password");
String pwd = sc.next();
Function<String, String> f1 = s -> s.substring(0,5);
Function<String, String> f2 = s -> s.toLowerCase();
if(f1.andThen(f2).apply(username).equals("durga") && pwd.equals("java")){
System.out.println("Valid user");
}else{
System.out.println("InValid user");
}
}
}