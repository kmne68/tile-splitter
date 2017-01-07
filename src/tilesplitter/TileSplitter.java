package tilesplitter;

import java.awt.image.*; // for using images
import javax.imageio.*; // for the BufferedImage class and its methods
import java.io.*; // supports input and output
import java.util.Random;

class TileSplitter {

    BufferedImage input, output, testImage;
    static BufferedImage testOut; // create a variable of type BufferedImage to hold our image
    BufferedImage[] testArray;
    BufferedImage[][] tileArray = new BufferedImage[16][16];
    int imageWidth = 0, imageHeight = 0;
    int subImageWidth = 8;
    int subImageHeight = 12;

    public void LoadImage() {
        try {
            input = ImageIO.read(new File("c:\\java\\images\\curses.bmp")); // assigning the image to the variable "input"
            imageWidth = input.getWidth();
            imageHeight = input.getHeight();
            System.out.println("imageWidth = " + imageWidth);
            System.out.println("imageHeight = " + imageHeight);
            //       output = ImageIO.write(input, "c:\\java\\images\\out.bmp", null)
        } catch (Exception e) {
            System.out.println(e.toString()); // minimal error handling, add more later to alert user if image fails to load
        }
    }

    public void ShowImage(BufferedImage test) // method to capture and save a SubImage of "input"
    {
        try {
            BufferedImage output = test;		//input.getSubimage(0,0,5,5); // Establish a BI variable "output" and assign to it the value
            File fo = new File("C:\\java\\images\\newimages20170104.png"); // the piece of "input" that starts at position 0,0 and extends 50p
            ImageIO.write(output, "JPG", fo); // right and 50p down. The subimage is written to a new file called
        } // "newimages2" and is converted from .bmp to .jpg.
        catch (IOException e) // minimal error handling, add more later
        {
        }
    }

    public BufferedImage SaveImage() // method to capture and save a SubImage of "input"
    {
        int x = 0, y = 0, w = subImageWidth, h = subImageHeight;     // width was 8, height was 12
        //	testArray = new BufferedImage[16];
        //	tileArray = new BufferedImage[imageWidth/8][imageHeight/12]; // divisors were 8 and 12 respectively, both values = 16

        try {
            for (int row = 0; row <= 15; row++) {
                System.out.println("row = " + row);
                for (int column = 0; column <= 15; column++) // was column <= 15
                {
                    System.out.println("column = " + column + ", x = " + x + ", y = " + y);
                    tileArray[row][column] = input.getSubimage(x, y, w, h);    // (x, y, w, h) row and column were reversed as indices
                    x = x + 8; // was x = x + 7                                            

                }
                x = 0;
                y = y + 12; // was y = y + 12
            }
            return testImage = tileArray[7][7];
        } finally {
        }
    }

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
        splitter.LoadImage(); // call the class method "LoadImage" on splitter--to load the image
        //	testOut = splitter.SaveImage(); // call the class method "SaveImage" on splitter--to capture and save the SubImage
        testOut = splitter.getRandomImage();
        splitter.ShowImage(testOut);
    }
}