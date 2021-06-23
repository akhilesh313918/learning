package playground;

interface Left{
	default void m1() {
		System.out.println("Left Default method");
	}
}

interface Right{
	default void m1() {
		System.out.println("Right Default method");
	}
}

public class Test1 implements Left, Right {
	
	public void m1() {
		//System.out.println("My own Implementation");
		Left.super.m1();
		Right.super.m1();
	}
	
	public static void main(String[] args) {
		Test1 t1 = new Test1();
		t1.m1();
	}

}
