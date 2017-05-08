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
		String message = "������¼��.";
		if(pins<0)
			throw new RuntimeException("����������С����" + message);
		else if(pins >10)
			throw new RuntimeException("���������ܴ���10" + message);
		else if((scoresArr[0] + scoresArr[1]) > 10)
			throw new RuntimeException("�ܹ����������ܳ���10" + message);
		
	}

	public int score(Round nextRound){
		if(!throwFinish)
			throw new RuntimeException("��δͶ�����,�޷���");
		calculateScore(nextRound);
		return score;
	}
	
	private void calculateScore(Round nextRound) {//�쳣�����������
		score = scoresArr[0] + scoresArr[1];
		if(strike || spare){
			if(!nextRound.isThrowFinish())
				throw new RuntimeException("����strike����spare,��ȴ�nextRoundͶ�����.");//��Ȼspare������ȫ�ȴ���һ�����..�����ȽϾ����..����˵�������Ծ���,�Ǹ���߶���Ҳ��,�����Ǹ��ӹ��ܶ�������,ȫ����?No,���Ƿ����(Ӱ��ϴ�,ҵ��������߲�������)��Ϊ������������.
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
