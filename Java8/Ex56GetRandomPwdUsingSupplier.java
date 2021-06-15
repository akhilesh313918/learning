//Program to get random password like 6A8A3A7A

import java.util.function.Supplier;

public class Ex56GetRandomPwdUsingSupplier{
	public static void main(String [] args){
		Supplier<String> s = () -> {
			String pwd = "";
			Supplier<Integer> d = () -> (int)(Math.random()*10);
			String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZ@#$";
			Supplier<Character> c = () -> symbols.charAt((int)(Math.random()*29));
			
			for (int i=0; i<=8; i++){
				if(i%2 == 0){
					pwd = pwd + d.get();
				}else{
					pwd = pwd + c.get();
				}
			}
			return pwd;
		};
		System.out.println(s.get());
		System.out.println(s.get());
		System.out.println(s.get());
		System.out.println(s.get());
		System.out.println(s.get());
		System.out.println(s.get());
		System.out.println(s.get());
	}
}