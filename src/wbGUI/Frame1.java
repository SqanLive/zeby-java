package wbGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame1 {

	private JFrame frmZebyrtgdeluxejava;

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
		
		JButton btnNewButton = new JButton("Open");
		btnNewButton.setBounds(1149, 11, 125, 70);
		frmZebyrtgdeluxejava.getContentPane().add(btnNewButton);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(1149, 92, 125, 70);
		frmZebyrtgdeluxejava.getContentPane().add(btnSave);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(1149, 173, 125, 70);
		frmZebyrtgdeluxejava.getContentPane().add(btnClear);
		
		JButton btnApplyChanges = new JButton("Apply Changes");
		btnApplyChanges.setBounds(1149, 254, 125, 70);
		frmZebyrtgdeluxejava.getContentPane().add(btnApplyChanges);
		
		JButton btnUndo = new JButton("Undo");
		btnUndo.setBounds(1149, 335, 125, 70);
		frmZebyrtgdeluxejava.getContentPane().add(btnUndo);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(1149, 416, 125, 70);
		frmZebyrtgdeluxejava.getContentPane().add(btnExit);
		
		JButton btnSharpen = new JButton("Sharpen");
		btnSharpen.setBounds(1149, 780, 125, 70);
		frmZebyrtgdeluxejava.getContentPane().add(btnSharpen);
		
		JButton btnEmboss = new JButton("Emboss");
		btnEmboss.setBounds(1149, 699, 125, 70);
		frmZebyrtgdeluxejava.getContentPane().add(btnEmboss);
		
		JButton btnInvert = new JButton("Invert");
		btnInvert.setBounds(1149, 618, 125, 70);
		frmZebyrtgdeluxejava.getContentPane().add(btnInvert);
		
		JButton btnMonochromatic = new JButton("Monochromatic");
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
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Stretch");
		chckbxNewCheckBox.setBounds(686, 780, 97, 23);
		frmZebyrtgdeluxejava.getContentPane().add(chckbxNewCheckBox);
		
		JCheckBox chckbxAutoZoom = new JCheckBox("Auto Zoom");
		chckbxAutoZoom.setBounds(686, 814, 97, 23);
		frmZebyrtgdeluxejava.getContentPane().add(chckbxAutoZoom);
		
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
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 1129, 758);
		frmZebyrtgdeluxejava.getContentPane().add(panel);
	}
}
