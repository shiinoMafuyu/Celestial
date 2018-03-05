package com.celestial.meek.realTest_2017_11;

import java.util.concurrent.ThreadLocalRandom;

public class AccountCreator {

	public static void main(String[] args) {
		int portStart = 8900;
		
		String[] passwords = new String[]{"ForestBlaze","AgniShine","TrilithonShake","LavaCromlech","MercuryPoison","PrincessUndine","BuryinLake","EmeraldMegalith","SilentSelene"};
		for(int i=0;i<100;i++){
			int index = ThreadLocalRandom.current().nextInt(passwords.length -1);
			String pwd = passwords[index] + ThreadLocalRandom.current().nextInt(1000, 9999);
			
			System.out.println(String.format("\"%s\":\"%s\",", (portStart+i),pwd));
		}
		
	}

	
	
}
