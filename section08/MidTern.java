package section08;

public class MidTern {
	public int score(int[] scores) {
		int result = 0;
//		for(int i=0; i<scores.length; i++) {
//			result += scores[i];
//		}
		//향상된 for 문
		for(int i : scores) {
			result += i;
			
			
		}
		return result;
	}

}