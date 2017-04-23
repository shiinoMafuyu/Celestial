package com.celestial.butterflystorm.zaza.matrixConvert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MatrixConvert {

	/**
	 * <b>方法说明：</b>
	 * <ul>
	 * 
	 * </ul>
	 * @param args 
	 */
	public static void main(String[] args) {
//		MatrixConvert mc = new MatrixConvert();
		int m =2,n=3;
		List<List<Integer>> matrix = MatrixConvert.createMatrix2();
		MatrixConvert.println(matrix);
		List<List<Integer>> transferedmatrix = MatrixConvert.trans(matrix);
		MatrixConvert.println(transferedmatrix);
	}

	private static List<List<Integer>> createMatrix2() {
		List<List<Integer>> l = new ArrayList<List<Integer>>();
		l.add(Arrays.asList(new Integer[]{1,5,3}));
		l.add(Arrays.asList(new Integer[]{3,2,4}));
		return l;
	}

	private static void println(List<List<Integer>> matrix) {
		for(List<Integer> li : matrix){
			for(Integer i : li){
				System.out.print(i.toString() + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static List<List<Integer>> trans(List<List<Integer>> matrix) {
		List<List<Integer>> l = new ArrayList<List<Integer>>();
		int row = matrix.size();
		int col = matrix.get(0).size();
		for(int i = col -1 ;i>=0;i--){
			List<Integer> lt = new ArrayList<Integer>();
			for(int j = 0 ;j<row ;j++){
				lt.add(matrix.get(j).get(i));
			}
			l.add(lt);
		}
		return l;
	}

	private static List<List<Integer>> createMatrix(int m, int n) {
		List<List<Integer>> l = new ArrayList<List<Integer>>();
		Random r = new Random();
		for(int i = 0;i < m ; i++){
			List<Integer> lrow = new ArrayList<Integer>();
			for(int j=0;j<n;j++){
				lrow.add(r.nextInt(10));
			}
			l.add(lrow);
		}
		return l;
	}
	
}
