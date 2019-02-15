import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
/**
 * Write a description of class Image here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Image
{
    public static BufferedImage loadImage(String path){
       try{
           return ImageIO.read(new File(path));
        }
       catch(IOException e){
           e.printStackTrace();
           System.exit(1);
        }
        return null;
    }

}
