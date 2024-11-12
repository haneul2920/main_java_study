package section02;

public class EX02_27 {

	public static void main(String[] args) {
		// 강제 형변환 예제1
		// int형 -> byte형 강제 형 변환(값이 작을 경우)
		int i = 500;
		byte b = (byte)i; //byte는 -128 ~ 128
		System.out.println(b);
		
		// 강제 형변환 예제 2
		// double(8비트) -----> float(4비트)
		double d1 = 1.0e100;
		float f3 = (float)d1;
		System.out.println(f3);
		
		// 무한대 현상
		double d4 = 9.123456789;
		float f4 = (float)d4;
		System.out.println(f4);
		
		

	}

}
