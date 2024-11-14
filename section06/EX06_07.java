package section06;

import java.util.Arrays;

public class EX06_07 {

	public static void main(String[] args) {
		int[] arr = { 1, 6, 2, 3, 10, 7, 4, 5, 8, 9 };
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			if (i == arr.length - 1) {
				System.out.print(arr[i]);
			} else {
				System.out.print(arr[i] + ", ");
			}
			

		}
		System.out.print("]");
		System.out.println();
		System.out.println(Arrays.toString(arr));


	}
}
