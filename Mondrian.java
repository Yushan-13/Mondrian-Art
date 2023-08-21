import java.util.*;
import java.awt.*;

/*
Yushan Huang CSE 123 BK
This Mondrian class generates basic Mondrian art and comoplex Mondrian art
by randomly splitting the canvas with height and width limit and filling random
color into each region.
*/
public class Mondrian {
          
    /*
    generating a basic mondiran art by splitting the canvas by randomly chosen vertical lines
    and horizontal lines while guaranteeing that the splitted region is at least 10 pixels by 10 pixels,
    and fill random color from white, red, yellow, and cyan in the region which is small enough.
    parameter:
    pixels: the 2d array of color of the whole canvas
    */
    public void paintBasicMondrian(Color[][] pixels){
        int length = pixels.length;
        int width = pixels[0].length;
        int x_1 = 0;
        int y_1 = 0;
        int x_2 = length;
        int y_2 = width;
        paintBasicMondrian(length, width, x_1, y_1, x_2, y_2, pixels);
    }

    /*
    private pair of the public method
    parameter: 
    length: the number of pixels of the length of the canvas
    width: the number of pixels of the width of the canvas.
    x_1: the x coordinate of the left boundary of the region
    x_2: the x coordinate of the right boundary of the region
    y_1: the y coordinate of the upper boundary of the region
    y_2: the y coordinate of the lower boundary of the region
    pixels: the 2d array of color of the whole canvas
    */
    private void paintBasicMondrian(int length, int width, int x_1, 
    int y_1, int x_2, int y_2, Color[][] pixels){//x - length, y - width, the region
        if (x_2 - x_1 < (0.25) * length && y_2 - y_1 < (0.25) * width){
            fillColor(pixels, x_1, y_1, x_2, y_2);
        }else if (x_2 - x_1 >= (0.25) * length && y_2 - y_1 < (0.25) * width){
            // recursive 2
            // split by vertical line
            int x_split = (int)(Math.random() * (x_2 - x_1 - 20) + x_1 + 10);
            paintBasicMondrian(length, width, x_1, y_1, x_split, y_2, pixels);
            paintBasicMondrian(length, width, x_split, y_1, x_2, y_2, pixels);
        }else if(x_2 - x_1 < (0.25) * length && y_2 - y_1 >= (0.25) * width){
            // recursive 3
            // split by horizontal line
            int y_split = (int)(Math.random() * (y_2 - y_1 - 20) + y_1 + 10);
            paintBasicMondrian(length, width, x_1, y_1, x_2, y_split, pixels);
            paintBasicMondrian(length, width, x_1, y_split, x_2, y_2, pixels);
        }else{
            // recursive 1
            int x_split = (int)(Math.random() * (x_2 - x_1 - 20) + x_1 + 10);
            int y_split = (int)(Math.random() * (y_2 - y_1 - 20) + y_1 + 10);
            // split
            paintBasicMondrian(length, width, x_1, y_1, x_split, y_split, pixels);
            paintBasicMondrian(length, width, x_1, y_split, x_split, y_2, pixels);
            paintBasicMondrian(length, width, x_split, y_1, x_2, y_split, pixels);
            paintBasicMondrian(length, width, x_split, y_split, x_2, y_2, pixels);
        }
    }

    /*
    helper method to get a random color from red, yellow, cyan, and white
    return: the random color generated.
    */
    public static Color getRandom(){
        Color[] random = {Color.RED, Color.YELLOW, Color.CYAN, Color.WHITE};
        return random[(int)(Math.random() * 4)];
    }

    /*
    helper method to fill the selected region with the random color
    parameter:
    pixels: an 2d array of color which represents the region selected
    x1, y1: integers which show the coordinate of the upper left point
    x2, y2: integers which show the coordinate of the lower right point of the region
    */
    public static void fillColor(Color[][] pixels, int x1, int y1, int x2, int y2){
        Color newColor = getRandom();
        for (int i = x1 + 1; i < x2; i++) {
            for (int j = y1 + 1; j < y2; j++) {
                pixels[i][j] = newColor;
            }
        }
    }

    /*
    generating a complex mondiran art by splitting the canvas by randomly chosen vertical lines
    and horizontal lines while guaranteeing that the splitted region is at least 10 pixels by 10 pixels,
    and fill random color from white, red, yellow, and cyan in the region which is small enough,
    but the color changes based on the location, the righter, the redder, the lower, the bluer.
    parameter:
    pixels: the 2d array of color of the whole canvas
    */
    public void paintComplexMondrian(Color[][] pixels){ // Color Related to Location
        int length = pixels.length;
        int width = pixels[0].length;
        int x_1 = 0;
        int y_1 = 0;
        int x_2 = length;
        int y_2 = width;
        paintComplexMondrian(length, width, x_1, y_1, x_2, y_2, pixels);
    }

    /*
    private pair of the public method
    parameter: 
    length: the number of pixels of the length of the canvas
    width: the number of pixels of the width of the canvas.
    x_1: the x coordinate of the left boundary of the region
    x_2: the x coordinate of the right boundary of the region
    y_1: the y coordinate of the upper boundary of the region
    y_2: the y coordinate of the lower boundary of the region
    pixels: the 2d array of color of the whole canvas
    */
    private void paintComplexMondrian(int length, int width, int x_1, 
    int y_1, int x_2, int y_2, Color[][] pixels){//x - length, y - width, the region
        if (x_2 - x_1 < (0.25) * length && y_2 - y_1 < (0.25) * width){
            fillColor2(pixels, x_1, y_1, x_2, y_2, length, width);
        }else if (x_2 - x_1 >= (0.25) * length && y_2 - y_1 < (0.25) * width){
            // recursive 2
            // split by vertical line
            int x_split = (int)(Math.random() * (x_2 - x_1 - 20) + x_1 + 10);
            paintComplexMondrian(length, width, x_1, y_1, x_split, y_2, pixels);
            paintComplexMondrian(length, width, x_split, y_1, x_2, y_2, pixels);
        }else if(x_2 - x_1 < (0.25) * length && y_2 - y_1 >= (0.25) * width){
            // recursive 3
            // split by horizontal line
            int y_split = (int)(Math.random() * (y_2 - y_1 - 20) + y_1 + 10);
            paintComplexMondrian(length, width, x_1, y_1, x_2, y_split, pixels);
            paintComplexMondrian(length, width, x_1, y_split, x_2, y_2, pixels);
        }else{
            // recursive 1
            int x_split = (int)(Math.random() * (x_2 - x_1 - 20) + x_1 + 10);
            int y_split = (int)(Math.random() * (y_2 - y_1 - 20) + y_1 + 10);
            // split
            paintComplexMondrian(length, width, x_1, y_1, x_split, y_split, pixels);
            paintComplexMondrian(length, width, x_1, y_split, x_split, y_2, pixels);
            paintComplexMondrian(length, width, x_split, y_1, x_2, y_split, pixels);
            paintComplexMondrian(length, width, x_split, y_split, x_2, y_2, pixels);
        }
    }

    /*
    helper method to fill the selected region with the random color, and based on the region
    change the color. Righter the region is, redder the color, and lower the region is,
    bluer the color.
    parameter:
    pixels: an 2d array of color which represents the region selected
    x1, y1: integers which show the coordinate of the upper left point
    x2, y2: integers which show the coordinate of the lower right point of the region
    length: the number of pixels of the length of the canvas
    width: the number of pixels of the width of the canvas.
    */
    public static void fillColor2(Color[][] pixels, int x1, int y1, int x2, int y2,
    int length, int width){
        Color newColor = getRandom();
        int red = newColor.getRed();
        int green = newColor.getGreen();
        int blue = newColor.getBlue();
        Color alter = new Color(Math.max(red - (200 * x1 / length), 0),
        green, Math.max(blue - (200 * y1 / width), 0));
        for (int i = x1 + 1; i < x2; i++) {
            for (int j = y1 + 1; j < y2; j++) { 
                pixels[i][j] = alter;
            }
        }
    }
    
    
    
}
