import java.util.function.Predicate;
import java.util.Scanner;

//Java program to check user authentication
class User{
String uname, pwd;
User(String uname, String pwd){
this.uname = uname;
this.pwd = pwd;
}
}

public class Ex33Authenticate{
public static void main(String [] args){

Predicate<User> p = user -> user.uname.equals("akhilesh") && user.pwd.equals("priyanka");

Scanner sc = new Scanner(System.in);
System.out.println("Enter user name");
String uname = sc.next();
System.out.println("Enter password");
String pwd = sc.next();

User user = new User(uname, pwd);

if(p.test(user)){
System.out.println("Login successful");
}else{
System.out.println("Invlaid username and password");
}

}
}