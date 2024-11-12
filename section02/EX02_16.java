package section02;

public class EX02_16 {

	public static void main(String[] args) {
		int ga = '가';
		int na = '나';
		
		int alphabetA = 'A'; //유니코드(정수) 65 - 'A'와 매핑됨
		int alphabetB = 'B'; //유니코드(정수) 66 - 'B'와 매핑됨
		
		System.out.println(ga); //'가'는 44032 유니코드값 출력
		System.out.println(na); //'나'는 45208 유니코드값 출력
		System.out.println(alphabetA);
		System.out.println(alphabetB);
		
		char alphabetC = 67;
		System.out.println(alphabetC);
		

	}

}
