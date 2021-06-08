import java.util.function.Function;
import java.util.function.Predicate;
import java.util.ArrayList;

class Student{
String name;
int marks;

public Student(String name, int marks){
this.name = name;
this.marks = marks;
}

public String toString(){
return "Name: " + name;
}

}

public class Ex42ProgramToFindStudentGradeUsingFuncAndPred{

public static void main(String [] agrs){

ArrayList<Student> list = new ArrayList<Student>();
Predicate<Student> p = s -> s.marks > 60;
populate(list);

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

for(Student s : list){
	if(p.test(s)){
	System.out.println("Name: "+ s.name);
	System.out.println("Marks: "+ s.marks);
	System.out.println("Grade: "+ f.apply(s));
	System.out.println("");
	}
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