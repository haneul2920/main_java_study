package game;

import java.util.Random;
import java.util.Scanner;

public class game3 {

	public static void main(String[] args) {
		// 계산기 게임(Calculator Game)
		Scanner scanner = new Scanner(System.in);

		System.out.println("첫 번째 숫자를 입력하세요 : ");
		int num1 = scanner.nextInt();

		System.out.println("두 번째 숫자를 입력하세요 : ");
		int num2 = scanner.nextInt();

		System.out.println("연산을 선택하세요 (+, -, *, .) ");
		char operator = scanner.next().charAt(0);

		int result = 0;
		switch (operator) {
			case '+' :
				result = num1 + num2;
				break;
			case '-' :
				result = num1 - num2;
				break;
			case '*' :
				result = num1 * num2;
				break;
			case '/' :
				result = num1 / num2;
				break;
			default : 
				System.out.println("연산을 선택해주세요!");

			
		}
		System.out.println("결과 : " + result);

	}

}
