
package section02;

public class Printf01 {

	// 서식문자 
	// %d : 정수(10진수)
	// %f : 실수
	// %s : 문자열
 	public static void main(String[] args) {
		//System.out.printf("저는 대학교 %d학년에 재학중입니다", 2);
		
		System.out.printf("%d은 첫 번째, %f은 두 번째, %s은 세번째.",1, 2.0, "셋");
		System.out.println();
 		// for문으로 1 부터 숫자 10까지 출력
 		for (int i=1; i<=10; i++) {
 			System.out.printf("숫자는 %d", i);
 			System.out.println("");
 			
 		}
	}

}
