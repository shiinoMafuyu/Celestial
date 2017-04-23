package com.celestial.butterflystorm.hypercube.hypercube;

import java.util.ArrayList;
import java.util.List;

public class CUBEUtil {
	public static final Double LENGTH=100.0;
	public static final Double START=0.0;
	/**
	 * ��ȡ�����ľ���(�ߵĳ���)
	 * @param a
	 * @param b
	 * @return
	 */
	public static double calculateLength(Point a, Point b) {
		return Math.sqrt(Math.pow((a.getX()-b.getX()), 2)+Math.pow(a.getY()-b.getY(), 2));
	}

	/**
	 * ��a,bΪ����,��ȡģ��,����length����b��λ��
	 * ����
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
	 * ���������ȡ��λģ��
	 * @param a
	 * @param b
	 * @return
	 */
	public static Point getUnitModulus(Point a, Point b) {
		double len=CUBEUtil.calculateLength(a, b);
		return new Point(b.getX()-a.getX(), b.getY()-a.getY()).div(len);
	}

	/**
	 * ���������
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
		//���� nCm  ok!
		/*List<List<Double>> lf=createPointZero1(3,2,0);
		for(List<Double> i:lf){
			System.out.println(i);
		}
		System.out.println(lf.size());*/
		//�����ռ�㼯   ok!
		int n=5;
		List<List<Double>> l=createPointZero(n);
		for(List<Double> i:l){
			System.out.println(i);
		}
		/*System.out.println("============================================");
		//�����ռ��߼� ok!
		List<List<Double>> l1=createPointZero(n);
		List<List<List<Double>>> lx=createLineZero(l1);
		for(List<List<Double>> i:lx){
			System.out.println(i);
		}
		//����ͶӰ��
		System.out.println("======================xx====================");
		List<Line> lineList=CUBEUtil.createLinePlain(lx);
		for(Line i:lineList){
			System.out.println(i);
		}*/
	}
	/**=================================================================================================*/
	
	

	/**
	 * �����ռ���ά��Ϊn�����е�
	 * @param n
	 * @return
	 */
	public static List<List<Double>> createPointZero(int n) {
		List<List<Double>> l=new ArrayList<List<Double>>();
		for(int i=0;i<=n;i++){
			l.addAll(createPointZero1(n,i,0));//���Բ��޸ĺ����Ĭ��ֵ0
		}
		return l;
	}

	/**
	 * 
	 * ���ز��ظ�������б�5C2 �㶮�İ�
	 * 
	 * @param n ά��
	 * @param m	ѡ��ֵ
	 * @param p ��ʼֵ��0,�����Բ�ȥ�޸�
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
	 * ����һ������Ϊn�� Double����List����
	 * �൱��һ��δ�趨��ά�ȵ�(nά�ռ�ԭ��)
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
	 * �ɿռ�㴴������пռ���
	 * hh~ԭ���ҵ��߱������ǵ������ ����~
	 * @param listPointZero
	 * @return
	 */
	public static List<List<List<Double>>> createLineZero(List<List<Double>> lz) {
		List<List<List<Double>>> l=new ArrayList<List<List<Double>>>();
		List<List<Double>> line=null;
		//������ѭ����ʽ����ÿ�����㶼����ֻ�����һ��  ���ÿ������ظ������� �ܴ��Ͼ���һ����
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
	 * ���������Ƿ��ǿռ�������һ����
	 * ���۷���:������ֻ��һ��ά�Ȳ�ͬ����һ���� ������
	 * @param p1 ��ά��1
	 * @param p2 ��ά��2
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
	 * ����ͶӰ�߼���
	 * ͶӰ�ߺͿռ�ά������Ŀһ��
	 * @param listLineZero �ռ�ά����List
	 * @return	��άƽ����List
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
	 * ��һ��ά���߽�ά��һ����άƽ����
	 * Ϊ��ͶӰ�ĵ��ʻ���traceOn�� �Ǻ�~
	 * ���Ȳ���ʾ
	 * @param lineZero һ��ά����
	 * @return һ��ͶӰ��
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
	 * ��һ��ά�ȵ�ͶӰ ����һ����ά��~
	 * @param arr
	 * @return
	 */
	private static Point traceOnPoint(Double[] arr) {
		int len=arr.length;
		double temp;
		for(int i=len,j=0;i>2;i--,j++){//iָ����  ά��Ϊn ִ��n-2��
			//jΪ������ʼλ��,����Ϊn-2�ĵط�
			//double temp=-arr[j]/Math.sqrt(i-1);
			temp=-arr[j]/(i);
			for(int k=j+1;k<len;k++){
				arr[k]+=temp;
			}
		}
		return new Point(arr[len-2], arr[len-1]);
	}

	
	
}
