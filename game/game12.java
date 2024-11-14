package game;

import java.util.Random;
import java.util.Scanner;

public class game12 {

	public static void main(String[] args) {
		// 고요한 숲 속에서 몬스터를 찾는 게임(2차원 배열)
		// 설명 : 2차원 배열에서 몬스터가 숨겨져 있는 위치를 찾는 게임. 사용자가 좌표를 입력하여 몬스터를 찾아 냅니다.
		// 학습포인트 : 타일 이동, 좌포 탐색, 랜덤 위치 설정
		char[][] forset = new char[5][5];
		
		for(int i = 0; i < forset.length; i++ ) {
			for(int j = 0; j < forset[i].length; j++) {
				forset[i][j] = '-';
			}
		}
		
		// 위에서 입력된 내용을 출력 해보세요.
		for(int i = 0; i < forset.length; i++ ) {
			for(int j = 0; j < forset[i].length; j++) {
				System.out.print(forset[i][j] + " ");
			}
			System.out.println();			
		}
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		
		int monsterRow = random.nextInt(5);
		int monsterCol = random.nextInt(5);
		
		forset[monsterRow][monsterCol] = 'M';
		
		
		System.out.println("숲 속에서 몬스터를 찾아보세요!(5 X 5 배열)");
		boolean foundMonster = false;
		
		while(!foundMonster) {
			for(char[] row : forset) {
				for(char cell : row) {
					System.out.print(cell + " ");
				}
				System.out.println();
			}
			System.out.println("좌표를 입력하세요 (행, 열) : ");
			int guessRow = scan.nextInt();
			int guessCol = scan.nextInt();
			if(guessRow == monsterRow && guessCol == monsterCol) {
				System.out.println("몬스터를 찾았습니다!");
				foundMonster = true;
			}else {
				System.out.println("몬스터는 여기에 없습니다. 다시 시도하세요.");
				forset[guessRow][guessCol] = 'X';
			}
			
		}
		
	}

}
