package game;

import java.util.Scanner;

public class game4 {

	public static void main(String[] args) {
		//단어 맞추기 게임
		String word = "JAVA";
		char[] guessedword = new char[word.length()];
		int attempts = 6;
		boolean guessed = false;
		Scanner scanner = new Scanner(System.in);
		
		for(int i = 0; i < word.length(); i++) {
			guessedword[i] = '_';
		}
		while (attempts > 0 & !guessed) {
			System.out.print("현재 단어 : ");
			System.out.println(guessedword);
			System.out.println("남은 시도 횟수 : " + attempts);
			System.out.print("글자를 입력하세요 : ");
			char guess = scanner.next().charAt(0);
			boolean correct = false;
			for(int i = 0; i < word.length(); i++) {
				if (word.charAt(i) == guess) {
					guessedword[i] = guess;
					correct = true;
				}
			}
			if(!correct) {
				attempts--;
			}
			guessed = true;
			for (char c : guessedword) {
				if(c == '_') {
					guessed = false;
					break;
				}
				
			}

		}
		if (guessed) {
			System.out.println("승리! 단어는 " + word + "입니다.");
		}else {
			System.out.println("패배! 단어는 " + word + "엿습니다.");
		}
				

	}

}
