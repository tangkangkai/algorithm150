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
			chars[str1.charAt(i)] += 1;
		}
		for (int i = 0; i < str2.length(); i++) {

			if (chars[str2.charAt(i)] == 0) {
				return false;
			}
			chars[str2.charAt(i)] -= 1;
		}
		return true;
	}

	// 1.4
	public void replaceSpace(char[] chars) {
		int length = chars.length;
		int spaceCount = 0;
		for (int i = 0; i < length; i++) {
			if (chars[i] == ' ') {
				spaceCount++;
			}
		}
		int newLength = length + spaceCount * 2;
		char[] tempChars = new char[newLength];

		for (int i = 0, j = 0; i < length; i++) {
			if (chars[i] == ' ') {
				tempChars[j++] = '%';
				tempChars[j++] = '2';
				tempChars[j++] = '0';
			} else {
				tempChars[j++] = chars[i];
			}
		}

		System.out.println(tempChars);
	}

	// 1.5
	public String strCompress(String str) {
		StringBuffer sb = new StringBuffer();

		int charCount = 1;
		char[] charArray = str.toCharArray();
		char last = charArray[0];

		for (int i = 1; i < charArray.length; i++) {
			if (charArray[i] == last) {
				charCount++;
			} else {
				sb.append(last);
				sb.append(charCount);
				last = charArray[i];
				charCount = 1;
			}
		}
		sb.append(last);
		sb.append(charCount);

		return sb.length() < str.length() ? sb.toString() : str;
	}

	// 1.6
	// make the names of variables understandable

	public int[][] rotateMatrix(int[][] matrix) {
		if (matrix == null) {
			return null;
		}

		int N = matrix.length;

		for (int layer = 0; layer < N / 2; layer++) {
			rotateBorder(matrix, layer, N);
		}

		return matrix;
	}

	// rotate the matrix Border, but not the whole matrix
	// i means row, n means the orgin size of the matrix

	private void rotateBorder(int[][] matrix, int layer, int N) {
		int first = layer;
		int last = N - 1 - layer;
		for (int element = first; element < last; element++) {
			int top = matrix[layer][element];
			matrix[layer][element] = matrix[N - 1 - element][layer];
			matrix[N - 1 - element][layer] = matrix[N - 1 - layer][N - 1
					- element];
			matrix[N - 1 - layer][N - 1 - element] = matrix[element][N - 1
					- layer];
			matrix[element][N - 1 - layer] = top;
		}
	}

	// 1.7
	// the first change will affect the matrix and the following judge
	public void setZero(int matrix[][]) {
		int M = matrix.length;
		int N = matrix[0].length;
		
		boolean[] ifRowZero = new boolean[M];
		boolean[] ifColumnZero = new boolean[N];

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (matrix[i][j] == 0) {
					ifRowZero[i] = true;
					ifColumnZero[j] = true;
				}
			}
		}

		for (int i = 0; i < M; i++) {
			if (ifRowZero[i]) {
				for (int j = 0; j < N; j++) {
					matrix[i][j] = 0;
				}
			}
		}

		for (int j = 0; j < N; j++) {
			if (ifColumnZero[j]) {
				for (int i = 0; i < M; i++) {
					matrix[i][j] = 0;
				}
			}
		}
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
		System.out.println(ifPermutation("helllo", "lhello"));
	}

	@Test
	public void test4() {
		char[] chars = "".toCharArray();
		// System.out.println();

		replaceSpace(chars);
	}

	@Test
	public void test5() {
		System.out.println(strCompress("aaab"));
	}

	@Test
	public void test6() {
		int[][] testMatrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 },
				{ 7, 8, 9 } };

		printMatrix(testMatrix);

		System.out.println("========");
		int[][] rotateMatrix = rotateMatrix(testMatrix);

		printMatrix(rotateMatrix);

	}

	public void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + "    ");
			}
			System.out.println();
		}
	}

	@Test
	public void test7() {
		int[][] testMatrix = new int[][] { { 1, 2, 0}, { 4, 0, 6 },
				{ 7, 8, 9 } };
		printMatrix(testMatrix);

		System.out.println("========");
		setZero(testMatrix);
		printMatrix(testMatrix);

	}

	@Test
	public void generalTest() {
		boolean[] test = new boolean[3];
		System.out.println(test[0]);
	}
}
