import java.awt.Graphics;
import java.util.ArrayList;
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Character
{
    private Game game;
    public int health;
    public ArrayList <Attack> attacks;
    private int count;
    private int p;
    private Fairy[] faries;
    private MainFairy boss;
    public Player(Game game, float x, float y, int width, int height, Fairy [] faries,MainFairy boss){
        super(x,y, width, height);
        this.game = game;
        attacks = new ArrayList<Attack>();
        count = 0;
        p=0;
        health = 5;
        this.faries=faries;
        this.boss=boss;
    }

    public ArrayList<Attack> getAttacks(){
        return attacks;
    }

    @Override
    public void update(){
        getInput();
        for(int k = attacks.size()-1; k>=0; k--)
        {
            if(attacks.get(k).getX()<=0)
                attacks.remove(k);
            else attacks.get(k).goesUp();
        }
        move();

        for(int i = 0 ;i <faries.length; i++)
        {
            if(faries[i]!=null){
                for(int l=0; l<faries[i].getAttacks().size(); l++){

                    if(faries[i].getAttacks().get(l).getX()>x && faries[i].getAttacks().get(l).getX()<x+width &&
                    faries[i].getAttacks().get(l).getY()>y && faries[i].getAttacks().get(l).getY()<y+height && faries[i].getAttacks().get(l).getHit()==false){
                        health--;
                        faries[i].getAttacks().get(l).setHit(true);}

                }}              
        }
        
        if(boss!=null){
       for(int l=0; l<boss.getAttacks().size(); l++){

                if(boss.getAttacks().get(l).getX()>x && boss.getAttacks().get(l).getX()<x+width &&
                boss.getAttacks().get(l).getY()>y &&boss.getAttacks().get(l).getY()<y+height && boss.getAttacks().get(l).getHit()==false){
                    health--;
                   boss.getAttacks().get(l).setHit(true);}

       } 
    }
    }

    private void getInput(){
        yMove=0;
        xMove=0;
        if(game.getKeyboard().up){
            if (y>0)
                yMove=-speed;}
        if(game.getKeyboard().right){
            if (x<640-width-5)
                xMove= speed;}
        if(game.getKeyboard().left){
            if (x>0)
                xMove = -speed;}
        if(game.getKeyboard().down){
            if (y<480-height-5)
                yMove = speed;}
        if(game.getKeyboard().space){
            if (count==999)
                count=0;
            if(count%5==0)
                attacks.add(new Attack(this,x+width/2,y));
            count++;
        }
    }

    public int getHealth(){
        return health;
    }

    public void setHealth(int health){
        this.health = health;
    }

    @Override
    public void render(Graphics g){
        //g.drawImage(Assets.player,(int) x,(int) y, null);
        if(p>=0 && p<=2)
            g.drawImage(Assets.pro1,(int) x,(int) y, null);
        else if(p>=3 && p<=5 )
            g.drawImage(Assets.pro2,(int) x,(int) y, null);
        else if(p>=6 && p<=8)
            g.drawImage(Assets.pro3,(int) x,(int) y, null);
        else 
            g.drawImage(Assets.pro4,(int) x,(int) y, null);
        p++;
        if(p==12)
            p=0;
        for(int i = 0; i<attacks.size(); i++)
            g.drawImage(Assets.attack,(int) attacks.get(i).getX(),(int) attacks.get(i).getY(),null); 
    }

}
