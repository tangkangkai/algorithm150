package one;

public class Test {
	public static void test1() {
		System.out.println(2 & 1);
	}

	public static boolean isUniqueString(String s) {
		int count = 0;

		for (int i = 0; i < s.length(); i++) {
			int checker = s.charAt(i) - 'a';
			if ((count & (1 << checker)) > 0) {
				return false;
			}
			count |= (1 << checker);
		}

		return true;

	}

	public static void main(String[] args) {
		System.out.println(isUniqueString("abcdefg"));
	}
}
