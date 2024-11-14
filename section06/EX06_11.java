package section06;

import java.util.Arrays;

public class EX06_11 {

	public static void main(String[] args) {
		int[] card = {1,6,4,5,3,2};
		int[] newCard = new int[card.length];
		
		System.out.println("변경 전 : ");
		System.out.println("card 배욜 : " + Arrays.toString(card));
		System.out.println("newCard 배욜 : " + Arrays.toString(newCard));
		
		//새로운 배열에 기존 내용 삽입
		for(int i = 0; i < card.length; i++) {
			newCard[i] = card[i];
		}
		
		newCard[1] = 10; 
		
		System.out.println("변경 후 : ");
		System.out.println("card 배욜 : " + Arrays.toString(card));
		System.out.println("newCard 배욜 : " + Arrays.toString(newCard));
	}

}
