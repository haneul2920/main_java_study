package section04;

import java.util.Scanner;

public class test2 {

	public static void main(String[] args) {
		// 로그인 시스템
		// id 가 admin 이고 비밀번호가 1234 라면
		// 두개의 숫자를 넣어서 로그인하는 프로그램을 구성하세요
		// 문자를 비교할때 id.equals("admin") 을 if문안에서 활용
		// 아이디 비밀번호는 공백으로 구분해서 넣으세오
		
		System.out.println("아이디와 비밀번호를 입력하세요");
		Scanner scan = new Scanner(System.in);
		String id = scan.next();
		String pw = scan.next();
		
		
		if(id.equals("admin") && pw.equals("1234")) {
			System.out.println("로그인 성공");
		}else {
			System.out.println("로그인 실패");
		}
		

	}

}
