package game;

import java.util.Scanner;

/* Strategic Dungeon Adventure */
/*<주요 기능>
* 전투 시스템: 주사위 기반의 전투로 적을 상대하며, 적의 난이도가 레벨에 따라 변화합니다.
* 아이템 관리: 아이템을 사용하여 전투에서 이득을 볼 수 있습니다.
* 상점 시스템: 상점에서 포션이나 무기를 구매하여 플레이어의 능력을 강화할 수 있습니다.
* 레벨 업: 플레이어는 적을 처치할 때마다 경험치를 얻고, 레벨업을 통해 더 강력해집니다.
* 
* <게임설명>
* 전투: 플레이어는 적과 전투를 벌이면서 적을 처치하고, 골드와 경험치를 얻습니다. 적은 레벨이 올라감에 따라 더 강력해집니다.
* 아이템: 상점에서 포션을 구매해 체력을 회복하거나, 무기를 구매해 공격력을 증가시킬 수 있습니다.
* 레벨업: 경험치를 통해 레벨업하면 공격력이 증가하고, 체력이 최대치로 회복됩니다.
* 도망: 전투 중 언제든지 도망을 선택할 수 있지만, 도망을 치면 경험치나 보상을 받을 수 없습니다.
* 
* <추가기능>
* 상점 시스템을 도입하여 전략적으로 자원을 관리할 수 있도록 했습니다.
* 난이도 조절: 적의 레벨이 플레이어의 레벨에 따라 증가하며, 전투 난이도가 점점 높아집니다.
* 아이템 사용: 포션을 사용하여 회복할 수 있고, 상점에서 무기를 구매해 공격력을 높일 수 있습니다.
* */

class AdventurePlayer {
   int health = 100;
   int gold = 50;
   int experience = 0;
   int level = 1;
   int attackPower = 10;
   int potionCount = 3;

   // 플레이어 공격
   public int attack() {
       return (int) (Math.random() * attackPower) + 1;
   }

   // 체력 회복
   public void usePotion() {
       if (potionCount > 0) {
           health += 30;
           if (health > 100) health = 100;
           // <문제1> 포션이 줄어 들게 소스를 넣으시오.
           potionCount--;
           System.out.println("포션을 사용하여 체력을 회복했습니다. 남은 포션: " + potionCount);
       } else {
           System.out.println("포션이 없습니다!");
       }
   }

   // 데미지 받기
   // <문제2> takeDamage 메서드를 만들어 넣으시오. 
   public int takeDamage(int damage) {

	   health -= damage;
	   if ( health <= 0 )
		   health = 0;
	   
		   return health;	   
   }

   // 경험치 획득 및 레벨업
   public void gainExperience(int exp) {
       experience += exp;
       if (experience >= level * 100) {
           // <문제3> 조건에 맞으면 레벨업이 되도록 소스를 넣으시오.
    	   if(experience >= 100) {
    		   levelUp();
    		   
    	   }
       }
   }

   // 레벨업
   public void levelUp() {
       level++;
       experience = 0;
       attackPower += 5;
       health = 100;
       System.out.println("레벨업! 현재 레벨: " + level + ", 공격력: " + attackPower);
   }

   // 상점에서 아이템 구매
   // <문제4> 아래 buyItem 메소드에 매게변수를 넣어 메소드를 완성하시오.
   public void buyItem(String item) {
       if (item.equals("potion") && gold >= 10) {
           potionCount++;
           gold -= 10;
           System.out.println("포션을 구매했습니다. 남은 포션: " + potionCount + ", 남은 골드: " + gold);
       } else if (item.equals("weapon") && gold >= 30) {
           attackPower += 5;
           gold -= 30;
           System.out.println("무기를 구매하여 공격력이 증가했습니다! 현재 공격력: " + attackPower + ", 남은 골드: " + gold);
       } else {
           System.out.println("골드가 부족하거나 잘못된 아이템입니다.");
       }
   }
}

class AdventureEnemy {
   int health;
   int attackPower;

   public AdventureEnemy(int level) {
       health = 20 + (level * 10); // 레벨에 따라 적의 체력이 증가
       attackPower = 5 + (level * 3); // 레벨에 따라 적의 공격력이 증가
   }

   // 적 공격
   public int attack() {
       return (int) (Math.random() * attackPower) + 1;
   }

   // 적이 데미지 받음
   // <문제5> 적이 데미지를 받는 메서드를 완성하시오.
   public void takeDamage(int damage) {
       // 소스 넣기
	   health -= damage;
	   if(health == 0) {
		   health = 0;
	   }
	   
   }
}

public class Game28 {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       AdventurePlayer player = new AdventurePlayer();
       int enemyLevel = 1;

       System.out.println("=== 전략 던전 탐험을 시작합니다! ===");

       while (player.health > 0) {
           System.out.println("\n1. 던전 탐험\n2. 상점 방문\n3. 상태 확인\n4. 게임 종료");
           System.out.print("행동을 선택하세요: ");
           int choice = scanner.nextInt();

           switch (choice) {
               case 1:
                   // 던전 탐험 (적과 전투)
                   AdventureEnemy enemy = new AdventureEnemy(enemyLevel);
                   System.out.println("레벨 " + enemyLevel + " 적과 마주쳤습니다!");

                   while (player.health > 0 && enemy.health > 0) {
                       System.out.println("\n1. 공격\n2. 포션 사용\n3. 도망");
                       System.out.print("행동을 선택하세요: ");
                       int battleChoice = scanner.nextInt();

                       if (battleChoice == 1) {
                           // 공격
                           int playerAttack = player.attack();
                           enemy.takeDamage(playerAttack);
                           System.out.println("적에게 " + playerAttack + "의 데미지를 입혔습니다.");

                           if (enemy.health > 0) {
                               int enemyAttack = enemy.attack();
                               player.takeDamage(enemyAttack);
                               System.out.println("적의 반격! " + enemyAttack + "의 데미지를 받았습니다. 남은 체력: " + player.health);
                           } else {
                               System.out.println("적을 처치했습니다!");
                               player.gainExperience(50 + (enemyLevel * 10)); // 적 처치 시 경험치 증가
                               player.gold += 20;
                               System.out.println("골드를 획득했습니다. 현재 골드: " + player.gold);
                               enemyLevel++;
                           }
                       } else if (battleChoice == 2) {
                           // 포션 사용
                           player.usePotion();
                       } else if (battleChoice == 3) {
                           // 도망
                           System.out.println("도망쳤습니다.");
                           break;
                       }
                   }

                   if (player.health <= 0) {
                       System.out.println("플레이어가 사망했습니다. 게임 오버.");
                   }
                   break;

               case 2:
                   // 상점 방문
                   System.out.println("\n1. 포션 구매 (10골드)\n2. 무기 구매 (30골드)");
                   System.out.print("구매할 아이템을 선택하세요: ");
                   int shopChoice = scanner.nextInt();
                   
                   if (shopChoice == 1) {
                       player.buyItem("potion");
                   } else if (shopChoice == 2) {
                       player.buyItem("weapon");
                   } else {
                       System.out.println("잘못된 선택입니다.");
                   }
                   break;

               case 3:
                   // 상태 확인
                   System.out.println("\n플레이어 상태:");
                   // <문제 6> 아래 System.out.println 소스에 player 변수를 넣어 체력 ~ 공격력까지 내용이 보이게 하시오.
                   System.out.println("체력: " + player.health);
                   System.out.println("레벨: " + player.level );
                   System.out.println("경험치: " + player.experience);
                   System.out.println("골드: " + player.gold);
                   System.out.println("포션 수: " + player.potionCount);
                   System.out.println("공격력: " + player.attackPower);
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