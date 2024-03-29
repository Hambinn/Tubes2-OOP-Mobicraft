package com.aetherwars.gui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.aetherwars.player.*;

public class Mana extends JPanel {
	private int manaMax;

	/**
	 * Create the panel.
	 */
	public Mana(Player player) {
		setLayout(null);

		JLabel mana1 = new JLabel("MANA", SwingConstants.CENTER);
		mana1.setBounds(2,5,65,30);
		mana1.setFont(new Font("Cascadia Code", 1, 14));
		manaMax = player.getMana();
		String totalMana = Integer.toString(player.getMana())+ "/" + Integer.toString(player.getRound());
		JLabel isiMana = new JLabel(totalMana, SwingConstants.CENTER);
	    isiMana.setBounds(2, 25, 65, 30);
		isiMana.setFont(new Font("Cascadia Code", 1, 14));
		add(mana1);
		add(isiMana);
	}

}
