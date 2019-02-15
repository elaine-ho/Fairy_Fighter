import java.awt.Graphics;
/**
 * Abstract class Aspects - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Aspects
{
    public float x,y;
    public int width, height;
    public Aspects(float x, float y, int width, int height){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
    }
    
    public abstract void update();
    public abstract void render (Graphics g);
    
    public float getX(){
        return x;
    }
    
    public float getY(){
        return y;
    }
      
    public int getHeight(){
        return height;
    }
            
    public int getWidth(){
        return width;
    }
}
