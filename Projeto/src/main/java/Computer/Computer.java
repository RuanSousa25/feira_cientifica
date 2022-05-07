package Computer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import java.util.Random;

public class Computer {
    
    public int WorksToDo; 
    
    public boolean working;
    
    public int xpos = 200;
    public int ypos = 100;
    
    private int c = 0;
    private int t = 0;
    
    public Computer(){
        WorksToDo = 30;
        newc();
    }
    void newc(){
        c = new Random().nextInt(100) + 1;
    }
    
    public void Tick(){
        if(working){
            t += 1;
            if(t > 100){
                t = 0;
                System.out.print("Miss");
                newc();
            }
            
            if(WorksToDo <= 0){
                working = false;
            }
        }
        
    }
    public void Draw(Graphics g,ImageObserver observer){
        g.drawString(String.valueOf(working) , 10, 30);
        
        if(working){
            g.drawLine(xpos, ypos - 10, xpos + 100, ypos - 10);
            
            Color backup = g.getColor();
            g.setColor(Color.RED);
            g.fillRect(xpos + c - 10, ypos - 15, 3, 11);
            g.fillRect(xpos + c + 10, ypos - 15, 3, 11);
            g.setColor(backup);
            g.fillRect(xpos + t, ypos - 15, 3, 10);
        }
        
        g.fillRect(xpos, ypos, 20, 20);
    }
    public void KeyPressed(KeyEvent e){
        if(e.getKeyCode() != KeyEvent.VK_SPACE) return;

        int min = c - 10;
        int max = c + 10;
        if(t > min && c < max){
            System.out.print("Nice");
            t = 0;
            WorksToDo -= 1;
        }else{
            System.out.print("Error");
            t = 0;
        }
        newc();
    }
    
    public Rectangle GetBounds(){
        return new Rectangle(xpos - 20,ypos - 20,20,20);
    }
}
