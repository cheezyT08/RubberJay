package cheezyT08.com.github.rubberJay;

//@author Torin

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
public class RubberJay {
	private Robot bot;
	private ArrayList<Integer> keysHeld = new ArrayList<Integer>();
	private int stdDelay = 50;
	
	public RubberJay() {
		try {
			bot = new Robot();
		} catch(AWTException ex) {
			System.out.println(1233);
			ex.printStackTrace();
		}
	}
	
	public void setStanderedDelay(int stdDelayIn) {
		if(stdDelayIn < 0) {
			throw new IllegalArgumentException("Standered delay must be 0 or above");
		}
		//Sets stdDelay to input*10
		stdDelay = stdDelayIn*10;
	}
	
	public void delay(int delay) {
		//Delays input microseconds
		try {
			Thread.sleep(delay);
		} catch(InterruptedException ex) {
			System.err.println("Error delaying:");
			ex.printStackTrace();
		}
	}
	
	public void typeKey(int key) {
		bot.keyPress(key);
		bot.keyRelease(key);
		delay(stdDelay);
	}
	
	public void pressKey(int key) {
		bot.keyPress(key);
		keysHeld.add(key);
		delay(stdDelay);
	}
	
	@SuppressWarnings("deprecation")
	public void releaseKey(int key) {
		bot.keyRelease(key);
		keysHeld.remove(new Integer(key));
		delay(stdDelay);
	}
	
	@SuppressWarnings("deprecation")
	public void releaseAllFrstToLst(int key) {
		for(int i = 0; i < keysHeld.size(); i++) {
			bot.keyRelease(keysHeld.get(i));
			keysHeld.remove(new Integer(keysHeld.get(i)));
		}
	}
	
	@SuppressWarnings("deprecation")
	public void releaseAllLstToFrst(int key) {
		for(int i = keysHeld.size()-1; i >= 0; i++) {
			bot.keyRelease(keysHeld.get(i));
			keysHeld.remove(new Integer(keysHeld.get(i)));
		}
	}
	
	public void typeString(String str) {
		for(char key : str.toCharArray()) {
			if(Character.isUpperCase(key)) {
				System.out.println("Up");
				bot.keyPress(Keys.SHIFT);
				typeKey(java.awt.event.KeyEvent.getExtendedKeyCodeForChar(key));
				bot.keyRelease(Keys.SHIFT);
			} else {
				typeKey(java.awt.event.KeyEvent.getExtendedKeyCodeForChar(key));
			}
			delay(stdDelay);
		}
	}
	
	public Robot getBot() {
		return bot;
	}
	
}
