package game;

public class Game21 {

	public static void main(String[] args) {
		//게임 캐릭터 체력 계산
		Character player = new Character();	
		
		int remainingHealth = player.takeDamage(50);
		System.out.println("남은 체력 : " + remainingHealth);
		
	}

}
