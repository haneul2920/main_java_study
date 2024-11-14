package game;

import java.util.Scanner;

public class Game20 {
   public static void main(String[] args) {
       /* Battleship (배틀쉽) 
        * 명중 하면 X, 빗나가면 O
        * */
       
       char[][] board = new char[5][5];
       initializeBoard(board);  // 기본 배경
       placeShips(board);
       playGame(board);
   }
   private static void initializeBoard(char[][] board) {
	   for(int i=0; i< board.length; i++) {
		   for(int j = 0; j < board[i].length; j++) {
			   board[i][j] = '-';
		   }
	   }
   }
   //1. initializeBoard 매소드를 만드시오
   

   public static void placeShips(char[][] board) {
       int ships = 3;
       while (ships > 0) {
           int row = (int) (Math.random() * 5);
           int col = (int) (Math.random() * 5);
           if (board[row][col] == '-') {
               board[row][col] = 'S';
               ships--;
               //2. 여기에 들어갈 소스는 1) board++, 2) row++, 3) ships++ 4) ships-- 
           }
       }
   }

   public static void printBoard(char[][] board, boolean revealShips) {
       for (int i = 0; i < board.length; i++) {
           for (int j = 0; j < board[0].length; j++) {
               if (board[i][j] == 'S' && !revealShips) {
                   System.out.print("- ");
               } else {
                   System.out.print(board[i][j] + " ");
               }
           }
           System.out.println();
       }
   }

   public static void playGame(char[][] board) {
       Scanner scanner = new Scanner(System.in);
       int hits = 0, attempts = 0;
       while (hits < 3) {
           printBoard(board, false);
           System.out.println("공격할 위치를 선택하세요 (행과 열): ");
           int row = scanner.nextInt();
           int col = scanner.nextInt();
           if (board[row][col] == 'S') {
               System.out.println("명중!");
               board[row][col] = 'X';
               hits++;
           } else if (board[row][col] == '-') {
               System.out.println("빗나감!");
               board[row][col] = 'O';
           } else {
               System.out.println("이미 공격한 위치입니다.");
           }
           attempts++;
       }
       System.out.println("모든 배를 격침시켰습니다! 총 " + attempts + "번의 시도로 승리했습니다.");
       printBoard(board, true);
       scanner.close();
   }
}