package com.fabiotesla.projeto;

import java.awt.event.KeyEvent;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author biog4
 */
public interface Scene {
    
    public void Draw(Graphics g);
    public void Tick();
    public void KeyPressed(KeyEvent e);
    public void KeyReleased(KeyEvent e);
}
