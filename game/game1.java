package game;

import java.util.Random;
import java.util.Scanner;

public class game1 {

	public static void main(String[] args) {
		// 가위 바위 보 게임 (Rock Paper Scissors)
		String[] rps = {"가위", "바위", "보"};
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		System.out.println("가위, 바위, 보 중 하나를 선택 하세요 : ");
		String userMove = scanner.nextLine();
		String computerMove = rps[random.nextInt(3)];
		
		System.out.println("컴퓨터의 선택 : " + computerMove);
		
		if(userMove.equals(computerMove)) {
			System.out.println("비겻습니다!");
		}else if (userMove.equals("가위") && computerMove.equals("바위")) {
			System.out.println("졋습니다!");
		}else if (userMove.equals("바위") && computerMove.equals("보")) {
			System.out.println("졋습니다!");
		}else if (userMove.equals("보") && computerMove.equals("가위")) {
			System.out.println("졋습니다!");
		}else {
			System.out.println("이겻습니다!");
		}
	}

	}
