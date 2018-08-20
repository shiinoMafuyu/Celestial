package com.celestial.leetcode._0003LongestSubstring;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Solution {
	public int lengthOfLongestSubstring(String s) {
        if(null == s)
            return 0;
        if("".equals(s))
            return 0;
        
        Integer max = 0;
        List<Set<Character>> itorList= new ArrayList<>();
        for(Integer i =0; i<s.length();i++){
        	Character core = s.charAt(i);
            for(Iterator<Set<Character>> itor = itorList.iterator();itor.hasNext();){
            	Set<Character> eiset = itor.next();
            	if(eiset.contains(core)){
            		itor.remove();
            		Integer len = eiset.size();
            		if(len > max)
            			max = len;
            	}else{
            		eiset.add(core);
            	}
            }
            Set<Character> iSet = new HashSet<>();
            iSet.add(core);
            itorList.add(iSet);
        }
        for(Iterator<Set<Character>> itor = itorList.iterator();itor.hasNext();){
        	Set<Character> ei = itor.next();
        	Integer len = ei.size();
        	itor.remove();
    		if(len > max)
    			max = len;
        }
        return max;
    }
    
}
