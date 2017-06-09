package com.celestial.meek.realTest_2017_05.ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MainPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ImageIcon icon;
	Image img;
	
	
	public MainPanel() {
		icon = new ImageIcon(GraExp.class.getResource("/bkg04.jpg"));
		img = icon.getImage();
		
		JButton jb = new JButton("’ŸªΩ¬‹¿Ú£°");
		jb.setBounds(50, 50, 40, 25);
		this.add(jb);
		
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, null);
	}
	
}
