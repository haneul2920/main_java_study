package section10;

class Animal{
	void sound() {
		System.out.println("Some sound ...");
	}
}

class Dog extends Animal{
	void sound() {
		System.out.println("멍멍 왈왈");
	}
}

class Cat extends Animal{
	void sound() {
		System.out.println("야옹");
	}
}

public class Extend_TEST1 {

	public static void main(String[] args) {
		
		Dog dog = new Dog();
		Cat cat = new Cat();
		
		
		dog.sound();
		cat.sound();

		Animal dog1 = new Dog();
		Animal Cat1 = new Cat();
		
		dog1.sound();
		Cat1.sound();
	}

}
