package section07;

public class EX07_15 {

	public static void main(String[] args) {
		System.out.println(Student.schoolName); // 정적 필드 호출
		
		Student.goToSchool(); // 정적 메소드 호출
		
		Student stu1 = new Student();
		stu1.studentName = "김고이";
		stu1.hello();
		System.out.println("학교는 " + Student.schoolName + " 입니다.");
		Student.goToSchool();
		
		Student stu2 = new Student();
		stu2.studentName = "김고삼";
		stu2.hello();
		System.out.println("학교는 " + Student.schoolName + " 입니다.");
		Student.goToSchool();
	}

}
