package com.fabiotesla.testedegraficos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author biog4
 */
public class MainMenu extends JPanel implements ActionListener {
    
    private Timer timer;
    
    public MainMenu(){
        
        timer = new Timer(25,this);
        timer.start();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Renderer.Draw(g, "TESTE", 200 / 2 - 20, 10);
        // this smooths out animations on some systems
        Toolkit.getDefaultToolkit().sync();
    }

    
}
