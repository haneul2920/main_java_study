package section10;

public class Customer extends Person { // 자식 클래스 선언
	int memberID;
	
	Customer(String name, int age, int memberID){
		super(name, age); // super메서드를 통해서 부모 생성자에 매개변수 젼달
					 	 // 부모객체 생성
		this.memberID = memberID;
	}
	
	void enter() {
		System.out.println("회원 번호 : " + memberID + "(" + name + ", " + age + "세) 님 입장하셧습니다.");
	}

}
