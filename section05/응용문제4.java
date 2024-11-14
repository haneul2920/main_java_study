package section05;

import java.util.Random;

public class 응용문제4 {

	public static void main(String[] args) {
		//두 개의 주사위가 같은 값이 나올 때까지 while 문을 사용해 반복하고, 반복횟수와 주사위 눈의 번호를 출력해 보세요.
		//Random random = new Random();
		int cnt = 0;
		int dice1,dice2;
		Random random = new Random();
		
		do {
			dice1 = random.nextInt(6) + 1;
			dice2 = random.nextInt(6) + 1;
			cnt++;
			System.out.println("주사위1 : " + dice1 + "\t" + "주사위2 : " + dice2);
			
		}while(dice1 != dice2);
		System.out.println("같은 값이 나올 때까지 반복한 횟수 : " + cnt);
		/*int dice1;
		int dice2;
		int cnt = 0;
		while(true) {
			dice1 = (int)(Math.random() * 6) + 1;
			dice2 = (int)(Math.random() * 6) + 1;
			cnt++;
			if(dice1 == dice2) {
				System.out.printf("반복 횟수는 %d이고 주사위 눈의 번호는 %d와 %d 입니다.",cnt, dice1, dice2);
				break;
				*/
			}
		
		//System.out.println();
		
	}

