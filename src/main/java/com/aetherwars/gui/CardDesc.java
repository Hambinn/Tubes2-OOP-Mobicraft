package com.aetherwars.gui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.aetherwars.player.*;
import com.aetherwars.model.*;
import com.aetherwars.spell.*;

public class CardDesc extends JPanel {

	/**
	 * Create the panel.
	 */
	public CardDesc(String classification, Card card) {
		setLayout(null);
		if (classification == "CardInfo") {
			JLabel desc = new JLabel(card.getName(), SwingConstants.CENTER);
			desc.setBounds(5,12,142,25);
			desc.setFont(new Font("Cascadia Code", 1, 14));
			add(desc);

			if (card.getTypeCard() == "Character"){
				JLabel type = new JLabel("Type : " + card.getTypeCard() + " " + card.getType(), SwingConstants.LEFT);
				type.setBounds(5,37,142,15);
				type.setFont(new Font("Cascadia Code", 0, 10));
				add(type);
				JLabel atk = new JLabel("ATK : " + card.getAttack(), SwingConstants.LEFT);
				atk.setBounds(5,52,142,15);
				atk.setFont(new Font("Cascadia Code", 0, 10));
				add(atk);
				JLabel hp = new JLabel("HP : " + card.getHealth(), SwingConstants.LEFT);
				hp.setBounds(5,67,142,15);
				hp.setFont(new Font("Cascadia Code", 0, 10));
				add(hp);
				JLabel level = new JLabel("Level : 1" , SwingConstants.LEFT);
				level.setBounds(5,82,142,15);
				level.setFont(new Font("Cascadia Code", 0, 10));
				add(level);
				JLabel exp = new JLabel("EXP : 0/1", SwingConstants.LEFT);
				exp.setBounds(5,97,142,15);
				exp.setFont(new Font("Cascadia Code", 0, 10));
				add(exp);
			}
			else if (card.getSpellType() == "Potion"){
				JLabel type = new JLabel("Type : " + card.getTypeCard() + " " + card.getSpellType(), SwingConstants.LEFT);
				type.setBounds(5,37,142,15);
				type.setFont(new Font("Cascadia Code", 0, 10));
				add(type);
				JLabel atk = new JLabel("Update ATK : " + card.getAttack(), SwingConstants.LEFT);
				atk.setBounds(5,52,142,15);
				atk.setFont(new Font("Cascadia Code", 0, 10));
				add(atk);
				JLabel hp = new JLabel("Update HP : " + card.getHealth(), SwingConstants.LEFT);
				hp.setBounds(5,67,142,15);
				hp.setFont(new Font("Cascadia Code", 0, 10));
				add(hp);
			}
			else if (card.getSpellType() == "Morph"){
				JLabel type = new JLabel("Type : " + card.getTypeCard() + " " + card.getSpellType(), SwingConstants.LEFT);
				type.setBounds(5,37,142,15);
				type.setFont(new Font("Cascadia Code", 0, 10));
				add(type);
			}
			else if (card.getSpellType() == "Swap"){
				JLabel type = new JLabel("Type : " + card.getTypeCard() + " " + card.getSpellType(), SwingConstants.LEFT);
				type.setBounds(5,37,142,15);
				type.setFont(new Font("Cascadia Code", 0, 10));
				add(type);
			}
		}
		else {
			String text = card.getDescription();
			JLabel atk = new JLabel("<html>" + text + "</html>", SwingConstants.LEFT);
			atk.setBounds(5,5,142,135);
			atk.setFont(new Font("Cascadia Code", 0, 10));
			add(atk);
		}
	}

}
