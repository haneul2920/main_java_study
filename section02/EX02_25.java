package section02;

public class EX02_25 {

	public static void main(String[] args) {
		int num1 = 14;
		double num2 = 3.14;
		
		//double num4 = num1; //num1을 자동으로 double로 형변환 해줌.
		//int num3 = (double)num2; // 자동 형 변환을 할수 없는 역방향! 컴바일 에러 발생!
		int num4 = (int) num2;
		
		System.out.println(num4);

	}

}
