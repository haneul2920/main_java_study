package section06;
import java.util.Random;
import java.util.Scanner;

public class EX06_응용문제3 {

	public static void main(String[] args) {
		
		int[][] arr = {	{1,2,3,4,5},
						{6,7,8,9,10}
									};
		Random random = new Random();
		Scanner scan = new Scanner(System.in);
		
		boolean finished = false;
		int num = random.nextInt(10);
		System.out.println("목표 숫자 : " + num);
		
		while(!finished) {
			System.out.println("숫자를 맞춰보세요. 행과 열을 입력하세요 (1~10) : ");
			int row = scan.nextInt();
			int col = scan.nextInt();
			if(arr[row][col] == num) {
				System.out.println("정답입니다.");
				finished = true;
			}else {
				System.out.println("틀렸습니다.");
			}
		}		

}
}