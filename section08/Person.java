package section08;

public class Person {
	//필드에 대한 접근 강화하기
	private int age;  //person 클래스에서만 접근 가능한 age필터 선언
	
	void setAge(int num) {
		if(num <= 0) {
			System.out.println("잘못된 수를 입력하셨습니다. 1이상의 값으로 설정하세요.");
			return;
		}else {
			age = num;
		}
	}
	int getAge() {
		return age;
	}
	
	
	void introducs(String name, int age) {
		System.out.println("제 이름은 " + name + "이고, 나이는 " + age + "세 입니다.");
	}
	void hello() {
		System.out.println("안녕하세요.");
	}

}
