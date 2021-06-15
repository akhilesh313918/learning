import java.util.function.Supplier;
import java.util.Date;

public class Ex53GetSysDateUsingSupplier{
public static void main (String [] args){
Supplier<Date> s = () -> new Date();
System.out.println(s.get());
}
}