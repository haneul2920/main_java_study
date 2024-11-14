package section07;

public class EX07_06 {

	public static void main(String[] args) {
		// 필드(field) 를 사용해보자
		Car c = new Car(); //클래스를 이용해 객체 생성
		System.out.println("wheel의 개수는 " + c.wheel + "개입니다."); //필드 값 출력
		
		c.wheel = 5; // c 객체의 데이터인 wheel의 값을 5로 변경
		System.out.println("wheel의 개수는 " + c.wheel + "개입니다.");

	}

}
