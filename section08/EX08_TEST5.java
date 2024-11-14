package section08;

class Person2{
	private int age;
	
	void setAge2(int num) {
		age = num;
		if(age < 0) {
			System.out.println("잘못된 수를 입력하셧습니다. 1이상의 값으로 설정하세요.");
		}
	}
	int getAge2() {
		return age;
	}
}

public class EX08_TEST5 {

	public static void main(String[] args) {
		Person2 lee = new Person2();
		lee.setAge2(-10);
		lee.setAge2(30);
		System.out.println("lee의 나이는 " + lee.getAge2() + "세 입니다.");

	}

}
