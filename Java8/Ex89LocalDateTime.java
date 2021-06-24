import java.time.*;

public class Ex89LocalDateTime{
public static void main(String [] args){
LocalDateTime dt = LocalDateTime.now();
System.out.println(dt);
int dd = dt.getDayOfMonth();
int mm = dt.getMonthValue();
int yyyy = dt.getYear();
System.out.printf("%d-%d-%d",dd,mm,yyyy);

int h = dt.getHour();
int m = dt.getMinute();
int s = dt.getSecond();
int n = dt.getNano();
System.out.println();
System.out.printf("%d-%d-%d-%d",h,m,s,n);
}
}