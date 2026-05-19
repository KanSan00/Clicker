package com.arakan.clicker.model;

public class Upgrade {

	private UpgradeType type;
	
	private String name;
	private int cost;
	private int power;
	private double magnification = 1.2;
	
	public Upgrade(String name, int cost, int power, UpgradeType type) {
		this.name = name;
		this.cost = cost;
		this.power = power;
		this.type = type;
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
	
	public UpgradeType getType() {
	    return type;
	}
	
	// コスト増加
    public void increaseCost() {
        cost = (int)(cost * magnification);
    }
}
