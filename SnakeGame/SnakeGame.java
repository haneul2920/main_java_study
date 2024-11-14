package SnakeGame;
/* Snake Game */
/*
* Snake Game 설명
* 이 게임은 클래스를 이용해 자바에서 간단한 스네이크 게임을 구현한 예제입니다. 
* 상속과 메서드 오버라이딩의 개념을 활용하여 기본적인 게임 구조를 설계하고, 
* final 키워드를 사용해 상속 불가 클래스와 오버라이딩 불가 메서드를 포함합니다.
*  Scanner를 이용해 사용자의 입력으로 뱀을 움직이게 하여 간단한 콘솔 기반의 게임을 제공합니다.
*  
*  게임 구조
*  Game 클래스: 게임의 기본적인 설정과 게임 루프를 관리하는 역할을 하며, play라는 메서드를 포함하여 게임을 시작합니다.
*             play 메서드에서 게임의 진행을 관리하며 final로 선언되어 있어 상속이 불가합니다. 
*             initializeBoard, updateBoard, printBoard는 보드를 초기화, 갱신, 출력하는 역할을 합니다.
    Snake 클래스: 스네이크의 위치와 방향을 관리하는 기본 클래스이며, 상속할 수 없도록 final로 선언됩니다.
                final 클래스이므로 상속할 수 없으며, move 메서드는 스네이크의 기본 이동 방식이며 PlayerSnake에서 오버라이딩 가능합니다.
    PlayerSnake 클래스: 스네이크의 움직임을 관리하는 클래스이며, 상속된 move 메서드를 오버라이딩하여 플레이어의 입력을 통해 움직임을 제어합니다.
                 Snake 클래스를 상속받고 move 메서드를 오버라이딩하여 사용자의 입력에 따라 스네이크의 방향을 설정합니다.
* */

// <문제> 게임 안에 먹이를 넣어 주고 뱀이 먹이를 먹으면 게임이 끝나도록 게임을 수정 하시오.
import java.util.Scanner;
import java.util.Random;

// 게임의 기본 클래스
class Game {
   protected final int WIDTH = 10;
   protected final int HEIGHT = 10;
   protected char[][] board = new char[WIDTH][HEIGHT];
   protected Snake snake;
   private int foodRow, foodCol;

   public Game() {
       this.snake = new PlayerSnake(5, 5); // 스네이크의 초기 위치
       initializeBoard();
       eat();
   }

   // 게임 시작 메서드
   public final void play() {
       Scanner scanner = new Scanner(System.in);
       
       while (true) {
           printBoard();
           System.out.print("움직일 방향을 입력하세요 (w: 위, a: 왼쪽, s: 아래, d: 오른쪽): ");
           char direction = scanner.nextLine().charAt(0);
           snake.move(direction, WIDTH, HEIGHT);
           if (isGameOver()) {
               System.out.println("게임 오버! 뱀이 벽에 부딪혔습니다.");
               break;
           }else if (snake.getX() == foodRow && snake.getY() == foodCol ) {
        	   System.out.println("게임 클리어! 뱀이 먹이를 찾았습니다.");
        	   break;
        	   
           }
           updateBoard();
       }
       scanner.close();
   }
  public void eat(){
	  Random rand = new Random();	  
	  foodRow = rand.nextInt(WIDTH);
	  foodCol = rand.nextInt(HEIGHT);
	  	  
	   
   }


   // 게임 보드 초기화
   private void initializeBoard() {
       for (int i = 0; i < WIDTH; i++) {
           for (int j = 0; j < HEIGHT; j++) {
               board[i][j] = '.';
               
           }
       }
   }

   // 게임 보드 업데이트
   protected void updateBoard() {
       initializeBoard();
       board[snake.getY()][snake.getX()] = 'S';
       board[foodRow][foodCol] = 'E';
   }

   // 게임 보드 출력
   protected void printBoard() {
       for (int i = 0; i < WIDTH; i++) {
           for (int j = 0; j < HEIGHT; j++) {
               System.out.print(board[i][j] + " ");
           }
           System.out.println();
       }
   }

   // 게임 오버 조건 체크
   protected boolean isGameOver() {	   
       return snake.getX() < 0 || snake.getX() >= WIDTH || snake.getY() < 0 || snake.getY() >= HEIGHT;
   }
}

// 스네이크의 기본 클래스 (상속 불가)
class Snake {
   protected int x, y;

   public Snake(int x, int y) {
       this.x = x;
       this.y = y;
   }
   
 
   // 스네이크의 위치 반환
   public int getX() {
	   
       return x;
   }

   public int getY() {
	   
       return y;
   }

   // 스네이크의 이동 메서드 (오버라이딩 가능)
   public void move(char direction, int width, int height) {
       switch (direction) {
           case 'w': y--;
           break;
           case 's': y++;
           break;
           case 'a': x--;
           break;
           case 'd': x++;
           break;
           default: System.out.println("잘못된 방향입니다! w, a, s, d 중 하나를 입력하세요.");
           break;
       }
   }
}

// 플레이어 스네이크 클래스 (메서드 오버라이딩)
class PlayerSnake extends Snake {

   public PlayerSnake(int x, int y) {
       super(x, y);
   }

   // 플레이어 입력을 통해 스네이크 이동
   @Override
   public void move(char direction, int width, int height) {
       super.move(direction, width, height);
   }
}

// 게임 실행 메인 클래스
public class SnakeGame {
   public static void main(String[] args) {
       Game game = new Game();
       game.play();
   }
}