package section02;

public class PrintSpase {

	public static void main(String[] args) {
		// 오른쪽 정렬하여 출력하기
		/*
		System.out.printf("%5d", 1);
		System.out.println();
		System.out.printf("%5d", 12);
		System.out.println();
		System.out.printf("%5d", 123);
		System.out.println();
		System.out.printf("%5d", 1234);
		System.out.println();
		System.out.printf("%5d", 12345);
		*/
		
		System.out.printf("정수 1 과 2를 더하기 %d", 1 + 2);
		System.out.println();
		System.out.printf("문자 1 과 2를 더하기 %s", "1" + "2");
		System.out.println();
		
		// 위의 소스를 for문으로 자동 처리 하세요
		String strSort = "";
		
		for(int i=1; i<=5; i++) {
			
			
			// 숫자를 문자로 변환 int --> string
			
			String str = Integer.toString(i);
			strSort = strSort + str;
			
			/*
			 * // 카멜 표기법 String stringSorting = ""; // 파스칼 표기법 String StringSorting = ""; //
			 * 팟홀 표기법 String string_sorting = "";
			 */
			
			System.out.printf("%5s", strSort);
			System.out.println();
			
			
			
		}
		System.out.println("--------------");
		float iSort = 0;
		for(int i=1; i<=5; i++) {
			iSort = iSort + i;
			System.out.println(iSort);
		}
		
		
		
	}

}
