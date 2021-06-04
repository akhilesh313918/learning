import java.util.function.Predicate;
class SoftwareEngineer{
String name;
int age;
boolean ishavingGF;

public SoftwareEngineer(String name, int age, boolean ishavingGF){
this.name = name;
this.age = age;
this.ishavingGF = ishavingGF;
}

public String toString(){
return name;
}
}

public class Ex34SWEAllowedToPUB{
public static void main(String [] args){
	SoftwareEngineer[] list = {
		new SoftwareEngineer("Durga", 60, false),
		new SoftwareEngineer("Suraj", 25, true),
		new SoftwareEngineer("Devesh", 24, true),
		new SoftwareEngineer("Rohit", 28, true),
		new SoftwareEngineer("Rana", 17, true),
		};
Predicate<SoftwareEngineer> allowed = se -> se.age >=18 && se.ishavingGF == true;
for(SoftwareEngineer se : list){
	if(allowed.test(se)){
		System.out.println(se);
	}
}

}

}