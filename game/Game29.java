package game;

/* 생성자 This를 활용한 간단한 텍스트 기반 전투 게임  */
class Character2 {
   String name;
   int health;
   int attackPower;

   // 기본 생성자
   Character2() {
       this("Unknown", 100, 10);  // 기본값을 설정한 다른 생성자 호출
   }

   // 이름만 받는 생성자
   Character2(String name) {
       this(name, 100, 10);  // 생명력과 공격력을 기본값으로 설정
   }

   // 모든 매개변수를 받는 생성자
   Character2(String name, int health, int attackPower) {
       this.name = name;
       this.health = health;
       this.attackPower = attackPower;
   }

   // 공격 메서드
   // <문제1> 괄호 안에 적당한 소스를 넣으시오.
   void attack(Character2 target) {
       System.out.println(this.name + " attacks " + target.name + " with " + this.attackPower + " damage!");
       target.health -= this.attackPower;
       if (target.health <= 0) {
           System.out.println(target.name + " 적을 무찔렀습니다.!");
       } else {
           System.out.println(target.name + "' 의 남은 체력은? : " + target.health);
       }
   }

   // 상태 출력 메서드
   void displayStatus() {
       System.out.println("Character: " + this.name + ", Health: " + this.health + ", Attack Power: " + this.attackPower);
   }
}

public class Game29 {

    public static void main(String[] args) {
        
        // 기본 생성자를 사용한 플레이어 생성
        // <문제2> 객체를 적절히 생성하시오 : 인스턴스명은 player

       // 모든 값을 지정한 몬스터 생성
       // <문제3> 객체를 적절히 생성하시오 : 인스턴스명은 monster
       

       // 게임 시작
    	Character2 player = new Character2("철수",300,50);
    	Character2 monster = new Character2("영희");
    	
       player.displayStatus();
       monster.displayStatus();

       System.out.println("\n Battle Start!\n");

       // 전투 시퀀스
       player.attack(monster);
       if (monster.health > 0) {  // 몬스터가 살아있다면 반격
           monster.attack(player);
       }

       // 전투 후 상태 출력
       System.out.println("\nAfter Battle Status:");
       player.displayStatus();
       monster.displayStatus();

    }

}