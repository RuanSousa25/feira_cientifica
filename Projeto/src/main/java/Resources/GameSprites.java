package Resources;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.HashMap;
/**
 *
 * @author biog4
 */

public class GameSprites {
    
    private static HashMap<String,BufferedImage> images = new HashMap<String,BufferedImage>();
    
    public GameSprites(){
        images.put("Player", LoadImage("images/player.png"));
    }
    private BufferedImage LoadImage(String path){
        try {
            return ImageIO.read(new File(path));
        } catch (IOException exc) {
            System.out.println("Error opening image file: " + exc.getMessage());
            return null;
        }
    }
    
    public static BufferedImage GetSprite(String name){
        return images.get(name);
    }
}
