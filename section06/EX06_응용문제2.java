package section06;

public class EX06_응용문제2 {

	public static void main(String[] args) {
		// 주어진 배열에서 짝수만 더하여 합을 구해보세요.
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		int sum = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] % 2 == 0){
				sum += arr[i];
			}
		}
		System.out.printf("짝수들의 합 : %d",sum);

	}

}
