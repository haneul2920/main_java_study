package Game2;

import java.util.Scanner;

/* Monster Battle Game */
/* 이 게임에서는 플레이어가 몬스터와 전투하며, 전투 중 특정한 스킬을 사용하거나 몬스터의 공격을 막을 수 있습니다.
* <게임 설명>
* 플레이어는 기본 공격과 스킬을 사용하여 몬스터와 싸웁니다.
* 마나가 충분할 때만 스킬을 사용할 수 있으며, 레벨업을 통해 더 강력해집니다.
* 몬스터를 처치하고 경험치를 얻어 성장하는 전투 시스템입니다.
* */

class Character2 {
   int health;
   
   // 기본 생성자
   public Character2(int health) {
       this.health = health;
   }

   // 공격 메서드 (하위 클래스에서 오버라이드)
   public int attack() {
       return 0; // 기본 공격은 0
   }

   // 데미지 받기
   public void takeDamage(int damage) {
       health -= damage;
       if (health < 0) health = 0;
   }

   // 상태 확인
   public boolean isAlive() {
       return health > 0;
   }
}

class GamePlayer extends Character2 {
   int mana = 50;
   int level = 1;
   int experience = 0;

   // 생성자
   public GamePlayer() {
       super(120); // 플레이어 체력
   }

   // 기본 공격
   // <문제1> (Math.random() * 15) + 10 을 넣어 아래 오버라이딩 소스를 완성하시오.
   @Override
   public int attack() {
	   int damage = (int)(Math.random() * 15)+10;
	   
	   return damage;
       
   }

   // 스킬 사용
   public int useSkill() {
       if (mana >= 20) {
           mana -= 20;
           return (int) (Math.random() * 40) + 30; // 30~69의 스킬 데미지
       } else {
           System.out.println("마나가 부족합니다.");
           return 0;
       }
   }

   // 경험치 증가 및 레벨업
   public void gainExperience(int exp) {
       experience += exp;
       if (experience >= 100) {
           levelUp();
       }
   }

   // 레벨업
   public void levelUp() {
       level++;
       experience = 0;
       health = 120; // 체력 리셋
       mana = 50; // 마나 리셋
       System.out.println("레벨업! 현재 레벨: " + level);
   }
}

class Monster2 extends Character2 {
   
   // // <문제2> 아래 생성자에서 몬스터의 체력을 80으로 하여 부모 클래스를 호출하시오 
   public Monster2() {
       super(80); // 몬스터 체력
   }

   // 몬스터 공격
   @Override  // <문제3> (Math.random() * 10) + 5 을 넣어 아래 오버라이딩 소스를 완성하시오.
   public int attack() {
      int damage = (int)(Math.random() * 10) + 5;
      return damage;
   }
}

public class Game33 {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       GamePlayer player = new GamePlayer();
       Monster2 monster = new Monster2();

       System.out.println("=== 몬스터 전투를 시작합니다! ===");

       while (player.isAlive() && monster.isAlive()) {
           System.out.println("\n1. 기본 공격\n2. 스킬 사용\n3. 상태 확인");
           System.out.print("행동을 선택하세요: ");
           int choice = scanner.nextInt();

           switch (choice) {
               case 1:
                   // 기본 공격
                   int playerAttack = player.attack();
                   monster.takeDamage(playerAttack);
                   System.out.println("몬스터에게 " + playerAttack + "의 데미지를 입혔습니다.");
                   break;

               case 2:
                   // 스킬 사용
                   int skillDamage = player.useSkill();
                   monster.takeDamage(skillDamage);
                   System.out.println("스킬로 " + skillDamage + "의 데미지를 입혔습니다.");
                   break;

               case 3:
                   // 상태 확인
                   System.out.println("플레이어 체력: " + player.health);
                   System.out.println("플레이어 마나: " + player.mana);
                   System.out.println("몬스터 체력: " + monster.health);
                   continue;

               default:
                   System.out.println("잘못된 선택입니다.");
                   break;
           }

           // 몬스터가 살아있으면 반격
           if (monster.isAlive()) {
               int monsterAttack = monster.attack();
               player.takeDamage(monsterAttack);
               System.out.println("몬스터의 공격! " + monsterAttack + "의 데미지를 받았습니다.");
           }

           if (!player.isAlive()) {
               System.out.println("플레이어가 사망했습니다. 게임 오버.");
               break;
           } else if (!monster.isAlive()) {
               System.out.println("몬스터를 처치했습니다! 경험치를 획득합니다.");
               // <문제 4> 경험치 50이 획득되도록 소스를 구성하시오.
               player.experience += 50;
               if(player.experience >= 100) {
            	   player.levelUp();
               }
               //player.gainExperience(50);               
               // <문제 5> 새로운 몬스터를 생성하시오
               monster = new Monster2();
           }
       }

       scanner.close();
   }
}