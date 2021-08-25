package singleton;

public class SingletonClass {
private static SingletonClass singletonInstance = new SingletonClass();
private SingletonClass() {
	
}

public static SingletonClass getInstace() {
	return singletonInstance;
}

public void simpleMethod() {
	System.out.println("hascode of singleton object" + singletonInstance);
}



}
