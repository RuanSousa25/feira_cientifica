package com.fabiotesla.projeto;

import Resources.GameSprites;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
/**
 *
 * @author biog4
 */
public class Player {

    public int xpos = 50;
    public int ypos = 100;
    public int xvel;
    public int xacc;
    
    public Player(){
        
    }
    
    public void Tick(){
        Rectangle r = GetBounds();
        xvel = xacc;
        
        xpos += xvel;
    }
    
    public void KeyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_A){
            xacc = -5;
        }
        if(e.getKeyCode() == KeyEvent.VK_D){
            xacc = 5;
        }
    }
    public void KeyReleased(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_A){
            xacc = 0;
        }
    }
    
    public void Draw(Graphics g,ImageObserver observer){
        Rectangle r = GetBounds();
        
        g.drawString(String.valueOf(xpos), 20, 10);
        g.drawImage(GameSprites.GetSprite("Player"), xpos - (r.width / 2), ypos - (r.height / 2),r.width,r.height, observer);
    }
    
    public boolean CheckCollision(Rectangle rect){
        return GetBounds().intersects(rect);
    }
    
    public Rectangle GetBounds(){
        return new Rectangle(xpos - 10,ypos - 10,20,20);
    }
}
