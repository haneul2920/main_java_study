package section07;

public class Student {
	
	static String schoolName = "코리아 고등학교";//정적 맴버 선언
	//필드
	String studentName;
	String name;
	int age;
	
	//생성자(클래스가 호출될 때 자동으로 실행되는 메서드)
	Student(){
		
	}
	
	Student(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	//메서드
	void study() {
		System.out.println("학생 "+name + "는 나이가 "+ age + " 입니다.");
	}
	
	//접근 제한자 private
	static void goToSchool() {
		System.out.println("학교에 갑니다.");
	}
	
	void hello() {
		System.out.println("안녕하세요.\n제 이름은 " + studentName + " 입니다");
	}

}
