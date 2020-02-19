package wbGUI;

import wbGUI.Picture;
import wbGUI.Opener;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.*;

public class Frame1 {

	private JFrame frmZebyrtgdeluxejava;
	
	BufferedImage FrameImage;
	Picture Nowy;
	int brightness_value;
	int contrast_value;
	int gamma_value;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
					window.frmZebyrtgdeluxejava.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	/**
	 * Create the application.
	 */
	public Frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmZebyrtgdeluxejava = new JFrame();
		frmZebyrtgdeluxejava.setTitle("ZebyRTGDeluxeJava");
		frmZebyrtgdeluxejava.setBounds(100, 100, 1300, 900);
		frmZebyrtgdeluxejava.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmZebyrtgdeluxejava.getContentPane().setLayout(null);
		
		
		
		JLabel ImageLabel = new JLabel("", JLabel.CENTER);
		ImageLabel.setBounds(10, 11, 1129, 758);
		frmZebyrtgdeluxejava.getContentPane().add(ImageLabel);
		
		JButton btnOpen = new JButton("Open");
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		//		OpenFile of = new OpenFile();
		//		String path = of.Open();
		//		//ImageLabel.setIcon(ResizeImage(path, ImageLabel));
				
		//		ImageIcon icon = new ImageIcon(path);
		//		ImageLabel.setIcon(icon);
			
				Picture.LoadPicture();
		//		FrameImage = Nowy.image;
				ImageIcon icon = new ImageIcon(Nowy.image);
				ImageLabel.setIcon(icon);
				
			}
		});
		btnOpen.setBounds(1149, 11, 125, 70);
		frmZebyrtgdeluxejava.getContentPane().add(btnOpen);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Picture.SavePicture();
				
			}
		});
		btnSave.setBounds(1149, 92, 125, 70);
		frmZebyrtgdeluxejava.getContentPane().add(btnSave);
		
	
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(1149, 416, 125, 70);
		frmZebyrtgdeluxejava.getContentPane().add(btnExit);
		
		JButton btnSharpen = new JButton("Sharpen");
		btnSharpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Picture.Sharpen(Nowy.image, Nowy.finalimage);
				ImageIcon icon = new ImageIcon(Nowy.finalimage);
				ImageLabel.setIcon(icon);
			}
		});
		btnSharpen.setBounds(1149, 780, 125, 70);
		frmZebyrtgdeluxejava.getContentPane().add(btnSharpen);
		
		JButton btnEmboss = new JButton("Emboss");
		btnEmboss.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Picture.Emboss(Nowy.image, Nowy.finalimage);
				ImageIcon icon = new ImageIcon(Nowy.finalimage);
				ImageLabel.setIcon(icon);
			}
		});
		btnEmboss.setBounds(1149, 699, 125, 70);
		frmZebyrtgdeluxejava.getContentPane().add(btnEmboss);
		
		JButton btnInvert = new JButton("Invert");
		btnInvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Picture.Invert(Nowy.image, Nowy.finalimage);
			//	FrameImage = Picture.finalimage;
				ImageIcon icon = new ImageIcon(Nowy.finalimage);
				ImageLabel.setIcon(icon);
			}
		});
		btnInvert.setBounds(1149, 618, 125, 70);
		frmZebyrtgdeluxejava.getContentPane().add(btnInvert);
		
		JButton btnMonochromatic = new JButton("Monochromatic");
		btnMonochromatic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Picture.Monochromatic(Nowy.image, Nowy.finalimage);
			//	FrameImage = Picture.finalimage;
				ImageIcon icon = new ImageIcon(Nowy.finalimage);
				ImageLabel.setIcon(icon);
			}
		});
		btnMonochromatic.setBounds(1149, 537, 125, 70);
		frmZebyrtgdeluxejava.getContentPane().add(btnMonochromatic);
		
		JButton btnNoiseRemoval = new JButton("Noise Removal");
		btnNoiseRemoval.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Picture.Noise(Nowy.image, Nowy.finalimage);
				ImageIcon icon = new ImageIcon(Nowy.finalimage);
				ImageLabel.setIcon(icon);
			}
		});
		btnNoiseRemoval.setBounds(1014, 780, 125, 70);
		frmZebyrtgdeluxejava.getContentPane().add(btnNoiseRemoval);
		
		JButton btnAutoAdjustment = new JButton("Auto Adjustment");
		btnAutoAdjustment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Picture.Auto(Nowy.image, Nowy.finalimage, Nowy.processimage);
				ImageIcon icon = new ImageIcon(Nowy.finalimage);
				ImageLabel.setIcon(icon);
			}
		});
		btnAutoAdjustment.setBounds(10, 780, 125, 70);
		frmZebyrtgdeluxejava.getContentPane().add(btnAutoAdjustment);
		
		JLabel brightness_label = new JLabel("Brightness");
		brightness_label.setBounds(198, 818, 70, 30);
		frmZebyrtgdeluxejava.getContentPane().add(brightness_label);
		
		JLabel contrast_label = new JLabel("Contrast");
		contrast_label.setBounds(358, 818, 70, 30);
		frmZebyrtgdeluxejava.getContentPane().add(contrast_label);
		
		JLabel gamma_label = new JLabel("Gamma");
		gamma_label.setBounds(518, 818, 70, 30);
		frmZebyrtgdeluxejava.getContentPane().add(gamma_label);
		
		JSlider brightness = new JSlider();
		JSlider contrast = new JSlider();
		JSlider gamma = new JSlider();


		brightness.setValue(0);
		brightness.setMinimum(-255);
		brightness.setMaximum(255);
		brightness.setBounds(145, 780, 150, 40);
		brightness.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				brightness_value = brightness.getValue();
				brightness_label.setText("" + brightness_value);
				Picture.Brightness(Nowy.image, Nowy.finalimage, brightness_value);
				ImageIcon icon = new ImageIcon(Nowy.finalimage);
				ImageLabel.setIcon(icon);
				contrast.setValue(0);
				contrast_label.setText("Contrast");
				gamma.setValue(5);
				gamma_label.setText("Gamma");
			}
		});
		frmZebyrtgdeluxejava.getContentPane().add(brightness);
		
		contrast.setValue(0);
		contrast.setMinimum(-100);
		contrast.setBounds(305, 780, 150, 40);
		contrast.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				contrast_value = contrast.getValue();
				contrast_label.setText(""+ contrast_value);
				Picture.Contrast(Nowy.image, Nowy.finalimage, contrast_value);
				ImageIcon icon = new ImageIcon(Nowy.finalimage);
				ImageLabel.setIcon(icon);
				brightness.setValue(0);
				brightness_label.setText("Brightness");
				gamma.setValue(5);
				gamma_label.setText("Gamma");
				
			}
		});
		frmZebyrtgdeluxejava.getContentPane().add(contrast);
		
		gamma.setValue(5);
		gamma.setMinimum(1);
		gamma.setMaximum(25);
		gamma.setBounds(465, 780, 150, 40);
		gamma.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				gamma_value = gamma.getValue();
				gamma_label.setText(""+ gamma_value);
				Picture.Gamma(Nowy.image, Nowy.finalimage, gamma_value);
				ImageIcon icon = new ImageIcon(Nowy.finalimage);
				ImageLabel.setIcon(icon);
				brightness.setValue(0);
				brightness_label.setText("Brightness");
				contrast.setValue(0);
				contrast_label.setText("Contrast");
				
			}
		});
		frmZebyrtgdeluxejava.getContentPane().add(gamma);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageLabel.setIcon(null);
				Nowy.image = null;
				Nowy.finalimage = null;
				Nowy.processimage = null;
				brightness.setValue(0);
				brightness_label.setText("Brightness");
				contrast.setValue(0);
				contrast_label.setText("Contrast");
				gamma.setValue(5);
				gamma_label.setText("Gamma");
			}
		});
		btnClear.setBounds(1149, 173, 125, 70);
		frmZebyrtgdeluxejava.getContentPane().add(btnClear);
		
		JButton btnApplyChanges = new JButton("Apply Changes");
		btnApplyChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Picture.Apply(Nowy.image, Nowy.finalimage);
			//	Nowy.image = Nowy.finalimage;
				ImageIcon icon = new ImageIcon(Nowy.finalimage);
				ImageLabel.setIcon(icon);
			}
		});
		btnApplyChanges.setBounds(1149, 254, 125, 70);
		frmZebyrtgdeluxejava.getContentPane().add(btnApplyChanges);
		
		JButton btnUndo = new JButton("Undo");
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("przed");
				ImageLabel.setIcon(null);
				Picture.Undo(Nowy.image, Nowy.finalimage);
				//Nowy.finalimage = Nowy.image;
			//	FrameImage = Nowy.finalimage;
				Nowy.finalimage = Nowy.image;
				Picture.finalimage = Picture.image;
				ImageIcon icon = new ImageIcon(Nowy.finalimage);
				ImageLabel.setIcon(icon);
				System.out.println("po");
				//zabawa
				File outputfile = new File("C:\\\\Users\\\\Sqan\\\\Desktop\\image.png");
				File outputfile2 = new File("C:\\\\Users\\\\Sqan\\\\Desktop\\finalimage.png");
				try {
					ImageIO.write(Nowy.image, "PNG", outputfile);
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} 
				try {
					ImageIO.write(Nowy.finalimage, "PNG", outputfile2);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				//zabawa
			}
		});
		btnUndo.setBounds(1149, 335, 125, 70);
		frmZebyrtgdeluxejava.getContentPane().add(btnUndo);
		
		
		
		
	}
	
public ImageIcon ResizeImage(String ImagePath, JLabel ImageLabel) {
		
		ImageIcon MyImage = new ImageIcon(ImagePath);
		Image img = MyImage.getImage();
		Image newImg = img.getScaledInstance(ImageLabel.getWidth(), ImageLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		return image;
	}

public void CheckboxStateChange(ItemEvent e, JCheckBox StretchCheckBox, JCheckBox AutoZoomCheckBox, JLabel ImageLabel, String path){
	
	System.out.println("XD");
	if(e.getStateChange() == ItemEvent.SELECTED) {
		
		ImageLabel.setIcon(ResizeImage(path, ImageLabel));
			
	}
	else {
		ImageIcon icon = new ImageIcon(path);
		ImageLabel.setIcon(icon);
	}
}

	
}


