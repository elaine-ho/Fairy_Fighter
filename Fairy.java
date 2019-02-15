import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fairy extends Character
{
    private Game game;
    public long spawnTime;
    BufferedImage character;
    private int loc;
    public boolean remove = false;
    int num;
    Player player;
    private int hits;
    private boolean dead = false;
    boolean fire = false;
    int deadCount;
    public ArrayList<Attack2> attacks;
    private int attCount;
    public Fairy(Game game, float x, float y, int width, int height, int loc, Player player)
    {
        super(x,y,width,height);
        this.game=game;
        spawnTime = System.nanoTime();
        int temp = (int)(Math.random() * 3);
        if(temp==1)
            character = Assets.fairy1;
        else if (temp==2)
            character = Assets.fairy2;
        else
            character = Assets.fairy3;
        this.loc = loc;

        num = (int)(Math.random() * 150) + 50;
        startingLoc();
        this.player=player;
        hits=0;
        deadCount=0;

        attacks = new ArrayList<Attack2>();
        attCount=0;
    }
    
    public ArrayList<Attack2> getAttacks(){
        return attacks;
    }

    @Override 
    public void update(){
        move();
        if( y + 10 > num && attCount%20==0 && !dead)
        {
            attacks.add(new Attack2(this, x + 8, y+7));
        }

        attCount++;
        if(attCount==999)
        attCount=0;
        if(y<num && !dead)
            y+=5;
        ArrayList<Attack> temp = player.getAttacks();
        for(int i = 0 ;i <temp.size(); i++)
        {
            if(temp.get(i).getX()>x && temp.get(i).getX()<x+height &&
            temp.get(i).getY()>y && temp.get(i).getY()<y+width)
                hits++;
        }

        if(hits==10){
            fire =true;
            dead=true;}
        long now = System.nanoTime();
        if(now>spawnTime+(1000000000*10)){
            if(y>-40 &&!dead)
                y-=10;
            if(y<-40)
                remove=true;
        }

        if(dead)
            deadCount++;

        if(deadCount==20)
            remove=true;


        for(int k = attacks.size()-1; k>=0; k--)
        {
            if(attacks.get(k).getX()>=480)
                attacks.remove(k);
            else attacks.get(k).goesDown();
        }
    }

    public boolean getDead()
    {
        return dead;
    }

    public boolean getRemove(){
        return remove;
    }

    public void startingLoc(){
        if(loc == 0)
            x = 20+ num/2;
        if(loc == 1 && num%2==0)
            x = 300 -num/2;
        else if(loc == 1)
            x = 270 + num/2;
        if(loc ==2)
            x = 480 -num/2;
    }

    @Override
    public void render(Graphics g){
        if (fire)
            g.drawImage(Assets.fire,(int) x,(int) y, null);
        else
            g.drawImage(character,(int) x,(int) y, null);

        for(int i = 0; i<attacks.size(); i++)
            g.drawImage(Assets.att2,(int) attacks.get(i).getX(),(int) attacks.get(i).getY(),null); 
    }
}
