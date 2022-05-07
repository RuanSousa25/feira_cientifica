package GameEngine;

import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;


public class FileLoader {
	
	
	public static BufferedImage LoadImage(String Path) {
		try 
		{
		    return ImageIO.read(new File(Path)); // eventually C:\\ImageTest\\pic2.jpg
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			return null;
		}
	}
	
}
