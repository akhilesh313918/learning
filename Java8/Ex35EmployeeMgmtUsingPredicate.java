import java.util.function.Predicate;
import java.util.ArrayList;

class Employee{
String name;
String designation;
double salary;
String city;

public Employee(String name, String designation, double salary, String city){
this.name = name;
this.designation = designation;
this.salary = salary;
this.city = city;
}

public String toString(){
String s = String.format("[%s, %s, %.2f, %s]", name, designation, salary, city);
return s;
}

}

public class Ex35EmployeeMgmtUsingPredicate{

public static void main(String [] args){
	
ArrayList<Employee> emplist = new ArrayList<Employee>();
populate(emplist);

//To check employee as Manager
Predicate<Employee> p1 = emp -> emp.designation.equals("Manager");
System.out.println("All Employees having Designation as Manager");
display(p1, emplist);

//To Check Employee city as Bangalore
Predicate<Employee> p2 = emp -> emp.city.equals("Bangalore");
System.out.println("All Employees having city as Bangalore");
display(p2, emplist);

//To check Employee salary < 20000
Predicate<Employee> p3 = emp -> emp.salary < 20000;
System.out.println("All Employee having salary less than 20000");
display(p3, emplist);

//Preicate Chaning
//All employee having desgination as Manager and from city bangalore
System.out.println("All employee having desgination as Manager and from city bangalore");
display(p1.and(p2), emplist);

//All employee having salary < 20000 or from city bangalore
System.out.println("All employee having salary < 20000 or from city bangalore");
display(p3.or(p2), emplist);

//All employee having salary > 20000
System.out.println("All employee having salary > 20000");
display(p3.negate(), emplist);


}


public static void display(Predicate<Employee> p, ArrayList<Employee> list){
	for(Employee e : list){
		if(p.test(e)){
			System.out.println(e);
		}
	}
	System.out.println("***************************");
}

public static void populate(ArrayList<Employee> list){
	list.add(new Employee("Durga", "Manager", 25000, "Hyderabad"));
	list.add(new Employee("Sunny", "Manager", 20000, "Bangalore"));
	list.add(new Employee("Ramya", "CEO", 50000, "Mysore"));
	list.add(new Employee("Suresh", "Lead", 15000, "Hyderabad"));
	list.add(new Employee("Kapil", "Tester", 14000, "Chennai"));
	list.add(new Employee("Partha Sarthi", "HR", 12000, "Pune"));
	list.add(new Employee("Arjun", "Developer", 23000, "Hyderabad"));
	list.add(new Employee("Mallika", "Developer", 25000, "Bangalore"));
	list.add(new Employee("Katrina", "Tester", 21000, "Noida"));
	list.add(new Employee("Gajendra", "Scrum Master", 22000, "Indore"));
}

}