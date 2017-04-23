package com.celestial.agniRadiance.test.realTest_2017_04;

public class Fee {
	FeeType feeType = FeeType.Rate;
	
	Double rate = 0.05;
	Double fiexd = 0.0;
	Ladder ladder = new Ladder();
	
	public Money calFee(Money money) {
		Money feeMaoney = new Money().setCurrenceType(money.getCurrenceType());
		switch (feeType.getType()) {
		case 1:
			feeMaoney.setAmount(rate*money.getAmount());
			break;
		case 2:
			feeMaoney.setAmount(fiexd);
			break;
		case 3:
			feeMaoney.setAmount(ladder.getFee(money.getAmount()));
			break;
		default:
			feeMaoney.setAmount(rate*money.getAmount());
			break;
		}
		
		return feeMaoney;
		
		
	}

}

enum FeeType {

	Rate(1),Fixed(2),Ladder(3);
	
	private Integer type;
	
	private FeeType(int t){
		this.setType(t);
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}
