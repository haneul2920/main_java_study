package game;

import game.Player;

public class Game22 {

	public static void main(String[] args) {
		//레벨 업 경험치 계산
		Player ply = new Player();
		
		int remainingExp = ply.getRemainingExperience();
		System.out.println("레벨업까지 남은 경험치 : " + remainingExp);

	}

}