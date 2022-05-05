package com.fabiotesla.testedegraficos;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Main extends Canvas {
    
    public BufferedImage background;
    
    
    public void paint(Graphics g){
        g.setColor(new Color(0,0,0));
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        DrawBackground(g);
    }
    
    void DrawBackground(Graphics g){
        g.drawImage(background, 0, 0,this.getWidth(),this.getHeight(), this);
    }
    
}
