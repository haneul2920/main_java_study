package section08;

public class DiceGame {
	//주사위 게임
	public int rollDice() {
		return (int)(Math.random()*6)+1;
	}

}

//문제 : DiceGame 클래스를 활용 하여 주사위 결과를 보여주는 실행 클래스를 만들어 실행 하시오.
//실행 클래스 명은 DiceGameExe
//결과는 System.out.println을 활용