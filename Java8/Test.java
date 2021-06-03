interface Interf{
public void m1();
}

class Test implements Interf{

public void m1(){
System.out.println("My Own implementation");
}

public static void main(String [] args){
	Test t = new Test();
	t.m1();
}
}