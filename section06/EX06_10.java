package section06;

import java.util.Arrays;

public class EX06_10 {

	public static void main(String[] args) {
		int[] arr01 = {3,2,1};
		
		//배열의 얕은 복사
		int[] arr02 = arr01;
		
		Arrays.sort(arr01);
		System.out.println("변경 전 : ");
		System.out.println("arr01 배열 : " + Arrays.toString(arr01));
		System.out.println("arr02 배열 : " + Arrays.toString(arr02));
		
		arr02[1] = 10;
		System.out.println("변경 후 : ");
		System.out.println("arr02 배열 : " + Arrays.toString(arr01));
		System.out.println("arr01 배열 : " + Arrays.toString(arr02));
	}

}
