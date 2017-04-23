package com.celestial.butterflystorm.hypercube.hypercube;

import java.util.ArrayList;
import java.util.List;

public class CUBEUtil {
	public static final Double LENGTH=100.0;
	public static final Double START=0.0;
	/**
	 * 获取两点间的距离(线的长度)
	 * @param a
	 * @param b
	 * @return
	 */
	public static double calculateLength(Point a, Point b) {
		return Math.sqrt(Math.pow((a.getX()-b.getX()), 2)+Math.pow(a.getY()-b.getY(), 2));
	}

	/**
	 * 以a,b为基点,获取模量,再由length重设b的位置
	 * 重设
	 * @param a
	 * @param b
	 * @param length
	 * @return
	 */
	public static Point getPointByPointAndLength(Point a, Point b, double length) {
		Point p=CUBEUtil.getUnitModulus(a,b);
		b=b.setNewPosition(a,p.mul(length));
		return b;
	}

	/**
	 * 根据两点获取单位模量
	 * @param a
	 * @param b
	 * @return
	 */
	public static Point getUnitModulus(Point a, Point b) {
		double len=CUBEUtil.calculateLength(a, b);
		return new Point(b.getX()-a.getX(), b.getY()-a.getY()).div(len);
	}

	/**
	 * 计算组合数
	 * @param a
	 * @param b
	 * @return
	 */
	public static int c(int a, int b) {
		int mass=1;
		for(int i=0;i<b;i++){
			mass*=a--;
		}
		int massB=1;
		for(int i=1;i<=b;i++){
			massB*=i;
		}
		return mass/massB;
	}
	/**
	 * =================================================================================================
	 * @param args
	 */
	public static void main(String[] args) {
		//创建 nCm  ok!
		/*List<List<Double>> lf=createPointZero1(3,2,0);
		for(List<Double> i:lf){
			System.out.println(i);
		}
		System.out.println(lf.size());*/
		//创建空间点集   ok!
		int n=5;
		List<List<Double>> l=createPointZero(n);
		for(List<Double> i:l){
			System.out.println(i);
		}
		/*System.out.println("============================================");
		//创建空间线集 ok!
		List<List<Double>> l1=createPointZero(n);
		List<List<List<Double>>> lx=createLineZero(l1);
		for(List<List<Double>> i:lx){
			System.out.println(i);
		}
		//创建投影线
		System.out.println("======================xx====================");
		List<Line> lineList=CUBEUtil.createLinePlain(lx);
		for(Line i:lineList){
			System.out.println(i);
		}*/
	}
	/**=================================================================================================*/
	
	

	/**
	 * 创建空间中维度为n的所有点
	 * @param n
	 * @return
	 */
	public static List<List<Double>> createPointZero(int n) {
		List<List<Double>> l=new ArrayList<List<Double>>();
		for(int i=0;i<=n;i++){
			l.addAll(createPointZero1(n,i,0));//别脑残修改后面的默认值0
		}
		return l;
	}

	/**
	 * 
	 * 返回不重复的组合列表5C2 你懂的吧
	 * 
	 * @param n 维数
	 * @param m	选择值
	 * @param p 初始值是0,请勿脑残去修改
	 * @return
	 */
	public static List<List<Double>> createPointZero1(int n, int m, int p) {
		List<List<Double>> l=new ArrayList<List<Double>>();
		if(m==0){
			l.add(getListDouble(n));
		}
		else if(m>1){
			for(int i=p;i+m<=n;i++){
				List<List<Double>> l2=null;
				l2=createPointZero1(n,m-1,i+1);
				for(List<Double> j:l2){
					j.set(i, j.get(i)+LENGTH);/**1*/
				}
				l.addAll(l2);
			}
		}else{
			List<List<Double>> l2=new ArrayList<List<Double>>();
			for(int i=p;i<n;i++){
				List<Double> point=getListDouble(n);
				point.set(i, point.get(i)+LENGTH);/**2*/
				l2.add(point);
			}
			return l2;
		}
		return l;
	}

	/**
	 * 建立一个长度为n的 Double类型List集合
	 * 相当于一个未设定的维度点(n维空间原点)
	 * @param n
	 * @return
	 */
	public static List<Double> getListDouble(int n) {
		List<Double> point=new ArrayList<Double>();
		for(int i=0;i<n;i++){
			point.add(START);/**3*/
		}
		return point;
	}

	/**
	 * 由空间点创造出所有空间线
	 * hh~原来我的线本来就是点的引用 哈哈~
	 * @param listPointZero
	 * @return
	 */
	public static List<List<List<Double>>> createLineZero(List<List<Double>> lz) {
		List<List<List<Double>>> l=new ArrayList<List<List<Double>>>();
		List<List<Double>> line=null;
		//按这种循环方式好像每两个点都仅且只配对了一次  不用考虑线重复的问题 能搭上就是一条线
		for(int i=0;i<lz.size();i++){
			for(int j=i;j<lz.size();j++){
				if(compare(lz.get(i),lz.get(j))){
					line=new ArrayList<List<Double>>();
					line.add(lz.get(i));
					line.add(lz.get(j));
					l.add(line);
				}
			}
		}
		return l;
	}

	/**
	 * 看两个点是否是空间多面体的一条边
	 * 理论方法:两个点只有一个维度不同则是一条边 否则不是
	 * @param p1 多维点1
	 * @param p2 多维点2
	 * @return
	 */
	private static boolean compare(List<Double> p1, List<Double> p2) {
		int num=0;
		for(int i=0;i<p1.size();i++){
			if(!p1.get(i).equals(p2.get(i))){
				num++;
			}
		}
		return num==1;
	}

	/**
	 * 创建投影线集合
	 * 投影线和空间维度线数目一样
	 * @param listLineZero 空间维度线List
	 * @return	二维平面线List
	 */
	public static List<Line> createLinePlain(List<List<List<Double>>> l0) {
		List<Line> l=new ArrayList<Line>();
		for(int i=0;i<l0.size();i++){
			Line line=traceOn(l0.get(i));
			l.add(line);
		}
		return l;
	}

	/**
	 * 将一条维度线降维成一条二维平面线
	 * 为何投影的单词会是traceOn呢 呵呵~
	 * 正等测显示
	 * @param lineZero 一条维度线
	 * @return 一条投影线
	 */
	private static Line traceOn(List<List<Double>> lineZero) {
		int size= lineZero.get(0).size();
		Double[] arr0=new Double[size];
		Double[] arr1=new Double[size];
		lineZero.get(0).toArray(arr0);
		lineZero.get(1).toArray(arr1);
		
		Point p1=traceOnPoint(arr0);
		Point p2=traceOnPoint(arr1);
		return new Line(p1, p2);
	}

	/**
	 * 将一个维度点投影 返回一个二维点~
	 * @param arr
	 * @return
	 */
	private static Point traceOnPoint(Double[] arr) {
		int len=arr.length;
		double temp;
		for(int i=len,j=0;i>2;i--,j++){//i指次数  维度为n 执行n-2次
			//j为数组起始位置,最终为n-2的地方
			//double temp=-arr[j]/Math.sqrt(i-1);
			temp=-arr[j]/(i);
			for(int k=j+1;k<len;k++){
				arr[k]+=temp;
			}
		}
		return new Point(arr[len-2], arr[len-1]);
	}

	
	
}
