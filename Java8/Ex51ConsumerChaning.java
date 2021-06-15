//Consumer Chaning

import java.util.function.Consumer;

class Movie{
String name;
String result;

public Movie(String name,String result){
this.name = name;
this.result = result;
}
} 

public class Ex51ConsumerChaning{
	public static void main(String [] args){
		Consumer<Movie> c1 = m -> {System.out.println("Movie:"+m.name+" is ready to release");};
		Consumer<Movie> c2 = m -> {System.out.println("Movie:"+m.name+" is "+m.result);};
		Consumer<Movie> c3 = m -> {System.out.println("Movie:"+m.name+" information stored in DB");};	
		Consumer<Movie> chainnedC = c1.andThen(c2).andThen(c3);
		
		Movie m1 = new Movie("Bahubali","Hit");
		chainnedC.accept(m1);
		
		Movie m2 = new Movie("Radhe","Flop");
		chainnedC.accept(m2);
		
		}
}