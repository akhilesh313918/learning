package playground;
public class Palindrome_prime
{
 public static void main(String args[])
{
int i , k, rem, t=0, rev=0,p=0,h=0;
outer:
	for(i=1;i<1000;i++)
	{
		k=i;
		for(int j=2;j<i/2;i++)
		{
			if(k%j==0)
			t++;
		}
		if(t==0)
		{
			rem=k%10;
			rev=rev*10+rem;
			k=k/10;
			for(int q=2;q<rev/2;q++)
			{
				if(rev%q==0)
					p++;
			}
			if(p==0)
			{
				System.out.print(i+ ",");h++;
			}
		}
		if(h>0)
			continue outer;
	}
}
}
