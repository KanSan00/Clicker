package com.arakan.clicker.model.upgrade;

public class ClickUpgrade extends Upgrade {

	public ClickUpgrade(UpgradeType type) {
		super(type);
	}

	@Override
	public void buyUpgrade() {
		ability++;
	}
}
