import java.awt.Graphics;
/**
 * Abstract class Characters - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Character extends Aspects
{
    public float speed;
    public float xMove, yMove;
    public final float defaultSpeed = 6f;
    public Character(float x, float y, int width, int height){
        super(x,y, width, height);
        speed = defaultSpeed;
    }
    
    
    public void move(){
        x += xMove;
        y +=yMove;
    }
    
    
    public float getyMove()
    {return yMove;
    }        


    public float getxMove()
    {return xMove;
    }

    public void setXMove(int XMove){
        xMove=XMove;
    }

    public void setYMove(int YMove){
        yMove=YMove;
    }


    public float getSpeed()
    {return speed;
    }

    public void setSpeed(float speed){
        this.speed=speed;
    }

}
