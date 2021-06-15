import java.util.function.Consumer;
import java.util.ArrayList;

class Movies{
String name;
String hero;
String heroine;

public Movies(String name, String hero, String heroine){
this.name = name;
this.hero = hero;
this.heroine = heroine;
}
}

public class Ex49DemoCousumer{
public static void main(String [] args){
ArrayList<Movies> l1 = new ArrayList<Movies>();
populate(l1);
Consumer<Movies> c = m -> {
	System.out.println("Movie name : " + m.name);
	System.out.println("Hero name : " + m.hero);
	System.out.println("Heroine name : " + m.heroine);
	System.out.println();
};
for(Movies m : l1){
	c.accept(m);
}
}


public static void populate(ArrayList<Movies> l){
	l.add(new Movies("BahuBali","Prabhash","Anuksha"));
	l.add(new Movies("Kedarnath","Sushant","Sara"));
	l.add(new Movies("Chakde","Sharukh","Preeti"));
	l.add(new Movies("Moneyheist","Professor","Tokyo"));
	l.add(new Movies("Prison Break","Micheal Scoldfield","Sara Trancaty"));
}


}