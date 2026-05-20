package com.arakan.clicker.model;

import java.util.ArrayList;
import java.util.List;

public class GameModel {

	private int fragment = 0;
	private int clickPower = 1;
	private int autoPower = 0;
    private Upgrade clickUpgrade;
    private Upgrade autoUpgrade;
	
	private List<Upgrade> upgrades = new ArrayList<>();

    public GameModel() {
	    	clickUpgrade = new Upgrade("クリック強化", 100, 1, UpgradeType.CLICK);
	    	autoUpgrade = new Upgrade("自動強化", 100, 1, UpgradeType.AUTO);

    		upgrades.add(clickUpgrade);
    		upgrades.add(autoUpgrade);
    }
    
    public List<Upgrade> getUpgrades() {
        return upgrades;
    }
    
    public Upgrade getClickUpgrade() {
        return clickUpgrade;
    }

    public Upgrade getAutoUpgrade() {
        return autoUpgrade;
    }
    
    // 獲得スコアを返す
    public int getFragment() {
        return fragment;
    }

    // ワンクリックのパワーを返す
    public int getClickPower() {
        return clickUpgrade.getPower();
    }

    // クリックされた時に追加されるスコア
    public void addFragment() {
    		fragment += clickPower;
    }
    // 自動でスコア増やす
    public void addAutoFragment() {
    		fragment += autoPower;
    }
    
    public void addClickPower(int power) {
        clickPower += power;
    }

    public void addAutoPower(int power) {
    		autoPower += power;
    }

    // クリックから獲得できるスコアを増やす
    public void buyUpgrade(Upgrade up) {
    	 if(fragment < up.getCost()) return;
    	    fragment -= up.getCost();
    	    applyUpgradeEffect(up);
    		up.increaseCost();
    }
    
    private void applyUpgradeEffect(Upgrade up) {
    		switch(up.getType()) {
    			case CLICK:
    				clickPower += up.getPower();
    				break;
    			case AUTO:
    				autoPower += up.getPower();
    				break;
    		}
    }
    
    // 購入できるかどうかの判定
    public boolean canBuyUpgrade(Upgrade up) {
        return fragment >= up.getCost();
    }
}
