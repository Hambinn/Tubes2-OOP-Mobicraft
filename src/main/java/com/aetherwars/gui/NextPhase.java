package com.aetherwars.gui;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class NextPhase extends JPanel {
    private String curr_phase;
    private String next_phase;
	/**
	 * Create the panel.
	 */
	public NextPhase(String phaseName, int width, int height, String curr_phase) {
        super();
		setLayout(null);
		setBackground(Color.LIGHT_GRAY);
		JLabel phase = new JLabel(phaseName, SwingConstants.CENTER);
		phase.setVerticalAlignment(SwingConstants.TOP);
		phase.setBounds(0,2,width,height);
		phase.setFont(new Font("Cascadia Code", 1, 14));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (curr_phase == "DRAW") {
                    next_phase = "PLAN";
                } else if (curr_phase == "PLAN") {
                    next_phase = "ATTACK";
                } else if (curr_phase == "ATTACK") {
                    next_phase = "END";
                } else if (curr_phase == "END") {
                    next_phase = "DRAW";
                }
//            repaint();
            }
          });    
		add(phase);
	}

    public String getNextPhase() {
        return next_phase;
    }

}
