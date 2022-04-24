package com.aetherwars.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class CharIcon extends JPanel {
	private BufferedImage image;
	private Image scaledImage;
	/**
	 * Create the panel.
	 */
	public CharIcon(String filename) {
		try {                
			image = ImageIO.read(new FileInputStream(filename));
			scaledImage = image.getScaledInstance(120,120,Image.SCALE_SMOOTH);
		} catch (IOException ex) {
	             // handle exception...
	    }
	}
	
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(scaledImage, 0, 0, this);          
    }
}
