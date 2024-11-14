package game;

public class Character {
	int health = 100;
	
		
	public int takeDamage(int d) {
		
		
		health -= d;
		
		return health;
		
	}
	
	//데미지를 받아 체력을 계산하고 변환 하는 메소드(매게 변수명 : damage)
	//health -= damage;

}
