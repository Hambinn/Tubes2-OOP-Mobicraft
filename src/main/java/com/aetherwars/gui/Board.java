package com.aetherwars.gui;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.aetherwars.model.Card;

public class Board extends JPanel {
	private BufferedImage image;
	private Image scaledImage;
	private int width;
	private int height;
	private BufferedImage imageSword;
	private Image scaledImageSword;
	private BufferedImage imageHeart;
	private Image scaledImageHeart;
	private boolean isFilled;

	/**
	 * Create the panel.
	 */
	public Board(Card card, boolean isFilled, String deckPos) {
		setLayout(null);
		this.isFilled = isFilled;
		try {
			if (isFilled) {
				imageHeart = ImageIO.read(new FileInputStream("src/main/java/com/aetherwars/gui/heart.png"));
				imageSword = ImageIO.read(new FileInputStream("src/main/java/com/aetherwars/gui/sword.png"));
				scaledImageHeart = imageHeart.getScaledInstance(15,15,Image.SCALE_SMOOTH);
				scaledImageSword = imageSword.getScaledInstance(15,15,Image.SCALE_SMOOTH);
				image = ImageIO.read(new FileInputStream("src/main/resources/com/aetherwars/" + card.getImagePath()));
				width = image.getWidth();
				height = image.getHeight();
				while ((width > 75) || (height > 80)) {
					width = (int) (width*0.9);
					height = (int) (height*0.9);
				}
				scaledImage = image.getScaledInstance(width,height,Image.SCALE_SMOOTH);
				JLabel atk = new JLabel(Integer.toString(card.getAttack()), SwingConstants.CENTER);
				atk.setBounds(2,20,15,15);
				atk.setFont(new Font("Cascadia Code", 0, 10));
				add(atk);
				JLabel hp = new JLabel(Integer.toString(card.getHealth()), SwingConstants.CENTER);
				hp.setBounds(86,20,15,15);
				hp.setFont(new Font("Cascadia Code", 0, 10));
				add(hp);
				JLabel stat = new JLabel("0/1 [1]", SwingConstants.CENTER);
				stat.setBounds(2,105,100,20);
				stat.setFont(new Font("Cascadia Code", 0, 10));
				add(stat);				
			}
			else {
				JLabel pos = new JLabel(deckPos, SwingConstants.CENTER);
				pos.setBounds(2,2,100,122);
				pos.setFont(new Font("Cascadia Code", 0, 20));
				add(pos);				
			}
		} catch (IOException ex) {
	             // handle exception...
	    }
	}

	public boolean isFilled(){
		return this.isFilled;
	}
	
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (isFilled) {
            g.drawImage(scaledImage, (103-width)/2, (125-height)/2, this);
            g.drawImage(scaledImageSword, 2, 2, this);          
            g.drawImage(scaledImageHeart, 86, 2, this);         	
        }
	}
}
