package Game2;

class Weapon {
   String name;
   int damage;

   Weapon(String name, int damage) {
       this.name = name;
       this.damage = damage;
   }

   // 공격 메서드, 오버라이딩될 메서드
   int calculateDamage() {
       System.out.println(name + " 기본 공격력: " + damage);
       return damage;
   }
}

class Sword extends Weapon {
   Sword() {
       super("Sword", 15);
   }

   // Sword의 공격력을 조금 높여서 계산
   @Override
   int calculateDamage() {
       int extraDamage = 5;
       System.out.println(name + " 공격력: " + (damage + extraDamage));
       return damage + extraDamage;
   }
}

class Bow extends Weapon {
   Bow() {
       super("Bow", 10);
   }
   @Override
   int calculateDamage() {
	   int extraDamage = 5;
	   System.out.print(name + " 공격력: " + (damage + extraDamage));
	   return damage + extraDamage;
   }

   // Bow는 멀리서 공격할 수 있어 추가 피해량을 다르게 계산
   // <문제1> 위 Sword를 참고하여 오버라이딩 하시오/
}

class Player {
   String name;
   Weapon weapon;

   Player(String name, Weapon weapon) {
       this.name = name;
       this.weapon = weapon;
   }

   // 공격 메서드
   void attack(Monster monster) {
       System.out.println(name + " attacks " + monster.name + " with " + weapon.name);
       int inflictedDamage = weapon.calculateDamage();
       monster.takeDamage(inflictedDamage);
   }
}

class Monster {
   String name;
   int health;

   Monster(String name, int health) {
       this.name = name;
       this.health = health;
   }

   // 오버라이딩될 피해 처리 메서드
   void takeDamage(int damage) {
       health -= damage;
       System.out.println(name + " takes " + damage + " damage, remaining health: " + health);
       if (health <= 0) {
           System.out.println(name + " is defeated!");
       }
   }
}

class Goblin extends Monster {
   Goblin() {
       super("Goblin", 20);  //<문제 2> Monster의 이름은 Goblin, 체력은 20 으로 생성자를 호출하시오.
   }

   // Goblin은 피해를 덜 받도록 피해량을 줄여서 받음
   @Override
   void takeDamage(int damage) {
       int reducedDamage = damage - 2;
       health -= reducedDamage;
       System.out.println(name + " takes " + reducedDamage + " reduced damage, remaining health: " + health);
       if (health <= 0) {
           System.out.println(name + " is defeated!");
       }
   }
}

class Dragon extends Monster {
   Dragon() {
       super("Dragon", 50);
   }

   // Dragon은 피해를 더 받음
   @Override
   void takeDamage(int damage) {
       int amplifiedDamage = damage + 5;
       health -= amplifiedDamage;
       System.out.println(name + " takes " + amplifiedDamage + " amplified damage, remaining health: " + health);
       if (health <= 0) {
           System.out.println(name + " is defeated!");
       }
   }
}


public class Game31 {

    public static void main(String[] args) {
         // 무기 선택
       Weapon sword = new Sword();
       Weapon bow = new Bow();

       // 플레이어 생성 및 무기 선택
       Player player1 = new Player("Hero", sword);
       Player player2 = new Player("Archer", bow);

       // 몬스터 생성
       Monster goblin = new Goblin();
       Monster dragon = new Dragon();

       // 공격 시작
       player1.attack(goblin);  // Hero가 Goblin을 Sword로 공격
       player2.attack(dragon);  // Archer가 Dragon을 Bow로 공격
    }

}