import java.util.function.Function;

public class Ex41StringCountSpace{
	public static void main(String [] args){
		String s = "I  have  to  practice  code  daily";
		Function<String, Integer> f = s1 -> s1.length() - s1.replaceAll(" ", "").length();
		System.out.println(f.apply(s));
	}
}