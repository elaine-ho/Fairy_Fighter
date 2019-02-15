import java.awt.Graphics;
/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends State
{
    private int i;
    public GameOver(Game game) {
        super(game);
        int i = 0;
    }
    
    public boolean dead(){
        return false;
    }
    @Override
    public void update(){
        i++;
    }

    @Override
    public void render(Graphics g){
        g.drawImage(Assets.rekt,0,0,null);
    }
    
    public boolean completed()
    {
        return i==200;
    }
    
    public boolean compareTo(State s)
    {
        return this==s;
    }
}
