package com.celestial.leetcode.WordLadderII;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
	
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        new Ladder(beginWord, wordList.toArray(new String[]{}),new ArrayList<String>());
		return Ladder.getLadder(endWord);
    }
	
}


class Ladder{


	List<String> parentList;
	String me;
	String[] leftArr;
	List<Ladder> nextLadder;
	static List<List<String>> resultList = new ArrayList<>();

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @return 
	 */
	static List<List<String>> getLadder(String endWord) {
		List<List<String>> theLadder = new ArrayList<>();
		Integer min = resultList.get(0).size();
		Map<Integer,List<List<String>>> map = new HashMap<>();
		for(List<String> li : resultList){
			
			if(endWord.equals(li.get(li.size() - 1))){
				theLadder.add(li);
				Integer sizeKey = li.size();
				List<List<String>> sameLengthList = map.get(sizeKey);
				if(sameLengthList == null)
					sameLengthList = new ArrayList<>();
				sameLengthList.add(li);
				map.put(sizeKey, sameLengthList);
				if(min > sizeKey)
					min = sizeKey;
			}
		}
		
		List<List<String>> ladders = map.get(min);
		if(null == ladders)
			ladders = new ArrayList<>();
		return ladders;
	}

	/**
	 * <b>构造方法</b>
	 * <br/>
	 * @param me
	 * @param leftArr
	 */
	public Ladder(String me, String[] leftArr,List<String> parentList) {
		this.me = me;
		this.leftArr = leftArr;
		this.parentList = copy(parentList);
		
		this.parentList.add(me);
		nextLadder = new ArrayList<>();
		
		addNextLadder();
	}


	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param parentList2
	 * @return 
	 */
	private List<String> copy(List<String> parentList2) {
		List<String> list = new ArrayList<>();
		for(String si : parentList2){
			list.add(si);
		}
		return list;
	}


	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul> 
	 */
	private void addNextLadder() {
		List<String> userfulNextArr = getusefulNextArr(leftArr);
		if(userfulNextArr != null && userfulNextArr.size() >0){
			for (String str : userfulNextArr) {
				String[] childLeftArr = getChildLeftArr(leftArr,str);
				nextLadder.add(new Ladder(str,childLeftArr,parentList));
			}
		}else{
		}
		resultList.add(copy(parentList));
		

	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param leftArr2
	 * @param str
	 * @return 
	 */
	private String[] getChildLeftArr(String[] leftArr2, String str) {
		List<String> list = new ArrayList<>();
		for(String si: leftArr2){
			if(!str.equals(si))
				list.add(si);
		}
		
		return list.toArray(new String[]{});
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param leftArr2
	 * @return 
	 */
	private List<String> getusefulNextArr(String[] leftArr2) {
		List<String> resList = new ArrayList<>();
		for(String si : leftArr2){
			if(oneCharDifferent(si,me)){
				resList.add(si);
			}
		}
		return resList;
	}

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param str1
	 * @param str2
	 * @return 
	 */
	private boolean oneCharDifferent(String str1, String str2) {
		int defNum = 0;
		for(int i=0;i<str1.length();i++){
			if(str1.charAt(i) != str2.charAt(i))
				defNum ++;
		}
		return defNum == 1;
	}


}


