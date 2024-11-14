package section06;

import java.util.Arrays;
import java.util.Comparator;

public class EX06_08 {

	public static void main(String[] args) {
		// Arrays.sort();
		Integer[] arr = {1,6,2,3,10,7,4,5,8,9};
		
		System.out.println("정렬 전 배열 : " + Arrays.toString(arr));
		
		//배열의 오름차순으로 정렬
		Arrays.sort(arr);
		System.out.println("오름차순 정렬 : " + Arrays.toString(arr));
		
		
		//배열의 내림차순으로 정렬
		Arrays.sort(arr, Comparator.reverseOrder());
		System.out.println("내림차순 정렬 : " + Arrays.toString(arr));
	}

}
