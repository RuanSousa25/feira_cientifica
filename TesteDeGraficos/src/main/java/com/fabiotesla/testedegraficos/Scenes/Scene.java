/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabiotesla.testedegraficos.Scenes;

import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Scene {
    
    public String SceneName;
    public BufferedImage background;
    
    public Scene(String Name){
        SceneName = Name;
        LoadArchives();
    }

    private void LoadArchives() {
        try {
            background = ImageIO.read(new File("Resources/" + SceneName + "Background.png"));
            
        } catch (IOException exc) {
            System.out.println("Error opening image file: " + exc.getMessage());
        }
    }
    
    
}
