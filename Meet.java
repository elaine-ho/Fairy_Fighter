import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;
public class Meet extends State
{
    private int line;
    public ArrayList<String> text;
    private boolean completed;
    private int count;
    private int [] speaker;
    boolean prologue;
    int a;
    int b;
    /**
     * Constructor for objects of class Intro
     */
    public Meet(Game game)
    {
        super(game);
        text = game.getText4();
        line = 0;
        completed = false;
        count = 0;
        speaker =  new int[] {1,1,1,1,2,1,2,1,2,1,1,1,2,1,2,1,2,1,2,1,1};
        prologue=true;
        a=0; b=0;
    }

    public boolean dead(){
        //sees if you survied the princess cross ex. true is bad
        
        return b>=a;
    }

    @Override
    public void update(){
        if(game.getKeyboard().space && count >10 && line<11){
            line++;
            count = 0;}
            if(game.getKeyboard().space && count >10 && line>11 && speaker[line]==2){
            line++;
            count = 0;}
        count ++;
        if(line>=11 && speaker[line]==1)
        {
            if(game.getKeyboard().up && count>10){
                count=0;
                line++;
                a++;
                
            }
            
            
            if(game.getKeyboard().down && count>10){
                count=0;
                line++;
                b++;
                
            }
        }
    }

    @Override
    public void render(Graphics g){
        g.drawImage(Assets.forest,0,0,null);
        g.drawImage(Assets.textbox,0,0,null);
        if(speaker[line]==1)
            g.drawImage(Assets.propic,0,0,null);
        else
            g.drawImage(Assets.princesspic,0,0,null);
        g.setFont(new Font("Serif",Font.PLAIN, 25));
        g.setColor(Color.WHITE);
        if(line>7)
            g.drawImage(Assets.princess,300,250,null);
        else
            g.drawImage(Assets.princess2,300,250,null);
        if(prologue){
            if(line<11){
                if(text.get(line).length()>43){
                    g.drawString(text.get(line).substring(0,43), 150, 370);
                    g.drawString(text.get(line).substring(43), 150, 410);}
                else
                    g.drawString(text.get(line), 150, 370);

            }

            else prologue=false;}
            
        if(line >=11 && line<text.size()){
            
            
            if(speaker[line]==1)
            {
                g.drawImage(Assets.up,568,360,null);
                g.drawImage(Assets.down,568,400,null);
                
            }
                    if(text.get(line).length()>43){
                    g.drawString(text.get(line).substring(0,43), 150, 370);
                    g.drawString(text.get(line).substring(43), 150, 410);}
                else
                    g.drawString(text.get(line), 150, 370);
        }
        else if(line>=11) completed=true;
            
            
            
            
        
    }

    public boolean completed(){
        return completed;
    }


    public boolean compareTo(State s)
    {
        return s==this;
    }
}
