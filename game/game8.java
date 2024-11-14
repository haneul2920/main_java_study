package game;

import java.util.Random;

import java.util.Scanner;

public class game8 {

	public static void main(String[] args) {

			// 야구 게임

		Random rand = new Random();

		Scanner scanner = new Scanner(System.in);

		int[] target = { rand.nextInt(5) + 1, rand.nextInt(5) + 1, rand.nextInt(5) + 1 };
		int[] guess = new int[3];
		int attempts = 0;
		
		System.out.print("컴퓨터가 정한 숫자는 : ");
		
		for(int i=0; i<target.length; i++) {
			System.out.print(target[i] + " ");
			
		}
		System.out.println();

		while (true) {

			int strikes = 0, balls = 0;

			attempts++;

			System.out.print("숫자 3개를 입력하세요 (1 ~ 5): ");

			for (int i = 0; i < 3; i++) {

				guess[i] = scanner.nextInt();

			}

			for (int i = 0; i < 3; i++) {

					//if
				if(target[i] == guess[i]) {
					guess[i] = scanner.nextInt();
					strikes++;	
				}else {
					balls++;	
				}

				

			}

			System.out.println(strikes + " 스트라이크, \t" + balls + " 볼");

			if (strikes == 3) {

				System.out.println("축하합니다! " + attempts + "번 만에 맞추셨습니다.");

				break;

			}

		}

	}

}