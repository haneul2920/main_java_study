package game;

import java.util.Scanner;

public class game10 {

	public static void main(String[] args) {
		// 두 문자 배열에서 공통 문자 찾기 게임
		// 두 문자 배열에서 공통으로 존재하는 문자를 찾는 게임
		Scanner scan = new Scanner(System.in);

		//char[] array1 = new char[5];
		//char[] array2 = new char[5];
		String[] array1 = new String[5];
		String[] array2 = new String[5];
		
		
		System.out.println("첫 번째 배열의 중복되지 않는 5개의 문자를 입력하세요.");

		for (int i = 0; i < array1.length; i++) {
			//array1[i] = scan.next().charAt(0);
			array1[i] = scan.nextLine();
		}

		System.out.println("두 번째 배열의 중복되지 않는 5개의 문자를 입력하세요.");

		for (int i = 0; i < array2.length; i++) {
			//array2[i] = scan.next().charAt(0);
			array2[i] = scan.nextLine();

		}

		System.out.println("공통문자는 : ");
		for (int i = 0; i < array1.length; i++) {
			for (int j = 0; j < array2.length; j++) {
				//if (array1[i] == array2[j]) 
				if (array1[i].equals(array2[j])){
					System.out.print(array1[i] + "");
				}
			}
		}
	}

}
