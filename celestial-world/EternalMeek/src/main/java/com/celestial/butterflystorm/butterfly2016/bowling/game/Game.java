package com.celestial.butterflystorm.butterfly2016.bowling.game;

public class Game {
	
	public Game() {
		for(int i=0 ; i< GAMEROUND;i++){
			roundArr[i] = new Round();
		}
	}
	
	public void add(int pins) {
		if(roundArr[roundIndex].isThrowFinish())
			roundIndex++;
		roundArr[roundIndex].add(pins);
	}
	
	/**
	 * <b>����˵����</b>
	 * <ul>
	 * ��ֹĳ��ʱ��ȡ���ܷ�.<br/>
	 * ע��:���Ϊstrike ���� spare�Ļ������һ�����.<br/>
	 * </ul>
	 * @param n
	 * @return
	 */
	public int gainScore(int n){
		int score =0;
		for(int i =0;i <= n ;i++){
			score += score(i);
		}
		return score;
	}
	
	public int score(int n){
		if(n>=11)
			throw new RuntimeException("�غ������Ϊ10");
		return roundArr[n].score(roundArr[n+1]);
	}
	
	public Round[] getRoundArr() {
		return roundArr;
	}
	
	public static final int GAMEROUND = 11;
	private Round[] roundArr = new Round[GAMEROUND];
	private int roundIndex = 0;
	

}
