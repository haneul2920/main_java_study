package game;

public class Player {
	int Experience = 450;
	int levelUpExperience = 500;
	
	//다음 레벨까지 남은 경험치를 반환하는 메소드
	public int getRemainingExperience() {
		int i = levelUpExperience-Experience;		
		
		return i;
		
	}

}
