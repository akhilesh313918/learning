import java.util.function.BiFunction;
import java.util.ArrayList;

class Student{
String name;
int rollno;
public Student(String name, int rollno){
	this.name = name;
	this.rollno = rollno;
}

}

public class Ex61CreateStuObjUsingBiFuction{
public static void main(String [] args){
	ArrayList<Student> l = new ArrayList<Student>();
	BiFunction<String, Integer, Student> f = (name, roll) -> new Student(name, roll);
	l.add(f.apply("Akhilesh",100));
	l.add(f.apply("Priyanka", 101));
	
	for(Student s: l){
		System.out.println("Student Name: "+s.name);
		System.out.println("Student RollNo.: "+s.rollno);
	}
}
}