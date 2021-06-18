import java.util.function.*;
public class Ex69PrimitiveTypeFuncInterFace{
public static void main(String [] args){

// To take integer as input
IntFunction<Integer> f1 = i -> i*i;
System.out.println(f1.apply(5));

//To take String as input and integer as output
ToIntFunction<String> f2 = s -> s.length();
System.out.println(f2.applyAsInt("Akhilesh")); 

//To take Integer as input and Double as output
ToDoubleFunction<Integer> f3 = i -> Math.sqrt(i);
System.out.println(f3.applyAsDouble(5));

}
}