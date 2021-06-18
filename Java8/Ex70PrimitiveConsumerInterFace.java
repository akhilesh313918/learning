import java.util.function.*;
public class Ex70PrimitiveConsumerInterFace{
public static void main(String [] args){

// To take integer as input
IntConsumer c1 = i -> System.out.println(i*i);
c1.accept(10);


//To take double as input
DoubleConsumer c2 = i -> System.out.println(i*i);
c2.accept(10); 

//To take Long as input
LongConsumer c3 = i -> System.out.println(i*i);
c3.accept(10);

}
}