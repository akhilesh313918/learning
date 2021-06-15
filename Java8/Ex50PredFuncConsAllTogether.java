import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Consumer;

class Student{
String name;
int marks;

public Student(String name, int marks){
this.name = name;
this.marks = marks;
}

}

public class Ex50PredFuncConsAllTogether{
public static void main(String [] args){
	ArrayList<Student> l = new ArrayList<Student>();
	populate(l);
	
	Predicate<Student> p = s -> s.marks>=60;
	
	Function<Student, String> f = s -> {
		int marks = s.marks;
		
		if(marks>=80){
		return "A[Distinction]";
	}
	else if(marks >=60){
		return "B[First Division]";
	}
	else if(marks >=50){
		return "C[Second Division]";
	}
	else if(marks >=40){
		return "D[Third Division]";
	}
	else{
		return "E[Failed]";
	}
	};
	
	Consumer<Student> c = s -> {
		System.out.println("Name : " + s.name);
		System.out.println("Marks : " + s.marks);
		System.out.println("Grade : " + f.apply(s));
	};
	
	System.out.println("With Predicate");
	System.out.println("****************************");
	//with Predicate
	for(Student s : l){
		if(p.test(s)){
			c.accept(s);
		}
	}
	
	System.out.println("");
	System.out.println("Without Predicate");
	System.out.println("****************************");
	
	//without Predicate
	for(Student s : l){
		
			c.accept(s);
		
	}
	
}

public static void populate(ArrayList<Student> list){
	list.add(new Student("Sunny", 80));
	list.add(new Student("Bunny", 70));
	list.add(new Student("Chinny", 60));
	list.add(new Student("Vinny", 50));
	list.add(new Student("Tinny", 40));
	list.add(new Student("Ginny", 32));
	}
}