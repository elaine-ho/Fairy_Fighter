
/**
 * Write a description of class Attack2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Attack2
{
   public Fairy fairy;
    public float x;
    public float y;
    public boolean hit;
   public Attack2(Fairy fairy, float x, float y)
   {
       this.fairy = fairy;
       this.y=y;
       this.x=x;
       hit = false;
    }
    
   public float getY()
   {
       return y;
    }
    
    public float getX()
    {
        return x;
    }
    
   public void goesDown()
   {
       y+=8;
    }
    
    public boolean getHit()
    {
        return hit;
    }
    
    public void setHit(boolean hit)
    {
        this.hit=hit;
    }
}
