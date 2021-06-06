import java.util.function.Function;

public class Ex40StringSpaceRemove{
	public static void main(String [] args){
		String s = "I have to practice code daily";
		Function<String, String> f = s1 -> s1.replaceAll(" ", "");
		System.out.println(f.apply(s));
	}
}