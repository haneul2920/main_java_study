package section08;

public class DiceGameExe {

	public static void main(String[] args) {
		DiceGame dicegame = new DiceGame();
		int result = dicegame.rollDice();
		
		System.out.println("주사위 숫자는 : " + result);

	}

}
