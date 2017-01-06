package tilesplitter;

import java.awt.image.*; // for using images
import javax.imageio.*; // for the BufferedImage class and its methods
import java.io.*; // supports input and output

class TileSplitter
{
	BufferedImage input, output, testImage, testOut; // create a variable of type BufferedImage to hold our image
	BufferedImage[] testArray;
	BufferedImage[][] tileArray;
	int imageWidth=0, imageHeight=0;
        
	public void LoadImage() // method to load the image for manipulation

	{
		try
		{
			input = ImageIO.read(new File("c:\\java\\images\\curses.bmp")); // assigning the image to the variable "input"
			imageWidth = input.getWidth();
			imageHeight = input.getHeight();
                        System.out.println("imageWidth = " + imageWidth);
                        System.out.println("imageHeight = " + imageHeight);
                 //       output = ImageIO.write(input, "c:\\java\\images\\out.bmp", null)
		}
		catch(Exception e)
		{
			System.out.println(e.toString()); // minimal error handling, add more later to alert user if image fails to load
		}
	}

	public void ShowImage(BufferedImage test) // method to capture and save a SubImage of "input"
	{
		try
		{
			BufferedImage output = test;		//input.getSubimage(0,0,5,5); // Establish a BI variable "output" and assign to it the value
			File fo = new File("C:\\java\\images\\newimages20170104.png"); // the piece of "input" that starts at position 0,0 and extends 50p
			ImageIO.write(output,"JPG",fo); // right and 50p down. The subimage is written to a new file called
			} // "newimages2" and is converted from .bmp to .jpg.
		catch (IOException e) // minimal error handling, add more later
		{
		}
	}

	public BufferedImage SaveImage() // method to capture and save a SubImage of "input"
	{
		int x = 0, y = 0, w = 8, h = 12;     // width was 8, height was 12
	//	testArray = new BufferedImage[16];
		tileArray = new BufferedImage[imageWidth/8][imageHeight/12]; // divisors were 8 and 12 respectively, both values = 16

		try
		{
			for (int row = 0; row <= 15; row++)
			{
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
			return testImage = tileArray[3][6];
			}
		finally{}
		}
/* {
BufferedImage output;
int x=0, y=0, w=8, h=12;
try
{
for (int column = 0; column <= imageWidth; column =+ 12)
{
for (int row = 0; row <= imageHeight; row =+ 8)
{
tileArray[row][column] = input.getSubimage(x, y, w, h);
w += 8;
}
h += 12;
}return output = tileArray[2][2];
// this is a test tile to see if the loop worked
// finally{}
// output = input.getSubimage(x,y,w,h); // Establish a BI variable "output" and assign to it the value
// File fo = new File("C:\\java\\images\\newimages3.jpg"); // the piece of "input" that starts at position 0,0 and extends 50p
// ImageIO.write(output,"JPG",fo); // right and 50p down. The subimage is written to a new file called
} finally{}
// "newimages2" and is converted from .bmp to .jpg.
// catch (IOException e) // minimal error handling, add more later
// {
// }
}*/
	public static void main(String args[]) 
	{
            OutputStream stream;
		BufferedImage testOut = null;
		TileSplitter fout; // declare a variable "fout" of type TileSplitter on which our methods can act
		fout = new TileSplitter(); // establish fout as a new instance of TileSplitter.
		fout.LoadImage(); // call the class method "LoadImage" on fout--to load the image
//		fout.ShowImage(testOut);
		testOut = fout.SaveImage(); // call the class method "SaveImage" on fout--to capture and save the SubImage
		fout.ShowImage(testOut);
/*
{
testOut = tileArray[5][5];
File fo = new File ("c:\\java\\images\\newimages3.jpg");
ImageIO.write(testOut, "JPG", fo);
}
catch (IOException e){} */
}
}

/*
class TileSplitter
{
	BufferedImage input, output, testImage, testOut; // create a variable of type BufferedImage to hold our image
	BufferedImage[] testArray;
	BufferedImage[][] tileArray;
	int imageWidth=0, imageHeight=0;
        
	public void LoadImage() // method to load the image for manipulation

	{
		try
		{
			input = ImageIO.read(new File("c:\\java\\images\\curses.bmp")); // assigning the image to the variable "input"
			imageWidth = input.getWidth();
			imageHeight = input.getHeight();
                        System.out.println("imageWidth = " + imageWidth);
                        System.out.println("imageHeight = " + imageHeight);
                 //       output = ImageIO.write(input, "c:\\java\\images\\out.bmp", null)
		}
		catch(Exception e)
		{
			System.out.println(e.toString()); // minimal error handling, add more later to alert user if image fails to load
		}
	}

	public void ShowImage(BufferedImage test) // method to capture and save a SubImage of "input"
	{
		try
		{
			BufferedImage output = test;		//input.getSubimage(0,0,5,5); // Establish a BI variable "output" and assign to it the value
			File fo = new File("C:\\java\\images\\newimages20170104.png"); // the piece of "input" that starts at position 0,0 and extends 50p
			ImageIO.write(output,"JPG",fo); // right and 50p down. The subimage is written to a new file called
			} // "newimages2" and is converted from .bmp to .jpg.
		catch (IOException e) // minimal error handling, add more later
		{
		}
	}

	public BufferedImage SaveImage() // method to capture and save a SubImage of "input"
	{
		int x = 0, y = 0, w = 40, h = 40;     // width was 8, height was 12
	//	testArray = new BufferedImage[16];
		tileArray = new BufferedImage[imageWidth/16][imageHeight/16]; // divisors were 8 and 12 respectively

		try
		{
			for (int row = 0; row <= 3; row = row + 1)
			{
				for (int column = 0; column <= 3; column = column + 1) // was column <= 15
				{
					tileArray[column][row] = input.getSubimage(x,y,w,h);
					x = x + 4; // was x = x + 7
				}
				y = y + 5; // was y = y + 12
			}
			return testImage = tileArray[1][2];
			}
		finally{}
		}
        */
/* {
BufferedImage output;
int x=0, y=0, w=8, h=12;
try
{
for (int column = 0; column <= imageWidth; column =+ 12)
{
for (int row = 0; row <= imageHeight; row =+ 8)
{
tileArray[row][column] = input.getSubimage(x, y, w, h);
w += 8;
}
h += 12;
}return output = tileArray[2][2];
// this is a test tile to see if the loop worked
// finally{}
// output = input.getSubimage(x,y,w,h); // Establish a BI variable "output" and assign to it the value
// File fo = new File("C:\\java\\images\\newimages3.jpg"); // the piece of "input" that starts at position 0,0 and extends 50p
// ImageIO.write(output,"JPG",fo); // right and 50p down. The subimage is written to a new file called
} finally{}
// "newimages2" and is converted from .bmp to .jpg.
// catch (IOException e) // minimal error handling, add more later
// {
// }
}*/
/*	public static void main(String args[]) 
	{
            OutputStream stream;
		BufferedImage testOut = null;
		TileSplitter fout; // declare a variable "fout" of type TileSplitter on which our methods can act
		fout = new TileSplitter(); // establish fout as a new instance of TileSplitter.
		fout.LoadImage(); // call the class method "LoadImage" on fout--to load the image
//		fout.ShowImage(testOut);
		testOut = fout.SaveImage(); // call the class method "SaveImage" on fout--to capture and save the SubImage
		fout.ShowImage(testOut);
*/
/*
{
testOut = tileArray[5][5];
File fo = new File ("c:\\java\\images\\newimages3.jpg");
ImageIO.write(testOut, "JPG", fo);
}
catch (IOException e){} */
//}
//} 