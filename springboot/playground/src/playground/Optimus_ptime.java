//package playground;
//
////to find next prime number
//import java.util.*;
//public class Palindrome_prime
//{
//   public static void main (String args[])
//{
//Scanner in = new Scanner (System.in);
//int i , k, rem, t=0, rev=0,p=0;
//outer:
//	for(i=11;i<1000;i++)
//	{
//		k=i;
//		for(int j=2;j<i/2;i++)
//		{
//			t++;
//		}
//		if(t==0)
//		{
//			rem=k%10;
//			rev=rev*10+rem;
//			k=k/10;
//			for(int q=2;q<rev/2;q++)
//			{
//				if(rev%q==0)
//					p++;
//			}
//			if(p==0)
//			{
//				System.out.println(i+ " ");
//			}
//			else
//			{
//				continue outer;
//			}
//		}
//	}
//}
//}
