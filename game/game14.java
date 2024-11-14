package game;

import java.util.Random;
import java.util.Scanner;

public class game14 {

	public static void main(String[] args) {
		// 지뢰찾기 게임
		char[][] board = {{'-', '-', '-'}, {'-', '-', '-'}, {'-', '-', '-'}};
		boolean[][] mines = new boolean[3][3];
		Random random = new Random();
		Scanner scanner =new Scanner(System.in);
		boolean gameOver = false;
		
		//for (int i = 0; i < 3; i++) {
			int row = random.nextInt(mines.length);
			int col = random.nextInt(mines.length);		
			mines[row][col] = true;
		//}
			board[row][col] = '*';
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {	
					System.out.print(board[i][j] + " ");
				}
				System.out.println();
			}
				
		
		while(!gameOver) {
			
			System.out.println("행과 열을 선택하세요 (0-2): ");
			int row1 = scanner.nextInt();
			int col1 = scanner.nextInt();
			
			
			if(mines[row1][col1]) {
				System.out.println("지뢰를 밟았습니다! 게임 종료.");
				gameOver = true;
			}else {
				board[row1][col1] = 'O';
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {	
						System.out.print(board[i][j] + " ");
					}
					System.out.println();
				}
			}
		}
		
		

	}

}
