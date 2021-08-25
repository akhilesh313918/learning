package singleton;

import factory.Engineer;
import factory.Teacher;

public class MainClass {
public static void main(String[] args) {
	SingletonClass singletonClassObj1 = SingletonClass.getInstace();
	singletonClassObj1.simpleMethod();
	
	SingletonClass singletonClassObj2 = SingletonClass.getInstace();
	singletonClassObj2.simpleMethod();
	
	Teacher teacher1 = new Teacher();
	System.out.println(teacher1);
	
	Teacher teacher2 = new Teacher();
	System.out.println(teacher2);
	
}
}
