package com.celestial.butterflystorm.butterfly2016.zaza.busFee;

import java.util.Calendar;
import java.util.Scanner;

public class BusFee {
	
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		String[] msg = new String[]{"参数错误,","请输入如下形式参数:\n  (int year, int month)\n  (int year, int month, int percent)\n  (int year, int month, int percent , double price)"};
		boolean isContinue = true;
		Scanner sc = new Scanner(System.in);
		if(args == null)
			args = sc.next().split(",");
		while(isContinue){
			try {
				BusFee bf = new BusFee();
				int n = args.length;
				if(n>=2)System.out.print(args[0]+"年"+args[1]+"月,应冲公交费用:");
				switch(n){
					case 1:System.out.println(msg[1]);
					break;
					case 2:System.out.println(bf.getRecharge(Integer.valueOf(args[0]),Integer.valueOf(args[1])));
					break;
					case 3:System.out.println(bf.getRecharge(Integer.valueOf(args[0]),Integer.valueOf(args[1]),Integer.valueOf(args[2])));
					break;
					case 4:System.out.println(bf.getRecharge(Integer.valueOf(args[0]),Integer.valueOf(args[1]),Integer.valueOf(args[2]),Double.valueOf(args[3])));
					break;
					default:
						System.out.println(msg[0]+msg[1]);
				}
				args = sc.next().split(",");
			} catch (Exception e) {
				System.out.println(msg[0]+msg[1]);
				args = sc.next().split(",");
			}
		}
		
	}
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 获取每月工多少天,休息多少天.<br/>
	 * </ul>
	 * @param year
	 * @param money (1~12)
	 * @return iArr[0] : 该月工作日,iArr[1] : 该月休息日
	 */
	public int[] getDayScattered(int year, int month) {
		if(month > Calendar.DECEMBER || month < Calendar.JANUARY)
			throw new RuntimeException("鱼粉");
		month -= 1;
		int[] iArr = new int[]{0,0};
		Calendar cd = Calendar.getInstance();
		cd.set(year, month, 1);
		int days = cd.getActualMaximum(Calendar.DAY_OF_MONTH);
		for(int date = 1 ; date <= days ; date++){
			cd.set(year, month, date);
			int weekDay = cd.get(Calendar.DAY_OF_WEEK);
			if(weekDay == Calendar.SATURDAY || weekDay == Calendar.SUNDAY)
				iArr[1] += 1;
			else
				iArr[0] += 1;
		}
		return iArr;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 这个月冲多少钱.<br/>
	 * 周末周日不上班<br/>
	 * 默认费用一天来回2块.<br/>
	 * </ul>
	 * @param year
	 * @param money (1~12)
	 * @return
	 */
	public double getRecharge(int year, int month) {
		return getRecharge(year, month, 0);
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param year
	 * @param month (1~12)
	 * @param percent 周末去的比例(%)可以为负,自己体会含义<br/>
	 * @return
	 */
	public double getRecharge(int year, int month, int percent) {
		return getRecharge(year,month,percent,2);
	}
	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param year
	 * @param month
	 * @param percent
	 * @param price 一天来回合计价格<br/>
	 * @return
	 */
	public double getRecharge(int year, int month, int percent,double price) {
		if(percent  > 100)
			throw new RuntimeException("比例范围错误,请限定在小于100范围.");
		int[] iArr = getDayScattered(year, month);
		double fee = (iArr[0]  + Math.round(iArr[1] * percent/100)) * price;
		return fee;
	}
}
