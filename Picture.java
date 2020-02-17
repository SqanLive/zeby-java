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
	 
	 //KONSTRUKTOR
	 public Picture(BufferedImage processed_image) {
		 System.out.println("Constructor");
		 image = processed_image;
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
	    			Picture Nowy = new Picture(ImageIO.read(selectedFile));
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
	        		ImageIO.write(image, "PNG", final_file); 
	        	  //ImageIO.write(image, "png", new File("C://Users/Sqan/Desktop/igh.png")); // ROBI PNG 
				
	    		}
	        	  
	  
	            System.out.println("Writing complete."); 
	        } 
	        catch(IOException e) 
	        { 
	            System.out.println("Error: "+e); 
	        } 
	 }
	 
	 public static void Monochromatic(BufferedImage image) {
		 
		 
		 
		 try
	        { 
				 int width = image.getWidth();
				 int height = image.getHeight();
				 
				 for(int i=0; i<height; i++) {
			         
			            for(int j=0; j<width; j++) {
			            
			               Color c = new Color(image.getRGB(j, i));
			               int red = (int)(c.getRed() * 0.299);
			               int green = (int)(c.getGreen() * 0.587);
			               int blue = (int)(c.getBlue() *0.114);
			               Color newColor = new Color(red+green+blue,red+green+blue,red+green+blue);   
			               image.setRGB(j,i,newColor.getRGB());
			            }
			      }
				 finalimage =  image;
				 System.out.println("Monochrome complete."); 
	        } 
	        catch(Exception e) 
	        { 
	            System.out.println("Error: "+e); 
	        } 
	 }
	 
	 public static void Invert(BufferedImage image) {
		 
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
			               image.setRGB(j,i,newColor.getRGB());
			            }
			      }
				 finalimage =  image;
				 System.out.println("Invert complete."); 
	        } 
	        catch(Exception e) 
	        { 
	            System.out.println("Error: "+e); 
	        } 
	 }
	 
	 public static void Undo() {
		 
		 finalimage = image;
		 
	 }
	
	
}
