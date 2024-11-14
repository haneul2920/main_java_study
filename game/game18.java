package game;

import java.util.Scanner;
import java.util.Random;

public class game18 {
   public static void main(String[] args) {
	   // 뱀게임
	   //1. 먹이를 랜덤으로 나타내 준다
	   //2. 뱀이 먹이를 먹으면 게임 종료
       Scanner scanner = new Scanner(System.in);
       Random rand = new Random();
       
       int n = 10;
       char[][] board = new char[n][n];
       int snakeRow = n / 2, snakeCol = n / 2;
       char direction = 'R'; // 기본 이동 방향 (R: 오른쪽)
      

       // 게임 보드 초기화
       for (int i = 0; i < n; i++) {
           for (int j = 0; j < n; j++) {
               board[i][j] = '.';
           }
       }
       board[snakeRow][snakeCol] = 'S';
       
       //먹이 위치
       int randRow = rand.nextInt(n);
       int randcol = rand.nextInt(n);
       
       board[randRow][randcol] = 'ㅣ';
       boolean gamefinished = false;

       while (!gamefinished) {
           // 게임 보드 출력
//           for (int i = 0; i < n; i++) {
//               for (int j = 0; j < n; j++) {
//                   System.out.print(board[i][j] + " ");
//               }
//               System.out.println();
//           }
//           System.out.println();
    	   printBoard(board);

           System.out.print("방향 입력 (W: 위, A: 왼쪽, S: 아래, D: 오른쪽): ");
           direction = scanner.next().toUpperCase().charAt(0);

           // 뱀의 현재 위치를 초기화
           board[snakeRow][snakeCol] = '.';

           // 방향에 따라 뱀의 위치 업데이트
           switch (direction) {
               case 'W':
                   snakeRow = (snakeRow - 1 + n) % n; // 위로 이동
                   break;
               case 'S':
                   snakeRow = (snakeRow + 1) % n;     // 아래로 이동
                   break;
               case 'A':
                   snakeCol = (snakeCol - 1 + n) % n; // 왼쪽으로 이동
                   break;
               case 'D':
                   snakeCol = (snakeCol + 1) % n;     // 오른쪽으로 이동
                   break;
           }
           if(snakeRow == randRow && snakeCol == randcol) {        	   
        	   board[randRow][randcol] = '$';
        	   for (int i = 0; i < n; i++) {
                   for (int j = 0; j < n; j++) {
                       System.out.print(board[i][j] + " ");
                   }
                   System.out.println();
        	   }
        	   System.out.println("먹이를 찾았습니다!\n게임 종료");
        	   gamefinished = true;
           }

           board[snakeRow][snakeCol] = 'S'; // 새로운 위치에 뱀 위치 표시
       }
   }
   private static void printBoard(char[][] board) {
	   for (int i = 0; i < board.length; i++) {
           for (int j = 0; j < board[i].length; j++) {
               System.out.print(board[i][j] + " ");
           }
           System.out.println();
	   }
	   System.out.println();
   
   }
}