import java.util.function.Function;
public class Ex39FunctionalInterface{
public static void main(String [] args){
	Function<String, Integer> f1 = s -> s.length();
	Function<Integer, Integer> f2 = i-> i*i;
	
	System.out.println(f1.apply("Priyanka"));
	System.out.println(f2.apply(5));
}
}