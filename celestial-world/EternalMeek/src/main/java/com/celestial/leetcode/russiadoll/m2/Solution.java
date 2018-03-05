/******************************************************************
 * Solution.java
 * Copyright 2017 by WZG. All Rights Reserved.
 * CreateDate：2017年10月12日
 * Author：wangzg
 * Version：1.0.0
 ******************************************************************/

package com.celestial.leetcode.russiadoll.m2;

/**
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
 * 
 * </p>
 */
public class Solution {
	private void switchTo(int[][] envelopes, int index1, int index2) {
		int x = envelopes[index1][0];
		int y = envelopes[index1][1];

		envelopes[index1][0] = envelopes[index2][0];
		envelopes[index1][1] = envelopes[index2][1];

		envelopes[index2][0] = x;
		envelopes[index2][1] = y;
	}

	private int findMid(int[][] envelopes, int start, int end) {
		int i = start, j = end;
		while (i <= j) {
			if (envelopes[i][0] > envelopes[start][0] && envelopes[j][0] <= envelopes[start][0]) {
				switchTo(envelopes, i, j);
			} else if (envelopes[i][0] == envelopes[start][0]) {
				if (envelopes[i][1] < envelopes[start][1]) // if the 'w' is equal, we try to get the smallest 'h'.
				{
					switchTo(envelopes, i, start);
				}

				i++;
			} else if (envelopes[i][0] < envelopes[start][0])
				i++;
			else
				j--;
		}

		switchTo(envelopes, start, j);

		return j;
	}

	private void quickSort(int[][] envelopes, int start, int end) {
		if (start >= end)
			return;
		int index = findMid(envelopes, start, end);
		quickSort(envelopes, start, index - 1);
		quickSort(envelopes, index + 1, end);
	}

	private int BST(int[][] envelopes, int start, int end, int target) {
		int i = start, j = end;

		while (i <= j) {
			int mid = (i + j) / 2;
			if (envelopes[mid][1] < envelopes[target][1])
				i = mid + 1;
			else
				j = mid - 1;
		}

		if (i == end + 1) // extend the Russian Doll length
		{
			switchTo(envelopes, end + 1, target);

			return end + 1;
		} else {
			if (envelopes[target][1] < envelopes[i][1]) // Replace the current Russian Doll using smaller h envelope.
			{
				envelopes[i][0] = envelopes[target][0];
				envelopes[i][1] = envelopes[target][1];

			}

			return end;
		}
	}

	public int maxEnvelopes(int[][] envelopes) {
		int m = envelopes.length;
		if (m == 0)
			return 0;

		quickSort(envelopes, 0, m - 1);
		int start = 0, end = 0;

		for (int i = 1; i < m; i++) {
			end = BST(envelopes, start, end, i);
		}

		return end + 1;
	}
}
