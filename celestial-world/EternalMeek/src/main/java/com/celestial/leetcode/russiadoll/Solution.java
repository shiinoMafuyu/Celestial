package com.celestial.leetcode.russiadoll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * <b>修改记录：</b> 
 * <p>
 * <li>
 * 
 *                        ---- wangzg 2017年10月12日
 * </li>
 * </p>
 * 
 * <b>类说明：</b>
 * <p> 
 * 俄罗斯套娃:
 * 
 * </p>
 */
public class Solution {

	
	public int maxEnvelopes(int[][] envelopes) {
		if(envelopes == null)
			return 0;
		List<List<int[]>> allList = RussiaDoll.getAllRussiaDoll(Arrays.asList(envelopes));
		List<List<int[]>> finalList = RussiaDoll.findMax(allList);
		List<int[]> oneResult = chooseOne(finalList);
//		RussiaDoll.println(finalList);
		return oneResult.size();
    }

	private List<int[]> chooseOne(List<List<int[]>> finalList) {
		if(finalList == null){
			return new ArrayList<>();
		}else if(finalList.size() ==0){
			return new ArrayList<>();
		}else{
			return finalList.get(0);
		}
	}
	
}


class RussiaDoll{
	private static List<List<int[]>> resList = new ArrayList<>();
	
	static List<List<int[]>> findMax(List<List<int[]>> list) {
		Integer max = 0;
		Map<Integer,List<List<int[]>>> resMap = new HashMap<>();
		for(List<int[]> aSerial : list){
			Integer sizeKey = aSerial.size();
			if(sizeKey > max){
				max = sizeKey;
			}
			
			List<List<int[]>> keyValList = resMap.get(sizeKey);
			if(keyValList == null)
				keyValList = new ArrayList<>();
			keyValList.add(aSerial);
			resMap.put(sizeKey, keyValList);
			
		}
		return resMap.get(max);
	}

	static void println(List<List<int[]>> arr) {
		for(List<int[]> li : arr){
			for(int[] ai : li){
				System.out.print(Arrays.toString(ai));
			}
			System.out.println();
		}
		
	}

	static List<List<int[]>> getAllRussiaDoll(List<int[]> boxes) {
		for(int[] box : boxes){
			List<int[]> paList= new ArrayList<>();paList.add(box);
			recresiveFindAll(paList,boxes);
		}
		return resList;
	}

	private static void recresiveFindAll(List<int[]> paList, List<int[]> boxes) {
		List<int[]> userFulBoxes = findUserFulBox(paList.get(paList.size() - 1),boxes);
		if(userFulBoxes.size() > 0){
			for(int[] usefulBox : userFulBoxes){
				List<int[]> paListNew = copy(paList);
				paListNew.add(usefulBox);
				List<int[]> unusedUsefularr = getUnusedUsefularr(userFulBoxes,usefulBox);
				recresiveFindAll(paListNew,unusedUsefularr);
			}
		}
		else{
			resList.add(paList);
		}
	}

	private static List<int[]> copy(List<int[]> paList) {
		List<int[]> copyList = new ArrayList<>();
		for(int[] arr : paList){
			copyList.add(arr);
		}
		return copyList;
	}

	private static List<int[]> getUnusedUsefularr(List<int[]> userFulBoxes, int[] usefulBox) {
		List<int[]> unusedUsefularr = new ArrayList<>();
		for(int[] arr : userFulBoxes){
			if(!usefulBox.equals(arr))
				unusedUsefularr.add(arr);
		}
		return unusedUsefularr;
	}

	private static List<int[]> findUserFulBox(int[] box, List<int[]> boxes) {
		List<int[]> userFulBoxes = new ArrayList<>();
		for(int[] boi : boxes){
			if(box[0] < boi[0] && box[1] < boi[1])
				userFulBoxes.add(boi);
		}
		return userFulBoxes;
	}
}
