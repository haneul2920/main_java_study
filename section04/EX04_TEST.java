package section04;

import java.util.Scanner;

public class EX04_TEST {

	public static void main(String[] args) {
		// IF
		// 홀짝 판단
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요");
		
		int num = sc.nextInt();
		
		if(num %2 == 0) {
			System.out.println("짝수");
		}else {
			System.out.println("홀수");
		}

	}

}
