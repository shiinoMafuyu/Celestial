package com.celestial.butterflystorm.butterfly2018.arrangeChar;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.celestial.agniRadiance.EzUtil.UtilCollection;
import com.google.common.collect.Sets;

/**
 * 对汉字数组进行按拼音排序
 * @author wangzg
 *
 */
public class ArrangeChinaChar {
	private String[] sortedArr;
	public ArrangeChinaChar(String[] newArray) {
		Comparator<Object> com=Collator.getInstance(java.util.Locale.CHINA);
		sortedArr = UtilCollection.deepCopyArr(newArray);
        Arrays.sort(sortedArr,com);  
	}

	public String[] getSortedArr() {
		return sortedArr;
	}

	//
	public static void main(String[] args) {
//		String[] newArray={"上海","天津","广州","杭州","辽宁","南京","武汉","北京","厦门","内蒙"}; 
		String[] newArray="盐醋酱油味精鸡精芡粉花椒胡椒老抽生抽孜然干辣椒辣椒粉白糖米醋白醋老姜仔姜泡椒花生油植物油耗油菜籽油橄榄油料酒冰糖调酒番茄酱豆豉豆瓣酱咖喱粉五香粉十三香芥末芝麻酱老干妈".split("");
		ArrangeChinaChar ac = new ArrangeChinaChar(newArray);
		String[] sortedArr = ac.getSortedArr();
		System.out.println(Arrays.toString(sortedArr));
		
//		List<String> list= new ArrayList<>();
//		for(String s: sortedArr) {
//			if(!list.contains(s))
//				list.add(s);
//		}
//		System.out.println(list.size());
//		System.out.println(list);
		Map<String,Integer> charMap = new LinkedHashMap<>();
		for(String s: sortedArr) {
			Integer num = charMap.get(s);
			if(null == num) {
				num=0;
			}
			num++;
			charMap.put(s, num);
		}
		System.out.println(charMap.size());
		for(Entry<String, Integer> ei : charMap.entrySet()) {
			System.out.print(String.format("%s[%s],", ei.getKey(),ei.getValue()));
		}
	}

}
