package section10.access2;

import section10.access1.*;

public class PublicB {
	public static void main(String[] args) {
		PublicA a = new PublicA(9);
		a.printA();
		
		//DefaultC c = new DefaultC(); //에러 : default 접근제한자로 인해 다른 패키지에서 사용 불가한 클래스
		
	}

}
