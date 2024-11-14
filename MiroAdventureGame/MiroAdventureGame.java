package MiroAdventureGame;

import java.util.Scanner;

class Player {
	int health = 100;
	int potionCount;
	int KeyCount;
	int pointCount;
	int shieldCount;
	private long shieldEndTime;

	public void Charater(int health) {
		this.health = health;
	}
	//실드 시간
	public void isShieldTime(int tim) {
		shieldEndTime = System.currentTimeMillis()+ tim * 1000;
	}
	public boolean isShieldActive() {		
        return System.currentTimeMillis() <= shieldEndTime;
    }
	
	//함정을 밟았을때의 상황
	public void takeDamage(int damage) {ㅁ
		if (!isShieldActive()) { // 실드가 없을 때만 피해 적용
			health -= damage;
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			System.out.println("함정을 밟았습니다!");
			if (health <= 0) {
				health = 0;
			}
		} else {
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			System.out.println("실드가 활성 상태입니다! 함정 피해를 막았습니다.");
		}
	}
	//실드 사용
	public void uesShield() {
		if (shieldCount > 0) {
			isShieldActive();
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			System.out.println("실드를 사용하셨습니다. 3초간 함정 피해를 막아줍니다.");
			shieldCount--;
		}else {
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			System.out.println("실드가 없습니다.");
		}
	}
	//포션 사용
	public void usePotion() {
		if (potionCount > 0 && health < 100) {
			health += 50;
			potionCount--;
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			System.out.println("포션을 사용 하셧습니다. 현재 HP :" + health);
		} else if (health >= 100) {
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			System.out.println("최대 체력입니다.");
		} else {
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			System.out.println("남아 있는 포션이 없습니다.");
		}
	}
	public int getShield() {
		shieldCount++;
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("실드를 획득하셧습니다.");
		return shieldCount;
	}

	//포션 획득
	public int getPotion() {
		potionCount ++;
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("포션을 획득 하셧습니다. 현재 포션수 : " + potionCount);
		return potionCount;
	}
	//열쇠 획득
	public int getKey() {
		return KeyCount++;
	}
	//열쇠 사용
	public void useKey() {
		if (KeyCount > 0) {
					
		}
	}
	//포인트 획득
	public int getpoint() {
		pointCount += 10;
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("포인트 획득"+pointCount);		
		return pointCount;
	}

}

class GameObject {
	protected int x, y;

	public GameObject(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void move(int dx, int dy) {
		x += dx;
		y += dy;
	}
}

class PlayerMove extends GameObject {
	
	public PlayerMove(int x, int y) {
		super(x, y);
	}
}

class MazeMap{

 
	public final char[][] MazeLevel1 = { 	{ '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' },
											{ ' ', ' ', ' ', ' ', ' ', ' ', 'K', '#', '$', '#' },
											{ '#', '#', ' ', '#', 'I', '#', '#', '#', ' ', '#' },
											{ '#', ' ', ' ', '#', '#', '#', ' ', '#', ' ', '#' },
											{ '#', 'D', '#', '#', ' ', ' ', 'T', ' ', ' ', '#' },
											{ '#', ' ', '#', '#', ' ', '#', '#', '#', '#', '#' },
											{ '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#' },
											{ '#', ' ', '#', ' ', '#', '#', '#', '#', ' ', '#' },
											{ '#', 'T', ' ', ' ', ' ', ' ', '$', '#', ' ', 'E' },
											{ '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' } };



	public final char[][] MazeLevel2 = { 	{ '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' },
											{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'D', ' ', '#' },
											{ '#', ' ', '#', '#', ' ', '#', '#', '#', '#', '#', 'D', '#', '#', ' ', '#' },
											{ '#', ' ', '#', ' ', ' ', '#', ' ', ' ', ' ', '#', ' ', '#', '$', ' ', '#' },
											{ '#', ' ', '#', ' ', '#', '#', ' ', '#', ' ', ' ', ' ', 'K', '#', ' ', '#' },
											{ '#', ' ', '#', ' ', '#', '$', ' ', '#', ' ', '#', ' ', '#', '#', ' ', '#' },
											{ '#', ' ', '#', ' ', '#', '#', '#', '#', ' ', '#', ' ', '#', 'S', 'K', '#' },
											{ '#', ' ', '#', ' ', ' ', ' ', 'T', ' ', ' ', '#', ' ', '#', '#', '#', '#' },
											{ '#', ' ', '#', '#', '#', '#', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', '#' },
											{ '#', ' ', ' ', 'T', '#', ' ', ' ', '#', ' ', ' ', ' ', '#', '#', ' ', '#' },
											{ '#', 'D', '#', ' ', '#', ' ', '#', '#', ' ', '#', ' ', ' ', '#', 'T', '#' },
											{ '#', ' ', '#', ' ', '#', ' ', '#', ' ', ' ', '#', '#', ' ', '#', ' ', '#' },
											{ '#', ' ', '#', ' ', '#', ' ', ' ', ' ', '#', '#', ' ', ' ', '#', ' ', '#' },
											{ '#', '$', '#', 'K', '#', ' ', '#', 'I', '#', ' ', ' ', '#', '#', 'T', 'E' },
											{ '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' } };

}

class Item extends MazeMap {
	
	public char[][] map;
	
    public char[][] getMap() {
        return map;
    }
    
	//난이도 선택
	public void MazeMapLevel(int level) {
        if (level == 1) {
            this.map = MazeLevel1;
        } else {
            this.map = MazeLevel2;
        }
    }

    //탈출구 출력
	public boolean isExit(int x, int y) {
		return map[y][x] == 'E';
	}
	//포인트 아이콘 출력
	public boolean isPoint(int x, int y) {
		return map[y][x] == '$';
	}
	//벽 출력
	public boolean isWall(int x, int y) {
		return map[y][x] == '#';
	}
	//함정 출력
	public boolean isTrap(int x, int y) {
		return map[y][x] == 'T';
	}
	//포션 출력
	public boolean isPotion(int x, int y) {
		return map[y][x] == 'I';
	}
	//열쇠 출력
	public boolean isKey(int x, int y) {
		return map[y][x] == 'K';
	}
	//문 출력
	public boolean isDoor(int x, int y) {
		return map[y][x] == 'D';
	}
	//실드 출력
	public boolean isShield(int x, int y) {
		return map[y][x] == 'S';
	}
	//실드 획득시 실드 아이콘 제거
	public void removeShield(int x, int y) {
		if (isShield(x, y)) {
			map[y][x] = ' ';
			}
	}
	//포션 획득시 포션 아이콘 제거
	public void removePotion(int x, int y) {
		if (isPotion(x, y)) {
			map[y][x] = ' ';
		}
	}
	//문 오픈시 문 아이콘 제거
	public void removeDoor(int x, int y) {
		if (isDoor(x, y)) {
			map[y][x] = ' ';
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			System.out.println("문을 열었습니다.");	
		}
	}
	//키 획득시 키 아이콘 제거
	public void removeKey(int x, int y) {
		if (isKey(x, y)) {
			map[y][x] = ' ';
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			System.out.println("키를 획득 하셧습니다.");
		}
	}
	//포인트 획득시 포인트 아이콘 제거
	public void removePoint(int x, int y) {
		if (isPoint(x, y)) {
			map[y][x] = ' ';
		}
	}
	public void removeTrap(int x, int y) {
		if (isTrap(x, y)) {
			map[y][x] = ' ';
		}
	}
}

public class MiroAdventureGame {
	private final Item item;
	private final PlayerMove PlayerMove;
	private final int limitTimeInSeconds = 60;

	public MiroAdventureGame(int level) {
		this.item = new Item();	
		this.item.MazeMapLevel(level);
		this.PlayerMove = new PlayerMove(0, 1); // 시작 지점
	}

	public void play() {

		Scanner scanner = new Scanner(System.in);
		Player player = new Player();
		long startTime = System.currentTimeMillis();

		while (true) {
			long elapsedTime = (System.currentTimeMillis() - startTime) / 1000;
			long remainingTime = limitTimeInSeconds - elapsedTime;// 경과 시간 계산	
			if (elapsedTime >= limitTimeInSeconds) { // 제한 시간 초과 검사
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("     시간 초과! 게임 종료.");
				break;
			}
			
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			System.out.println("이동할 방향을 입력하세요 (WASD) 포션사용 (P) 실드사용 (I)\n현재 HP : "+player.health);
			System.out.println("남은 시간 : " + remainingTime + "초");
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");

			printMaze(); //맵 출력
			char direction = scanner.next().toUpperCase().charAt(0);
			int dx = 0, dy = 0;
			//ui선택
			switch (direction) {
			case 'W':
				dy = -1;
				break;
			case 'S':
				dy = 1;
				break;
			case 'A':
				dx = -1;
				break;
			case 'D':
				dx = 1;
				break;
			case 'P':
				player.usePotion();
				break;
			case 'I':
				player.uesShield();
				player.isShieldTime(3);
				player.shieldCount--;
				break;
			default:
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("     잘못된 입력입니다");
				continue;
			}

			int newX = PlayerMove.getX() + dx;
			int newY = PlayerMove.getY() + dy;
			//열쇠 없을시 플레이어 이동
			if (newX >= 0 && newY >= 0 && newY < item.getMap().length && newX < item.getMap()[0].length
					&& !item.isWall(newX, newY) && !item.isDoor(newX, newY) && player.KeyCount == 0) {
				PlayerMove.move(dx, dy);
			}	//열쇠 획득후 플레이어 이동
				if(newX >= 0 && newY >= 0 && newY < item.getMap().length && newX < item.getMap()[0].length
					&& !item.isWall(newX, newY) && player.KeyCount > 0) {
					PlayerMove.move(dx, dy);
				}
				//함정을 밟았을때
			if (item.isTrap(PlayerMove.getX(), PlayerMove.getY())) {				
				player.takeDamage(30);
				item.removeTrap(PlayerMove.getX(), PlayerMove.getY());
			}
			if (item.isPotion(PlayerMove.getX(), PlayerMove.getY())) { // 포션획득
				player.getPotion();	
				item.removePotion(PlayerMove.getX(), PlayerMove.getY());//포션 획득시 맵에서 포션 제거
			}
			if (item.isKey(PlayerMove.getX(), PlayerMove.getY())) { // 열쇠 획득
				player.getKey();				
				item.removeKey(PlayerMove.getX(), PlayerMove.getY()); // 열쇠 획득시 맵에서 열쇠 제거
			}
			if(item.isShield(PlayerMove.getX(), PlayerMove.getY())) { // 실드 획득
				player.getShield();
				item.removeShield(PlayerMove.getX(), PlayerMove.getY()); //실드 획득시 맵에서 실드 제거
				
			}
			if(item.isPoint(PlayerMove.getX(), PlayerMove.getY())) { //포인트 획득
				player.getpoint();				
				item.removePoint(PlayerMove.getX(), PlayerMove.getY()); // 포인트 획득시 맵에서 포인트 제거
			}
			if (item.isDoor(PlayerMove.getX(), PlayerMove.getY()) && player.KeyCount > 0) {	 //도어 오픈
				item.removeDoor(PlayerMove.getX(), PlayerMove.getY()); 
				player.KeyCount--; // 도어 오픈시 열쇠 감소
			}
			if (item.isExit(PlayerMove.getX(), PlayerMove.getY())) { // 탈출시 게임 종료
				System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
				System.out.println("축하합니다! 미로를 탈출했습니다!\n획득 포인트 : "+player.pointCount);
				break;
			}
			if (player.health <= 0) {
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("     플레이어 사망 GAEM OVER");
				return;
			}
			
		}
		scanner.close();
	}
	
	private void printMaze() {
		char[][] map = item.getMap();
		for (int y = 0; y < map.length; y++) {
			for (int x = 0; x < map[y].length; x++) {
				if (PlayerMove.getX() == x && PlayerMove.getY() == y) {
					System.out.print("P ");
				} else {
					System.out.print(map[y][x] + " ");
				}
			}
			System.out.println();
		}
	}
	// 게임 실행
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("난이도를 선택하세요: 1 (쉬움), 2 (어려움)");
		int level = scanner.nextInt();
		MiroAdventureGame game = new MiroAdventureGame(level);
		game.play();
	}
}