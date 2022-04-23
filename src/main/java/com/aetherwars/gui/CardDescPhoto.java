package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class CardDescPhoto extends JPanel {
	private BufferedImage image;
	private Image scaledImage;
	private int width;
	private int height;
	/**
	 * Create the panel.
	 */
	public CardDescPhoto(String filename) {
		try {
			image = ImageIO.read(this.getClass().getResource(filename));
			width = image.getWidth();
			height = image.getHeight();
			while ((width > 111) || (height > 145)) {
				width = (int) (width*0.9);
				height = (int) (height*0.9);
			}
			scaledImage = image.getScaledInstance(width,height,Image.SCALE_SMOOTH);
		} catch (IOException ex) {
	             // handle exception...
	    }
	}
	
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(scaledImage, (111-width)/2, (145-height)/2, this);          
	}
}
