package GameEngine;

import java.awt.image.BufferedImage;

public class Animation {
	public int currectSprite;
	private int time;
	private int speed;
	public boolean running;
	public boolean loop;
	
	
	public Animation(BufferedImage[] _sprites,int _speed) {
		speed = _speed;
	}
	public BufferedImage[] sprites;
	
	public void tick() {
		if(sprites.length > 0);
		if(!running) return;
		
		time += 1;
		if(time > speed) {
			NextFrame();
		}
		
	}
	
	void NextFrame() {
		currectSprite += 1;
		if(loop) {
			if(currectSprite >= sprites.length) currectSprite = 0;
		}else {
			if(currectSprite >= sprites.length) currectSprite = sprites.length;
		}
	}
	
	public void Play() {
		running = true;
	}
	public void Stop() {
		running = false;
	}
	

	public BufferedImage GetSprite() {
		if(sprites.length > 0);
		return sprites[currectSprite];
	}
}
