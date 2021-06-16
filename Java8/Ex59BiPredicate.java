import java.util.function.BiPredicate;

public class Ex59BiPredicate{
public static void main(String [] args){
	BiPredicate<Integer, Integer> p = (a,b) -> (a*b)%2 == 0;
	System.out.println(p.test(2,2));
	System.out.println(p.test(3,3));
}
}