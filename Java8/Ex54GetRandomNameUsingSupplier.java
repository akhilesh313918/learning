import java.util.function.Supplier;


public class Ex54GetRandomNameUsingSupplier{
	public static void main(String [] args){
		Supplier<String> s = () -> {
			String [] names = {"Sunny", "Bunny", "Chinny", "Vinny"};
			int x = (int)(Math.random()*4);
			return names[x];
		};
	System.out.println(s.get());		
		
	}
}