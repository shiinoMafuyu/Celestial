package com.celestial.butterflystorm.butterfly2016.zaza.busFee;

import java.util.Calendar;
import java.util.Scanner;

public class BusFee {
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		String[] msg = new String[]{"��������,","������������ʽ����:\n  (int year, int month)\n  (int year, int month, int percent)\n  (int year, int month, int percent , double price)"};
		boolean isContinue = true;
		Scanner sc = new Scanner(System.in);
		if(args == null)
			args = sc.next().split(",");
		while(isContinue){
			try {
				BusFee bf = new BusFee();
				int n = args.length;
				if(n>=2)System.out.print(args[0]+"��"+args[1]+"��,Ӧ�幫������:");
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
	 * <b>����˵����</b>
	 * <ul>
	 * ��ȡÿ�¹�������,��Ϣ������.<br/>
	 * </ul>
	 * @param year
	 * @param money (1~12)
	 * @return iArr[0] : ���¹�����,iArr[1] : ������Ϣ��
	 */
	public int[] getDayScattered(int year, int month) {
		if(month > Calendar.DECEMBER || month < Calendar.JANUARY)
			throw new RuntimeException("���");
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
	 * <b>����˵����</b>
	 * <ul>
	 * ����³����Ǯ.<br/>
	 * ��ĩ���ղ��ϰ�<br/>
	 * Ĭ�Ϸ���һ������2��.<br/>
	 * </ul>
	 * @param year
	 * @param money (1~12)
	 * @return
	 */
	public double getRecharge(int year, int month) {
		return getRecharge(year, month, 0);
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param year
	 * @param month (1~12)
	 * @param percent ��ĩȥ�ı���(%)����Ϊ��,�Լ���Ậ��<br/>
	 * @return
	 */
	public double getRecharge(int year, int month, int percent) {
		return getRecharge(year,month,percent,2);
	}
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param year
	 * @param month
	 * @param percent
	 * @param price һ�����غϼƼ۸�<br/>
	 * @return
	 */
	public double getRecharge(int year, int month, int percent,double price) {
		if(percent  > 100)
			throw new RuntimeException("������Χ����,���޶���С��100��Χ.");
		int[] iArr = getDayScattered(year, month);
		double fee = (iArr[0]  + Math.round(iArr[1] * percent/100)) * price;
		return fee;
	}
}
