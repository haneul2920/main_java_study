package section05;

public class 응용문제3 {

	public static void main(String[] args) {
		// 1부터 100까지의 정수 중에서 짝수만을 더해 출력하는 코드를 for 문을 사용해 작성해 보세요.
		int sum = 0;
		for(int i = 1; i<=100; i++) {
			if(i % 2 != 0) {
				continue;
			}
			System.out.println(i);
			sum += i;			
		}
		System.out.println("짝수의 합 : " + sum);		

	}

}
