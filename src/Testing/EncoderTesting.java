/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Testing;

import java.awt.Color;

/**
 *
 * @author ujjaw
 */
public class EncoderTesting {
    public static void main(String[] args) {
        Color a = new Color(100,125,204);
        Color b = new Color(179,207,82);
        
        EncoderTesting t1 = new EncoderTesting();
        
        Color c = t1.returnhiddencolor(a,b);
        
        //System.out.println(c.getRed()+" "+c.getGreen()+" "+c.getBlue());
    }
    
    public int returnhiddenrgb(int master, int tohide)
    {
        String a = intobinary(master);
        String b = intobinary(tohide);
        String c = (a.substring(0,4)+b.substring(0,4));
        System.out.println(a+"\n"+b+"\n"+c+"\n");
        return (Integer.parseInt(c,2));
    }
    
    public Color returnhiddencolor(Color master, Color tohide)
    {
            int red = returnhiddenrgb(master.getRed(),tohide.getRed());
            int green = returnhiddenrgb(master.getGreen(),tohide.getGreen());
            int blue = returnhiddenrgb(master.getBlue(),tohide.getBlue());

            System.out.println(intobinary(red)+"\n"+intobinary(green)+"\n"+intobinary(blue));
            return new Color(red, green, blue);
    }
    
    public String intobinary(int num)
    {
        return (String.format("%08d", Integer.parseInt(Integer.toString(num, 2), 10)));
    }
    
    public void first()
    {
        String a = (String.format("%08d", Integer.parseInt(Integer.toString(201, 2), 10)));
        String b = (String.format("%08d", Integer.parseInt(Integer.toString(106, 2), 10)));
        String c = (a.substring(0,4)+b.substring(0,4));
        System.out.println(a+"\n"+b+"\n"+c+"\n");
        System.out.println(Integer.parseInt(c,2));
    }
}
