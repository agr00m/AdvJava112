package java112.labs1;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class ImageConverter {
    
    String inputImage = "";
    String outputFile = "";
    
    public static void main(String args[]) {
        ImageConverter imageConverter = new ImageConverter();
        imageConverter.run(args[0]);
        imageConverter.getImage();
    }
    
    public void run(String file) {
        inputImage = file;
        outputFile = file + ".txt";
    }
    
    public void getImage() {
      
        int color = 0;
        int red = 0;
        int blue = 0;
        int green = 0;
        
        try (
            PrintWriter out = new PrintWriter(new FileWriter(outputFile))
        ){
            BufferedImage image = ImageIO.read(new File(inputImage));
            String[][] imageArray = new String[image.getWidth()][image.getHeight()];
            
            for (int x = 0; x < image.getWidth(); x++) {
                for (int y = 0; y < image.getHeight(); y++) {
                    color = image.getRGB(x, y);
                    red =   (color >> 16) & 0xFF;
                    green = (color >>  8) & 0xFF;
                    blue =  (color) & 0xFF;                                        
                    if (red+green+blue < 600) {
                        imageArray[x][y] = "1";
                    } else {
                        imageArray[x][y] = "0";
                    }                    
                }
            }
                        
            for (int x = 0; x < image.getWidth(); x++) {
                for (int y = 0; y < image.getHeight();) {
                    String binStr = imageArray[x][y++] + imageArray[x][y++] + 
                                    imageArray[x][y++] + imageArray[x][y++] +
                                    imageArray[x][y++] + imageArray[x][y++] +
                                    imageArray[x][y++] + imageArray[x][y++];
                    int decimal = Integer.parseInt(binStr, 2);
                    String hexStr = Integer.toString(decimal, 16);
                    out.print("0b" + binStr + " 0x" + hexStr + "\t");
                }
                out.println();
            }
        } catch (FileNotFoundException fileNotFound) {
         fileNotFound.printStackTrace();
        } catch (IOException ioException) {
         ioException.printStackTrace();
        } catch (Exception exception) {
         exception.printStackTrace();
        }
    }
}