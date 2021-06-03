import java.util.function.Predicate;
import java.util.*;

class Ex30PredicateJoining{

public static void main(String[] args){
int x[] = {0,2,4,5,10,12,15,17,20,25,27};

Predicate<Integer> p1 = I -> (I>10);
Predicate<Integer> p2 = I -> (I%2==0);

System.out.println("Given number is greater than 10");
m1(p1,x); 

System.out.println("Given number not greater than 10");
m1(p1.negate(),x);

System.out.println("Even Numbers");
m1(p2,x);

System.out.println("Odd Numbers");
m1(p2.negate(),x);

System.out.println("Even Numbers and greater than 10");
m1(p2.and(p1),x);

System.out.println("Even Numbers or greater than 10");
m1(p1.or(p2), x);

}

public static void m1(Predicate<Integer> p, int x[]){
	for(int x1:x){
		if(p.test(x1)){
			System.out.println(x1);
		}
	}
}

}