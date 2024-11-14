package section05;

public class 응용문제05 {

	public static void main(String[] args) {
		// 다중 반복문을 사용해 삼각형 * 출력
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4 - i; j++) {
				System.out.print(" ");
			}
			for(int k = 0; k < (2*i) + 1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		

	}

}
