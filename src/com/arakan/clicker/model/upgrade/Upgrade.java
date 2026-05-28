package com.arakan.clicker.model.upgrade;

public class Upgrade {

	protected UpgradeType type;
	
	protected String name;
	protected int cost;
	protected int ability;
	protected double magnification = 1.2;
	
	public Upgrade(UpgradeType type) {
		this.type = type;
		this.name = type.getName();
		this.cost = type.getCost();
		this.ability = type.getAbility();
	}
	
	public UpgradeType getType() {
		return type;
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
	
	// コスト増加
    public void increaseCost() {
        cost = (int)(cost * magnification);
    }
    
    public void buyUpgrade() {
    		ability++;
    }
}
