package com.celestial.butterflystorm.puddingIII.config;

public class Config {
	/**
	 �������ɲ���:
	 
	 1.java�ļ���ȥԴ���ļ�(һ����src)��Ѱ�Һ�׼���ļ���ȫһ�µ�Դ���ļ�,�ٸ���src�µ�·��ȥWebRoot/WEB-INF/classes���Ҷ�Ӧ��.class�ļ�.
	   	ע�������Ŀ�Ƿ��Ѿ�����������.class�ļ�.;��ȫһ��ָ����һ��,md5ֵһ��.
	   	
	 2.jsp .xml .jsp .avi .js ...�ȵȷ�java���͵��ļ�ȫ����WebRoot��������� ׼���ļ�һ�����ļ���
	 	Ȼ�����һ������,������Config.puddingPath���潨������Ŀ����Ŀ¼��,��ɲ�������.
	 	
	 	ע:java�ļ�������ȫ��srcĿ¼,�ҳ�ȫ������ȫһ���ļ�;ͬ�����������ļ�Ҳ����WebRoot�ҳ�ȫ����ȫһ���ļ�.�������������ҵ��ĵ�һ������λ��Ϊ׼,
	 	����������ʾ"�ҵ�����ȫһ���ļ���ֹһ��".(��˵�����Բ���Ϊ��ֻ����һ��,��ԭ�������������ִ��ڵ�.)
	*/
	
	/**���ɺõĲ����ļ�����λ��,Ĭ������.*/
	public static String puddingPath = "E:/t/t26_myToolDevelopTestDataArea/puddingIII/res";
	
	/**��ӡ��ʾ��Ϣ���,Ĭ����*/
	public static  boolean isPrint = true;
	
	public static  COPY_METHOD CopyMethod = COPY_METHOD.COPY_BY_CMD;
	
	
	
	/**
	 * ���ɲ����ļ�ʱ�õĿ���������<br/>
	 */
	public enum COPY_METHOD{
		
		/**
		 * ����Windows��CMD������п���<br/>
		 * ���ı���ļ��������޸�ʱ��<br/>
		 * Ĭ��<br/>
		 */
		COPY_BY_CMD("copyByCmd"),
		/**
		 * java���������ļ����ơ�<br/>
		 * �ļ��޸Ĵ���ʱ���ΪΪ��ǰ<br/>
		 * ����<br/>
		 */
		COPY_BY_TRANSFER("copyByTransfer");
		
		private String method;
		private COPY_METHOD(String method){
			this.method = method;
		}
		@Override
		public String toString() {
			return method;
		}
		
	}
	/**
	 * ������Ŀ����ѡ���Ӧÿ�����͡�
	 */
	public enum PUDDING_TYPE{
		
		/**
		 * web��Ŀ
		 */
		WEB("web"),
		/**
		 * java��Ŀ
		 */
		JAVA("java");
		
		
		private PUDDING_TYPE(String type){
			this.type = type;
		}
		private String type;
		public String toString(){
			return type;
		}
	}
	
}
