package wbGUI;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Picture extends Frame1{

	 static BufferedImage image;
	 
	 static BufferedImage finalimage;
	 
	 static BufferedImage processimage;
	 
	 //KONSTRUKTOR
	 public Picture(BufferedImage processed_image, BufferedImage processed2_image, BufferedImage processed3_image) {
		 System.out.println("Constructor");
		 image = processed_image;
		 finalimage = processed2_image;
		 processimage = processed3_image;
	 };
	 
	 
	 //WCZYTYWANIE OBRAZU
	 public static void LoadPicture() {
		 try
	        { 
	        	JFileChooser file = new JFileChooser();
	    		file.setCurrentDirectory(new File(System.getProperty("user.home")));
	    		FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "png");
	    		file.addChoosableFileFilter(filter);
	    		int result = file.showOpenDialog(null);
	    		
	    		if(result == JFileChooser.APPROVE_OPTION) 
	    		{
	    			File selectedFile = file.getSelectedFile();
	    			Picture Nowy = new Picture(ImageIO.read(selectedFile), ImageIO.read(selectedFile), ImageIO.read(selectedFile));
	    		//	image = ImageIO.read(selectedFile);
	    			
	    			
				
	    		}
	        	  
	            System.out.println("Reading complete."); 
	        } 
	        catch(IOException e) 
	        { 
	            System.out.println("Error: "+e); 
	        } 
	 }
	 
	 
	 // ZAPIS OBRAZU
	 public static void SavePicture() {
	        try
	        { 
	        	JFileChooser out_file = new JFileChooser();
	        	out_file.setCurrentDirectory(new File(System.getProperty("user.home")));
	        	int result_output = out_file.showSaveDialog(null);
	        	
	        	if(result_output == JFileChooser.APPROVE_OPTION) 
	    		{
	        		File final_file = out_file.getSelectedFile();
	        		ImageIO.write(finalimage, "PNG", final_file); 
	        	  //ImageIO.write(image, "png", new File("C://Users/Sqan/Desktop/igh.png")); // ROBI PNG 
				
	    		}
	        	  
	  
	            System.out.println("Writing complete."); 
	        } 
	        catch(IOException e) 
	        { 
	            System.out.println("Error: "+e); 
	        } 
	 }
	 
	 public static void Monochromatic(BufferedImage image, BufferedImage finalimage) {
		 
		 
		 
		 try
	        { 
			 	File outputfile3 = new File("C:\\\\Users\\\\Sqan\\\\Desktop\\3image.png");
			 	try {
					ImageIO.write(image, "PNG", outputfile3);
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} 
			 
				 int width = image.getWidth();
				 int height = image.getHeight();
				 
				 for(int i=0; i<height; i++) {
			         
			            for(int j=0; j<width; j++) {
			            
			               Color c = new Color(image.getRGB(i, j));
			               int red = (int)(c.getRed() * 0.299);
			               int green = (int)(c.getGreen() * 0.587);
			               int blue = (int)(c.getBlue() *0.114);
			               Color newColor = new Color(red+green+blue,red+green+blue,red+green+blue);
			               finalimage.setRGB(i,j,newColor.getRGB());
			            }
			      }
				// finalimage =  image;
				 System.out.println("Monochrome complete."); 
				 File outputfile = new File("C:\\\\Users\\\\Sqan\\\\Desktop\\image.png");
					File outputfile2 = new File("C:\\\\Users\\\\Sqan\\\\Desktop\\finalimage.png");
					try {
						ImageIO.write(image, "PNG", outputfile);
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} 
					try {
						ImageIO.write(finalimage, "PNG", outputfile2);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
	        } 
	        catch(Exception e) 
	        { 
	            System.out.println("Error: "+e); 
	        } 
	 }
	 
	 public static void Invert(BufferedImage image, BufferedImage finalimage) {
		 
		 try
	        { 
				 int width = image.getWidth();
				 int height = image.getHeight();
				 
				 for(int i=0; i<height; i++) {
			         
			            for(int j=0; j<width; j++) {
			            
			               Color c = new Color(image.getRGB(j, i));
			               int red = (int)(255 - c.getRed());
			               int green = (int)(255 - c.getGreen());
			               int blue = (int)(255 - c.getBlue());
			               Color newColor = new Color(red,green,blue);   
			               finalimage.setRGB(j,i,newColor.getRGB());
			            }
			      }
				// finalimage =  image;
				 System.out.println("Invert complete."); 
	        } 
	        catch(Exception e) 
	        { 
	            System.out.println("Error: "+e); 
	        } 
	 }
	 
	 public static void Undo(BufferedImage image, BufferedImage finalimage) {
		 
		 finalimage = image;
		 
	 }
	
	 public static void Apply(BufferedImage image, BufferedImage finalimage) {
		 
		 image = finalimage;
	 }
	 
	 public static void Emboss(BufferedImage image, BufferedImage finalimage) {
		 
		 try
	        { 
				 int width = image.getWidth();
				 int height = image.getHeight();
				 
				 for(int x=1; x<(width -1); x++) {
			         
			            for(int y=1; y<(height - 1); y++) {
			            
			               Color c = new Color(image.getRGB(x, y));
			               Color c2 = new Color(image.getRGB(x+1, y+1));
			               int red = Math.min(Math.abs(c.getRed() - c2.getRed() + 128), 255);
			               int green = Math.min(Math.abs(c.getGreen() - c2.getGreen() + 128), 255);
			               int blue = Math.min(Math.abs(c.getBlue() - c2.getBlue() + 128), 255);
			               Color newColor = new Color(red,green,blue);
			               finalimage.setRGB(x,y,newColor.getRGB());
			            }
			      }
				 System.out.println("Emboss complete."); 
	        } 
	        catch(Exception e) 
	        { 
	            System.out.println("Error: "+e); 
	        } 
		 
	 }
	 
	 public static void Sharpen(BufferedImage image, BufferedImage finalimage) {
		 
		 try
	        { 
				 int width = image.getWidth();
				 int height = image.getHeight();
				 double[][] filter = {{-1,-1,-1},{-1,9,-1},{-1,-1,-1}};
				 
				 for(int x=0; x<width; x++) {
			         
			            for(int y=0; y<height; y++) {
			            
			            	double red = 0;
		                    double green = 0;
		                    double blue = 0;
			            	
			               for(int filterX = 0; filterX < 3; filterX++) {
			            	   
			            	   for(int filterY = 0; filterY < 3; filterY++) {
			            		   
			            		   int imageX = (x - 3 / 2 + filterX + width) % width;
			                       int imageY = (y - 3 / 2 + filterY + height) % height;
			                       
			                       Color c = new Color(image.getRGB(imageX, imageY));
			                       
			                       
			                       red = c.getRed() * filter[filterX][filterY]+red;
			                       green = c.getGreen()* filter[filterX][filterY]+green;
			                       blue = c.getBlue()* filter[filterX][filterY]+blue;
			                       
			            	   }
			            	   int r = (int) Math.min(Math.max(red, 0), 255);
			            	   int g = (int) Math.min(Math.max(green, 0), 255);
			            	   int b = (int) Math.min(Math.max(blue, 0), 255);
			            	   Color newColor = new Color(r,g,b);
			            	   finalimage.setRGB(x,y,newColor.getRGB());
			               }
			            }
			      }
				 System.out.println("Sharpen complete."); 
	        } 
	        catch(Exception e) 
	        { 
	            System.out.println("Error: "+e); 
	        } 
		 
	 }
	 
	 
	 public static void Noise(BufferedImage image, BufferedImage finalimage) {
		 
		 try {
		 
			 int width = image.getWidth();
			 int height = image.getHeight();
			 
			 for(int x=4; x<(width-5); x++) {
				 for(int y=4; y<(height-5); y++) {
					 double sumBlue =0;
					 double sumGreen = 0;
					 double sumRed =0;
					 
					 for(int i =-2; i<= 2; i++) {
						 for(int j= -2; j<=2; j++) {
							 
							 Color c = new Color(image.getRGB(x+i, y+j));
							 int red = c.getRed();
							 int green = c.getGreen();
							 int blue = c.getBlue();
							 sumRed = sumRed + red;
							 sumGreen = sumGreen + green;
							 sumBlue = sumBlue+ blue;
							 
						 }
					 }
					 
					 int avred = (int)(sumRed / 25);
					 int avgreen = (int)(sumGreen / 25);
					 int avblue = (int)(sumBlue / 25);
					 Color newColor = new Color(avred,avgreen,avblue);
	          	   	 finalimage.setRGB(x,y,newColor.getRGB());
				 }
			 }
		 }
		 catch(Exception e) 
	     { 
	            System.out.println("Error: "+e); 
	     }
		 
	 }
	 
	 public static void Auto(BufferedImage image, BufferedImage finalimage, BufferedImage processimage) {
		 
		 try {
		 
			 int width = image.getWidth();
			 int height = image.getHeight();
			 int windowsize = 5;
			 int counter = 0;
			 
			 if(width*height < 800*700) {
				 windowsize = 3;
			 }
			 
			 //BLUR
			 for(int row = (windowsize - 1); row<(width-windowsize); row++) {
				 for(int column =(windowsize - 1) ; column < (height - windowsize); column++) {
	                 double sumBlue = 0;
	                 double sumGreen = 0;
	                 double sumRed = 0;
	                 
	                 for (int i = -(windowsize - 1) / 2; i <= (windowsize - 1) / 2; i++)
	                 {
	                     for (int j = -(windowsize - 1) / 2; j <= (windowsize - 1) / 2; j++)
	                     {
	                         int currentX = (row + i );
	                         int currentY = (column + j );
	                         Color c = new Color(image.getRGB(currentX, currentY));
	                         int blue = c.getBlue();
	                         int green = c.getGreen();
	                         int red = c.getRed();
	
	                         sumRed = sumRed + red;
	                         sumGreen = sumGreen + green;
	                         sumBlue = sumBlue + blue;
	                     }
	                 }
	                 int averageRed = (int)(sumRed / (windowsize * windowsize));
	                 int averageGreen = (int)(sumGreen / (windowsize * windowsize));
	                 int averageBlue = (int)(sumBlue / (windowsize * windowsize));
	                 Color newColor = new Color(averageRed,averageGreen,averageBlue);
	          	   	 finalimage.setRGB(row,column,newColor.getRGB());
	          	   	 counter++;
				 }
			 }
			 
			 //MASKA
			 double Suma = 0;
			 
			 for(int x =0; x< width; x++) {
				 
				 for(int y = 0; y < height; y++) {
					 
					 Color c = new Color(image.getRGB(x, y));
					 Color c2 = new Color(finalimage.getRGB(x, y));
					 
					 int oldblue = c.getBlue();
	                 int oldgreen = c.getGreen();
	                 int oldred = c.getRed();
	                 
	                 int blurblue = c2.getBlue();
	                 int blurgreen = c2.getGreen();
	                 int blurred = c2.getRed();
	                 
	                 int R = oldred - blurred;
	                 if (R < 0)
	                 {
	                     R = 0;
	                 }
	                 int G = oldgreen - blurgreen;
	                 if (G < 0)
	                 {
	                     G = 0;
	                 }
	                 int B = oldblue - blurblue;
	                 if (B < 0)
	                 {
	                     B = 0;
	                 }
	                 //Threshold
	                 if (R < 4)
	                 {
	                     R = 0;
	                 }
	                 if (G < 4)
	                 {
	                     G = 0;
	                 }
	                 if (B < 4)
	                 {
	                     B = 0;
	                 }
	                 
	                 Suma +=R; //////TUU
	                 Color c3 = new Color(R, G, B);
	                 processimage.setRGB(x,y,c3.getRGB());
				 }
				 
			 }
			 
			 Suma = Suma / (width * height);
			 double factor = 0.7 + 2 * Suma /5;
			 
			 //DODAWANIE MASKI
			 
			 for (int x = 0; x < width; x++)
	         {
	             for (int y = 0; y < height; y++)
	             {
	            	 Color c = new Color(finalimage.getRGB(x, y));
	            	 Color c2 = new Color(processimage.getRGB(x, y));
	                 int imageBlue = c.getBlue();
	                 int imageGreen = c.getGreen();
	                 int imageRed = c.getRed();
	
	                 int maskBlue = c2.getBlue();
	                 int maskGreen = c2.getGreen();
	                 int maskRed = c2.getRed();
	
	                 int R = 0, G = 0, B = 0;
	                 R = (int) ((maskRed * factor) + imageRed); ;
	                 if (R > 255)
	                 {
	                     R = 255;
	                 }
	                 G = (int) ((maskGreen * factor) + imageGreen); ;
	                 if (G > 255)
	                 {
	                     G = 255;
	                 }
	                 B = (int) ((maskBlue * factor) + imageBlue); ;
	                 if (B > 255)
	                 {
	                     B = 255;
	                 }
	                 Color c3 = new Color(R, G, B);
	                 finalimage.setRGB(x,y,c3.getRGB());
	                 
	             }
	         }
			 
			 
			 //GAMMA
			 
			 double gamma;
	         int red2 = 0;
	
	         for (int x = 0; x < width; x++)
	         {
	             for (int y = 0; y < height; y++)
	             {
	            	 Color c = new Color(finalimage.getRGB(x, y));
	                 int red = c.getRed();
	                 red2 += red;
	             }
	         }
	
	         double suma = red2;
	         suma /= (height * width * 255);
	         gamma = (-0.3) / Math.log10(suma);
	         
	         for (int x = 0; x < width; x++)
	         {
	             for (int y = 0; y < height; y++)
	             {
	            	 Color c = new Color(finalimage.getRGB(x, y));
	                 double blue = c.getBlue();
	                 double green = c.getGreen();
	                 double red = c.getRed();
	                 blue = (255.0 * Math.pow(blue / 255.0, gamma));
	                 green = (255.0 * Math.pow(green / 255.0, gamma));
	                 red = (255.0 * Math.pow(red / 255.0, gamma));
	                 Color newcolor = new Color((int)red, (int)green, (int)blue);                 
	          	     finalimage.setRGB(x,y,newcolor.getRGB());
	
	             }
	         }
			 
		 }
		 catch(Exception e) 
	     { 
	            System.out.println("Error: "+e); 
	     }
	 }
	 
	 public static void Brightness(BufferedImage image, BufferedImage finalimage, int value) {
		 
		 try
	        { 

             int width = image.getWidth();
			 int height = image.getHeight();

             
             for (int x = 0; x < width; x++)
             {
                 for (int y = 0; y < height; y++)
                 {
                     Color c = new Color(image.getRGB(x, y));

                     int cR = c.getRed() + value;
                     int cG = c.getGreen() + value;
                     int cB = c.getBlue() + value;

                     if (cR < 0) cR = 1;
                     if (cR > 255) cR = 255;

                     if (cG < 0) cG = 1;
                     if (cG > 255) cG = 255;

                     if (cB < 0) cB = 1;
                     if (cB > 255) cB = 255;

                     Color newcolor = new Color(cR, cG, cB);                 
	          	     finalimage.setRGB(x,y,newcolor.getRGB());
	          	//     System.out.println(x + " " + y + " " + cR + " " + cG + " " + cB);

                 }
             }
	        } 
	        catch(Exception e) 
	        { 
	            System.out.println("Error: "+e); 
	        } 
		 
	 }
	 
	 public static void Contrast(BufferedImage image, BufferedImage finalimage, int value) {
		 
		 try
	        { 

				 int width = image.getWidth();
				 int height = image.getHeight();
				 double contrast = value;
				 contrast = (100 + contrast)/ 100;
				 contrast *= contrast;
				 
				 for (int x = 0; x < width; x++)
	             {
	                 for (int y = 0; y < height; y++)
	                 {
	                	 Color c = new Color(image.getRGB(x, y));
	                     double pR = c.getRed() / 255.0;
	                     pR -= 0.5;
	                     pR *= contrast;
	                     pR += 0.5;
	                     pR *= 255;
	                     if (pR < 0) pR = 0;
	                     if (pR > 255) pR = 255;
	
	                     double pG = c.getGreen() / 255.0;
	                     pG -= 0.5;
	                     pG *= contrast;
	                     pG += 0.5;
	                     pG *= 255;
	                     if (pG < 0) pG = 0;
	                     if (pG > 255) pG = 255;
	
	                     double pB = c.getBlue() / 255.0;
	                     pB -= 0.5;
	                     pB *= contrast;
	                     pB += 0.5;
	                     pB *= 255;
	                     if (pB < 0) pB = 0;
	                     if (pB > 255) pB = 255;
	
	                     Color newcolor = new Color((int)pR, (int)pG, (int)pB);                 
		          	     finalimage.setRGB(x,y,newcolor.getRGB());
	
	                 }
	          
	          
		        } 
	        }
	        catch(Exception e) 
	        { 
	            System.out.println("Error: "+e); 
	        } 
		 
	 }
	 
	 public static void Gamma(BufferedImage image, BufferedImage finalimage, int value) {
		 
		 try
	        { 

				 int width = image.getWidth();
				 int height = image.getHeight();
				 double gamma = value;
				 gamma = gamma / 5;
				 
				 for (int x = 0; x < width; x++)
	             {
	                 for (int y = 0; y < height; y++)
	                 {
	                	 Color c = new Color(image.getRGB(x, y));
	                     
	                	 double red = c.getRed();
	                	 double green = c.getGreen();
	                	 double blue = c.getBlue();
	                	 
	                	 red = 255.0 * Math.pow( red / 255.0, 1.0 / gamma);
	                	 green = 255.0 *Math.pow( green / 255.0, 1.0 / gamma);
	                	 blue = 255.0 *Math.pow( blue / 255.0, 1.0 / gamma);
	                	 
	                	 
	                     Color newcolor = new Color((int)red, (int)green, (int)blue);                 
		          	     finalimage.setRGB(x,y,newcolor.getRGB());
	
	                 }
	          
	          
		        } 
	        }
	        catch(Exception e) 
	        { 
	            System.out.println("Error: "+e); 
	        } 
		 
		 
	 }
	 
	 
	 
	  
	
}
