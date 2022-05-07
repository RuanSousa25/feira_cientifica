package com.fabiotesla.testedegraficos;

/**
 *
 * @author biog4
 */
import java.awt.Dimension;
import javax.swing.*;

public class TesteDeGraficos {

    private static void initWindow(){
        JFrame window = new JFrame("Test");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set Main Panel
        JPanel t = new MainMenu();
        t.setPreferredSize(new Dimension(200,200));
        window.add(t);
        //
        window.setResizable(false);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        //window.removeAll();
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                initWindow();
            }
        });
    }
}
