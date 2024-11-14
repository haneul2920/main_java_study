package section05;

public class EX05_07 {

	public static void main(String[] args) {
		int sum = 0;
		for(int i = 1; i <= 100; i++) {
			if(i % 2 != 0) {
				continue;
			}
			System.out.println(i);
			sum += i;
		}
		System.out.println("짝수 합 : " + sum);
		
		

	}

}

