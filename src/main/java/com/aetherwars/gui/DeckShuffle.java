package com.aetherwars.gui;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class DeckShuffle extends JPanel {
	/**
	 * Create the panel.
	 */
	public DeckShuffle(int sisaDeck) {
		setLayout(null);
		String totalDeck = sisaDeck + "/60";
		JLabel deck1 = new JLabel("DECK", SwingConstants.CENTER);
		deck1.setBounds(2,5,65,30);
		deck1.setFont(new Font("Cascadia Code", 1, 14));
	    add(deck1);
	    
	    JLabel lblNewLabel = new JLabel(totalDeck, SwingConstants.CENTER);
	    lblNewLabel.setBounds(2, 25, 65, 30);
		lblNewLabel.setFont(new Font("Cascadia Code", 1, 14));
	    add(lblNewLabel);
	}
}
