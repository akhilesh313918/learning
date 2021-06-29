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
System.out.println();
//My requirement is to create any particular date for eg. 1995,May,28,12:45
LocalDateTime dt1 = LocalDateTime.of(1995,05,28,12,45);
System.out.println(dt1);

System.out.println("After 6 months: "+dt1.plusMonths(6));
System.out.println("Before 6 months:"+dt1.minusMonths(6));

}
}