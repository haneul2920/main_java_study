package section10.access1;

public class PublicA {
	public int a;
	public String str;
	
	public PublicA(int a) {
		this.a = a;
	}
	
	
	private PublicA(String str) {
		this.str = str;
		
	}
	
	public void printStr() {
		System.out.println("생성자 오버로딩으로 문자를 매개변수로 만들어 매소드 호출 테스트 입니다.");
		
	}
	
	public void printA() {
		System.out.println("PublicA 클래스의 printA() 메서드입니다."+a);
		
	}
	
	DefaultC dc = new DefaultC();
	void methodA() {
		dc.VariableC = 20;
	}

}
