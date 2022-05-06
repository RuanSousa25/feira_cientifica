package com.fabiotesla.projeto;

import java.awt.Dimension;
import javax.swing.*;

/**
 *
 * @author biog4
 */
public class Main {
    private static JFrame frame;
    private static Game game;
    public static void main(String[] args){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        game = new Game();
        game.setPreferredSize(new Dimension(600,400));
        frame.add(game);
        frame.addKeyListener(game);
        frame.pack();
        frame.setVisible(true);
    }
}
