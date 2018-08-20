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
	 * <b>方法说明：</b>
	 * <ul>
	 * 截止某轮时获取的总分.<br/>
	 * 注意:如果为strike 或者 spare的话需等下一轮完成.<br/>
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
			throw new RuntimeException("回合数最大为10");
		return roundArr[n].score(roundArr[n+1]);
	}
	
	public Round[] getRoundArr() {
		return roundArr;
	}
	
	public static final int GAMEROUND = 11;
	private Round[] roundArr = new Round[GAMEROUND];
	private int roundIndex = 0;
	

}
