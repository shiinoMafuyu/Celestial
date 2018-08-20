package com.celestial.meek.realTest_2016_10;


public class enumTest {

	public enum SeasonEnum {
		spring, summer, autumn, winter;
		
		public static SeasonEnum getSeason(String position) {
            if ("test".equals(position))
                return spring;
            else
                return winter;
        }
	}
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args) {
//		System.out.println(SeasonEnum.getSeason("test"));
		/*FileReader f = new FileReader("rely/dragonNest/englishName.txt");
		f.selectAllLineBetweenRegex2("", "");
		while(f.hasNext()){
			System.out.println(f.readLine());
		}*/
		
	}
	
}
