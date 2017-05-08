package com.celestial.butterflystorm.butterfly2016.bowling.test;

import java.util.Random;

import com.celestial.butterflystorm.butterfly2016.bowling.game.Game;

import junit.framework.TestCase;


public class TestGame extends TestCase {
	private Game g;
	
	public void setUp(){
		g = new Game();
	}
	
	public void testSpare(){
		randomAdd(g,5);//0 1 2 3 4(�ӵ�0����ʼ)
		g.add(4);
		g.add(5);// 5
		
		g.add(5);//6 (spare)
		g.add(5);
		
		g.add(4);//7
		g.add(5);
		
		assertEquals(9, g.score(5));
		
		assertEquals(14, g.score(6));
		
	}
	
	public void testStrike(){
		randomAdd(g,7);
		
		g.add(10);
		g.add(8);
		g.add(1);
		assertEquals(19, g.score(7));
	}
	
	public void testNormalScore(){
		g.add(5);
		g.add(3);
		g.add(2);
		g.add(7);
		assertEquals(8, g.score(0));
		assertEquals(9, g.score(1));
	}
	
	public void testStrikeScore(){
		g.add(5);
		g.add(3);
		g.add(10);
		g.add(2);
		g.add(7);
		assertEquals(8, g.score(0));
		assertEquals(19, g.score(1));
		assertEquals(9, g.score(2));
	}
	public void testPerfectGame(){
		for(int i=0;i<Game.GAMEROUND;i++){
			g.add(10);
		}
		for(int i=0;i<Game.GAMEROUND -1;i++){
			assertEquals(20, g.score(i));
		}
	}
	public void testDrunkPerfect(){
		for(int i=0;i<Game.GAMEROUND;i++){
			int pines1 = (int)Math.floor(Math.random()*10);//��Ҫ10.������demo,ʵ���������һ��10��ͽ�����һ����,�����������ӵڶ���0������..
			g.add(pines1);
			g.add(10-pines1);
		}
		for(int i=0;i<Game.GAMEROUND -1;i++){
			int drunkScore = 10+g.getRoundArr()[i+1].firstScore();
			assertEquals(drunkScore, g.score(i));
		}
	}
	
	public void testMax(){
		randomAdd(g,9);
		g.add(5);
		g.add(5);
		g.add(10);
		
		assertEquals(20, g.score(9));
	}

	/**
	 * <b>����˵����</b>
	 * <ul>
	 * Ϊ��Ϸgame ��� n�غϵ�¼������
	 * </ul>
	 * @param game
	 * @param n
	 */
	private void randomAdd(Game game, int n) {
		if(n<0 || n > 11)
			throw new RuntimeException("�غ������ܴ���11��С��0");
		for(int i=0;i<n;i++){
			Random r = new Random();
			int pines1 = r.nextInt(10)+1;//1 <= pines1 <= 10
			game.add(pines1);
			if(pines1 != 10){
				game.add(r.nextInt(10-pines1)+1);
			}
		}
	}
	
	public void testGainScore(){
		g.add(1);
		g.add(4);
		
		g.add(4);
		g.add(5);
		
		g.add(6);
		g.add(4);
		
		g.add(5);
		g.add(5);
		
		g.add(10);//ok
		//-------------һ��--------
		
		g.add(0);
		g.add(1);
		
		g.add(7);
		g.add(3);
		
		g.add(6);
		g.add(4);
		
		g.add(10);
		
		g.add(2);
		g.add(8);
		
		g.add(6);
		g.add(0);
		
		assertEquals(5,g.gainScore(0));
		assertEquals(14,g.gainScore(1));
		assertEquals(29,g.gainScore(2));
		
		assertEquals(49,g.gainScore(3));
		assertEquals(60,g.gainScore(4));
		assertEquals(61,g.gainScore(5));
		
		assertEquals(77,g.gainScore(6));
		assertEquals(97,g.gainScore(7));
		assertEquals(117,g.gainScore(8));
		
		assertEquals(133,g.gainScore(9));
		
		
	}
}
