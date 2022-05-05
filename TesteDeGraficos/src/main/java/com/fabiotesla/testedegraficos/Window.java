package com.fabiotesla.testedegraficos;

import java.awt.Component;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author biog4
 */
public class Window {
    
    private static JFrame win;
    private static Main main;
    public static void main(String[] args){
        win = new JFrame("Game");
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setUndecorated(false);
        
        main = new Main();
        LoadImages();
        
        win.setExtendedState(JFrame.MAXIMIZED_BOTH);
        win.add(main);

        
        win.setResizable(false);
        
        win.pack();
        
        win.setVisible(true);
    }
    
    private static void LoadImages(){
        try {
            main.background = ImageIO.read(new File("images/QuartoBackground.png"));
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void AddComp(Component c){
        if(c != null){
           win.add(c); 
        }
    }
}
