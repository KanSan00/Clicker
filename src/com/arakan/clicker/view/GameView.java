package com.arakan.clicker.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagLayout;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.arakan.clicker.model.upgrade.Upgrade;

public class GameView extends JFrame {
	private JLabel fragmentLabel;
	// GameView.java の上部（フィールド変数定義）に追記
	private JLabel intervalLabel; // ← 追加
    private JButton clickButton;
    
    private Map<Upgrade, JButton> upgradeButtons = new HashMap<>();
    
    public GameView(List<Upgrade> upgrades) {
        setTitle("クリッカー");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // フルスクリーン
        GraphicsDevice device = GraphicsEnvironment
                .getLocalGraphicsEnvironment()
                .getDefaultScreenDevice();
        device.setFullScreenWindow(this);

        setLayout(new BorderLayout());

        // スコア
        fragmentLabel = new JLabel("欠片: 0");
        fragmentLabel.setFont(new Font("Serif", Font.BOLD, 24));
        
        intervalLabel = new JLabel("収集間隔: 1000ms");
        intervalLabel.setFont(new Font("Serif", Font.PLAIN, 18));

        // 現状左上のパネル
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(fragmentLabel, BorderLayout.WEST);
        topPanel.add(intervalLabel, BorderLayout.EAST);
        
        // ボタン
        clickButton = new JButton("クリック！");
        clickButton.setPreferredSize(new Dimension(200, 200));
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.add(clickButton);
        
        // 強化ボタン
        JPanel rightPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        
        // 強化ボタンの自動生成。強化項目の数に応じて生成する
        for(Upgrade up : upgrades) {
            JButton button = new JButton(up.getName()+ " : "+ up.getCost());
            button.setPreferredSize(new Dimension(200, 100));
            buttonPanel.add(button);
            buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));
            // Mapに追加
            upgradeButtons.put(up, button);
        }
        rightPanel.add(buttonPanel);

        add(centerPanel, BorderLayout.CENTER);
        add(topPanel, BorderLayout.NORTH);
        add(rightPanel, BorderLayout.EAST);

        setVisible(true);
    }

    public void setScore(int fragment) {
    		fragmentLabel.setText("欠片: " + fragment);
    }

    public JButton getClickButton() {
        return clickButton;
    }
    
    public void updateUpgradeButton(Upgrade up, boolean canBuy) {
    	    JButton button = upgradeButtons.get(up);
    	    button.setText(up.getName()+ " : "+ up.getCost());
    	    button.setEnabled(canBuy);
    	}
    
    /**
     * 渡されてきた強化内容のボタンを返す
     * @param up
     * @return
     */
    public JButton getUpgradeButton(Upgrade up) {
    	    return upgradeButtons.get(up);
    	}
    
 // ▼ 下部（メソッド定義エリア）に、値を更新するためのメソッドを追加 ▼
    public void setIntervalText(int ms) {
        intervalLabel.setText("収集間隔: " + ms + "ms");
    }
}
