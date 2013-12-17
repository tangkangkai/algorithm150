package one;

//CareerCup 1
//by Kangkai Tang

import org.junit.Test;

public class SolutionForOne {

	// 1.1
	public boolean isUnique(String s) {
		boolean[] byteUniqueArray = new boolean[128];

		for (int i = 0; i < s.length(); i++) {
			int character = s.charAt(i);
			if (byteUniqueArray[character] == true) {
				return false;
			}
			byteUniqueArray[character] = true;
		}

		return true;
	}

	// 1.2
	public void reverse(char[] str) {
		int length = str.length - 1;
		for (int i = 0; i < str.length / 2; i++) {
			int left = i;
			int right = length - i;

			char temp = str[left];
			str[left] = str[right];
			str[right] = temp;
		}
	}

	// 1.3
	public boolean ifPermutation(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}

		int[] chars = new int[256];
		for (int i = 0; i < str1.length(); i++) {
			int charNum = str1.charAt(i);
			chars[charNum] += 1;
		}
		for (int i = 0; i < str2.length(); i++) {
			int charNum = str2.charAt(i);
			if (chars[charNum] == 0) {
				return false;
			}
			chars[charNum] -= 1;
		}
		return true;
	}

	@Test
	public void test1() {
		System.out.println(isUnique("great"));
	}

	@Test
	public void test2() {
		char[] myChar = "hello".toCharArray();
		System.out.println(myChar);
		reverse(myChar);
		System.out.println(myChar);
	}

	@Test
	public void test3() {
		System.out.println(ifPermutation("fhelllo", "hlhello"));
	}
}
