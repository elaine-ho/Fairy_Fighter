
/**
 * Write a description of class MainFairyAtts here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainFairyAtts extends Attack2
{
    public MainFairy boss;
    public boolean hit;
    /**
     * Constructor for objects of class MainFairyAtts
     */
    public MainFairyAtts(MainFairy boss,float x, float y)
    {
        super(boss,x,y);  
        hit = false;
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
