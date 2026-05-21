package com.arakan.clicker.model;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class GameModel {

	private int fragment = 0;
	
	private Map<UpgradeType, Integer> stats = new EnumMap<>(UpgradeType.class);
	
	private List<Upgrade> upgrades = new ArrayList<>();

    public GameModel() {
        for (UpgradeType type : UpgradeType.values()) {
            upgrades.add(new Upgrade(type));
            stats.put(type, 0);
        }
        stats.put(UpgradeType.CLICK, 1);
    }
    
    public int getPower(UpgradeType type) {
        return stats.get(type);
    }
    
    public void addPower(UpgradeType type,int value) {
    		stats.put(type,stats.get(type) + value);
    }
    
    
    public List<Upgrade> getUpgrades() {
        return upgrades;
    }
    
    // 獲得スコアを返す
    public int getFragment() {
        return fragment;
    }

    // クリックされた時に追加されるスコア
    public void addFragment(Upgrade up) {
    		fragment += up.getPower();
    }
    
    /**
     * 渡されたTypeからそのUpgradeを返す。
     * @param type
     * @return
     */
    public Upgrade getUpgrade(UpgradeType type) {
    		for(Upgrade up : upgrades) {
    			if(up.getType() == type) {
    				return up;
    			}
        }

        return null;
    }

    /**
     *  クリックから獲得できるスコアを増やす
     * @param up
     */
    public void buyUpgrade(Upgrade up) {
    	
    	if(!canBuyUpgrade(up)) return;
    	
    	    fragment -= up.getCost();
    	    
    		up.increaseCost();
    		up.increasePower();
    }
    
    /**
     *  購入できるかどうかの判定
     * @param up
     * @return
     */
    public boolean canBuyUpgrade(Upgrade up) {
        return fragment >= up.getCost();
    }
}
