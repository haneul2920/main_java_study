package section09;

public class Phone {
	//생성자 매개변수 부족
	String brand;
	int series;
	String color = "검정색" ;//필드 기본값 초기화
	
	
	Phone(String brand, int series){ //매개변수를 2개로 받는 생성자
		this.brand = brand;
		this.series = series;
	}

	Phone(String brand, int series, String color){ //매개변수를 3개로 받는 생성자
		this.brand = brand;
		this.series = series;
		this.color = color;
	}
	
	void PhoneInfo() {
		System.out.println(color + " " + brand + " " + series);
	}

}
