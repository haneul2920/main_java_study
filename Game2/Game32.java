package Game2;

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

class Character {
   int health;
   int attackPower;

   // 생성자를 통해 초기 체력과 공격력을 설정
   public Character(int health, int attackPower) {
       this.health = health;
       this.attackPower = attackPower;
   }

   // 공격 메소드 - 자식 클래스에서 오버라이딩 예정
   public int attack() {
       return (int) (Math.random() * attackPower);
   }

   // 데미지를 받는 메소드
   public void takeDamage(int damage) {
       health -= damage;
       if (health < 0) health = 0;
   }

   // 상태 출력
   public void displayStatus() {
       System.out.println("체력: " + health + ", 공격력: " + attackPower);
   }
}

class Player3 extends Character {
   private int potionCount;

   // 생성자를 통해 초기 상태를 설정
   public Player3(int health, int attackPower, int potionCount) {
       //<문제1> 아래에 적절한 소스를 넣어 주세요.
	   super(health,attackPower);
	   this.potionCount = potionCount;
	   //this.health = health;
	   //this.attackPower = attackPower;
       
   }

   // 공격 메소드 - 오버라이딩하여 플레이어의 고유한 공격 구현
   @Override
   public int attack() {
       int damage = (int) (Math.random() * attackPower) + 5; // 추가 공격력
       System.out.println("플레이어가 " + damage + "의 데미지를 입혔습니다.");
       // <문제 2> 여기에 들어갈 소스를 작성하시오.
       return damage;
       
       
   }

   // 포션 사용 메소드
   public void usePotion() {
       if (potionCount > 0) {
           health += 20;
           if (health > 100) health = 100;
           potionCount--;
           System.out.println("포션을 사용하여 체력을 회복했습니다. 남은 포션: " + potionCount);
       } else {
           System.out.println("포션이 없습니다!");
       }
   }

   // 포션 수를 반환하는 메소드
   public int getPotionCount() {
       return potionCount;
   }
}


class Enemy extends Character   { // <문제 3> extends 다음에 들어갈 것은?
   public Enemy(int level) {
       super(20 + (level * 10), 5 + (level * 3)); // 레벨에 따라 체력과 공격력 증가
   }

   // 공격 메소드 - 오버라이딩하여 적의 고유한 공격 구현
   @Override
   public int attack() { // <문제4> 메소드 명을 쓰시오
       int damage = (int) (Math.random() * attackPower) + 1; // 적은 일정 범위 내에서 랜덤 데미지
       System.out.println("적이 " + damage + "의 데미지를 입혔습니다.");
       return damage;
   }
}


public class Game32 {
    public static void main(String[] args) {
    
        Scanner scanner = new Scanner(System.in);
       Player3 player = new Player3(100, 10, 3); // 초기 체력, 공격력, 포션 수
       int enemyLevel = 1;

       System.out.println("=== 던전 탐험을 시작합니다! ===");

       while (player.health > 0) {
           System.out.println("\n1. 던전 탐험\n2. 상태 확인\n3. 게임 종료");
           System.out.print("행동을 선택하세요: ");
           int choice = scanner.nextInt();

           switch (choice) {
               case 1:
                   // 던전 탐험
                   Enemy enemy = new Enemy(enemyLevel);
                   System.out.println("레벨 " + enemyLevel + " 적과 마주쳤습니다!");
                   enemy.displayStatus();

                   while (player.health > 0 && enemy.health > 0) {
                       System.out.println("\n1. 공격\n2. 포션 사용\n3. 도망");
                       System.out.print("행동을 선택하세요: ");
                       int battleChoice = scanner.nextInt();

                       if (battleChoice == 1) {
                           // 플레이어 공격
                           int playerAttack = player.attack();
                           enemy.takeDamage(playerAttack);

                           if (enemy.health > 0) {
                               // 적의 반격
                               int enemyAttack = enemy.attack();
                               player.takeDamage(enemyAttack);
                               System.out.println("남은 체력: " + player.health);
                           } else {
                               System.out.println("적을 처치했습니다!");
                               enemyLevel++;
                           }
                       } else if (battleChoice == 2) {
                           player.usePotion();
                       } else if (battleChoice == 3) {
                           System.out.println("도망쳤습니다.");
                           break;
                       }
                   }

                   if (player.health <= 0) {
                       System.out.println("플레이어가 사망했습니다. 게임 오버.");
                   }
                   break;

               case 2:
                   System.out.println("플레이어 상태:");
                   player.displayStatus();
                   System.out.println("포션 수: " + player.getPotionCount());
                   break;

               case 3:
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