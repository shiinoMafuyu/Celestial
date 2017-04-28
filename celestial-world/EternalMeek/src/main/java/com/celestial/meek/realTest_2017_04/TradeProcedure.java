package com.celestial.meek.realTest_2017_04;

public class TradeProcedure {
	
	public static void main(String[] args) {
		TradeDependence tradeDependence = new TradeDependence();
		TradeProcedure.processTrade(tradeDependence);
		
	}

	/**
	 * ÒµÎñÂß¼­
	 * @param tradeDependence
	 */
	public static void processTrade(TradeDependence td) {
		Trader buyer = td.getBuyer();
		Trader seller = td.getSeller();
		Trader manager = td.getManager();
		
		
		Money feeMoney = td.getFee().calFee(td.getMoney());
		Money feeClearMoney = td.getMoney().sub(feeMoney.getAmount());
		
		buyer.sub(td.getMoney()).add(td.getGoods());
		seller.add(feeClearMoney).sub(td.getGoods());
		manager.add(feeMoney);
		
	}

	
}
