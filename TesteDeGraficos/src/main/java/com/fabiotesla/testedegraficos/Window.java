package com.fabiotesla.testedegraficos;

import java.awt.Component;
import javax.swing.*;

/**
 *
 * @author biog4
 */
public class Window {
    
    private static JFrame win;
    
    public static void main(String[] args){
        win = new JFrame("Game");
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        win.setLocationRelativeTo(null);
        win.setResizable(false);
        win.setVisible(true);
    }
    
    public static void AddComp(Component c){
        if(c != null){
           win.add(c); 
        }
    }
}
