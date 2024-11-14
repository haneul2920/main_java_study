package MysteryDungeonAdventure;

import java.util.Scanner;

class AdventurePlayer {
	int health = 100;
	int level = 1;
	int gold = 10000;
	int exp = 0;
	int potionCount = 3;
	int def = -500;
	int attackPower = 1000;
	double upgradeChanceWeapon = 1.0;
	double upgradeChanceArmor = 1.0;
	int upgradeWeaponCount = 0;
	int upgradeArmorCount = 0;

	public int defense() {
		return (int) (Math.random() * def) - 1;
	}

	// 플레이어 공격
	public int attack() {
		return (int) (Math.random() * attackPower) + 1;
	}

	// 포션 구매
	public void buypotion(String potion) {
		if (potion.equals("포션 구매") && gold >= 10) {
			gold -= 10;
			potionCount++;
			System.out.println("포션을 구매 하셧습니다. 보유 포션 : " + potionCount);
		} else {
			System.out.println("골드가 부족합니다.");
		}
	}

	// 무기 업그레이드
	public void weaponUpGrade(String weapon) {
		if (weapon.equals("무기 업그레이드") && gold >= 20) {
			gold -= 20;
			if (Math.random() < upgradeChanceWeapon) {
				System.out.println("업그레이드 성공!");
				upgradeChanceWeapon -= 0.1;
				attackPower += 10;
				upgradeWeaponCount++;
				if (upgradeChanceWeapon < 0.1) {
					upgradeChanceWeapon = 0;
				}
			} else if (upgradeChanceWeapon == 0) {
				System.out.println("최고 단계입니다.");
				gold += 20;
			} else {
				System.out.println("업그레이드 실패!!");
			}
		} else {
			System.out.println("골드가 부족합니다.");
		}
	}

	// 방어구 업그레이드
	public void defUpGrade(String armor) {
		if (armor.equals("방어구 업그레이드") && gold >= 10) {
			gold -= 10;
			if (Math.random() < upgradeChanceArmor) {
				System.out.println("업그레이드 성공");
				upgradeChanceArmor -= 0.1;
				def += -5;
				upgradeArmorCount++;
				if (upgradeChanceArmor < 0.1) {
					upgradeChanceArmor = 0;
				}
			} else if (upgradeChanceArmor == 0) {
				System.out.println("최고 단계입니다.");
				gold += 10;
			} else {
				System.out.println("업그레이드 실패!!");
			}
		} else {
			System.out.println("골드가 부족합니다.");
		}
	}

	// 경험치 획득 및 레벨업
	public void exp(int getexp) {
		exp += getexp;
		if (exp >= level * 100) {
			if (exp >= 100)
				levelUp();
		}
	}

	// 레벨업
	public void levelUp() {
		level++;
		attackPower += 5;
		health = 100;
		exp = 0;
		System.out.println("축하합니다!!\n레벨업 하셧습니다");
	}

	// 포션 사용
	public void usePotion() {
		if (potionCount > 0 && health < 100) {
			health += 30;
			potionCount--;
			System.out.println("포션사용 HP+30 현재 HP : " + health);

		} else if (health >= 100) {
			System.out.println("최대 체력 입니다 ");
		} else {
			System.out.println("남아있는 포션이 없습니다.");
		}
	}

	// 받은 데미지
	public int takeDamage(int damage) {
		health -= damage;
		if (health <= 0) {
			health = 0;
		} else if (health > 100) {
			health = 100;

		}
		return health;
	}

}

// 보스몬스터
class AdventureMonster2{
	int bossHealth = 1000;
	int bossDamage = 100;
	// 보스 몬스터 공격
	public int BossMonsterAttack() {
		return (int) (Math.random() * bossDamage) + 1;
	}
	// 보스 몬스터가 받는 공격
		public void BossMosterTakeDamage(int bossMonster) {
			bossHealth -= bossMonster;
			if (bossHealth <= 0)
				bossHealth = 0;		
		}
		public AdventureMonster2(int level) {
			
		}
}
class AdventureMonster {
	int health;
	int damage;

	// 몬스터 스펙
	public AdventureMonster(int level) {
		health = 20 + (level * 10);
		damage = 5 + (level * 5);
	}

	// 몬스터 공격
	public int attackdamage() {
		return (int) (Math.random() * damage) + 1;
	}

	// 몬스터가 받는 공격
	public void monsterTakeDamage(int monsterD) {
		health -= monsterD;
		if (health <= 0)
			health = 0;

	}
	// 보스 몬스터가 받는 공격


	// 보스 몬스터 공격



}

// 게임 플레이
public class MysteryDungeonAdventure {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		AdventurePlayer player = new AdventurePlayer();
		int mosterLevel = 1;

		System.out.println("Mystery Dungeon Adventure게임을 시작합니다!");
		while (player.health > 0) {
			System.out.println("\n1. 던전 탐험\n2. 상점 방문\n3. 상태 확인\n4. 게임 종료");
			System.out.println("행동을 선택 해주세요.");
			int choice = scanner.nextInt();
			

			switch (choice) {
			case 1:
				// 공격
				AdventureMonster Moster = new AdventureMonster(mosterLevel);
				AdventureMonster2 bossMoster = new AdventureMonster2(mosterLevel);
				
				if (mosterLevel < 10) {
					System.out.println("레벨 " + mosterLevel + " 적과 마주쳤습니다!");
				}else if(mosterLevel == 10){
					System.out.println("보스 출현!");
					
				}
				

				while (player.health > 0 && Moster.health > 0 ) {
					System.out.println("\n1. 공격\n2. 포션 사용\n3. 도망");
					System.out.println("행동을 선택 해주세요.");
					int battleChoice = scanner.nextInt();
					int palyerAttack = player.attack();

					if (battleChoice == 1 && mosterLevel <= 10) {
						
						Moster.monsterTakeDamage(palyerAttack);						
						System.out.println("몬스터에게 " + palyerAttack + "의 데미지를 입혔습니다.");

						if (mosterLevel < 10 && Moster.health > 0) {
							int MosterAttack = Moster.attackdamage();
							int playerdef = player.defense();
							int toTalDamage = playerdef + MosterAttack;
							player.takeDamage(toTalDamage);
							if (toTalDamage <= 0)
								toTalDamage = 0;
							System.out.println("몬스터의 반격! " + toTalDamage + "의 데미지를 받았습니다. 남은 체력 : " + player.health);

						}else if (mosterLevel >= 10 && bossMoster.bossHealth > 0) {	
							bossMoster.BossMosterTakeDamage(palyerAttack);
							System.out.println("보스 몬스터에게 " + palyerAttack + "의 데미지를 입혔습니다.");						
							int bossMosterAttack = bossMoster.BossMonsterAttack();
							int playerdef = player.defense();
							int toTalDamage = playerdef + bossMosterAttack;
							player.takeDamage(toTalDamage);
							if (toTalDamage <= 0)
								toTalDamage = 0;
							System.out.println("보스 몬스터의 반격! " + toTalDamage + "의 데미지를 받았습니다. 남은 체력 : " + player.health);
						}else if (mosterLevel == 10 && bossMoster.bossHealth <= 0) {
							System.out.println("보스를 처치 했습니다");
							return;
						} else {
							System.out.println("몬스터를 처치했습니다!");
							player.exp(50 + (mosterLevel * 50));
							player.gold += 100;
							System.out.println("골드를 획득했습니다. 현재 골드 : " + player.gold);
							mosterLevel++;
						}
					} else if (battleChoice == 2) {
						player.usePotion();
					} else if (battleChoice == 3) {
						System.out.print("도망쳤습니다.");
						break;
					}
				}
				if (player.health <= 0) {
					System.out.println("플레이어가 사망 했습니다.\nGAME OVER");
				}
				break;

			case 2:
				// 상점 방문
				System.out.println("\n1. 포션 구매 (-10골드)\n2. 무기 업그레이드 (-20골드)\n3. 방어구 업그레이드 (-10골드)");
				System.out.print("선택 해주세요.");
				int shopChoice = scanner.nextInt();

				if (shopChoice == 1) {
					player.buypotion("포션 구매");
				} else if (shopChoice == 2) {
					player.weaponUpGrade("무기 업그레이드");
				} else if (shopChoice == 3) {
					player.defUpGrade("방어구 업그레이드");
				} else {
					System.out.println("잘못된 선택입니다.");
				}
				break;

			case 3:
				// 상태 확인
				System.out.println("\n플레이어 상태 : ");
				System.out.println("체력 : " + player.health);
				System.out.println("레벨 : " + player.level);
				System.out.println("경험치 : " + player.exp);
				System.out.println("골드 : " + player.gold);
				System.out.println("포션 수 : " + player.potionCount);
				System.out.println("공격력 : " + player.attackPower);
				System.out.println("방어력 : " + player.def);
				System.out.println("무기 단계 : +" + player.upgradeWeaponCount);
				System.out.println("방어력 단계 : +" + player.upgradeArmorCount);
				break;
			case 4:
				System.out.println("게임을 종료 합니다.");
				return;
			default:
				System.out.println("잘못된 선택 입니다. 다시 선택하세요");
				break;
			}
		}
		scanner.close();
	}
}
