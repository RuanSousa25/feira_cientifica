package GameEngine;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.*;

import MainPackage.Main;

public class Player {
	
	public Point position = new Point();
	
	public Animation Idle;
	
	public Player() {
		LoadAnimations();
		Idle.Play();
	}
	public Player(Point _pos) {
		position = _pos;
		LoadAnimations();
	}
	
	public void Tick() {
		Idle.tick();
	}
	
	public void Draw(Graphics g,ImageObserver observer) {
		if(Idle != null) {
			g.drawImage(Idle.GetSprite(),position.x, position.y, 64, 64, observer);
		}
		
	}
	
	void LoadAnimations() {
		
		BufferedImage[] idle = {
			FileLoader.LoadImage("Sprites/Player/sprite_0.png"),	
			FileLoader.LoadImage("Sprites/Player/sprite_1.png"),	
		};
		Idle = new Animation(idle,20);
		Idle.loop = true;
		
	}
}


