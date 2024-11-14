package game;

import game.Bow;
import game.Sword;
import game.Weapon;

class Weapon {
   String name;
   int damage;

   // 무기 기본 생성자
   Weapon(String name, int damage) {
       //<문제 1> 여기에 들어갈 소스는?
	   this.name = name;
	   this.damage = damage;
       System.out.println("무기: " + name + " 데미지 " + damage);
   }
}
class Sword extends Weapon {
   Sword() {
	   super("Sword",15);
	   
       // <문제2> 기본 공격력 15이다 여기에 들어갈 소스는?
	   
   }
}
class Bow extends Weapon {
   Bow() {
       super("Bow", 10); // Bow는 기본 공격력 10
   }
}
class GPlayer {
   String name;
   Weapon weapon;

   GPlayer(String name, Weapon weapon) {
       this.name = name;
       this.weapon = weapon;
       System.out.println(name + " 선택한 무기는 " + weapon.name + " 이고 데미지는 " + weapon.damage +" 입니다.");
   }

   void attack(GameMonster monster) {
       System.out.println(name + "가 " + monster.name + "를 " + weapon.name +"로 공격했습니다.");
       monster.takeDamage(weapon.damage);// <문제 3> 여기에 들어갈 소스는?
   }
}
class GameMonster {
   String name;
   int health;

   GameMonster(String name, int health) {
       this.name = name;
       this.health = health;
       System.out.println(name + " 의 체력은 " + health + " 입니다!");
   }

   void takeDamage(int damage) {
       health -= damage;
       System.out.println(name + " 은 " + damage + " 데미지를 입었고, 남은 체력은: " + health +" 입니다.");
       if (health <= 0) {
           System.out.println(name + " 은 죽었습니다!");
       }
   }
}
public class Game30 {
    public static void main(String[] args) {
        // 무기 선택
       Weapon sword = new Sword();
       Weapon bow = new Bow();

       // 플레이어 생성 및 무기 선택
       GPlayer player1 = new GPlayer("Hero", sword);
       GPlayer player2 = new GPlayer("Archer", bow);

       // 몬스터 생성
       GameMonster monster = new GameMonster("Goblin", 20);

       // 공격 시작
       // <문제 4> 아래에 소스를 넣어 공격을 시행하시오.
       player1.attack(monster);
       player2.attack(monster);
       

    }
}