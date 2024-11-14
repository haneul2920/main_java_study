package section03;

public class EX03_15 {

	public static void main(String[] args) {
		//논리 연산자 : &&(and), ||(or), ^(XOR), !(not)
				boolean b1 = true;
				boolean b2 = false;
				boolean b3 = true;
				boolean b4 = false;
				
				System.out.println("###논리곱###");
				System.out.println(b1 && b2);
				System.out.println(b1 && b3);
				System.out.println(b1 && b4);
				System.out.println();
				
				System.out.println("###논리합###");
				System.out.println(b1 || b2);
				System.out.println(b1 || b3);
				System.out.println(b2 || b4);
				System.out.println();
				
				System.out.println("###배타적 논리합###");
				System.out.println(b1 ^ b2);
				System.out.println(b1 ^ b3);
				
				

	}

}
