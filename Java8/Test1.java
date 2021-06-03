interface Interf{
public static void m1(){
System.out.println("Interface Static Method");	
}
}

public class Test1 implements Interf{

public static void m1(){
Interf.super.m1();
}

public static void main(String [] args){
Test1 t1 = new Test1();
t1.m1();
}
}