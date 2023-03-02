/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Testing;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/**
 *
 * @author ujjaw
 */
public class DecoderTesting {
    public static void main(String[] args) {
        Color a = new Color(107,124,197);
        
        decodepixel stg = new decodepixel();
        
        Color c = stg.returndecodedcolor(a);
        
        //System.out.println(c.getRed()+" "+c.getGreen()+" "+c.getBlue());
    }
}


    
class decodepixel
{
         public Color returndecodedcolor(Color hidden)
    {
            int red = returndecodedrgb(hidden.getRed());
            int green = returndecodedrgb(hidden.getGreen());
            int blue = returndecodedrgb(hidden.getBlue());

            //System.out.println(intobinary(red)+"\n"+intobinary(green)+"\n"+intobinary(blue)+"\n");
            return new Color(red, green, blue);
    }
         
    private int returndecodedrgb(int hidden)
    {
        //System.out.println(hidden);
        String a = intobinary(hidden);
        String c = (a.substring(4)+"0000");
        
        //System.out.println(c+"\n");
        return (Integer.parseInt(c,2));
    }
    
    private String intobinary(int num)
    {
        String toreturn = (String.format("%08d", Integer.parseInt(Integer.toString(num, 2), 10)));
        //System.out.println(toreturn);
        return toreturn;
    }
}
