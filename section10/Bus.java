package section10;

public class Bus extends Car2 {
	int peopleNum;
	
	Bus(int peopeleNum){
		this.peopleNum = peopeleNum;
	}
	
	void takePerson() {
		System.out.println("승객이 버스에 탔습니다.");
		
		System.out.println("지금까지 탑승한 승객은 "+peopleNum+"명 입니다.");
		peopleNum++;
	}
	

}
