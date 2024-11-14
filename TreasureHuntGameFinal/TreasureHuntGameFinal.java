package TreasureHuntGameFinal;
/* <게임설명>
* 목적: 플레이어는 보물이 숨겨진 위치를 찾아야 합니다.
* 게임 흐름:
    플레이어는 시작할 때 이름을 입력합니다.
    보물은 무작위로 숨겨진 좌표에 배치됩니다.
    플레이어는 위치를 입력하여 보물을 찾아야 합니다.
    각 탐색 시도 후 체력이 줄어들고, 체력이 0이 되면 게임이 종료됩니다.
    플레이어가 보물 근처에 도착하면 축하 메시지가 출력됩니다.
* <코드설명>
*  플레이어 이름 입력: Scanner 클래스를 사용하여 main 메서드에서 플레이어의 이름을 입력받아 생성합니다.
    보물의 위치: 보물 위치는 0부터 9 사이의 무작위 좌표로 설정됩니다.
    사용자 입력 탐색: 사용자가 X, Y 좌표를 입력하면 해당 위치를 탐색합니다. 보물에 가까운 위치로 가면 축하 메시지가 출력됩니다.
    체력 감소: 보물을 찾지 못할 경우 체력이 10씩 줄어들고, 체력이 0이 되면 게임이 자동으로 종료됩니다.
    게임 종료: 사용자가 보물을 찾거나 체력이 0이 되면 게임이 종료됩니다.
* 
* */

import java.util.Scanner;

class Player {
   private String name;
   protected int health;

   public Player(String name) {
       this.name = name;
       this.health = 100; // 기본 체력
   }

   public String getName() {
       return name;
   }

   public int getHealth() {
       return health;
   }

   // <문제1> final 을 활용하여 소스를 구성하시오
   // 접근제한자 public, return 없음, 메소드명은 decreaseHealth 
   final void decreaseHealth(int amount) {
   		if (health - amount >= 0) {
           health -= amount;
           System.out.println(name + "님의 체력이 " + amount + "만큼 감소했습니다. 현재 체력: " + health);
       } else {
           System.out.println(name + "님은 더 이상 체력이 남아 있지 않습니다.");
       }
   }
}

class Location {
   protected int x, y;

   public Location(int x, int y) {
       this.x = x;
       this.y = y;
   }

   public void showLocation() {
       System.out.println("플레이어가 현재 위치 (" + x + ", " + y + ")에 있습니다.");
   }

   protected double distanceTo(int targetX, int targetY) {
       return Math.sqrt(Math.pow(this.x - targetX, 2) + Math.pow(this.y - targetY, 2));
   }
}

class TreasureLocation extends Location {
   private boolean hasTreasure;

   public TreasureLocation(int x, int y, boolean hasTreasure) {
       // <문제 2> 아래에 들어갈 소스는?
       super(x,y);
       this.hasTreasure = hasTreasure;
   }

   public boolean checkTreasure(int x, int y) {
       return this.x == x && this.y == y && hasTreasure;
   }
}

public class TreasureHuntGameFinal extends Player {
    
    private TreasureLocation treasureLocation;
   private Location playerLocation;
   private int gridSize;

   public TreasureHuntGameFinal(String playerName, int gridSize, int treasureX, int treasureY) {
       // <문제 3> 아래에 들어갈 소스를 작성하시오
       super(playerName);
       // <문제 4> 아래에 들어갈 소스를 작성하시오
       this.gridSize = gridSize;
       this.treasureLocation = new TreasureLocation(treasureX, treasureY, true);
       this.playerLocation = new Location(0, 0); // 시작 위치를 (0, 0)으로 설정
   }

   public void displayGrid() {
       for (int i = 0; i < gridSize; i++) {
           for (int j = 0; j < gridSize; j++) {
               if (i == playerLocation.y && j == playerLocation.x) {
                   System.out.print("P "); // 플레이어 위치
               } else if (i == treasureLocation.y && j == treasureLocation.x) {
                   System.out.print("T "); // 보물 위치 (플레이어가 발견하면 표시)
               } else {
                   System.out.print(". "); // 빈 공간
               }
           }
           System.out.println();
       }
   }

   public void findTreasure(int x, int y) {
       if (this.getHealth() <= 0) {
           System.out.println(this.getName() + "님은 체력이 없어 더 이상 탐험할 수 없습니다.");
           return;
       }

       // 현재 위치 갱신
       playerLocation.x = x;
       playerLocation.y = y;
       // <문제 5> 현재 위치를 보여주는 메소드를 호출하시오
       playerLocation.showLocation();
       // 보물 근처에 있는지 확인
       if (treasureLocation.checkTreasure(x, y)) {
           System.out.println("축하합니다, " + getName() + "님! 보물을 찾았습니다!");
       } else {
           // <문제 6> 아래에 보물과의 거리를 찾는 소스를 작성하시오.
    	   double distance = playerLocation.distanceTo(treasureLocation.x,treasureLocation.y);
           System.out.println("보물이 여기에 없습니다. 현재 보물과의 거리: " + String.format("%.2f", distance));
           this.decreaseHealth(10); // 탐색 실패 시 체력 감소
           displayGrid(); // 2차원 평면을 출력하여 플레이어 위치 시각화
       }
   }
    
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

       // 플레이어 이름 입력 받기
       System.out.print("플레이어 이름을 입력하세요: ");
       String playerName = scanner.nextLine();

       int gridSize = 10; // 10x10 2차원 평면
       int treasureX = (int)(Math.random() * gridSize);
       int treasureY = (int)(Math.random() * gridSize);
       // <문제 7> 아래에 인스턴스 명을 game으로 하여 TreasureHuntGameFinal 클래스를 호출하는 소스를 넣어 게임 동작되도록 하시오.
       TreasureHuntGameFinal game = new TreasureHuntGameFinal(playerName, gridSize, treasureX, treasureY);
       // 보물을 찾을 때까지 반복
       while (game.getHealth() > 0) {
           game.displayGrid(); // 현재 평면 상태를 먼저 출력

           System.out.print("탐색할 X 좌표를 입력하세요 (0-" + (gridSize - 1) + "): ");
           int x = scanner.nextInt();
           System.out.print("탐색할 Y 좌표를 입력하세요 (0-" + (gridSize - 1) + "): ");
           int y = scanner.nextInt();

           // 입력 좌표로 탐색 시도
           game.findTreasure(x, y);

           // 보물을 찾은 경우 게임 종료
           if (game.treasureLocation.checkTreasure(x, y)) {
               game.displayGrid();
               continue;
           }
       }

       System.out.println("게임이 종료되었습니다. 감사합니다!");
       scanner.close();
   }

}