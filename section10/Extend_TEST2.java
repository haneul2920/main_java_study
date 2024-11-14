package section10;

class Vehicle{
	int speed;
	
	Vehicle(int speed){
		this.speed = speed;
		System.out.println("이 탈것의 속도는 : " + speed);
		
	}
}

class Car extends Vehicle{
	String model;
	Car(int speed, String model){
		super(speed);
		this.model = model;
		System.out.println("이 차의 모델은? "+ model);
	}
}

public class Extend_TEST2 {

	public static void main(String[] args) {
		Car2 car = new Car2(120, "tesla Model Y");
		

	}

}
