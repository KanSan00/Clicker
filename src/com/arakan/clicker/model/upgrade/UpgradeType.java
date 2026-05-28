package com.arakan.clicker.model.upgrade;

public enum UpgradeType {
    CLICK("クリック強化", 100, 1),
    AUTO("自動強化", 100, 1),
	TIMESAVING("時間短縮", 100, 50);
	
	private String name;
	private int cost;
	private int ability;
	
	UpgradeType(String name, int cost, int ability){
		this.name = name;
		this.cost = cost;
		this.ability = ability;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getCost() {
		return this.cost;
	}
	
	public int getAbility() {
		return this.ability;
	}
}
