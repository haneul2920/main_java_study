package game;

import java.util.Scanner;

public class game11 {

	public static void main(String[] args) {
		// 두 문자 배열의 위치를 문자 비교 게임
		// 설명 : 두 배열의 각 위치에 있는 문자가 동일한지 비교하는 게임
		Scanner scan = new Scanner(System.in);
		
		String[] array1 = new String[5];
		String[] array2 = new String[5];
		
		System.out.println("첫 번째 배열에 중복되지 않는 5개의 문자를 입력하세요.");
		for(int i = 0; i < array1.length; i++) {
			array1[i] = scan.next();
		}
		
		System.out.println("두 번째 배열에 중복되지 않는 5개의 문자를 입력하세요.");
		for(int i = 0; i < array2.length; i++) {
			array2[i] = scan.next();
		}
		
		//for 문에서 배열을 비교 하세요
		
		for(int i = 0; i < array1.length; i++) {
			if(array1[i].equals(array2[i])) {
				//비교해서 같을 때 :
				System.out.printf("위치 %d에서 동일한 문자 : %s \n" , i, array1[i]);
			}else {
				//비교해서 다를 때 : 
				System.out.println("위치 " + i + "에서 다른 문자 : " + array1[i] + " vs " + array2[i] );
			}
		}

	}

}
