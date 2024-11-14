package section07;

public class Car { // 클래스 선언
	//필드 선언
	int wheel = 4; //기본 초기화 값 int : 0, double : 0.0, boolean : false
	String model;
	int year;
	
	Car(){
		
	}
	//매개 변수 2개
	Car(String model, int year){
		this.model = model;
		this.year = year;
	}
	//매개 변수 1개
	Car(String model){
		this.model = model;
		this.year = 2024;
	}
	
	void ride() { //메서드 선언		
		System.out.println("달립니다");
		System.out.println("씽씽씽");
	}
	void displayCarInfo() {
		System.out.println("Model : "+ model + "\tyear : " + year);
	}
	
}
