package MiroGame;

import java.util.Scanner;

class GameObject {
   protected int x, y;

   public GameObject(int x, int y) {
       this.x = x;
       this.y = y;
   }

   public int getX() { return x; }
   public int getY() { return y; }

   public void move(int dx, int dy) {
       x += dx;
       y += dy;
   }
}

class Player extends GameObject {
   public Player(int x, int y) {
       super(x, y);
   }
}

class Maze {
   private final char[][] map = {
       {'S', ' ', ' ', '#', ' ', ' ', '#', ' ', ' ', 'E'},
       {'#', '#', ' ', '#', ' ', '#', '#', '#', ' ', '#'},
       {' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' '},
       {' ', '#', '#', '#', '#', ' ', '#', '#', ' ', '#'},
       {' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' '},
       {'#', '#', '#', ' ', '#', '#', '#', '#', '#', ' '},
       {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' '},
       {' ', '#', '#', '#', '#', '#', '#', ' ', '#', ' '},
       {' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' '},
       {'#', '#', '#', '#', '#', '#', '#', '#', '#', 'E'}
   };

   public char[][] getMap() {
       return map;
   }

   public boolean isExit(int x, int y) {
       return map[y][x] == 'E';
   }

   public boolean isWall(int x, int y) {
       return map[y][x] == '#';
   }
}

public class Miro {
   private final Maze maze;
   private final Player player;

   public Miro() {
       this.maze = new Maze();
       this.player = new Player(0, 0); // 시작 지점
   }

   public void play() {
       Scanner scanner = new Scanner(System.in);
       while (true) {
           printMaze();
           System.out.println("이동할 방향을 입력하세요 (WASD): ");
           char direction = scanner.next().toUpperCase().charAt(0);
           int dx = 0, dy = 0;

           switch (direction) {
               case 'W': dy = -1; break;
               case 'S': dy = 1; break;
               case 'A': dx = -1; break;
               case 'D': dx = 1; break;
               default: System.out.println("잘못된 입력입니다."); continue;
           }

           int newX = player.getX() + dx;
           int newY = player.getY() + dy;

           if (newX >= 0 && newY >= 0 && newY < maze.getMap().length && newX < maze.getMap()[0].length 
               && !maze.isWall(newX, newY)) {
               player.move(dx, dy);
           } else {
               System.out.println("벽에 막혔습니다!");
           }

           if (maze.isExit(player.getX(), player.getY())) {
               System.out.println("축하합니다! 미로를 탈출했습니다!");
               break;
           }
       }
       scanner.close();
   }

   private void printMaze() {
       char[][] map = maze.getMap();
       for (int y = 0; y < map.length; y++) {
           for (int x = 0; x < map[y].length; x++) {
               if (player.getX() == x && player.getY() == y) {
                   System.out.print("P ");
               } else {
                   System.out.print(map[y][x] + " ");
               }
           }
           System.out.println();
       }
   }

   public static void main(String[] args) {
       Miro game = new Miro();
       game.play();
   }
}