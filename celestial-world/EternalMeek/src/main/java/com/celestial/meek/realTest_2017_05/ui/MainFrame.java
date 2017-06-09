package com.celestial.meek.realTest_2017_05.ui;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class MainFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainFrame() {
		
		
		MainPanel mp = new MainPanel();
		setContentPane(mp);
		
		JTextArea jt = new JTextArea("競技！勝利！把过程和结果混为一谈，就本末倒置了哈！", 5, 3);
		jt.setBounds(30, 30, 100, 30);
		add(jt);
		
		
		setBounds(450, 500, 400, 250);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		MainFrame mf = new MainFrame();
		System.out.println(1234);
	}
}
