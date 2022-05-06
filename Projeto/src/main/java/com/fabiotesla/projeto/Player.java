package com.fabiotesla.projeto;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;
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
        
        if(r.x + xvel < 0 || r.x + r.width + xvel > 200){
            if(r.x + Math.signum(xvel) > 0){
                xpos += -(int)Math.signum(xvel);
            }else{
                xvel = 0;
            }
        }
        xpos += xvel;
    }
    
    public void KeyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_A){
            xacc = -1;
        }
        if(e.getKeyCode() == KeyEvent.VK_D){
            xacc = 1;
        }
    }
    public void KeyUnPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_A){
            xacc = 0;
        }
    }
    
    public void Draw(Graphics g){
        Rectangle r = GetBounds();
        
        g.drawString(String.valueOf(xpos), 20, 10);
        g.fillRect(r.x, r.y, r.width, r.height);
    }
    
    public Rectangle GetBounds(){
        return new Rectangle(xpos - 10,ypos - 10,20,20);
    }
}
