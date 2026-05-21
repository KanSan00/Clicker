package com.arakan.clicker.model;

public enum UpgradeType {
    CLICK("クリック強化", 100, 1),
    AUTO("自動強化", 100, 1);
	
	private String name;
	private int cost;
	private int power;
	
	UpgradeType(String name, int cost, int power){
		this.name = name;
		this.cost = cost;
		this.power = power;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getCost() {
		return this.cost;
	}
	
	public int getPower() {
		return this.power;
	}
}
