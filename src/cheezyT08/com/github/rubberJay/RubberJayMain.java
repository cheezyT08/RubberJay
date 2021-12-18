package cheezyT08.com.github.rubberJay;

//@author CheezyT08

public class RubberJayMain {

	public static void main(String[] args) {
		RubberJay rj = new RubberJay();
		
		rj.setStanderedDelay(5);
		rj.typeKey(Keys.WINDOWS);
		rj.typeString("notepad");
		rj.typeKey(Keys.ENTER);
		rj.delay(50);
		rj.setStanderedDelay(10);
		rj.typeString("Hello");
	}

}
