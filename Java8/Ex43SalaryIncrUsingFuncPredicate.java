import java.util.function.Function;
import java.util.function.Predicate;
import java.util.ArrayList;

class Employee{
String name;
double salary;

public Employee(String name, double salary){
this.name = name;
this.salary = salary;
}

public String toString(){
return name +" : "+ salary;
}
}

public class Ex43SalaryIncrUsingFuncPredicate{
	
public static void main(String [] args){
	ArrayList<Employee> l1 = new ArrayList<Employee>();
	populate(l1);
	System.out.println("Employee Salary before Increment");
	System.out.println(l1);
	System.out.println();
	
	Predicate<Employee> p = e -> e.salary < 3500;
	Function<Employee, Employee> f = e -> {
											e.salary = e.salary + 477;
											return e;
										  };
	
	ArrayList<Employee> l2 = new ArrayList<Employee>();
	
	for(Employee e:l1){
		if(p.test(e)){
			f.apply(e);
			l2.add(e);
		}
	}
	
	System.out.println("Employees salary after Increment");
	System.out.println(l2);
}

public static void populate(ArrayList<Employee> list){
	list.add(new Employee("Sunny", 3000));
	list.add(new Employee("Bunny", 7000));
	list.add(new Employee("Chinny", 2500));
	list.add(new Employee("Vinny", 5000));
	list.add(new Employee("Tinny", 4000));
	list.add(new Employee("Ginny", 3500));
	}
}