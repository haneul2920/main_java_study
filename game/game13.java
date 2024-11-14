package game;

import java.util.Scanner;

public class game13 {

	public static void main(String[] args) {
		// 행맨(Hangman)게임
		// 설명 : 
		//단어의 글자를 맞추는 게임, 사용자가 틀린 횟수에 따라 기회가 제한 되며
		//단어를 맞추기 전까지 반복하는 게임
		String[] words = {"JAVA", "PROGRAMMING", "HANGMAN"};
		String word = words[(int)(Math.random() * words.length)];
		
		//System.out.print(word);
		char[] guessed = new char[word.length()];
		for(int i = 0; i < guessed.length; i++) {
			guessed[i] = '_';
		}
		
//		for(int i = 0; i < guessed.length; i++) {
//			System.out.print(guessed[i] + " ");
//		}
		int tries = 6;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("기회는 총 6번 입니다.");
		
		while(tries > 0) {
			//char 형을 보고싶을때 String 변경하여 valueOf 메소드 사용
			System.out.println("현재 단어 : " + String.valueOf(guessed));			
			System.out.print("글자를 추측하세요 : ");
			//toUpperCase()는 대문자로 변경, toLowerCase()는 소문자로 변경
			char guess = scan.next().toUpperCase().charAt(0);
			
			boolean correctGuess = false;
			// correctGuess = true; tries--; 아래 소스에서 적절하게 넣어 완성하세요.
			for(int i = 0; i < word.length(); i++) {
				if(word.charAt(i) == guess) {
					guessed[i] = guess;
					correctGuess = true;
				}
			}
			if(!correctGuess) {
				tries--;
				System.out.println("틀렸습니다! 남은 기회 : " + tries);				
			}
			if(String.valueOf(guessed).equals(word)) {
				System.out.println("축하합니다! 단어를 맞췃습니다 : " + word);
				}
				break;
			}
			if(tries == 0) {
				System.out.println("기회를 모두 소진 했습니다. 단어는 '" + word + "'였습니다. ");
			}
		}
	}

