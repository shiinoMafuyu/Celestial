package com.celestial.butterflystorm.butterfly2016.hypercube.hypercube;
/**
 * ���д��з���ֵΪPoint(��������)�ĺ��� ������������
 * @author Administrator
 *
 */
public class Point {
	private double x=0;
	private double y=0;
	
	
	
	public Point() {
		super();
	}
	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	/**
	 * ���ƶ�
	 * @param a
	 * @param b
	 */
	public void move(double a,double b){
		x+=a;
		y+=b;
	}
	
	
	/**
	 * �����ƶ�d�ľ���
	 * @param d
	 * @return
	 */
	public Point move(double d){
		this.x+=d;
		this.y+=d;
		return this;
	}
	/**
	 * ��������� ��ȡ����
	 * @param d
	 * @return
	 */
	public Point sub(Point p){
		this.x-=p.getX();
		this.y-=p.getY();
		return this;
	}
	/**
	 * ��ĳ˷�
	 * @param d
	 * @return
	 */
	public Point mul(double d){
		this.x*=d;
		this.y*=d;
		return this;
	}
	/**
	 * ��ĳ���
	 * @param d
	 * @return
	 */
	public  Point div(double d){
		if(d==0){
			throw new RuntimeException("��������Ϊ0,�����?");
		}else{
			this.x/=d;
			this.y/=d;
			return this;
		}
	}
	/**
	 * ��ȡx,y����ƽ���͵�ƽ����
	 * �� ģ�����ߵ㵽ԭ��ľ���.
	 */
	public double getModule(){
		return Math.sqrt(Math.pow(x, 2)+ Math.pow(y, 2));
	}
	
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	/**
	 * ��ǰ���������ʼλ��a,��������p����λ�ú󷵻�
	 * @param a
	 * @param p
	 * @return
	 */
	public Point setNewPosition(Point a, Point p) {
		this.x=a.getX()+p.getX();
		this.y=a.getY()+p.getY();
		return this;
	}
	
	
}
