package com.celestial.leetcode._0003LongestSubstring.m2;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	public int lengthOfLongestSubstring(String s) {
        if(null == s)
            return 0;
        if("".equals(s))
            return 0;
        
        Integer max = 0,i = 0 , j = 0;
        Set<Character> set = new HashSet<>();
        for(;j<s.length();){
            Character ch = s.charAt(j);
            if(set.contains(ch)){
            	set.remove(s.charAt(i));
                i++;
            }else{
                set.add(ch);
                j++;
                max = Math.max(max,j-i);
            }
        }
        return max;
    }
}
