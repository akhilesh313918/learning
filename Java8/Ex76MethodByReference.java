interface Interf{
public void m1();
}

public class Ex76MethodByReference{
public static void m2(){
	System.out.println("implemented by method reference");
}	
public static void main(String [] args){
Interf i = Ex76MethodByReference::m2;
i.m1();
}
}