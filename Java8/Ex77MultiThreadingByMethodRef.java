class Test{
public void m1(){
for(int i=0; i<10; i++){
System.out.println("Child Thread");
}
}
}

public class Ex77MultiThreadingByMethodRef{
public static void main(String [] args){
Test t = new Test();
Runnable r = t::m1;
Thread t1 = new Thread(r);
t1.start();
for(int i=0; i<10; i++){
System.out.println("Parent thread");
}
}
}