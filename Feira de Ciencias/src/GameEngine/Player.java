package GameEngine;

import java.awt.Point;
import java.awt.image.*;

public class Player {
	
	public Point position = new Point();
	
	public Animation Idle;
	
	public Player() {
		
	}
	public Player(Point _pos) {
		position = _pos;
	}
	
	void Tick() {
		Idle.tick();
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


