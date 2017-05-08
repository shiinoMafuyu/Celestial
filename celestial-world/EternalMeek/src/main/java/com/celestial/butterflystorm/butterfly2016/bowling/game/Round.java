package com.celestial.butterflystorm.butterfly2016.bowling.game;


public class Round {
	
	public void add(int pins){
		check(pins);
		if(firstHit){
			scoresArr[0] = pins;
			firstHit = false;
			if(pins == 10){
				scoresArr[1] = 0;
				strike = true;
				throwFinish = true;
			}
		}else{
			scoresArr[1] = pins;
			throwFinish = true;
			if(scoresArr[0] + scoresArr[1] == 10){
				spare = true;
			}
		}
		
	}
	
	private void check(int pins) {
		String message = "请重新录入.";
		if(pins<0)
			throw new RuntimeException("击倒数不能小于零" + message);
		else if(pins >10)
			throw new RuntimeException("击倒数不能大于10" + message);
		else if((scoresArr[0] + scoresArr[1]) > 10)
			throw new RuntimeException("总共击倒数不能超过10" + message);
		
	}

	public int score(Round nextRound){
		if(!throwFinish)
			throw new RuntimeException("尚未投掷完成,无分数");
		calculateScore(nextRound);
		return score;
	}
	
	private void calculateScore(Round nextRound) {//异常管理就免了嘛
		score = scoresArr[0] + scoresArr[1];
		if(strike || spare){
			if(!nextRound.isThrowFinish())
				throw new RuntimeException("此轮strike或者spare,需等待nextRound投掷完成.");//虽然spare不必完全等待下一轮完成..这样比较精简吧..或者说这样可以精简,那更大尺度上也能,那岂不是复杂功能都不做了,全精简?No,把是否必须(影响较大,业务需求或者操作体验)纳为考虑条件即可.
			score += nextRound.getScoresArr()[0];
			if(strike)
				score += nextRound.getScoresArr()[1];
		}
	}
	
	@Override
	public String toString() {
		return "Round [(" + scoresArr[0] + "," + scoresArr[1] + ")]";
	}
	
	public boolean isStrike() {
		return strike;
	}
	public boolean isSpare() {
		return spare;
	}
	
	public int firstScore(){
		return scoresArr[0];
	}
	
	public int secondScore(){
		return scoresArr[1];
	}
	
	public boolean isThrowFinish() {
		return throwFinish;
	}
	
	public int[] getScoresArr() {
		return scoresArr;
	}
	
	private int score = -1;
	private int[] scoresArr = new int[2];
	private boolean firstHit = true;
	private boolean strike = false;
	private boolean spare = false;
	private boolean throwFinish = false;
	
}
