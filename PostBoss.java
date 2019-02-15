import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;
/**
 * Write a description of class PostBoss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PostBoss extends State
{
   private int line;
    public ArrayList<String> text;
    private boolean completed;
    private int count;
    private int [] speaker;
    /**
     * Constructor for objects of class Intro
     */
    public PostBoss(Game game)
    {
        super(game);
        text = game.getText3();
        line = 0;
        completed = false;
        count = 0;
        speaker =  new int[] {2,1,2,1,1,1};
    }

    public boolean dead(){
        return false;
    }

    @Override
    public void update(){
        if(game.getKeyboard().space && count >10){
            line++;
            count = 0;}

        count ++;

    }

    @Override
    public void render(Graphics g){
        g.drawImage(Assets.background,0,0,null);
        g.drawImage(Assets.textbox,0,0,null);
        if(speaker[line]==1)
        g.drawImage(Assets.propic,0,0,null);
        else
        g.drawImage(Assets.forestFairy,0,0,null);
        g.setFont(new Font("Serif",Font.PLAIN, 25));
        g.setColor(Color.WHITE);
        if(line<4)
        g.drawImage(Assets.boss,300,50,null);
        if(line<text.size()){
            if(text.get(line).length()>43){
                g.drawString(text.get(line).substring(0,43), 150, 370);
                g.drawString(text.get(line).substring(43), 150, 410);}
             else
            g.drawString(text.get(line), 150, 370);

        }

        else completed=true;
    }

    public boolean completed(){
        return completed;
    }

    public boolean compareTo(State s)
    {
        return s==this;
    }
}
