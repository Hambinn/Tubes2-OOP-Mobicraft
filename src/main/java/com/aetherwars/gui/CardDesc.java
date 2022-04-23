package gui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class CardDesc extends JPanel {

	/**
	 * Create the panel.
	 */
	public CardDesc(String classification) {
		setLayout(null);
		if (classification == "CardInfo") {
			JLabel desc = new JLabel("Nama Kartu", SwingConstants.CENTER);
			desc.setBounds(5,12,142,25);
			desc.setFont(new Font("Cascadia Code", 1, 14));
			add(desc);
			JLabel atk = new JLabel("ATK : 1", SwingConstants.LEFT);
			atk.setBounds(5,37,142,15);
			atk.setFont(new Font("Cascadia Code", 0, 10));
			add(atk);
			JLabel hp = new JLabel("HP : 10", SwingConstants.LEFT);
			hp.setBounds(5,52,142,15);
			hp.setFont(new Font("Cascadia Code", 0, 10));
			add(hp);
			JLabel level = new JLabel("Level : 1", SwingConstants.LEFT);
			level.setBounds(5,67,142,15);
			level.setFont(new Font("Cascadia Code", 0, 10));
			add(level);
			JLabel exp = new JLabel("EXP : 0/1", SwingConstants.LEFT);
			exp.setBounds(5,82,142,15);
			exp.setFont(new Font("Cascadia Code", 0, 10));
			add(exp);
			JLabel type = new JLabel("Type : Gatau", SwingConstants.LEFT);
			type.setBounds(5,97,142,15);
			type.setFont(new Font("Cascadia Code", 0, 10));
			add(type);
		}
		else {
			String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas lacus ante, laoreet eu pretium vel, aliquet sit amet justo. Mauris ut auctor lectus, at dapibus mauris.";
			JLabel atk = new JLabel("<html>" + text + "</html>", SwingConstants.LEFT);
			atk.setBounds(5,5,142,135);
			atk.setFont(new Font("Cascadia Code", 0, 10));
			add(atk);
		}
	}

}
