package com.arakan.clicker.model;

public enum UpgradeType {
    CLICK{
    		@Override
    		public void apply(GameModel model, int power) {
    			model.addClickPower(power);
    		}
    },
    AUTO{
    		@Override
    		public void apply(GameModel model, int power) {
    			model.addAutoPower(power);
    		}
    	
    };
    
    // 抽象メソッド
    public abstract void apply(GameModel model,int power);
}
