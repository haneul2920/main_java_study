package section04;

import java.util.Scanner;

public class 응용문제 {

	public static void main(String[] args) {
		//응용문제 
		//나이별 요금계산 나이에 따라 버스 요금을 계산합니다.
		//7세이하는 무료 8~18세 1000원
		//19이상은 2000원
		//힌트 : else if 를 활용하세요.
		Scanner sc = new Scanner(System.in);
			System.out.println("나이를 입력하세요.");
			int age = sc.nextInt();
				if(age >= 19) {
				System.out.println("2000원 입니다.");
				}
				else if (age > 8 && age <= 18){
					System.out.println("1000원 입니다.");
				}
				else {
					System.out.println("무료 입니다.");
				}
				System.out.println("시스템을 종료 합니다.");
				
			
			}
		
		
	}


