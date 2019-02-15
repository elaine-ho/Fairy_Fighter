import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.Color;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Write a description of class Intro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GoodEnd extends State
{
    private int line;
    public ArrayList<String> text;
    private boolean completed;
    private int count;
    private int [] speaker;
    private boolean speak;
    private int k;
    /**
     * Constructor for objects of class Intro
     */
    public GoodEnd(Game game)
    {
        super(game);
        text = new ArrayList<String>();
        speaker = new int[]{2,1,2,1,1};
        speak = false;
        try{
            Scanner fileIn = new Scanner(new FileReader("res/good end.txt"));
            int p;
            while(fileIn.hasNextLine())
                text.add(fileIn.nextLine());
            fileIn.close();
        }
        catch (IOException errMessage)
        {
            System.err.println(errMessage);
        }

        line = 0;
        completed = false;
        count = 0;
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
        if(speak)
        {
            k++;
            if(k==200)
            completed=true;
        }
    }

    @Override
    public void render(Graphics g){
        if (speak){
            g.drawImage(Assets.goodEnd,0,0,null);
        }
        else{
            g.drawImage(Assets.forest,0,0,null);
            g.drawImage(Assets.textbox,0,0,null);
            g.drawImage(Assets.princess,300,250,null);
            g.setFont(new Font("Serif",Font.PLAIN, 25));
            g.setColor(Color.WHITE);

            if(speaker[line]==1)
                g.drawImage(Assets.propic,0,0,null);
            else
                g.drawImage(Assets.princesspic,0,0,null);

            if(line<text.size()){
                if(text.get(line).length()>43){
                    g.drawString(text.get(line).substring(0,43), 150, 370);
                    g.drawString(text.get(line).substring(43), 150, 410);}
                else
                    g.drawString(text.get(line), 150, 370);

            }

            else speak=true;}
    }

    public boolean completed(){
        return completed;
    }

    public boolean compareTo(State s)
    {
        return s==this;
    }

}