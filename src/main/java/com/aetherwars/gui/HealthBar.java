package gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class HealthBar extends JPanel {

	/**
	 * Create the panel.
	 */
	public HealthBar(int currHealth, String player) {
		setLayout(null);
		if (player == "A") {
			JPanel health = new JPanel();
			int width = currHealth*6;
			health.setBackground(Color.CYAN);
			health.setBounds(0, 0, width, 20);
			add(health);			
		}
		else {
			JPanel health = new JPanel();
			int width = (80-currHealth)*6;
			health.setBounds(0, 0, width, 20);
			add(health);
		}
	}
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
