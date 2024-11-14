package game;

import java.util.Scanner;

class Dungeon {
   int treasureCount = 4;
   
   // 던전에서 랜덤으로 이벤트 발생 (보물, 적 또는 아무것도 없음)
   public String explore() {
       int event = (int)(Math.random() * 3);
       switch (event) {
           case 0: return "보물 발견";
           case 1: return "적과 마주침";
           default: return "아무 일도 일어나지 않음";
       }
   }
}

class DungeonPlayer {
   int health = 100;
   int treasures = 0;

   // 적과 싸움
   public int fight() {
       return (int)(Math.random() * 20) + 10;
   }

   // 도망치기
   public boolean escape() {
       return Math.random() > 1; // 70% 확률로 도망 성공
   }

   // 보물 획득
   // 아래 소스를 활용하여 메서드를 완성하세요.
   public void findTreasure() {
	   treasures++;
       System.out.println("보물을 발견했습니다! 현재 보물 개수: " + treasures);
   }
   public int takeDamage(int damage) {
	   
      // 데미지 받기
    // 아래 소스를 활용하여 메서드를 완성하세요.
	   health -= damage;
       if (health < 0) 
    	   health = 0;
       return health;
   }
   
}

public class Game27 {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       DungeonPlayer player = new DungeonPlayer();
       Dungeon dungeon = new Dungeon();

       System.out.println("=== 보물 찾기 게임 ===");

       while (player.health > 0 && player.treasures < dungeon.treasureCount) {
           System.out.println("\n던전을 탐험합니다...");
           String event = dungeon.explore();

           switch (event) {
               case "보물 발견":
                   player.findTreasure();
                   break;

               case "적과 마주침":
                   System.out.println("적과 마주쳤습니다! 1. 싸우기 2. 도망가기");
                   int choice = scanner.nextInt();

                   if (choice == 1) {
                       // 여기에 들어갈 소스를 넣으시오.
                	   int damage = player.fight();
                       System.out.println("적을 공격하여 " + damage + "의 데미지를 입혔습니다.");
                       player.takeDamage((int) (Math.random() * 15) + 5);
                       System.out.println("적의 반격을 받았습니다. 현재 체력: " + player.health);
                   } else {
                       if (player.escape()) {
                           System.out.println("도망쳤습니다!");
                       } else {
                           System.out.println("도망에 실패했습니다! 적의 공격을 받습니다.");
                           player.takeDamage((int) (Math.random() * 15) + 5);
                           System.out.println("현재 체력: " + player.health);
                       }
                   }
                   break;

               default:
                   System.out.println("아무 일도 일어나지 않았습니다.");
                   break;
           }
       }

       // 아래 소스를 활용하여 게임을 완성하세요.    
       if(player.health <= 0) {
    	   System.out.println("플레이어가 사망했습니다. 게임 오버.");    	   
       }
       if(dungeon.treasureCount == player.treasures) {
    	   System.out.println("모든 보물을 찾았습니다! 게임 승리!");
       }
           
       

       scanner.close();
   }
}