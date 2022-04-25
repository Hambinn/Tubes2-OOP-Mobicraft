package com.aetherwars.gui;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class Phase extends JPanel {

	/**
	 * Create the panel.
	 */
	public Phase(String phaseName, int width, int height, String curr_phase) {
		setLayout(null);
		if (curr_phase.equals(phaseName)) {
			setBackground(Color.GREEN);
		} else {
			setBackground(Color.ORANGE);
		}
		JLabel phase = new JLabel(phaseName, SwingConstants.CENTER);
		phase.setVerticalAlignment(SwingConstants.TOP);
		phase.setBounds(0,2,width,height);
		phase.setFont(new Font("Cascadia Code", 1, 14));
		add(phase);
	}

}
