package game;

import java.util.Scanner;

public class game16 {

	public static void main(String[] args) {
		// 2중 배열 활용 단어 퍼즐 게임
		// 퍼즐을 완성하는 게임
		char[][] puzzle = { { 'H', 'A', 'P' },
							{ 'P', 'Y', 'N' },
							{ 'P', 'L', 'E' } 
												};
		char[][] guessed = new char[3][3];
		// char[][] guessed = {{'-', '-', '-',}, {'-', '-', '-',}, {'-', '-', '-',}};
		// 위의 소스를 이중 for 문을 사용하여 작성하기 참고 game12.java
		for (int i = 0; i < guessed.length; i++) {
			for (int j = 0; j < guessed[i].length; j++) {
				guessed[i][j] = '-';
			}
		}
		for (int i = 0; i < guessed.length; i++) {
			for (int j = 0; j < guessed[i].length; j++) {
				System.out.print(guessed[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("------------------------------");
		//향상된 for 문으로 바꾸기
		
		for(char[] val : guessed) {
			for(char guess : val) {
				System.out.print(guess + " ");
			}
			System.out.println();
		}
		

		Scanner scan = new Scanner(System.in);
		boolean gameCompleted = false;

		while (!gameCompleted) {
			System.out.println("현재 퍼즐 상태 : ");
			for (int i = 0; i < guessed.length; i++) {
				for (int j = 0; j < guessed[i].length; j++) {
					System.out.print(guessed[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println("행과 열을 선택해 글자를 추측하세요 (0-2) : ");
			int row = scan.nextInt();
			int col = scan.nextInt();
			System.out.println("추측한 글자를 입력하세요 : ");
			char guess = scan.next().toUpperCase().charAt(0); // toUpperCase() 대문자로 바꿈

			// 아래 소스를 활용하여 if 문을 구성하여 게임을 완성하시오 (2중 for 문사용)
			// 아래 게임소스에서 사용
			// 아래 게임 소스에서 사용
			// guessed[row][col] = guess; //아래 게임 소스에서 사용
			// completed = false;
			// gameCompleted = true;

			if (puzzle[row][col] == guess) {
				// 소스 1
				guessed[row][col] = guess;
				boolean completed = true;
//				for (int i = 0; i < guessed.length; i++) {
//					for (int j = 0; j < guessed[i].length; j++) {
//						if (guessed[i][j] != puzzle[i][j]) {
//							// 소스2
//							completed = false;
//						}
//					}
//				}
				//위 소스를 향상된 for 문으로 바꿔서 테스트 해보세요
				if (completed) {
					for (int i = 0; i < guessed.length; i++) {
						for (int j = 0; j < guessed[i].length; j++) {
							System.out.print(guessed[i][j] + " ");
							// 소스3							
						}
						System.out.println();
					}
					gameCompleted = true;
					System.out.println("퍼즐을 완성 했습니다!");

				}
			} else {
				System.out.println("틀렸습니다. 다시 시도하세요.");
			}

		}
	}

}
