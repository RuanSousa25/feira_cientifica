package MainPackage;

import java.awt.Dimension;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Main {
	
	public static JFrame frame;
	public static void main(String[] args) {
		frame = new JFrame("Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ChangeScene(new MainMenu());
	}

	public static void ChangeScene(JPanel panel) {
		frame.getContentPane().removeAll();
		
		panel.setPreferredSize(new Dimension(500,500));
		
		frame.add(panel);
		frame.addKeyListener((KeyListener)panel);
		
		frame.setResizable(false);
		
		frame.pack();
		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
