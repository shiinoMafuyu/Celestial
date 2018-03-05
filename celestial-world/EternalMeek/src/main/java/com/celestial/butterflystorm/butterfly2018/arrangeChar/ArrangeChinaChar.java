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
 * �Ժ���������а�ƴ������
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
//		String[] newArray={"�Ϻ�","���","����","����","����","�Ͼ�","�人","����","����","����"}; 
		String[] newArray="�δ׽���ζ�������ͷۻ��������ϳ�������Ȼ�����������۰����״װ״��Ͻ��н��ݽ�������ֲ���ͺ��Ͳ�����������ϾƱ��ǵ��Ʒ��ѽ��������꽴��ଷ������ʮ�����ĩ֥�齴�ϸ���".split("");
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
