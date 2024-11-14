package game;

import java.util.Scanner;

public class game5 {

	public static void main(String[] args) {
		// 숫자 계산 게임 (Number Calculation Game)
		// for문 활용
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("몇 개의 숫자를 계산 하시겟습니까 : ");
		int count = scanner.nextInt();		
		int[] num = new int[count];
		
		System.out.println(count + "숫자를 입력해주세요.");
		
		for(int i = 0; i < count; i++) {
			num[i] = scanner.nextInt();
		}
		
		int sum = 0;
		int product = 1;
		double average = 0;
		
		for(int i=0; i < count; i++) {
			sum = sum + num[i];
			product *= num[i];
			average = sum / (double)count;
		}
			

		
		System.out.println("합 : " + sum);
		System.out.println("곱 : " + product);
		System.out.println("평균 : " + average);
		
		/*Scanner scanner = new Scanner(System.in);
		System.out.println("3개의 숫자를 입력하세요 : ");
		//System.out.println("4개의 숫자를 입력하세요 : ");
		int[] numbers = new int[3];
		for(int i = 0; i < 3; i++) {
			numbers[i] = scanner.nextInt();
			
		}
		int sum = 0;
		int product = 0;
		double average = 0;
		
		sum = numbers[0] + numbers[1] + numbers[2];
		product = numbers[0] * numbers[1] * numbers[2];
		average = (numbers[0] + numbers[1] + numbers[2]) / 3;
		
		System.out.println("합 : " + sum);
		System.out.println("곱 : " + product);
		System.out.println("평균 : " + average);
*/
	}

}
