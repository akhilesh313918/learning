import java.util.function.Function;
import java.util.ArrayList;

class Employee{
String name;
double salary;

public Employee(String name, double salary){
this.name = name;
this.salary = salary;
}

public String toString(){
return "name: " + name;
}
}

public class Ex43CalcAllEmpSalaryUsingFunc{
	public static void main(String [] args){
		ArrayList<Employee> l = new ArrayList<Employee>();
		populate(l);
		<ArrayList<Employee>, Double> f = l1 -> {
			double total = 0;
		for(Employee e : l1){
		total = total + e.salary;
		3}
return total;			
		};
		System.out.println("The total salary of employee :" + f.apply(l));
	}
	
	public static void populate(ArrayList<Employee> list){
	list.add(new Employee("Sunny", 80));
	list.add(new Employee("Bunny", 70));
	list.add(new Employee("Chinny", 60));
	list.add(new Employee("Vinny", 50));
	list.add(new Employee("Tinny", 40));
	list.add(new Employee("Ginny", 32));
	}
}