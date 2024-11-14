package game;

import java.util.Scanner;

/* Dungeon Adventure 게임 */
/* 
* <주요 기능>
* 플레이어는 주사위를 굴려 공격하며 적과 싸웁니다.
* 체력이 0 이하가 되면 게임 오버가 됩니다.
* 적을 처치하면 경험치를 획득하고, 경험치가 충분하면 레벨업을 합니다.
* 아이템을 랜덤으로 획득할 수 있습니다.
* 
* <게임 흐름>
* 공격하기: 플레이어가 주사위를 굴려 적을 공격하고, 적이 반격합니다. 
*            적이 죽으면 플레이어는 경험치와 점수를 획득합니다.
* 아이템 획득: 랜덤으로 아이템을 획득하며, 포션을 획득하면 체력을 회복할 수 있습니다.
* 상태 확인: 현재 체력, 레벨, 경험치, 점수를 확인할 수 있습니다.
* 게임 종료: 플레이어가 원하는 시점에 게임을 종료할 수 있습니다.
* 
* <설명>
* 플레이어는 매턴마다 선택을 하고, 적과의 전투 또는 아이템 획득 등을 통해 성장을 경험하게 됩니다.
* 적을 처치하면 점수가 올라가고, 경험치가 쌓이면 레벨업하여 더 강해집니다.
* 적과의 전투는 주사위 기반으로 무작위성이 가미되어 예측할 수 없는 결과가 나옵니다.
* 이 게임은 여러 메소드를 활용하여 플레이어와 적의 상태를 관리하고, 
* 전투 및 성장 시스템을 구현한 기본적인 게임입니다.
* */

class Player1 {
   int health = 100;
   int experience = 0;
   int level = 1;
   String[] items = {"갑옷", "검", "방패", "포션"};
   int score = 0;

   // 체력 감소
   public int takeDamage(int damage) {
       // 수업시간에 했던 메소드를 참고하여 메소드를 완성하세요.
	   health -= damage;
	   if(health <= 0) {
		   health =0;
	   }
	   return health;
   }

   // 경험치 증가
   public void gainExperience(int exp) {
       experience += exp;
       if (experience >= level * 100) {
           experience = 0;
           levelUp();
       }
   }

   // 레벨업
   public void levelUp() {
       level++;
       health = 100;
       System.out.println("레벨업! 현재 레벨: " + level);
   }

   // 랜덤 아이템 획득
   public String getRandomItem() {
       int index = (int) (Math.random() * items.length);
       // 수업시간에 했던 메소드를 참고하여 메소드를 완성하세요.
       return items[index];
   }

   // 점수 증가
   public int addScore(int points) {
       // 수업시간에 했던 메소드를 참고하여 메소드를 완성하세요.
	   score += points;
	   return points;
	   
   }
}

class Enemy {
   int health = 50;

   // 적 체력 감소
   public int takeDamage(int damage) {
       if (health < 0) health = 0;
       // 수업시간에 했던 메소드를 참고하여 메소드를 완성하세요.
       health -= damage;
       return health;
       
   }

   // 주사위 굴려서 공격
   public int attack() {
       return (int)(Math.random() * 20) + 1;
   }
}


public class Game25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       Player1 player = new Player1();
       Enemy enemy = new Enemy();

       System.out.println("=== 던전 탐험을 시작합니다! ===");

       while (player.health > 0) {
           System.out.println("\n1. 공격하기\n2. 아이템 획득\n3. 상태 확인\n4. 게임 종료");
           System.out.print("행동을 선택하세요: ");
           int choice = scanner.nextInt();

           switch (choice) {
               case 1:
                   // 공격하기
                   int playerAttack = (int) (Math.random() * 20) + 100;
                   enemy.takeDamage(playerAttack);
                   System.out.println("적에게 " + playerAttack + "의 데미지를 입혔습니다!");

                   if (enemy.health > 0) {
                       int enemyAttack = enemy.attack();
                       player.takeDamage(enemyAttack);
                       System.out.println("적의 공격! " + enemyAttack + "의 데미지를 받았습니다.");
                       System.out.println("남은 체력: " + player.health);

                       if (player.health <= 0) {
                           System.out.println("게임 오버! 당신은 사망했습니다.");
                           return;
                       }
                   } else {
                       System.out.println("적을 처치했습니다!");
                       player.gainExperience(100);
                       player.addScore(100);
                       enemy = new Enemy(); // 새로운 적 생성
                   }
                   break;

               case 2:
                   // 아이템 획득
                   String item = player.getRandomItem();
                   System.out.println("아이템을 획득했습니다: " + item);
                   if (item.equals("포션")) {
                       player.health = 100;
                       System.out.println("체력이 회복되었습니다.");
                   }
                   break;

               case 3:
                   // 상태 확인
                   System.out.println("플레이어 상태");
                   System.out.println("체력: " + player.health);
                   System.out.println("레벨: " + player.level);
                   System.out.println("경험치: " + player.experience);
                   System.out.println("점수: " + player.score);
                   break;

               case 4:
                   // 게임 종료
                   System.out.println("게임을 종료합니다.");
                   return;

               default:
                   System.out.println("잘못된 선택입니다. 다시 선택하세요.");
                   break;
           }
       }

       scanner.close();

    }

}