import java.awt.Graphics;
import java.util.ArrayList;
/**
 * Write a description of class MainFairy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainFairy extends Fairy
{
    private Game game;
    public int health;
    private boolean right;
    private int attCount;
    public MainFairy(Game game, float x, float y, int width, int height,int loc, Player player)
    {
        super(game,x,y,width,height,loc,player);
        health = 50;
        right = true;
        attCount=0;
    }
    
    public int getHealth()
    {
        return health;
    }
    
    public void setPlayer(Player p){
        player=p;
    }
    
    @Override
    public void update(){
        attCount++;
        if(attCount%17==0){
        attacks.add(new MainFairyAtts(this, x + 8, y+7));
        attCount=0;}
        

        
        if(x<30)
        right = true;
        if(x>480)
        right = false;
        if(right)
        {
            x+=3;
        }
        if(!right)
        {
            x-=3;
        }
        ArrayList <Attack> temp = player.getAttacks();
        for(int i = 0 ;i <temp.size(); i++)
        {
            if(temp.get(i).getX()>x && temp.get(i).getX()<x+height &&
            temp.get(i).getY()>y && temp.get(i).getY()<y+width
             && temp.get(i).getHit()==false)
                {
                    health--;
                    player.getAttacks().get(i).setHit(true);
            }
        }
        
                        for(int k = attacks.size()-1; k>=0; k--)
        {
            if(attacks.get(k).getX()>=480)
                attacks.remove(k);
            else attacks.get(k).goesDown();
        }
    }
    
    @Override
    public void render(Graphics g){
        g.drawImage(Assets.boss,(int) x, (int) y, null);
        for(int i = 0; i<attacks.size(); i++)
            g.drawImage(Assets.att3,(int) attacks.get(i).getX(),(int) attacks.get(i).getY(),null);
    }
    
    public boolean bossDead()
    {
        return health ==0;
        
        
    }
}
