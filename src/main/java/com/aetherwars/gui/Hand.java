package gui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Hand extends JPanel {
	private BufferedImage image;
	private Image scaledImage;
	private int width;
	private int height;
	private boolean isFilled;

	/**
	 * Create the panel.
	 */
	public Hand(boolean isFilled, String filename) {
		setLayout(null);
		try {
			this.isFilled = isFilled;
			if (isFilled) {
				image = ImageIO.read(this.getClass().getResource(filename));
				width = image.getWidth();
				height = image.getHeight();
				while ((width > 100) || (height > 75)) {
					width = (int) (width*0.9);
					height = (int) (height*0.9);
				}
				scaledImage = image.getScaledInstance(width,height,Image.SCALE_SMOOTH);
				JLabel mana = new JLabel("MANA 3", SwingConstants.CENTER);
				mana.setBounds(2,90,100,20);
				mana.setFont(new Font("Cascadia Code", 0, 12));
				add(mana);
				JLabel stat = new JLabel("ATK+4/HP+1", SwingConstants.CENTER);
				stat.setBounds(2,110,100,20);
				stat.setFont(new Font("Cascadia Code", 0, 12));
				add(stat);
			}
			else {
				//do nothing
			}
		} catch (IOException ex) {
	             // handle exception...
	    }
	}
	
    @Override
    protected void paintComponent(Graphics g) {
    	if (isFilled) {
            super.paintComponent(g);
            g.drawImage(scaledImage, (103-width)/2, 10, this);    		
    	}
	}

}
