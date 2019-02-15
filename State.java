import java.awt.Graphics;
/**
 * Write a description of class State here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class State
{
    private static State currentState = null;
    public static void setState(State state){
        currentState = state;
    }
    
    public static State getState(){
        return currentState;}
        
    public abstract void update();
    public abstract void render(Graphics g);
    public abstract boolean completed();
    public abstract boolean compareTo(State s);
    public abstract boolean dead();
    public Game game;
    public State(Game game){
        this.game=game;
    }

}
