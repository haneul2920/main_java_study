package section08;

public class EX08_17 {

	public static void main(String[] args) {
		int[] sutdentA = {97,53};
		int[] sutdentB = {95,66};
		
		MidTern mid = new MidTern();
		int sumA = mid.score(sutdentA);
		int sumB = mid.score(sutdentB);
		
		if(sumA > sumB) {
			System.out.println("A학생의 중간고사 총점이 더 높습니다.");
		}else if(sumA<sumB){
			System.out.println("B학생의 중간고사 총점이 더 높습니다.");			
		}else {
			System.out.println("두 학생의 중간고사 총점이 같습니다");
		}

	}

}
