package steganography;

import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Steganography
{
    
    public BufferedImage decode(String hiddenpath) throws IOException
    {
        File hiddenfile= new File(hiddenpath);
        BufferedImage hidden = ImageIO.read(hiddenfile);
        
        decodepixel dcp = new decodepixel();
        
        for (int y = 0; y < hidden.getHeight(); y++) {
         for (int x = 0; x < hidden.getWidth(); x++) {
            
            Color hiddencolor = new Color(hidden.getRGB(x, y), true);

            Color color = dcp.returndecodedcolor(hiddencolor);
            //Setting new Color object to the image
            hidden.setRGB(x, y, color.getRGB());
         }
      }
        return hidden;
    }
    
    public BufferedImage hide(String masterpath, String tohidepath) throws IOException
   {
       File masterfile= new File(masterpath);
       File tohidefile= new File(tohidepath);
      
      BufferedImage master = ImageIO.read(masterfile);
      BufferedImage tohide = ImageIO.read(tohidefile);
      
      hidepixel cvt = new hidepixel();
      
      for (int y = 0; y < tohide.getHeight(); y++) {
         for (int x = 0; x < tohide.getWidth(); x++) {
            
            Color mastercolor = new Color(master.getRGB(x, y), true);
            Color tohidecolor = new Color(tohide.getRGB(x,y),true);

            Color color = cvt.returnhiddencolor(mastercolor, tohidecolor);
            //Setting new Color object to the image
            master.setRGB(x, y, color.getRGB());
         }
      }
      return master;
   }
    
    private class hidepixel
{
         private Color returnhiddencolor(Color master, Color tohide)
    {
            int red = returnhiddenrgb(master.getRed(),tohide.getRed());
            int green = returnhiddenrgb(master.getGreen(),tohide.getGreen());
            int blue = returnhiddenrgb(master.getBlue(),tohide.getBlue());

            //System.out.println(intobinary(red)+"\n"+intobinary(green)+"\n"+intobinary(blue));
            return new Color(red, green, blue);
    }
         
    private int returnhiddenrgb(int master, int tohide)
    {
        String a = intobinary(master);
        String b = intobinary(tohide);
        String c = (a.substring(0,4)+b.substring(0,4));
        //System.out.println(a+"\n"+b+"\n"+c+"\n");
        return (Integer.parseInt(c,2));
    }
    
    private String intobinary(int num)
    {
        return (String.format("%08d", Integer.parseInt(Integer.toString(num, 2), 10)));
    }
}
    
    private class decodepixel
{
         private Color returndecodedcolor(Color hidden)
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
}
