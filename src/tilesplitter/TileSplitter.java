package tilesplitter;

import java.awt.image.*; 
import javax.imageio.*; 
import java.io.*;
import java.util.Random;

class TileSplitter {

    
    BufferedImage input, output, testImage;
    static BufferedImage testOut; 
    BufferedImage[] testArray;
    BufferedImage[][] tileArray = new BufferedImage[16][16];
    int imageWidth = 0, imageHeight = 0;
    int subImageWidth = 8;
    int subImageHeight = 12;

    
    //
    public void LoadImage() {
        try {
            input = ImageIO.read(new File("c:\\java\\images\\curses.bmp"));
            imageWidth = input.getWidth();
            imageHeight = input.getHeight();
            System.out.println("imageWidth = " + imageWidth);
            System.out.println("imageHeight = " + imageHeight);
            //       output = ImageIO.write(input, "c:\\java\\images\\out.bmp", null)
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    // method to capture and save a SubImage of "input"
    public void ShowImage(BufferedImage test) 
    {
        try {
            BufferedImage output = test;
            File fo = new File("C:\\java\\images\\newimages20170104.png"); 
            ImageIO.write(output, "JPG", fo);
        }
        catch (IOException e)
        {
            System.out.println("Writing to output failed.");
        }
    }
    
    
    // Initial method to capture and save a Sub-Image of "input"
    public BufferedImage SaveImage() 
    {
        int x = 0, y = 0, w = subImageWidth, h = subImageHeight;     // width is 8, height is 12

        try {
            for (int row = 0; row <= 15; row++) {
                System.out.println("row = " + row);
                for (int column = 0; column <= 15; column++) // was column <= 15
                {
                    System.out.println("column = " + column + ", x = " + x + ", y = " + y);
                    tileArray[row][column] = input.getSubimage(x, y, w, h);
                    x = x + 8;                                            

                }
                x = 0;
                y = y + 12;
            }
            return testImage = tileArray[7][7];
        } finally {
        }
    }

    // Returns a random 8 x 12 sub-image from our Buffered Image input
    public BufferedImage getRandomImage() {

        Random randomRow = new Random();
        int rowIndex = (randomRow.nextInt(16)) * 8;

        Random randomColumn = new Random();
        int columnIndex = (randomColumn.nextInt(16)) * 12;

        System.out.println("rowIndex = " + rowIndex + ", columnIndex = " + columnIndex);

        return input.getSubimage(rowIndex, columnIndex, subImageWidth, subImageHeight);
    }

    
    public static void main(String args[]) {
        TileSplitter splitter = new TileSplitter();
        splitter.LoadImage();
        //	testOut = splitter.SaveImage(); // Capture and save the SubImage
        testOut = splitter.getRandomImage();
        splitter.ShowImage(testOut);
    }
}