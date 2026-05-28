package com.arakan.clicker.model.upgrade;

public class TimeUpgrade extends Upgrade {
	
	AutoUpgrade auto;
	
	public TimeUpgrade(UpgradeType type, AutoUpgrade auto) {
		super(type);
		
		this.auto = auto;
	}

	@Override
	public void buyUpgrade() {
		this.auto.shortenInterval(50);
	}

}
