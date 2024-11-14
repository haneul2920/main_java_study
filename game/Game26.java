package game;

import java.util.Scanner;

import game.Monster;

/* Monster Battle Game */
/* 이 게임에서는 플레이어가 몬스터와 전투하며, 전투 중 특정한 스킬을 사용하거나 몬스터의 공격을 막을 수 있습니다.
* <게임 설명>
* 플레이어는 기본 공격과 스킬을 사용하여 몬스터와 싸웁니다.
* 마나가 충분할 때만 스킬을 사용할 수 있으며, 레벨업을 통해 더 강력해집니다.
* 몬스터를 처치하고 경험치를 얻어 성장하는 전투 시스템입니다.
* */

class GamePlayer {
   int health = 120;
   int mana = 50;
   int level = 1;
   int experience = 0;

   // 기본 공격
   public int attack() {
       return (int) (Math.random() * 15) + 10;
   }

   // 스킬 사용
   public int useSkill() {
       if (mana >= 20) {
           mana -= 20;
           return (int) (Math.random() * 40) + 30;
       } else {
           System.out.println("마나가 부족합니다.");
           return 0;
       }
   }

   // 데미지 받기
   public void takeDamage(int damage) {
       health -= damage;
       if (health < 0) health = 0 ;   	   
       
       
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
       health = 120;
       mana = 50;
       System.out.println("레벨업! 현재 레벨: " + level);
   }
}

class Monster {
   int health = 80;

   // 몬스터 공격
   public int attack() {
       return (int) (Math.random() * 10) + 5;
   }

   // 몬스터 데미지 받기
   public void takeDamage(int damage) {
       health -= damage;
       if (health < 0) health = 0;
   }
}

public class Game26 {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       GamePlayer player = new GamePlayer();
       Monster monster = new Monster();

       System.out.println("=== 몬스터 전투를 시작합니다! ===");

       while (player.health > 0 && monster.health > 0) {
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
                   System.out.println("몬스터의 체력: " + monster.health);
                   break;

               default:
                   System.out.println("잘못된 선택입니다.");
                   break;
           }

           // 몬스터가 살아있으면 반격
           if (monster.health > 0) {
               int monsterAttack = monster.attack();
               player.takeDamage(monsterAttack);
               System.out.println("몬스터의 공격! " + monsterAttack + "의 데미지를 받았습니다.");
               System.out.println("남은 체력 : " + player.health);
               System.out.println("몬스터의 남은 체력 : " + monster.health);
               if (player.health <= 0) {
            	   System.out.print("당신은 사망 했습니다.");
               }
           } else {
        	   System.out.println("몬스터를 처치했습니다! 경험치를 획득합니다.");
        	   player.gainExperience(50);     
        	   monster = new Monster();
           }
           // 아래 소스를 활용하여 게임을 완성하세요.    

                // 새로운 몬스터 생성
           }
       scanner.close();
       }

       
   }