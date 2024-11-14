package section08;

public class EX08_15 {
	//결과 값을 반환하는 메서드를 호출하는 클래스
	public int sum(int[] nums) {
		int result = 0;
		
		for(int i = 0; i<nums.length; i++) {
			result += nums[i];
		}
		
		return result; // 매개변수 int 형식으로 변환
	}

	public static void main(String[] args) {
		
		int[] num = {500,200,100};
		EX08_15 calc = new EX08_15();
		System.out.println("숫자들의 합은 : " + calc.sum(num));

	}

}
