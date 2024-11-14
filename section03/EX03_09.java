package section03;

import java.util.Arrays;

public class EX03_09 {

	public static void main(String[] args) {
		// ** 산술연산자 **
		
		//int x = 100;
		//int y = 200;
		
		//System.out.println(x + y); //100 + 200
		//System.out.println(x - y); //100 - 200
		//System.out.println(x * y); //100 * 200
		//System.out.println((double) x / y); //100 / 200 정수형의 계산으로 0.5가 아닌 0을 반환
		//System.out.println(x % y); //100 % 200
		
		//float result = (float) x / y;
		//System.out.println("result : " + result);
		
		// 위 산술연산자를 for 문과 if 문을 이용하여 작성하시오.
	      for(int i=0; i<5; i++) {
			//System.out.println(i);
			//if(i == 0) System.out.println(x + y);
			//if(i == 0) System.out.println(x - y);
			//if(i == 0) System.out.println(x * y);
			//if(i == 0) System.out.println((double)x / y);
			//if(i == 0) System.out.println(x % y);
			
		}
		
		// 대입연산자 : =, +=, -=, /=, %=
		String strPlus = "";
		
		String str1 = "JAVA 과정";
		strPlus += str1;
		String str2 = "에 오신것을 ";
		strPlus += str2;
		String str3 = "환영 합니다.";
		strPlus += str3;
		
		System.out.println(strPlus);
		
		String str = "JAVA 과정에 오신것을 환영 합니다.";
		String[] strList = str.split("");
		System.out.println(Arrays.toString(strList));
		
		//for문을 사용하여 "JAVA 과정에 오신것을 환영 합니다." 로 출력 하세요.
		// +=을 활용하세요.
		String plus = "";
		for(int i=0; i<=3; i++) {
			System.out.println(strList[i]);
			plus += strList[i];
			
		}
		System.out.println(plus);
		// 관계연산자
		

	}

}
