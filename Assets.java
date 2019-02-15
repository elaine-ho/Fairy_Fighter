import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
/**
 * Write a description of class Assets here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Assets
{
    public static BufferedImage player, opponent, background, fairy1, fairy2,fairy3,princesspic,badEnd,goodEnd;
    public static BufferedImage attack,fire,att2,rekt,textbox,propic,forestFairy,boss,forest,up,down;
    public static BufferedImage pro1, pro2,pro3,pro4, menu1, menu2, particle,att3,princess,princess2;
   public static void init(){
       //ADD MUSIC HERE LATER
       background = Image.loadImage("res/stars.jpg");
       player = Image.loadImage("res/pro.png");
       fairy1 = Image.loadImage("res/fairy.png");
       fairy2 = Image.loadImage("res/fairy2.png");
       fairy3 = Image.loadImage("res/fairy3.png");
       attack = Image.loadImage("res/att.png");
       fire = Image.loadImage("res/fire.png");
       pro1=Image.loadImage("res/pro1.png");
       pro2=Image.loadImage("res/pro2.png");
       pro3=Image.loadImage("res/pro3.png");
       pro4=Image.loadImage("res/pro4.png");
       att2 = Image.loadImage("res/att2.png");
       rekt = Image.loadImage("res/rekt.jpg");
       menu1= Image.loadImage("res/1.png");
       menu2 = Image.loadImage("res/2.png");
       particle = Image.loadImage("res/particle.png");
       textbox = Image.loadImage("res/textbox.png");
       propic=Image.loadImage("res/proPic.png");
       forestFairy = Image.loadImage("res/bossPic.png");
       boss = Image.loadImage("res/boss.png");
       att3=Image.loadImage("res/att3.png");
       princess=Image.loadImage("res/princess.png");
       princess2=Image.loadImage("res/princess2.png");
       forest=Image.loadImage("res/forest.jpg");
       princesspic=Image.loadImage("res/princesspic.png");
       up=Image.loadImage("res/up.png");
       down=Image.loadImage("res/down.png");
       badEnd=Image.loadImage("res/badEnd.png");
       goodEnd=Image.loadImage("res/goodEnd.png");
    }
}
