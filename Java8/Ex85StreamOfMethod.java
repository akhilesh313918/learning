import java.util.stream.*;

public class Ex85StreamOfMethod{
public static void main(String [] args){

//Applying stream for group of values	
Stream<Integer> s = Stream.of(9,99,999,9999,9999);
s.forEach(System.out::println);

//Applying stream for arrays
Double[] d = {10.1,10.2,10.3,10.4,10.5};
Stream<Double> s1 = Stream.of(d);
s1.forEach(System.out::println);

}
}