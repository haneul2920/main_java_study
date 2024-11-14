package section06;

import java.util.Arrays;

public class EX06_12_13 {

	public static void main(String[] args) {
		
		
		int [] card = {1,6,4,5,3,2};
		int [] newCard = new int[card.length];
		
		
		Arrays.sort(card);
		//System.arraycopy(복사 대상 배열, 복사 시작 위치, 카피할 배열, 시작위치, 복사할 길이):
		System.arraycopy(card, 0, newCard, 0, card.length);
		//int[] newCard = Arrays.copyOf(card, card.length);
		
		System.out.println("card 배열 : " + Arrays.toString(card));
		System.out.println("newCard 배열 : " + Arrays.toString(newCard));

	}

}
