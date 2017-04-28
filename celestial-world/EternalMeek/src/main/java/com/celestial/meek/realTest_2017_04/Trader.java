package com.celestial.meek.realTest_2017_04;

public class Trader {
	String id;
	String name;
	Money money;
	Goods goods;
	
	Integer antScore;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Money getMoney() {
		return money;
	}

	public void setMoney(Money money) {
		this.money = money;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Integer getAntScore() {
		return antScore;
	}

	public void setAntScore(Integer antScore) {
		this.antScore = antScore;
	}

	public void query(Goods goods2) {
		this.goods = new Goods();
		this.money = new Money();
		
	}

	public Trader add(Money money) {
		this.money.add(money.getAmount());
		return this;
	}

	public Trader sub(Money money2) {
		this.money.sub(money.getAmount());
		return this;
	}

	public Trader sub(Goods goods2) {
		this.goods.sub(goods2.getNum());
		return this;
	}

	public Trader add(Goods goods2) {
		this.goods.add(goods2.getNum());
		return this;
	}
	
	
}
