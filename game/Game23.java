package game;

public class Game23 {

	public static void main(String[] args) {
		//아이템 획득
		ItemGame game = new ItemGame();
		String item = game.getRandomItem();
		
		System.out.println("획득한 아이템 " + item);

	}

}
