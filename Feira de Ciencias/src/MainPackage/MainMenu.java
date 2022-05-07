package MainPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;

public class MainMenu extends JPanel implements ActionListener, KeyListener {

	
	public int selected = 0;
	private Timer timer;
	public MainMenu() {
		timer = new Timer(25,this);
		timer.start();
	}
	
	//Events
	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		Font backupFont = g.getFont();
		g.setColor(Color.WHITE);
		g.setFont(new Font("monospaced", Font.PLAIN, 60));
		g.drawString("Jogo", 0, 50);
		g.setFont(backupFont);
		
		Color backupColor = g.getColor();
		//
		g.setFont(new Font("monospaced", Font.PLAIN, 20));
		
		g.setColor(selected == 0 ? Color.RED : Color.WHITE);
		g.drawString("Jogar", 0, 120);
		g.setColor(selected == 1 ? Color.RED : Color.WHITE);
		g.drawString("Exit", 0, 140);
		
		g.setFont(backupFont);
		g.setColor(backupColor);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			if(selected > 0) {
				selected -= 1;
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			if(selected < 1) {
				selected += 1;
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_E) {
			switch(selected) {
				case 0:
					Main.ChangeScene(new Game());
					break;
				case 1:
					Main.frame.dispatchEvent(new WindowEvent(Main.frame, WindowEvent.WINDOW_CLOSING));
					break;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}
	
	
	
}
