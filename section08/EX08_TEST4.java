package section08;

public class EX08_TEST4 {

	public static void main(String[] args) {
		Calc1 c = new Calc1();
		int result = c.plus(3,2);
		int res = result ;
		System.out.println("반환받은 결과는" + result + "입니다.");
		System.out.println("계산 결과는 "+ res + "입니다.");
		
	}

}

class Calc1{
	int plus(int num1,int num2) {
		int res = num1 + num2;
		return res;	
	}
	
}
