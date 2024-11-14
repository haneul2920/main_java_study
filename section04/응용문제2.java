package section04;

import java.util.Scanner;

public class 응용문제2 {

	public static void main(String[] args) {
		// 응용문제
		//학생의 성적을 입력받아 90점 이상이면 "A" 80점 이상이면 "B" 70점이상이면 "c" 나머지는 "F"
		Scanner sc = new Scanner(System.in);
		System.out.println("점수를 입력 하세요.");
		
		int num = sc.nextInt();
		
		//if(num >= 90 ) {
		//	System.out.println("A");
		//}else if (num >= 80) {
		//	System.out.println("B");
		//}else if (num >= 70) {
		//	System.out.println("C");
		//}else {
		//	System.out.println("F");
		//}
		switch(num / 10) {
		case 10 :
		case 9 : 
			System.out.println("A");
			break;
		case 8 : 
			System.out.println("B");
			break;
		case 7 : 
			System.out.println("C");
			break;
		case 6 :
		case 5 :
		case 4 :
		case 3 :
		case 2 :
		case 1 :
		case 0 :
			System.out.println("F");
			break;
		default :
			System.out.println("잘못된 점수입니다.");
		}
		
		
		
	}

}
