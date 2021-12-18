package cheezyT08.com.github.keyTester;

//@author Torin

import javax.swing.SwingUtilities;
public class KeyTesterMain {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				new KeyTesterWindow();
			}
			
		});
	}

}
