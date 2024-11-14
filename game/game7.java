package game;

import java.util.Scanner;

public class game7 {

	public static void main(String[] args) {
		// 최대값 찾기 게임 (Find Maximum)
		// 설명 : 사용자가 입력한 여러 숫자 중 최대값을 찾는 게임.
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("몇 개의 숫자를 입력 하시겠습니까?");
		int count = scanner.nextInt();
		
		int[] numbers = new int[count];
		System.out.println(count + "개의 숫자를 입력하세요 : ");
		
		//숫자를 입력받아 배열에 저장 (game5.java 참고)
		for(int i = 0; i < count ; i++) {
			numbers[i] = scanner.nextInt();
		}
		
		
		// 최대값을 찾기 위한 초기값 설정
		int max = numbers[0];
		
	
		//배열을 순회하면서 최대값 찾기
		
		for (int i = 1; i < numbers.length; i++) {
			//if 문 처리값을 찾아 줄 수 있도록 구성
			if(numbers[i] > max ) {
				max = numbers[i];				
			}
			
		}
		
		System.out.println("가장 큰 숫자는 : " + max);
		
		int min = numbers[0];
	
		for(int i = 1; i < numbers.length; i++) {
			if(numbers[i] < min);{
				min = numbers[0];	
			}
			
		}
		System.out.println("가장 작은 숫자는 : " + min);

	}

}
