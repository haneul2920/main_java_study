package game;

import java.util.Scanner;

public class Game19 {

	public static void main(String[] args) {
		// 행 슬라이딩 퍼즐
		// 퍼즐에서 각 행을 좌우로 밀어 숫자를 정렬하는 게임.
		// 각 행은 배열 내에서 좌우로 순환 이동 됩니다.
		Scanner scan = new Scanner(System.in);
		int[][] board = {	{4,1,3,2},
							{8,7,6,5},
							{12,11,10,9},
							{16,15,14,13}				
						};
		while(true) {
			// 배경
			printBoard(board);
			System.out.println("행 선택(0~3)");
			int row = scan.nextInt();
			
			System.out.println("이동 방향 (L: 왼쪽, R: 오른쪽)");
			char direction = scan.next().toUpperCase().charAt(0);
			
			//선택한 행을 좌우로 슬라이드
			if(direction == 'L') {
				//왼쪽으로 가는 메소드 호출
				slideLeft(board, row);
			}else if(direction == 'R') {
				//오른쪽으로 가는 메소드 호출
				slideRight(board, row);
			}
			
		}
		

	}
	//왼쪽으로 가는 메소드 호출
	private static void slideLeft(int[][] board,int row) {
		int first = board[row][0];
		for(int i = 0; i < board[row].length-1; i++) {
			board[row][i] = board[row][i+1];			
		}
		board[row][board.length -1] = first;
	}
	//오른쪽으로 가는 메소드 호출
		private static void slideRight(int[][] board,int row) {
			int last = board[row][board[row].length-1];
			for(int i = board[row].length -1; i > 0; i--) {
				board[row][i] = board[row][i-1];			
			}
			board[row][0] = last;
		}
	private static void printBoard(int[][] board){
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board.length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	

}
