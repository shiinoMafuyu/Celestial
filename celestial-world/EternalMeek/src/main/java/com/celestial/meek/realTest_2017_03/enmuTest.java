package com.celestial.meek.realTest_2017_03;

public class enmuTest {

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args) {
	}
	
	public enum Type{
		RED (1), GREEN (3), YELLOW (2);
		private Type( int _nCode) {
	           this.nCode = _nCode;
	    }
		
		// 定义私有变量
	    private int nCode ;
		public String toString() {
	          return String.valueOf (this.nCode );
	    }
		
	}

}
