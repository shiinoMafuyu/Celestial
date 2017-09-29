package com.celestial.meek.realTest_2017_05.ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class GraExp extends JFrame {
	/**  */
	private static final long serialVersionUID = 1L;
	CInstead c1 = new CInstead();
	Container c;
	JLabel lbl1 = new JLabel("–’√˚£∫");
	JLabel lbl2 = new JLabel("√‹¬Î£∫");
	JTextField tf1 = new JTextField(10), tf2 = new JTextField(10);

	public GraExp() {
		setContentPane(c1);
		c = getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.LEFT));
		c.add(lbl1);
		c.add(tf1);
		c.add(lbl2);
		c.add(tf2);

		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setSize(new Dimension(400, 300));
		setVisible(true);
	}

	public static void main(String[] args) {
	}

	class CInstead extends JPanel {
		/**  */
		private static final long serialVersionUID = 1L;
		ImageIcon icon;
		Image img;

		public CInstead() {
			icon = new ImageIcon(GraExp.class.getResource("/bkg01.jpg"));
			img = icon.getImage();
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0, 0, null);
		}
	}
}
