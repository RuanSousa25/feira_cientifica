package MainPackage;

import java.awt.Dimension;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Main {
	
	public static JFrame frame;
	public static JPanel panel;
	
	public static void main(String[] args) {
		frame = new JFrame("Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ChangeScene(new MainMenu());
	}

	public static void ChangeScene(JPanel panel) {
		if(Main.panel != null) {
			frame.remove(Main.panel);
			frame.removeKeyListener((KeyListener) Main.panel);
		}
		
		Main.panel = panel;
		
		panel.setPreferredSize(new Dimension(128 * 10,64 * 10));
		
		frame.add(panel);
		frame.addKeyListener((KeyListener)panel);
		
		frame.setResizable(false);
		
		frame.pack();
		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
