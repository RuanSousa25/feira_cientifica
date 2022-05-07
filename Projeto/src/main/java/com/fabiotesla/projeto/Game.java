package com.fabiotesla.projeto;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Resources.GameSprites;
/**
 *
 * @author biog4
 */
public class Game extends JPanel implements ActionListener, KeyListener{

    private Timer timer;
    public Scene CurrectScene;
    private GameSprites Sprites;
    
    
    public Game(){
        CurrectScene = new Quarto();
        
        Sprites = new GameSprites();
        
        timer = new Timer(25,this);
        timer.start();
    }
    
    
    
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if(CurrectScene != null) CurrectScene.Draw(g,this);
        
        Toolkit.getDefaultToolkit().sync();
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
       
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(CurrectScene != null) CurrectScene.KeyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(CurrectScene != null) CurrectScene.KeyReleased(e);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.repaint();
        if(CurrectScene != null) CurrectScene.Tick();
    }
    
}
