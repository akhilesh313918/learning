import java.util.function.Function;

public class Ex47IdentityMethod{
public static void main(String [] args){
Function<String, String> f1 = Function.identity();
System.out.println(f1.apply("Durga"));
}
}