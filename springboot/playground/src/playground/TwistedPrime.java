package playground;
import java.util.*;
public class TwistedPrime
{
public static void main(String []args)
{
	Scanner in = new Scanner (System.in);
	int rev=0, rem, t;
	double X , k;
	System.out.println("Enter a number");
	X=in.nextDouble();
	int i=1;
	k=X;
	do
	{
		rem=(int)k%10;
		rev=(int)rev*10+rem;
		k=(int)k/10;
		i++;
	}
	while(k>0);t=0;
	System.out.println("REVERSE="+rev);
	for(int w = 2;w<rev/2;w++)
	{
		if(rev%w==0)
			t++;			
	}
	if(t==0)
		System.out.println(X+" is a twisted prime");
	else
		System.out.println(X+" is not a twisted prime");
}

}