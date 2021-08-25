package coding.questions;

import java.util.HashSet;
import java.util.Set;

public class Isogram {
	public static void main(String[] args) {
		Isogram isogram = new Isogram();
		System.out.println(isogram.isIsogram("tin"));
	}

	public boolean isIsogram(String s) {
		boolean isIsogram = true;
		char[] c = s.toCharArray();
		Set<Character> set = new HashSet<Character>();
		for (Character character : c) {
			if (set.contains(character)) {
				isIsogram = false;
			} else {
				set.add(character);
			}
		}
		return isIsogram;
	}
}
