package com.celestial.meek.realTest_2017_03;

public class enmuTest {

	/**
	 * <b>����˵����</b>
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
		
		// ����˽�б���
	    private int nCode ;
		public String toString() {
	          return String.valueOf (this.nCode );
	    }
		
	}

}
