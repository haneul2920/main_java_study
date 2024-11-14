package section08;

public class EX08_TEST2 {

	public static void main(String[] args) {
		Person1 p = new Person1();
		for(int i = 0; i < 3; i++) {
			p.printHello();
		}

	}

}

class Person1{
	void printHello() {
		System.out.println("Hello");
	}
}
