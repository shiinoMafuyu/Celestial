package com.celestial.butterflystorm.butterfly2018.netfile;

import com.celestial.agniRadiance.EzUtil.UtilNetWork;

public class SaveNetFile {

	public static void main(String[] args) {

		save2();
		
//		webSite01Bg();
	}

	private static void save2() {
		String[] arr = new String[] {
				"http://i3.hyperspeed.pro/images/hentaimanga.pro/galleries/3/703/0_372.jpg","http://i1.hyperspeed.pro/images/hentaimanga.pro/galleries/3/703/1_860.jpg","http://i4.hyperspeed.pro/images/hentaimanga.pro/galleries/3/703/2_74.jpg","http://i2.hyperspeed.pro/images/hentaimanga.pro/galleries/3/703/3_415.jpg","http://i4.hyperspeed.pro/images/hentaimanga.pro/galleries/3/703/4_238.jpg","http://i2.hyperspeed.pro/images/hentaimanga.pro/galleries/3/703/5_563.jpg","http://i2.hyperspeed.pro/images/hentaimanga.pro/galleries/3/703/6_359.jpg","http://i2.hyperspeed.pro/images/hentaimanga.pro/galleries/3/703/7_312.jpg","http://i1.hyperspeed.pro/images/hentaimanga.pro/galleries/3/703/8_143.jpg","http://i1.hyperspeed.pro/images/hentaimanga.pro/galleries/3/703/9_107.jpg","http://i4.hyperspeed.pro/images/hentaimanga.pro/galleries/3/703/10_30.jpg","http://i4.hyperspeed.pro/images/hentaimanga.pro/galleries/3/703/11_291.jpg","http://i3.hyperspeed.pro/images/hentaimanga.pro/galleries/3/703/12_247.jpg","http://i3.hyperspeed.pro/images/hentaimanga.pro/galleries/3/703/13_59.jpg","http://i4.hyperspeed.pro/images/hentaimanga.pro/galleries/3/703/14_51.jpg","http://i1.hyperspeed.pro/images/hentaimanga.pro/galleries/3/703/15_977.jpg"
		};
		
		for(String si :arr) {
			
			UtilNetWork.normalDownLoad(si);
			
			
		}
		
	}

	@SuppressWarnings("unused")
	private static void webSite01Bg() {
		int i = 1;
		while (true) {
			try {
				UtilNetWork.downLoadFromUrl("http://www.allhentai.pro/img/wall" + i + ".jpg", "wall" + i + ".jpg",
						"H:/2图片/5下载/bd/bg/");
				i++;
			} catch (Exception e) {
				break;
			}
		}
	}
	
	

}
