/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabiotesla.projeto;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

/**
 *
 * @author biog4
 */
public class Quarto implements Scene {

    public Player player;
    
    public Quarto(){
        player = new Player();
    }
    
    @Override
    public void Draw(Graphics g) {
        player.Draw(g);
    }

    @Override
    public void Tick() {
        player.Tick();
    }
    
    @Override
    public void KeyPressed(KeyEvent e){
        player.KeyPressed(e);
    }
    @Override
    public void KeyReleased(KeyEvent e){
        player.KeyReleased(e);
    }
}
