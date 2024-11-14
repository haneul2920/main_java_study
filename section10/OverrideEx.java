package section10;

class Animal2{
	void sound() {
		System.out.println("Some sound ...");
	}
}

class Dog2 extends Animal2{
	@Override
	void sound() {
		System.out.println("멍멍 왈왈");
	}
}

class Cat2 extends Animal2{
	@Override
	void sound() {
		System.out.println("야옹");
	}
}

public class OverrideEx {

	public static void main(String[] args) {
		Animal2 A = new Animal2();
		Dog2 dog = new Dog2();
		Cat2 cat = new Cat2();
		
		A.sound();
		dog.sound();
		cat.sound();

	}

}
