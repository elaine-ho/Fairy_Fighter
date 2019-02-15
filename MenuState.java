import java.awt.Graphics;
/**
 * Write a description of class MenuState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuState extends State
{
    private int i;
    public MenuState(Game game) {
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
        if(i>=0 && i <=50)
        g.drawImage(Assets.menu2,0,0,null);
        else 
        g.drawImage(Assets.menu1,0,0,null);
        if(i==100)
        i=0;
    }
    
    public boolean completed()
    {
        return game.getKeyboard().enter;
    }
    
    public boolean compareTo(State s)
    {
        return this==s;
    }
}
