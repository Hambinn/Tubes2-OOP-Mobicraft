package com.aetherwars.gui;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Phase extends JPanel {

	/**
	 * Create the panel.
	 */
	public Phase(String phaseName, int width, int height) {
		setLayout(null);
		JLabel phase = new JLabel(phaseName, SwingConstants.CENTER);
		phase.setVerticalAlignment(SwingConstants.TOP);
		phase.setBounds(0,2,width,height);
		phase.setFont(new Font("Cascadia Code", 1, 14));
		add(phase);
	}

}
