package section05;

public class ForTest {

	public static void main(String[] args) {
		// 1부터 100까지의 숫자 중 4의 배수이지만 8의 배수가 아닌 수를 출력 하시오
		
		int cnt = 0;
		
		for(int i=1; i<=100; i++) {
			if(i % 4 == 0 && i % 8 !=0) {
				System.out.println(i);
				cnt++;
			}
		
		}
		System.out.println("출력 갯수 : "+cnt);
	}

}
