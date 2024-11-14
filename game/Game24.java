package game;

public class Game24 {

	public static void main(String[] args) {
		// 점수 계산
		// 게임에서 적을 처치할 때마다 점수를 누적해 반환하는 메소드 활용
		ScoreGame game = new ScoreGame();
		int currentScore = game.addSocre(30);
		
		System.out.println("현재 점수 : " + currentScore);
		
		// 문제 : 위의 결과가 나오도록 클래스를 만드세요.
		// int score = 0; 클래스에 이 소스를 포함 하세요.		
		 
	}

}
