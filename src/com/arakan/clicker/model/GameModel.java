package com.arakan.clicker.model;

import java.util.ArrayList;
import java.util.List;

public class GameModel {

	private int fragment = 0;
	private int clickPower = 1;
	private int autoCount = 0;
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
    
    public int getCost() {
    	 return clickUpgrade.getCost();
    }
    
    public int getAutoCountCost() {
    		return autoUpgrade.getCost();
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
    		fragment += autoCount;
    }

    // クリックから獲得できるスコアを増やす
    public void buyUpgrade(Upgrade up) {
    	 if(fragment < up.getCost()) return;
    	    fragment -= up.getCost();
    	    switch(up.getType()) {
    	        case CLICK:
    	            clickPower += up.getPower();
    	            break;
    	        case AUTO:
    	            autoCount += up.getPower();
    	            break;
    	    }
    		up.increaseCost();
    }
    
    // コストの更新
    public void upgradeCost() {
    		clickUpgrade.increaseCost();
    }
    
    // 自動欠片収集のコストの更新
    public void upgradeAutoCountCost() {
    		autoUpgrade.increaseCost();
    }
    
    // コスト分スコアを引く
    public void diffFragment() {
    		fragment -= clickUpgrade.getCost();
    }
    public void fragmentDiffAutoCountCost() {
    		fragment -= autoUpgrade.getCost();
    }
    
    // 購入できるかどうかの判定
    public boolean canBuyUpgrade(Upgrade up) {
        return fragment >= up.getCost();
    }
}
