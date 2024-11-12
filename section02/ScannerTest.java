package section02;

import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		// 데이터 입력 받기
		Scanner scan = new Scanner(System.in);
				
		String name, address;
		int age;
		double weight;
		
		System.out.println("이름, 주소, 나이, 체중을 빈칸으로 구분하여 입력하세요.");
		name = scan.next();
		address = scan.next();
		age = scan.nextInt();
		weight = scan.nextDouble();
		
		
		System.out.println("이름은 : " + name);
		System.out.println("주소는 : " + address);
		System.out.println("나이는 : " + age);
		System.out.println("체중은 : " + weight);
		
	}

}
