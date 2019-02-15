import java.awt.Graphics;
import java.util.ArrayList;
/**
 * Write a description of class GameState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameState extends State
{
    private Player player;
    private Fairy [] faries;
    private int count;
    public GameState(Game game){
        super(game);
        init();
    }

    public void init(){
        faries = new Fairy[3];
        player = new Player(game,300,400, 27, 41,faries,null);
        count = 0;}
        
    public boolean dead()
    {
        return player.getHealth()==0;
    }

    public void add(int i)
    {
        Fairy temp = new Fairy(game, 0,0,33,33,i,player);
        faries[i] = temp;
        temp=null;
    }

    public  Player getPlayer(){
        return player;
    }

    public Fairy [] getFaires(){
        return faries;
    }

    @Override
    public void update(){
        player.update();

        for(int i=0;i<faries.length;i++){
            // int num = (int) (Math.random() * 100);
            if(faries[i]==null)
                add(i);}

        for(int i = 0; i<faries.length && faries[i]!=null;i++){
            faries[i].update();
            if(faries[i].getRemove()==true ){
                if(faries[i].getDead())
                    count++;
                faries[i]=null;
            }

        }
    }

    @Override
    public void render(Graphics g){
        g.drawImage(Assets.background,0,0,null);
        player.render(g);
        for(int i = 0; i<faries.length && faries[i]!=null;i++){
            faries[i].render(g);
        }
        g.drawString("Health",2,450);
        g.drawString("Faries Killed: " + count, 540,460);
        int loc = 0;
        for(int i =0; i < player.getHealth();i++){
            g.drawImage(Image.loadImage("res/heart.png"),loc,460,null);
            loc += 10;
        }
    }

    public boolean completed(){
        return count ==20;
    }

    public boolean compareTo(State s){
        return s == this;
    }
}
