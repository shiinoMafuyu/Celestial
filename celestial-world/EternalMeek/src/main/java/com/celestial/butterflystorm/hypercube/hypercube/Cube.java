package com.celestial.butterflystorm.hypercube.hypercube;

import java.util.List;

public class Cube {
	private static final int LENGTH=50;
	/**
	 * ά��
	 */
	private int n=0;
	/**
	 * ������
	 */
	private int pointNumber=0;
	/**
	 * ����
	 */
	private int lineNumber=0;
	/**
	 * ά�ȵ㼯
	 */
	public List<List<Double>> listPointZero=null;
	/**
	 * ά���߼�    �ռ��߼����������������� 	  һ����(������):List<List<Double>>		һ����(n��ά):List<Double>
	 */
	public List<List<List<Double>>> listLineZero=null;
	/**
	 * ͶӰ�߼�
	 */
	public List<Line> listLine=null;
	/**
	 * ���ñ��� �����ظ����� ���ڱ���ʹ��
	 */
	private double tx,ty,tr,thd;
	/**
	 * xλ�� ����ͶӰ������
	 */
	private double x_0=500;
	/**
	 * yλ�� ����ͶӰ������
	 */
	private double y_0=500;
	/**
	 * ��һ��ά�ȶ���ת
	 */
	public static final int ROTATE_TYPE1=1;
	/**
	 * ������ά��һ���ά�ȶ���ת
	 */
	public static final int ROTATE_TYPE2=2;
	/**
	 * ȫ����ת
	 */
	public static final int ROTATE_TYPE3=3;
	private int zhou;
	
	public Cube() {
		super();
		init(350,180,4);
	}
	/**
	 * 
	 * @param n ά��
	 */
	public Cube(int n) {
		init(350,180,n);
	}
	/**
	 * ����һ��nά������
	 * x,yλ��
	 * nά��
	 * @param n
	 */
	public Cube(int x,int y,int n) {
		super();
		init(x,y,n);
	}
	/**
	 * <b>���췽��</b>
	 * <br/>
	 * @param x x����
	 * @param y y����
	 * @param n ά��
	 * @param type ��ת����
	 */
	public Cube(int x,int y,int n,int type) {
		super();
		init(x,y,n,type);
	}
	private void init(int x, int y, int n, int type) {
		switch (type) {
			case Cube.ROTATE_TYPE1:
				this.zhou=1;
				break;
			case Cube.ROTATE_TYPE2:
				this.zhou=(n+1)/2;	
				break;
			case Cube.ROTATE_TYPE3:
				this.zhou=n-1;
				break;
			default:
				this.zhou=n-1;
				break;
		}
		this.x_0=x;
		this.y_0=y;
		this.n=n;
		listPointZero=CUBEUtil.createPointZero(n);
		this.pointNumber=listPointZero.size();
		listLineZero=CUBEUtil.createLineZero(listPointZero);
		this.lineNumber=listLineZero.size();
		listLine=CUBEUtil.createLinePlain(listLineZero);//�����ʼ��ʱ��������,�Ժ�ת��ʱ,��ı���ֱ��setֵ �ȽϺð�
		dtemp=new Double[n];
		
	}
	private void init(int x, int y, int n) {
		init(x,y,n,Cube.ROTATE_TYPE3);	
	}
	public int getN() {
		return n;
	}
	public int getPointNumber() { 
		return pointNumber;
	}
	public int getLineNumber() {
		return lineNumber;
	}
	/**
	 * ���ķ���  ��ת<br/>
	 * ��ת�Ƕ�ά������˶�����ά�������������ʵ�������������ռ�����ת<br/>
	 * һλ�ͱ�����<br/>
	 * <br/>
	 * <br/>
	 * <br/>
	 * ��չһ�£�һά�������������ռ���ֱ���˶���һά������Ҳ����<br/>
	 * 0ά�ͱ�����<br/>
	 * 0ά���������������ռ��ﲻ���ƶ�����ת��,�����ռ�����Լ���ȫ���ռ�<br/>
	 * 1ά�����˶�����ֱ���˶�������һ�����������˶�<br/>
	 * 2ά��������ת����������ռ�����ת��ֱ���˶�<br/>
	 * 3ά������ʲô��<br/>
	 */
	public void rotate() {
		calculatePoint();
		//calculateLine(); //set�ҵĿռ��߱������ǿռ������� �涬�����̫�ɰ���!
		calculatePlainLine();// set ����;��ڲ����� �趨��ֵ��
		System.out.println(" core method rotate-------------->");
	}
	
	
	/**
	 * ����ƽ���ߵĵ�λ��
	 * List<List<Double>>
	 */
	private void calculatePlainLine() {
		
		for(int i=0;i<listLineZero.size();i++){//�������пռ���  һ���ռ���
			calPoint(listLineZero.get(i),i);//��ȡ������
		}
	}
	Double[] dtemp=null;
	Double[] reTemp=new Double[2];
	/**
	 * 
	 * @param list
	 */
	private void calPoint(List<List<Double>> l,int i) {
		l.get(0).toArray(dtemp);
		traceOnPoint(dtemp);
		listLine.get(i).setAPoint(dtemp[n-2]+this.x_0,dtemp[n-1]+this.y_0);
		
		l.get(1).toArray(dtemp);
		traceOnPoint(dtemp);
		listLine.get(i).setBPoint(dtemp[n-2]+this.x_0,dtemp[n-1]+this.y_0);

	}
	
	
	/**
	 * ��ά�ȵ��ֵ,תΪƽ������������ ������λ
	 * @param arr
	 */
	private void traceOnPoint(Double[] arr) {
		double temp;
		for(int i=n,j=0;i>2;i--,j++){//iָ����  ά��Ϊn ִ��n-2��
			//jΪ������ʼλ��,����Ϊn-2�ĵط�
			//double temp=-arr[j]/Math.sqrt(i-1);
			temp=-arr[j]/(i);
			for(int k=j+1;k<n;k++){
				arr[k]+=temp;
			}
		}
	}
	/**
	 * 2��ά�� (�����ǵ�)�仯�˺�����ȷ�� ����λ��
	 * ά�ȵĻ�,ȡ1 2�� ����û�е�
	 */
	private void calculatePoint() {
		for(List<Double> i:listPointZero){
			plainRotate(i);
		}
	}
	/**
	 * ����ά�ȵ��ֵ��ʹ����ת<br/>
	 * ������ٸ�����ת����ȷ����һ����ת or ����ת or ȫ��ת��<br/>
	 * ��ôһ����ά���巢����ת��<br/>
	 * ��ά���壬����Ҳ���ɵ㹹�ɵ�(������ά����)��ֻ�ǵ��ά�Ȳ�ͬ����<br/>
	 * ��ά�������ת����Ҳ�ǵ����ת<br/>
	 * �������õĳ�ά���岻�ܶ���ά����ʵ���ܼ򵥣���ֻ�Ǳ���������������γɵ�nά�ռ���͹�������<br/>
	 * ���� �����Σ����������壬���糬������<br/>
	 * �����ö�ά����ת������������һ����ά����ת<br/>
	 * ��ô��һ����ά��ת�������ȿ�����ô��һ����ά����ת��<br/>
	 * ��ô��ô��һ����ά����ת��<br/>
	 * ��һ����ά��Χ��������תa��(����) ֻ���ȡ�����ά���ģ�ͽǶȣ�Ȼ��Ƕȼ���a������sin��cos����ģ������<br/>
	 * һ����ά���磬5ά��(1,0,1,1,1),��ôת�أ�<br/>
	 * ת����һ�����ı���xy,����Ϊ(0,1,1,1,1)�˿�֪��ĳ��ת����ĳ���Ƕ�(����z�ᣬ��ʱ��ת��90�ȣ�ֻ���Ҳ����ҿ���̫�����ôд��),ͬ������ǵڶ���������һ����Ҳ��ת��һЩ�Ƕ�<br/>
	 * ����x �� ����y����ת���������3ά��������������ת�Ļ�����ȫ������ĳ����ת��a�ȡ�<br/>
	 * (���� x y z ��ֱ�ת����a��,�������������Ȼ�ǰ�ĳ����ת��һ���Ƕȣ�����ÿ���ᶼ��ת��a�ȣ�������2PI/a�󣬽��ص�ԭλ����ĳ��ת������x y zת��һ����Ҳ�ص���ԭλ������һ�����ܽǶ�һ��������ĳ��Ҳ��ת��a)<br/>
	 * �����õ�ȫ����ת���������ڵĵ㶼��תһ��������1,2 2,3 3,4 .. n,1<br/>
	 * �����ÿ���㶼�������ʽ��ת����������˳����������ת����<br/>
	 * ���ע�ͱ��������רҵ��Ŭ������°�<br/>
	 * @param aPoint 1��ά�ȵ�
	 * @param temp ��ż�����������,Ϊ��ʹ�����ÿռ�,���ٶ��󴴽�.
	 */
	private void plainRotate(List<Double> aPoint) {
		for(int j=0;j<this.zhou;j++){
			tx=aPoint.get(j);
			ty=aPoint.get(j+1);
			//���ǵ�ǰ��λ��Ϊ0�����
			tr=Math.sqrt(tx*tx+ty*ty);
			if(tr!=0){
				//�û��ȼ���
				thd=calRadian(tx,ty,tr)+Math.PI/90;//ÿ����ת2��
				aPoint.set(j, tr*Math.sin(thd));
				aPoint.set(j+1, tr*Math.cos(thd));
			}else{
				aPoint.set(j, 0.0);
				aPoint.set(j+1, 0.0);
			}
		}
		//�����full type�Ļ� ����βά����תҲ�Ǳ����~
		if(zhou==n-1 && n !=2){
			tx=aPoint.get(n-1);
			ty=aPoint.get(0);
			//���ǵ�ǰ��λ��Ϊ0�����
			tr=Math.sqrt(tx*tx+ty*ty);
			if(tr!=0){
				//�û��ȼ���
				thd=calRadian(tx,ty,tr)+Math.PI/90;//ÿ����ת2��
				aPoint.set(n-1, tr*Math.sin(thd));
				aPoint.set(0, tr*Math.cos(thd));
			}else{
				aPoint.set(n-1, 0.0);
				aPoint.set(0, 0.0);
			}
		}
		
	}
	/**
	 * ���㻡��
	 * @param x
	 * @param y
	 * @return ����ֵ
	 */
	private double calRadian(double x, double y,double r) {
		if(y<0){
			return Math.PI-Math.asin(x/r);
		}else{
			return Math.asin(x/r);
		}
	}
	public double getX_0() {
		return x_0;
	}
	public void setX_0(double x_0) {
		this.x_0 = x_0;
	}
	public double getY_0() {
		return y_0;
	}
	public void setY_0(double y_0) {
		this.y_0 = y_0;
	}
	
	
	
	
}
