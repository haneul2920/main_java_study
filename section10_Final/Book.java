package section10_Final;

public class Book {
	String title;
	String author;
	
	Book(String title,String author){
		this.title = title;
		this.author = author;
		
	}
	
	final void info_title() {
		System.out.println("책의 제목은 "+title+"입니다.");
	}
	
	void info_author() {
		System.out.println("책의 저자는 "+ author +"입니다.");
	}

}
