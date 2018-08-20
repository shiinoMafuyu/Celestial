package com.celestial.butterflystorm.butterfly2016.hypercube.hypercube;
/**
 * 点a,b的值改变了重设长度length
 * 长度改变了 传入参数是否已a为基点 重设b,false的话以b为基点重设a.
 * @author Administrator
 *
 */
public class Line {
	private Point a=new Point();
	private Point b=new Point();
	
	private double length;

	public Line(Point a, Point b) {
		super();
		this.a = a;
		this.b = b;
		length=CUBEUtil.calculateLength(a,b);
	}

	public Line() {
		super();
	}

	
	/**
	 * 下面4个函数获取绘线坐标
	 * @return
	 */
	public int getX1(){
		return (int)a.getX();
	}
	
	public int getY1(){
		return (int)a.getY();
	}
	
	public int getX2(){
		return (int)b.getX();
	}
	
	public int getY2(){
		return (int)b.getY();
	}
	
	
	
	@Override
	public String toString() {
		return "Line [a=" + a + ", b=" + b + "]";
	}

	public Point getA() {
		return a;
	}

	public void setA(Point a) {
		this.a = a;
		length=CUBEUtil.calculateLength(a,b);
	}

	public Point getB() {
		return b;
	}

	public void setB(Point b) {
		this.b = b;
		length=CUBEUtil.calculateLength(a,b);
	}

	public double getLength() {
		return length;
	}

	/**
	 * 设定线的长度
	 * @param length
	 * @param is
	 */
	public void setLength(double length,boolean is) {
		this.length = length;
		if(is){
			b=CUBEUtil.getPointByPointAndLength(a,b,length);
		}
	}

	public void moveX(int x) {
		a.setX(a.getX()+x);
		b.setX(b.getX()+x);
		
	}

	public void setAPoint(Double d1, Double d2) {
		a.setX(d1);
		a.setY(d2);
	}
	public void setBPoint(Double d1, Double d2) {
		b.setX(d1);
		b.setY(d2);
	}
	
	
}
