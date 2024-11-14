package section09;

class Book2 {
	String title;
	int pages;
	
	Book2(String title, int pages){
		this.title=title;
		this.pages=pages;
		}
	Book2(){
		this.title="";
		
		
	}
	
}


public class PRACTICE_09_05 {

	public static void main(String[] args) {
		Book2 b1 = new Book2("어린왕자", 300);
		Book2 b2 = new Book2();
		

	}

}

