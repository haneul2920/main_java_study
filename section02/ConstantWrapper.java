package section02;

public class ConstantWrapper {

	public static void main(String[] args) {
		// Constants(상수)
		final int MAX_VALUE = 100;  // 상수선언
		System.out.println("최대값 : "+ MAX_VALUE);
		
		// MAX_VALUE = 200; 오류 : 상수는 변경할 수 없다
		
		// Wrapper 클래스 : 기본자료형을 객체로 다루기 위해 사용
		// int : Integer
		// double : Double
		int intValue = 10;
		Integer intObj = Integer.valueOf(intValue);
		System.out.println("intObj 객체 :"+ intObj);
		
		
	}

}
