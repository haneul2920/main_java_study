package game;

public class ItemGame {
	//아이템 배열
	String[] items = {"검","방패","물약","갑옷"};
	
	//랜덤으로 아이템을 반환하는 메소드
	public String getRandomItem() {
		
		int index =(int)(Math.random()*items.length);
		
		return items[index];
		
	}

}
