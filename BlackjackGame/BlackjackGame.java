package BlackjackGame;

/* 블랙잭 카드 게임 */
/*
* 설명: 플레이어는 목표 숫자(예: 21)를 넘지 않도록 카드를 뽑아 점수를 쌓는 게임입니다.
* Card 클래스: 개별 카드 객체로, 카드의 무늬와 숫자 및 값을 갖습니다.
* Deck 클래스: 카드 덱을 관리하며, 생성 시 모든 카드를 생성한 뒤 무작위로 섞습니다.
* Player 클래스: 각 플레이어의 손패를 관리하며, 카드 추가와 점수 계산 메서드를 포함합니다.
* BlackjackGame 클래스: 게임의 메인 클래스로, 플레이어와 딜러의 게임 로직을 실행합니다.
* */

import java.util.Random;
import java.util.Scanner;

// 카드 클래스
final class Card {
   private final String suit;
   private final String rank;
   private final int value;

   // <문제 1> 생성자 Card 안에 들어갈 적당한 소스를 넣으시오.
   public Card(String suit, String rank, int value) {
       this.suit = suit;
       this.rank = rank;
       this.value = value;
   }

   public int getValue() {
       return value;
   }

   @Override
   public String toString() {
       return suit + "의 " + rank;
   }
}

// 덱 클래스
class Deck {
    // <문제2> 아래 소스에서 빈칸에 들어갈 적절한 메서드를 넣어서 상수를 정의 하시오. 
   private static final int TOTAL_CARDS = 52;
   private final Card[] cards = new Card[TOTAL_CARDS];
   private int currentCardIndex = 0;

   public Deck() {
       String[] suits = {"하트", "다이아몬드", "클럽", "스페이드"};
       String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "잭", "퀸", "킹", "에이스"};
       int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};

       int index = 0;
       for (String suit : suits) {
           for (int i = 0; i < ranks.length; i++) {
               cards[index++] = new Card(suit, ranks[i], values[i]);
           }
       }
       shuffleDeck();
   }

   // 카드 덱을 섞는 메서드
   private void shuffleDeck() {
       Random random = new Random();
       for (int i = 0; i < cards.length; i++) {
           int j = random.nextInt(cards.length);
           Card temp = cards[i];
           cards[i] = cards[j];
           cards[j] = temp;
       }
   }

   // 카드를 한 장 뽑는 메서드
   public final Card drawCard() {
       if (currentCardIndex < cards.length) {
           return cards[currentCardIndex++];
       }
       throw new IllegalStateException("덱에 카드가 부족합니다!");
   }
}

// 플레이어 클래스
class Player {
   protected final Card[] hand = new Card[11];
   protected int handSize = 0;

   public void addCard(Card card) {
       if (handSize < hand.length) {
           hand[handSize++] = card;
       } else {
           System.out.println("더 이상 카드를 받을 수 없습니다.");
       }
   }

   // <문제3> 아래 메서드는 이 메서드를 다른 곳에서 오버라이딩을 할수 없게 하여 만들려고 한다. 적절히 넣으시오.(메서드 명 : getHandValue)
   // getHandValue {
   public final int getHandValue(){
       int totalValue = 0;
       int aceCount = 0;
       for (int i = 0; i < handSize; i++) {
           totalValue += hand[i].getValue();
           if (hand[i].getValue() == 11) aceCount++;
       }
       while (totalValue > 21 && aceCount > 0) {
           totalValue -= 10;
           aceCount--;
       }
       return totalValue;
   }

   public void showHand() {
       for (int i = 0; i < handSize; i++) {
           System.out.println(hand[i]);
       }
       System.out.println("총 점수: " + getHandValue());
   }
}

// 딜러 클래스 (플레이어 클래스 상속)
class Dealer extends Player {
   public void play(Deck deck) {
       while (getHandValue() < 17) {
           // <문제4> 플래이어가 카드를 받게 하려고 아래에 소스를 넣으려 합니다.
           // 메소드를 호출하여 완성하시오.
    	   addCard(deck.drawCard());
           
       }
   }
}

// 게임 클래스
public class BlackjackGame {
   private final Deck deck;
   private final Player player;
   private final Dealer dealer;

   public BlackjackGame() {
       this.deck = new Deck();
       this.player = new Player();
       this.dealer = new Dealer();
   }

   public void play() {
       // 초기 카드 두 장씩 배분
       player.addCard(deck.drawCard());
       player.addCard(deck.drawCard());
       dealer.addCard(deck.drawCard());
       dealer.addCard(deck.drawCard());

       // 플레이어의 턴
       System.out.println("당신의 패:");
       player.showHand();
       Scanner scanner = new Scanner(System.in);
       while (player.getHandValue() < 21) {
           System.out.print("카드를 더 받으시겠습니까? (히트/스탠드): ");
           String choice = scanner.nextLine();
           if (choice.equalsIgnoreCase("히트")) {
               player.addCard(deck.drawCard());
               System.out.println("당신의 패:");
               player.showHand();
           } else if (choice.equalsIgnoreCase("스탠드")) {
               break;
           } else {
               System.out.println("잘못된 입력입니다. '히트' 또는 '스탠드' 중 하나를 입력하세요.");
           }
       }

       // 플레이어가 버스트 여부 확인
       if (player.getHandValue() > 21) {
           System.out.println("당신이 버스트 되었습니다! 딜러의 승리입니다.");
           return;
       }

       // 딜러의 턴
       System.out.println("딜러의 패:");
       dealer.showHand();
       dealer.play(deck);

       if (dealer.getHandValue() > 21) {
           System.out.println("딜러가 버스트 되었습니다! 당신의 승리입니다.");
           return;
       }

       // 최종 결과
       int playerScore = player.getHandValue();
       int dealerScore = dealer.getHandValue();
       System.out.println("당신의 점수: " + playerScore);
       System.out.println("딜러의 점수: " + dealerScore);

       if (playerScore > dealerScore) {
           System.out.println("당신의 승리입니다!");
       } else if (playerScore < dealerScore) {
           System.out.println("딜러의 승리입니다.");
       } else {
           System.out.println("무승부입니다!");
       }
   }

   public static void main(String[] args) {
       BlackjackGame game = new BlackjackGame();
       // <문제 5> 아래에 게임을 실행 시키는 소스를 넣으시오.
       game.play();
   }
}

 