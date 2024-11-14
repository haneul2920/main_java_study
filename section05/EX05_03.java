package section05;

public class EX05_03 {

	public static void main(String[] args) {
		for(int j = 1; j<=9; j++) {
			for(int i=2; i<=9; i++) {
				System.out.print(i + "X" + j + "=" + (i * j) + "\t" ); // \t는 tab \s는 스페이스 \n는 엔터 줄 맞춤할때 활용
			}
			System.out.println();
		}
	}

}

