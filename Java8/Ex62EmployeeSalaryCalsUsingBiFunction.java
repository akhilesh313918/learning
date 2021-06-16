import java.util.function.BiFunction;

class Employee{
int eno;
String name;
double dailyWage;

public Employee(int eno, String name, double dailyWage){
this.eno = eno;
this.name = name;
this.dailyWage = dailyWage;
}

}

class TimeSheet{
int eno;
int days;

public TimeSheet(int eno, int days){
this.eno = eno;
this.days = days;
}
}

public class Ex62EmployeeSalaryCalsUsingBiFunction{
public static void main(String[]args){
Employee emp = new Employee(101, "Akhilesh", 10000);
TimeSheet ts = new TimeSheet(101, 25);

BiFunction<Employee, TimeSheet, Double> f = (e,t) -> e.dailyWage * t.days;
System.out.println("Monthly Salary : " +f.apply(emp,ts));
}
}