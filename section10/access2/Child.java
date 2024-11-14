package section10.access2;
import section10.access1.*;

public class Child extends Parent {
	void accessTest() {
		super.accessProtected();
		Parent p1 = new Parent();
	
	}
	
}
