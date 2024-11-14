package section03;

public class EX03_01 {

	public static void main(String[] args) {
		// ** 단항연산자 **
		// 부호연산자
		//int x1 = 100;
		//int resultPuls = +x1; //+부호
		//int resultMinus = -x1; //-부호
		
		//System.out.println(resultPuls);
		//System.out.println(resultMinus);
		
		// 증감연산자
		int num = 10;
		num++;
		System.out.println("num : "+ num);
		
		// for 문으로 증감연산자를 사용하여 num 변수에 0~20이 적히도록 하시오.
		int num1 = 0;
		
		for (int i=0; i<=20; i++) 
			System.out.println(num1++);
		
		//for 문을 이용하여 num2 변수(임의로 선언)에 20부터 1까지 찍히도록 하시오.
		//힌트 : --활용
		
		for (int num2=20; num2>=1; num2--) {
			System.out.println(num2);
		}
		// 논리 부정 연산자
		boolean isHuman = false;
		System.out.println(isHuman);
		System.out.println(!isHuman);

		
	}

}
