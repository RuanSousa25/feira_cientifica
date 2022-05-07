package MainPackage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import GameEngine.*;

public class Game extends JPanel implements ActionListener, KeyListener{

	private Timer timer;
	public Player player;
	
	public Game() {
		timer = new Timer(25,this);
		timer.start();
		player = new Player();
	}
	
	public void paint(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		player.Draw(g,this);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_H) {
			player.Idle.Stop();
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
		player.Tick();
	}

}
