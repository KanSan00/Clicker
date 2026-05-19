package com.arakan.clicker.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameView extends JFrame {
	private JLabel fragmentLabel;
	private JLabel costLabel;
	private JLabel autoCostLabel;
    private JButton clickButton;
    private JButton addClickFragmentButton;
    private JButton addAutoCountButton;

    public GameView() {
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
        // コスト
        costLabel = new JLabel("コスト: 0");
        costLabel.setFont(new Font("Serif", Font.BOLD, 24));
        // 自動欠片のコスト
        autoCostLabel = new JLabel("自動収集: 0");
        autoCostLabel.setFont(new Font("Serif", Font.BOLD, 24));

        // 現状左上のパネル
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(fragmentLabel, BorderLayout.WEST);
        
        // 右上のパネル
        JPanel rightTopPanel = new JPanel();
        rightTopPanel.setLayout(new BoxLayout(rightTopPanel, BoxLayout.Y_AXIS));
        rightTopPanel.add(costLabel);
        rightTopPanel.add(autoCostLabel);
        
        topPanel.add(rightTopPanel, BorderLayout.EAST);

        // ボタン
        clickButton = new JButton("クリック！");
        clickButton.setPreferredSize(new Dimension(200, 200));
        addClickFragmentButton = new JButton("クリックスコア増");
        addClickFragmentButton.setPreferredSize(new Dimension(200, 100));
        addAutoCountButton = new JButton("自動収集コスト増");
        addAutoCountButton.setPreferredSize(new Dimension(200, 100));

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.add(clickButton);
        JPanel rightPanel = new JPanel();
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 250)));
        buttonPanel.add(addClickFragmentButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonPanel.add(addAutoCountButton);
        
        rightPanel.add(buttonPanel);

        add(centerPanel, BorderLayout.CENTER);
        add(topPanel, BorderLayout.NORTH);
        add(rightPanel, BorderLayout.EAST);

        setVisible(true);
    }

    public void setScore(int fragment) {
    		fragmentLabel.setText("欠片: " + fragment);
    }
    
    public void setCost(int cost) {
    		costLabel.setText("コスト: " + cost);
    }
    
    public void setAutoCost(int cost) {
    		autoCostLabel.setText("自動収集コスト: " + cost);
    }

    public JButton getClickButton() {
        return clickButton;
    }
    
    public JButton getAddClickFragmentButton() {
    		return addClickFragmentButton;
    	}
    
    public JButton getAddAutoCountButton() {
    		return addAutoCountButton;
    }
}
