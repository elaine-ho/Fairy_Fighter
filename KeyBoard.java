import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 * Write a description of class KeyBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KeyBoard implements KeyListener
{
    private boolean[] keys;
    public boolean up, down, left, right,space,enter;
    public KeyBoard(){
        keys = new boolean [256];
    }
    
    public void update(){
        up = keys[KeyEvent.VK_UP];
        down= keys[KeyEvent.VK_DOWN];
        left = keys[KeyEvent.VK_LEFT];
        right = keys[KeyEvent.VK_RIGHT];
        space = keys[KeyEvent.VK_SPACE];
         enter = keys[KeyEvent.VK_ENTER];
    }
    @Override
    public void keyPressed(KeyEvent e){
        keys[e.getKeyCode()]=true;
    }

    @Override
    public void keyReleased(KeyEvent e){
        keys[e.getKeyCode()]=false;
    }

    @Override
    public void keyTyped(KeyEvent e){
        
    }
}
