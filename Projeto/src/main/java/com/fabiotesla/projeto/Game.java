/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabiotesla.projeto;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author biog4
 */
public class Game extends JPanel implements ActionListener, KeyListener{

    public Player player;
    private Timer timer;
    
    public Game(){
        player = new Player();
        timer = new Timer(25,this);
        timer.start();
    }
    
    
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        
        
        player.Draw(g);
        
        Toolkit.getDefaultToolkit().sync();
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
       
    }

    @Override
    public void keyPressed(KeyEvent e) {
        player.KeyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        player.KeyUnPressed(e);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.repaint();
        player.Tick();
    }
    
}
