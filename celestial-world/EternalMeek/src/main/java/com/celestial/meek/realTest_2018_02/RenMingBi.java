package com.celestial.meek.realTest_2018_02;

public class RenMingBi {

	 

    /**

     *@param args add by zxx ,Nov 29, 2008

     */

    private static final char[] data = new char[]{

                     '��','Ҽ','��','��','��','��','½','��','��','��'

             };

    private static final char[] units = new char[]{

             'Ԫ','ʰ','��','Ǫ','��','ʰ','��','Ǫ','��'

    };

    public static void main(String[] args) {

             // TODO Auto-generated methodstub

             System.out.println(

                              convert(100000003));

    }



    public static String convert(int money)

    {

             StringBuffer sbf = new StringBuffer();

             int unit = 0;

             while(money!=0)

             {

                     sbf.insert(0,units[unit++]);

                     int number = money%10;

                     sbf.insert(0,data[number]);

                     money /= 10;

             }



             return sbf.toString();

    }

}