package com.celestial.butterflystorm.butterfly2016.hypercube.hypercube;
/**
 * 所有带有返回值为Point(本类类型)的函数 均返回了自身
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
	 * 点移动
	 * @param a
	 * @param b
	 */
	public void move(double a,double b){
		x+=a;
		y+=b;
	}
	
	
	/**
	 * 往左移动d的距离
	 * @param d
	 * @return
	 */
	public Point move(double d){
		this.x+=d;
		this.y+=d;
		return this;
	}
	/**
	 * 两个点相减 获取向量
	 * @param d
	 * @return
	 */
	public Point sub(Point p){
		this.x-=p.getX();
		this.y-=p.getY();
		return this;
	}
	/**
	 * 点的乘法
	 * @param d
	 * @return
	 */
	public Point mul(double d){
		this.x*=d;
		this.y*=d;
		return this;
	}
	/**
	 * 点的除法
	 * @param d
	 * @return
	 */
	public  Point div(double d){
		if(d==0){
			throw new RuntimeException("除数不能为0,你蠢吗?");
		}else{
			this.x/=d;
			this.y/=d;
			return this;
		}
	}
	/**
	 * 获取x,y两点平方和的平方根
	 * 即 模量或者点到原点的距离.
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
	 * 当前对象根据起始位置a,方向向量p重设位置后返回
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
