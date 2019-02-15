
/**
 * Write a description of class Attack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Attack
{
    public Player player;
    private float x;
    private float y;
    public boolean hit;
   public Attack(Player player, float x, float y)
   {
       this.player = player;
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
    
   public void goesUp()
   {
       y-=8;
    }
    
    public boolean getHit()
    {
        return hit;
    }
    
    public void setHit(boolean h)
    {
        hit = h;
    }
}
