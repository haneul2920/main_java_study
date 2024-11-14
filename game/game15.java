package game;

import java.util.Scanner;

public class game15 {

	public static void main(String[] args) {
		// (이중 배열) 숫자 맞추기 게임
		int[][] board = {	{1,2,3},
							{4,5,6},
							{7,8,9}		};
		Scanner scan = new Scanner(System.in);
		boolean gamefinished = false;
		//while문 안에서 gamefinished = true; 이 소스를 넣어 완성하세요.
		
		int tagetNumber = 7; //목표 숫자 설정
		
		
		while(!gamefinished) {
			System.out.println("숫자를 맞춰주세요. 행과 열을 입력하세요. (0~2)");
			int row = scan.nextInt();
			int col = scan.nextInt();
			
			
			if(board[row][col] == tagetNumber) {
				System.out.println("정답입니다.");
				gamefinished = true;
			}else {
				System.out.println("틀렷습니다. 다시 시도하세요.");
				}
			}
			//if 
			//System.out.println("정답입니다.");
			
			//else
			//System.out.println("틀렷습니다. 다시 시도하세요.");
		}

	}


