package com.celestial.butterflystorm.hypercube.main;

import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.celestial.butterflystorm.hypercube.hypercube.Cube;
import com.celestial.butterflystorm.hypercube.hypercube.Line;
import com.celestial.butterflystorm.hypercube.hypercube.Point;

public class StartDraw extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Timer timer;
	private static Cube cube;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		cube=new Cube(350, 180, 7,Cube.ROTATE_TYPE1);
		
		StartDraw sd=new StartDraw();
		JFrame frame=new JFrame("³¬Õý·½Ìå~~");
		frame.add(sd);
		frame.setSize(800,471);
		frame.setAlwaysOnTop(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		sd.action();
		
		
		
	}

	private void action() {
		ready();
		
		timer =new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				cube.rotate();
				repaint();
			}
		}, 100, 100);
		
	}
	
	private void ready() {
		new Line(new Point(0, 0), new Point(20, 20));
		
	}

	

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		drowCube(g);
//		drowLine(g,line);
	}
	int ff=0;
	private void drowCube(Graphics g) {
		System.out.println(" draw--------------> "+ff++);
		int s=cube.listLine.size();
		for(int i=0;i<s;i++){
			drowLine(g,cube.listLine.get(i));
		}
		
	}

	private void drowLine(Graphics g, Line l) {
		g.drawLine(l.getX1(), l.getY1(), l.getX2(), l.getY2());
		
	}
	
}
