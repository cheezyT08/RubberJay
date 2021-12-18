package cheezyT08.com.github.keyTester;

//@author Torin

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyTesterWindow extends JFrame {
	JPanel keyPanel;
	JTextArea textBox;
	
	public KeyTesterWindow() {
		setSize(450, 350);
		setTitle("Key Tester");
		setLocationRelativeTo(null);
		
		textBox = new JTextArea(20, 30);
		textBox.setEditable(false);
		textBox.setFont(new Font("sans-serif", 1, 11));
		textBox.append("Press a key:\n");
		textBox.addKeyListener(new KeyPressListener());
		textBox.setBackground(new Color(230, 230, 230));

		add(textBox);
		
		setVisible(true);
	}
	
	private class KeyPressListener implements KeyListener {

		public void keyReleased(KeyEvent ev) {}
		public void keyTyped(KeyEvent ev) {}

		public void keyPressed(KeyEvent ev) {
			printDetails(ev.getKeyChar());
		}

		public void printDetails(int key) {
			int keyCode = KeyEvent.getExtendedKeyCodeForChar(key);
			String appStr = "Key: \'"+((char) key)+"\', VK(Virtual Key) code: "+
					keyCode+", char(ASCII) code: "+key+"\n";
			System.out.println(appStr);
			textBox.append(appStr);
		}
		
	}

}
