package game;

import java.util.Scanner;

public class game9 {

	public static void main(String[] args) {
		// 배열 중복 요소 찾기 게임 : 두 배열에서 중복된 요소를 찾아내는 게임
		Scanner scan = new Scanner(System.in);
		System.out.println("배열에 입력할 숫자 갯수를 입력하세요");

		int count = scan.nextInt();
		int[] array1 = new int[count];
		int[] array2 = new int[count];

		System.out.println("첫 번째 배열의 " + count + "개의 숫자를 입력하세요.");
		for (int i = 0; i < count; i++) {
			array1[i] = scan.nextInt();
		}

		System.out.println("두 번째 배열의 " + count + "개의 숫자를 입력하세요.");
		for (int i = 0; i < array1.length; i++) {
			array2[i] = scan.nextInt();
		}
		// 이중 for 문을 사용하여 완성하세요.
		System.out.println("두 배열의 중복된 숫자");
		for (int i = 0; i < array1.length; i++) {
			for (int j = 0; j < array1.length; j++) {
				if (array1[i] == array2[j]) {
					System.out.print(array1[i] + " ");
				}
			}
		}

	}

}
