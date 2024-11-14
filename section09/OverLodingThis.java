package section09;

class GameCharacter{
	String name;
	int level;
	int health;
	
	//기본 생성자
	GameCharacter(){
		this("Umknown" , 1, 100); //기본값을 설정한 다른 생성자 호출
		
	}
	
	GameCharacter(String name){
		this(name, 1, 100); // 레벨과 체력을 기본 값으로 설정
	}
	//모든 매개변수를 받는 생성자
	GameCharacter(String name, int level, int health){
		this.level = level;
		this.health = health;
		this.name = name;
		
	}
	void display() {
		System.out.println("Character : "+ this.name + ", level : " + this.level+", health : " + this.health);
	}
}

public class OverLodingThis {

	public static void main(String[] args) {
		GameCharacter character1 = new GameCharacter();
		GameCharacter character2 = new GameCharacter("knight");
		GameCharacter character3 = new GameCharacter("Archer",5 , 150);
		
		character1.display();
		character2.display();
		character3.display();
		

	}

}
