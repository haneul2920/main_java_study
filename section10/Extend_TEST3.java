package section10;

class Enployee {
	String name;
	double salary;

	Enployee(String name, double salary) {
		this.name = name;
		this.salary = salary;
		
	}
}

class Manager extends Enployee{
	double bonus;
	
	Manager(String name, double salary, double bonus){
		super(name,salary);
		this.bonus = bonus;
		System.out.println("직장인의 이름은 : " + name + ", 급여는 : " + salary);
		System.out.println("매니저의 보너스는 : "+bonus);
	}
}

public class Extend_TEST3 {

	public static void main(String[] args) {
		Manager manager = new Manager("박보검매니저", 80000, 10000);
		
	}

}
