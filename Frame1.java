package wbGUI;

import wbGUI.Picture;
import wbGUI.Opener;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame1 {

	private JFrame frmZebyrtgdeluxejava;
	
	BufferedImage FrameImage;
	Picture Nowy;

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
				FrameImage = Nowy.image;
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
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageLabel.setIcon(null);
			}
		});
		btnClear.setBounds(1149, 173, 125, 70);
		frmZebyrtgdeluxejava.getContentPane().add(btnClear);
		
		JButton btnApplyChanges = new JButton("Apply Changes");
		btnApplyChanges.setBounds(1149, 254, 125, 70);
		frmZebyrtgdeluxejava.getContentPane().add(btnApplyChanges);
		
		JButton btnUndo = new JButton("Undo");
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Picture.Undo();
				FrameImage = Picture.finalimage;
				ImageIcon icon = new ImageIcon(FrameImage);
				ImageLabel.setIcon(icon);
			}
		});
		btnUndo.setBounds(1149, 335, 125, 70);
		frmZebyrtgdeluxejava.getContentPane().add(btnUndo);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(1149, 416, 125, 70);
		frmZebyrtgdeluxejava.getContentPane().add(btnExit);
		
		JButton btnSharpen = new JButton("Sharpen");
		btnSharpen.setBounds(1149, 780, 125, 70);
		frmZebyrtgdeluxejava.getContentPane().add(btnSharpen);
		
		JButton btnEmboss = new JButton("Emboss");
		btnEmboss.setBounds(1149, 699, 125, 70);
		frmZebyrtgdeluxejava.getContentPane().add(btnEmboss);
		
		JButton btnInvert = new JButton("Invert");
		btnInvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Picture.Invert(FrameImage);
				FrameImage = Picture.finalimage;
				ImageIcon icon = new ImageIcon(FrameImage);
				ImageLabel.setIcon(icon);
			}
		});
		btnInvert.setBounds(1149, 618, 125, 70);
		frmZebyrtgdeluxejava.getContentPane().add(btnInvert);
		
		JButton btnMonochromatic = new JButton("Monochromatic");
		btnMonochromatic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Picture.Monochromatic(FrameImage);
				FrameImage = Picture.finalimage;
				ImageIcon icon = new ImageIcon(FrameImage);
				ImageLabel.setIcon(icon);
			}
		});
		btnMonochromatic.setBounds(1149, 537, 125, 70);
		frmZebyrtgdeluxejava.getContentPane().add(btnMonochromatic);
		
		JButton btnNoiseRemoval = new JButton("Noise Removal");
		btnNoiseRemoval.setBounds(1014, 780, 125, 70);
		frmZebyrtgdeluxejava.getContentPane().add(btnNoiseRemoval);
		
		JButton btnAutoAdjustment = new JButton("Auto Adjustment");
		btnAutoAdjustment.setBounds(10, 780, 125, 70);
		frmZebyrtgdeluxejava.getContentPane().add(btnAutoAdjustment);
		
		JButton btnRotate = new JButton("Rotate");
		btnRotate.setBounds(798, 780, 125, 70);
		frmZebyrtgdeluxejava.getContentPane().add(btnRotate);
		
		JCheckBox StretchCheckBox = new JCheckBox("Stretch");
		StretchCheckBox.setBounds(686, 780, 97, 23);
		frmZebyrtgdeluxejava.getContentPane().add(StretchCheckBox);
		
		JCheckBox AutoZoomCheckBox = new JCheckBox("Auto Zoom");
		AutoZoomCheckBox.setBounds(686, 814, 97, 23);
		frmZebyrtgdeluxejava.getContentPane().add(AutoZoomCheckBox);
		
		JSlider slider = new JSlider();
		slider.setValue(0);
		slider.setMinimum(-255);
		slider.setMaximum(255);
		slider.setBounds(145, 780, 150, 40);
		frmZebyrtgdeluxejava.getContentPane().add(slider);
		
		JSlider slider_1 = new JSlider();
		slider_1.setValue(0);
		slider_1.setMinimum(-100);
		slider_1.setBounds(305, 780, 150, 40);
		frmZebyrtgdeluxejava.getContentPane().add(slider_1);
		
		JSlider slider_2 = new JSlider();
		slider_2.setValue(5);
		slider_2.setMinimum(1);
		slider_2.setMaximum(25);
		slider_2.setBounds(465, 780, 150, 40);
		frmZebyrtgdeluxejava.getContentPane().add(slider_2);
		
		JLabel lblNewLabel = new JLabel("Brightness");
		lblNewLabel.setBounds(198, 818, 70, 30);
		frmZebyrtgdeluxejava.getContentPane().add(lblNewLabel);
		
		JLabel lblContrast = new JLabel("Contrast");
		lblContrast.setBounds(358, 818, 70, 30);
		frmZebyrtgdeluxejava.getContentPane().add(lblContrast);
		
		JLabel lblGamma = new JLabel("Gamma");
		lblGamma.setBounds(518, 818, 70, 30);
		frmZebyrtgdeluxejava.getContentPane().add(lblGamma);
		
		
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
