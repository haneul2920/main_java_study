package section07;

public class EX07_09 {

	public static void main(String[] args) {
//		Car c = new Car(); //클래스를 이용해서 객체 생성
		
//		c.ride(); //메서드 사용
//		c.ride(); //메서드 사용
//		c.ride(); //메서드 사용
//		
		Student student = new Student("Jone" , 20);
		
		student.study();
		
		Car c1 = new Car("아반떼",2017);
		c1.displayCarInfo();
		
		Car c2 = new Car("BMW",2022);
		c2.displayCarInfo();
		

	}

}
