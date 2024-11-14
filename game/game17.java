package game;

import java.util.Scanner;

public class game17 {
   public static void main(String[] args) {
       int[][] board = {
           {1, 2, 3},
           {4, 0, 5},
           {6, 7, 8}
       };
       Scanner scanner = new Scanner(System.in);
       int emptyRow = 1, emptyCol = 1;
       boolean gameCompleted = false;

       while (!gameCompleted) {
           // 현재 보드 상태 출력
           for (int i = 0; i < 3; i++) {
               for (int j = 0; j < 3; j++) {
                   System.out.print(board[i][j] + " ");
               }
               System.out.println();
           }

           System.out.println("빈 칸을 이동할 방향을 선택하세요 (W=위, S=아래, A=왼쪽, D=오른쪽): ");
           char move = scanner.next().toUpperCase().charAt(0);

           int newRow = emptyRow, newCol = emptyCol;
           if (move == 'W' && emptyRow > 0) newRow--;
           if (move == 'S' && emptyRow < 2) newRow++;
           if (move == 'A' && emptyCol > 0) newCol--;
           if (move == 'D' && emptyCol < 2) newCol++;

           board[emptyRow][emptyCol] = board[newRow][newCol];
           board[newRow][newCol] = 0;
           emptyRow = newRow;
           emptyCol = newCol;

           // 퍼즐 완성 여부 검사
           if (board[0][0] == 1 && board[0][1] == 2 && board[0][2] == 3 &&
               board[1][0] == 4 && board[1][1] == 5 && board[1][2] == 6 &&
               board[2][0] == 7 && board[2][1] == 8 && board[2][2] == 0) {
               System.out.println("퍼즐을 완성했습니다!");
               gameCompleted = true;
           }
       }
   }
}