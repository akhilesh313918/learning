import java.util.function.BiFunction;
import java.util.function.BiConsumer;
import java.util.ArrayList;

class Employee{
String name;
double salary;

public Employee(String name, double salary){
this.name = name;
this.salary = salary;
}
}

public class Ex63EmpSalIncrUsingBiFuctionBiConsumer{
public static void main(String[]args){
ArrayList<Employee> l = new ArrayList<Employee>();
BiFunction<String, Double, Employee> f = (name, salary) -> new Employee(name, salary);
BiConsumer<Employee, Double> c = (e,incr) -> e.salary = e.salary + incr;
l.add(f.apply("Akhilesh", 250000.00));
l.add(f.apply("Priyanka", 280000.00)) ;

for(Employee e : l){
	c.accept(e,50000.23);
}

for(Employee e : l){
	System.out.println("Name: " + e.name);
	System.out.println("Salary" + e.salary);
}

}
}