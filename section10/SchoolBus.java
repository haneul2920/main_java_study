package section10;

public class SchoolBus extends Bus{
	SchoolBus(int peopleNum){
		super(peopleNum);
	}
	
	@Override
	void takePerson() {
		super.takePerson();
		System.out.println("학생들이 자리에 모두 착석하고 출발합니다.");
	}
	
	@Override
	void ride() {
		System.out.println("시속 50km/h로 천천히 달립니다.");
	}

}
