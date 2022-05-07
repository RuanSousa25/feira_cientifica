package MainPackage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.Random;

import GameEngine.*;

public class Game extends JPanel implements ActionListener, KeyListener{

	public double Time;
	
	private BufferedImage background;
	private BufferedImage computer;
	private BufferedImage point;
	private Timer timer;
	
	private boolean running;
	private boolean wait;
	
	public Game() {
		background = FileLoader.LoadImage("Sprites/background.png");
		computer = FileLoader.LoadImage("Sprites/computer.png");
		point = FileLoader.LoadImage("Sprites/barlocation.png");
		
		Newp();
		
		timer = new Timer(25,this);
		timer.start();
	}
	
	public void paint(Graphics g) {
		Color b = g.getColor();
		g.setColor(Time > 150 ? Color.BLACK : Color.cyan);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(b);
		g.drawImage(background,0,0,getWidth(), getHeight(), this);
		
		//draw pc
		g.drawImage(computer,360,200,600,600, this);
		
		g.drawLine(360, 170, 360 + 600, 170);
		g.fillRect(360, 170, 600, 20);
		
		g.fillRect(360 + (currectvalue * 6) - 5,200,10,40);
		
		g.drawImage(point,360 + (p * 6) - 20,200,40,40, this);
		
		
		if(txt != null || txt != "") {
			Font bf = g.getFont();
			Color bc = g.getColor();
			g.setFont(new Font("monospaced", Font.BOLD, 40));
			g.setColor(Color.YELLOW);
			
			int strinlen = (int)g.getFontMetrics().getStringBounds(txt, g).getWidth();
			int start = getWidth()/2 - strinlen/2;
			g.drawString(txt, start, getHeight()/2);
			
			g.setFont(bf);
			g.setColor(bc);
		}
		
		
		g.drawString(String.valueOf(Time), 0, 40);
		g.drawString(String.valueOf(running), 0, 50);
		g.drawString(String.valueOf(points), 0, 60);
		
	}
	
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(running) {
			if(e.getKeyCode() == KeyEvent.VK_SPACE) {
				if(currectvalue < p + 6 && currectvalue > p - 6) {
					if(currectvalue < p + 3 && currectvalue > p - 3) {
						points += 300;
						DisplayText("Incrivel!");
					}else {
						points += 200;
						DisplayText("Boa!");
					}
				}else {
					points -= 200;
					DisplayText("Poxa");
				}
				Newp();
			}
		}else {
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				Main.ChangeScene(new MainMenu());
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	private int currectvalue;
	private int p;
	public int points;;
	private String txt;
	private int txtlifetime;
	
	void GameLogic() {
		if(!running) return;
		
		
		
		currectvalue += 1;
		if(currectvalue > 100) {
			DisplayText("Esqueceu?");
			points -= 100;
			Newp();
		}
		if(Time - txtlifetime > 2) {
			txt = "";
		}
		
		if(Time >= 60) {
			running = false;
			DisplayText("Você conseguiu :" + points + " em 1 minuto. Enter para voltar");
		}
		
	}
	
	void DisplayText(String msg) {
		txt = msg;
		txtlifetime = (int)Time;
	}
	
	void Newp() {
		currectvalue = 0;
		p = new Random().nextInt(10, 100);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Time += 1 / (double)25;
		switch ((int)Time) {
		case 0:
			DisplayText("Ready");
			break;
		case 1:
			DisplayText("Ready");
			break;
		case 2:
			DisplayText("Ready");
			break;
		case 3:
			DisplayText("GOOO!");
			break;
		case 4:
				running = true;
				break;
		}
		
		// TODO Auto-generated method stub
		GameLogic();
		
		repaint();
	}

}
