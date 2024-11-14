package section06;

public class EX06_17 {

	public static void main(String[] args) {
		
		//향상된 for 문
		int [] score = {90, 92, 93};
		
		int sum = 0;
		double avg = 0;
		
		//합과 평균을 구한다
		for( int val : score) {
			sum += val;//sum = sun + val;
		}
		
		avg = (double) sum / score.length;
		
		System.out.printf("총점 : %d\n평균 : %f",sum, avg);

	}

}
