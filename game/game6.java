package game;

import java.util.Scanner;

public class game6 {

	public static void main(String[] args) {
		// 타자 속도 게임 (Typing Speed Game)
		// 설명 : 제시된 문장을 얼마나 빠르게 입력하는지 측정하는 게임.
		// for(;;) : while 문과 같다
		while(true) {
		Scanner scanner = new Scanner(System.in);
		String sentence = "자바는 재미있는 프로그래밍 언어입니다!";
		System.out.println("다음 문장을 입력하세요 : " + sentence);
		
		
		long startTime = System.currentTimeMillis();
		String input = scanner.nextLine();
		long endTime = System.currentTimeMillis(); 
		double timeTaken = (endTime - startTime) / 1000.0;
		
		if(sentence.equals(input)) {
			System.out.println("정확하게 입력 하셨습니다!");
			System.out.println("소요 시간 : " + timeTaken + "초" );
			break;
		}else {
			System.out.println("틀렸습니다!");
		}
		
		//if System.out.println("정확하게 입력 하셨습니다!");
		//else System.out.println("틀렸습니다!");
		
		
		

	}

}
}
