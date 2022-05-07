
package com.fabiotesla.testedegraficos;

import javax.swing.*;
import java.awt.*;
/**
 *
 * @author biog4
 */
public class Renderer {

    public static void Draw(Graphics g,String msg,int x,int y){
        
        g.drawString(msg, x, y);
    }
    
}
