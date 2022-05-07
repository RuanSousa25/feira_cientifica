/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabiotesla.projeto;

import Computer.Computer;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;

/**
 *
 * @author biog4
 */
public class Quarto implements Scene {

    public Player player;
    
    public Computer pc;
    
    public Quarto(){
        player = new Player();
        pc = new Computer();
        
    }
    
    @Override
    public void Draw(Graphics g,ImageObserver observer) {
        player.Draw(g,observer);
        pc.Draw(g, observer);
    }

    @Override
    public void Tick() {
        player.Tick();
        pc.Tick();
        
        //CheckCollision
    }
    
    @Override
    public void KeyPressed(KeyEvent e){
        
        if(pc.working){
            if(e.getKeyCode() == KeyEvent.VK_E){
                pc.working = false;
            }
            pc.KeyPressed(e);
        }else{
            player.KeyPressed(e);
            if(e.getKeyCode() == KeyEvent.VK_E){
                if(player.CheckCollision(pc.GetBounds())){
                    pc.working = true;
                }
            }
        }
        
        
    }
    @Override
    public void KeyReleased(KeyEvent e){
        player.KeyReleased(e);
    }
}
