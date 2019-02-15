import java.awt.image.BufferStrategy;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * Write a description of class Game here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game implements Runnable
{
    private Window display;
    public int width,height;
    public String title;
    private boolean running=false;
    private Thread thread;
    private BufferStrategy b;
    private Graphics g;

    public State gameState;
    private State menuState;
    private State gameOver;
    private State introState;
    private State preBoss;
    private State boss,postBoss,meet,badEnd,goodEnd;

    private int stateNumber;
    private KeyBoard keyboard;
    public ArrayList<String> text;
    public ArrayList<String> text2,text3,text4;
    public Game(String t, int w, int h)
    {
        title =t;
        width=w;
        height =h;
        keyboard = new KeyBoard();
        stateNumber = 0;
        text = new ArrayList<String>();
                try{
            Scanner fileIn = new Scanner(new FileReader("res/intro.txt"));
            int p;
            while(fileIn.hasNextLine())
                text.add(fileIn.nextLine());
                        fileIn.close();
        }
        catch (IOException errMessage)
        {
            System.err.println(errMessage);
        }
        
        text2 = new ArrayList<String>();
                try{
            Scanner fileIn = new Scanner(new FileReader("res/preBoss.txt"));
            int p;
            while(fileIn.hasNextLine())
                text2.add(fileIn.nextLine());
                        fileIn.close();
        }
        catch (IOException errMessage)
        {
            System.err.println(errMessage);
        }
        
                text3 = new ArrayList<String>();
                try{
            Scanner fileIn = new Scanner(new FileReader("res/postBoss.txt"));
            int p;
            while(fileIn.hasNextLine())
                text3.add(fileIn.nextLine());
                        fileIn.close();
        }
        catch (IOException errMessage)
        {
            System.err.println(errMessage);
        }
                        text4 = new ArrayList<String>();
                try{
            Scanner fileIn = new Scanner(new FileReader("res/final.txt"));
            int p;
            while(fileIn.hasNextLine())
                text4.add(fileIn.nextLine());
                        fileIn.close();
        }
        catch (IOException errMessage)
        {
            System.err.println(errMessage);
        }
    }

    public int getWidth(){
        return width;}
        
        
        public State bossState(){
            return boss;
        }
    public int getHeight(){
        return height;}

    private void init(){
        display = new Window(title, width, height); 
        Assets.init();
    }

    public void init2(){
        gameState = new GameState(this);
        menuState = new MenuState(this);
        gameOver = new GameOver(this);
        introState = new Intro(this);
        preBoss = new PreBoss(this);
        boss = new Boss(this);
        postBoss = new PostBoss(this);
        meet=new Meet(this);
        badEnd = new BadEnd(this);
        goodEnd = new GoodEnd(this);
        display.getFrame().addKeyListener(keyboard);
        State.setState(menuState);


    }
    
    public ArrayList<String> getText()
    {
        return text;
    }

    public void run(){
        init();
        init2();
        int fps = 60;
        double timePerTick =1000000000/fps;
        double delta = 0; 
        long now;
        long lastTime=System.nanoTime();

        long timer = 0;
        int ticks =0;
        while(running){
            now = System.nanoTime();
            delta += (now - lastTime)/timePerTick;
            timer += now - lastTime;
            lastTime=now;

            if(delta >=1){
                update();
                render();
                delta--;}
        }

        stop();
    }

    private void update(){
        keyboard.update();
        if(State.getState() != null)
            State.getState().update();

        if (State.getState().compareTo(menuState) && State.getState().completed())
            State.setState(introState);
            
        if(State.getState().compareTo(introState) && State.getState().completed())
        State.setState(gameState);

        if(State.getState().compareTo(gameState) && State.getState().dead())
            State.setState(gameOver);
        if(State.getState().compareTo(gameOver) && State.getState().completed()){
            init2();}
            
        if(State.getState().compareTo(gameState) && State.getState().completed())
            State.setState(preBoss);
        if(State.getState().compareTo(preBoss) && State.getState().completed())
        State.setState(boss);
        if(State.getState().compareTo(boss) && State.getState().dead())
            State.setState(gameOver);
            
            if(State.getState().compareTo(boss) && State.getState().completed())
            State.setState(postBoss);
           if(State.getState().compareTo(postBoss) && State.getState().completed())
            State.setState(meet); 
           if(State.getState().compareTo(meet) && State.getState().completed() && State.getState().dead())
            State.setState(badEnd);  
            
            if(State.getState().compareTo(meet) && State.getState().completed())
            State.setState(goodEnd); 
            
            
            if((State.getState().compareTo(badEnd) && State.getState().completed())
            || (State.getState().compareTo(goodEnd) && State.getState().completed()))
            init2();
    }

    private void render(){
        b = display.getCanvas().getBufferStrategy();
        if(b == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }

        g = b.getDrawGraphics();
        //clear
        g.clearRect(0,0,width,height);

        //start

        //g.drawImage(Assets.background,0,0,null);

        if (State.getState() != null){
            State.getState().render(g);
        }
        //end
        b.show();
        g.dispose();
    }

    public KeyBoard getKeyboard()
    {
        return keyboard;
    }

    public synchronized void start(){
        if(running) return;
        running=true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop(){
        if(!running) return;
        running = false;
        try
        {thread.join();
        }
        catch(InterruptedException e){
            e.printStackTrace();}
    }
    public ArrayList<String> getText2()
    {
        return text2;
    }

    
        public ArrayList<String> getText3()
    {
        return text3;
    }
    
            public ArrayList<String> getText4()
    {
        return text4;
    }
}
