package com.celestial.butterflystorm.butterfly2016.hypercube.hypercube;

import java.util.List;

public class Cube {
	/**
	 * 维数
	 */
	private int n=0;
	/**
	 * 顶点数
	 */
	private int pointNumber=0;
	/**
	 * 线数
	 */
	private int lineNumber=0;
	/**
	 * 维度点集
	 */
	public List<List<Double>> listPointZero=null;
	/**
	 * 维度线集    空间线集包含多条单独的线 	  一条线(两个点):List<List<Double>>		一个点(n个维):List<Double>
	 */
	public List<List<List<Double>>> listLineZero=null;
	/**
	 * 投影线集
	 */
	public List<Line> listLine=null;
	/**
	 * 常用变量 避免重复定义 仅在本类使用
	 */
	private double tx,ty,tr,thd;
	/**
	 * x位置 换成投影点后加上
	 */
	private double x_0=500;
	/**
	 * y位置 换成投影点后加上
	 */
	private double y_0=500;
	/**
	 * 绕一个维度对旋转
	 */
	public static final int ROTATE_TYPE1=1;
	/**
	 * 绕自身维度一半的维度对旋转
	 */
	public static final int ROTATE_TYPE2=2;
	/**
	 * 全面旋转
	 */
	public static final int ROTATE_TYPE3=3;
	private int zhou;
	
	public Cube() {
		super();
		init(350,180,4);
	}
	/**
	 * 
	 * @param n 维度
	 */
	public Cube(int n) {
		init(350,180,n);
	}
	/**
	 * 创建一个n维立方体
	 * x,y位置
	 * n维度
	 * @param n
	 */
	public Cube(int x,int y,int n) {
		super();
		init(x,y,n);
	}
	/**
	 * <b>构造方法</b>
	 * <br/>
	 * @param x x坐标
	 * @param y y坐标
	 * @param n 维数
	 * @param type 旋转类型
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
		listLine=CUBEUtil.createLinePlain(listLineZero);//对象初始化时创建对象,以后转动时,点改变则直接set值 比较好吧
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
	 * 核心方法  自转<br/>
	 * 旋转是二维定义的运动，二维及以上物体才能实现在自身所属空间里旋转<br/>
	 * 一位就别想了<br/>
	 * <br/>
	 * <br/>
	 * <br/>
	 * 扩展一下，一维能在自身所属空间里直线运动，一维及以上也可以<br/>
	 * 0维就别想了<br/>
	 * 0维自身在自身所属空间里不能移动不能转动,自身就占据了自己的全部空间<br/>
	 * 1维定义了定义了直线运动，能在一条线上往复运动<br/>
	 * 2维定义了旋转，能在自身空间里旋转和直线运动<br/>
	 * 3维定义了什么？<br/>
	 */
	public void rotate() {
		calculatePoint();
		//calculateLine(); //set我的空间线本来就是空间点的引用 真冬真的是太可爱了!
		calculatePlainLine();// set 这个就绝壁不是了 设定其值吧
		System.out.println(" core method rotate-------------->");
	}
	
	
	/**
	 * 计算平面线的点位置
	 * List<List<Double>>
	 */
	private void calculatePlainLine() {
		
		for(int i=0;i<listLineZero.size();i++){//遍历所有空间线  一条空间线
			calPoint(listLineZero.get(i),i);//获取两个点
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
	 * 将维度点的值,转为平面点的坐标存放在 倒数两位
	 * @param arr
	 */
	private void traceOnPoint(Double[] arr) {
		double temp;
		for(int i=n,j=0;i>2;i--,j++){//i指次数  维度为n 执行n-2次
			//j为数组起始位置,最终为n-2的地方
			//double temp=-arr[j]/Math.sqrt(i-1);
			temp=-arr[j]/(i);
			for(int k=j+1;k<n;k++){
				arr[k]+=temp;
			}
		}
	}
	/**
	 * 2个维度 (而不是点)变化了后重新确定 各点位置
	 * 维度的话,取1 2吧 不会没有的
	 */
	private void calculatePoint() {
		for(List<Double> i:listPointZero){
			plainRotate(i);
		}
	}
	/**
	 * 重设维度点的值，使其旋转<br/>
	 * 重设多少根据旋转类型确定，一面旋转 or 半旋转 or 全旋转。<br/>
	 * 怎么一个多维物体发生旋转？<br/>
	 * 多维物体，最终也是由点构成的(包括超维物体)，只是点的维度不同而已<br/>
	 * 多维物体的旋转最终也是点的旋转<br/>
	 * 我们所用的超维物体不管多少维，其实都很简单，都只是表面最近领点的连线形成的n维空间正凸面体而已<br/>
	 * 比如 正方形，比如正方体，比如超正方体<br/>
	 * 所以让多维体旋转，首先让其中一个多维点旋转<br/>
	 * 怎么让一个多维旋转，我们先考虑怎么让一个二维点旋转？<br/>
	 * 那么怎么让一个二维点旋转？<br/>
	 * 让一个二维点围绕中心旋转a度(弧度) 只需获取这个二维点的模和角度，然后角度加上a，再用sin、cos乘以模就行了<br/>
	 * 一个多维点如，5维点(1,0,1,1,1),怎么转呢？<br/>
	 * 转动第一二个改变了xy,现在为(0,1,1,1,1)了可知绕某轴转动了某个角度(就是z轴，逆时针转动90度，只是我不想大家考虑太多就那么写了),同样如果是第二三个，第一三个也能转动一些角度<br/>
	 * 即绕x 轴 、绕y轴旋转。。如果是3维的正方体这样旋转的话，就全部点绕某轴旋转了a度。<br/>
	 * (点绕 x y z 轴分别转动了a度,所以算下来点必然是按某轴旋转了一个角度，由于每个轴都是转了a度，所以在2PI/a后，将回到原位，绕某轴转动和绕x y z转动一样，也回到了原位，次数一样，总角度一样所以绕某轴也是转动a)<br/>
	 * 所以让点全面旋转就是让相邻的点都旋转一番，比如1,2 2,3 3,4 .. n,1<br/>
	 * 方块的每个点都按这个方式旋转，不就完成了超立方体的旋转了吗。<br/>
	 * 这个注释表达起来不专业，努力理解下吧<br/>
	 * @param aPoint 1个维度点
	 * @param temp 存放计算结果的数组,为了使用引用空间,减少对象创建.
	 */
	private void plainRotate(List<Double> aPoint) {
		for(int j=0;j<this.zhou;j++){
			tx=aPoint.get(j);
			ty=aPoint.get(j+1);
			//考虑到前两位都为0的情况
			tr=Math.sqrt(tx*tx+ty*ty);
			if(tr!=0){
				//用弧度计算
				thd=calRadian(tx,ty,tr)+Math.PI/90;//每次旋转2度
				aPoint.set(j, tr*Math.sin(thd));
				aPoint.set(j+1, tr*Math.cos(thd));
			}else{
				aPoint.set(j, 0.0);
				aPoint.set(j+1, 0.0);
			}
		}
		//如果是full type的话 绕首尾维度旋转也是必须的~
		if(zhou==n-1 && n !=2){
			tx=aPoint.get(n-1);
			ty=aPoint.get(0);
			//考虑到前两位都为0的情况
			tr=Math.sqrt(tx*tx+ty*ty);
			if(tr!=0){
				//用弧度计算
				thd=calRadian(tx,ty,tr)+Math.PI/90;//每次旋转2度
				aPoint.set(n-1, tr*Math.sin(thd));
				aPoint.set(0, tr*Math.cos(thd));
			}else{
				aPoint.set(n-1, 0.0);
				aPoint.set(0, 0.0);
			}
		}
		
	}
	/**
	 * 计算弧度
	 * @param x
	 * @param y
	 * @return 弧度值
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
