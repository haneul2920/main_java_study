package section07;

public class PRACTTICE_07_04 {

	public static void main(String[] args) {
		Speaker speaker = new Speaker();
		speaker.turnOn();
		

	}

}

class Speaker{
	static int volume = 50;
	void turnOn() {	
		System.out.println("스피커의 전원이 켜졌습니다. 기본 볼륨은 " + volume + " 입니다.");
	}
}