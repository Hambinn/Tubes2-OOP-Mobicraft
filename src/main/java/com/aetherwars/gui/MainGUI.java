package com.aetherwars.gui;


import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import com.aetherwars.player.*;
import com.aetherwars.model.*;
import com.aetherwars.spell.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainGUI extends JFrame {
	private int curr_round;
	private String cardFileName;
	private int choosenDrawCard;
	private String curr_turn;
	private String next_phase;
	private String curr_phase;
	private JPanel contentPane;
	private JPanel drawPhase;
	private JPanel planPhase;
	private JPanel attackPhase;
	private JPanel endPhase;
	private JPanel shadowPanel;
	private JPanel drawCard1;
	private JPanel drawCard2;
	private JPanel drawCard3;
	private List<Card> drawCard;
	private Player player1;
	private Player player2;
	private JPanel hands1;
	private JPanel hands2;
	private JPanel hands3;
	private JPanel hands4;
	private JPanel hands5;
	private List<Card> cardHand;

	/**
	 * Create the frame.
	 */
	public MainGUI(Player player_1, Player player_2) {
		this.player1 = player_1;
		this.player2 = player_2;
		cardHand = player1.getPlayerHand();
		player1.fillTopThree();
		drawCard = player1.getTopThree();
		curr_phase = "DRAW";
		curr_round = 1;
		curr_turn = "PlayerA";
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		drawCard1 = new Hand(true, drawCard.get(0));
		drawCard1.setBounds(373, 209, 103, 145);
		drawCard1.setVisible(false);
		drawCard1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
				choosenDrawCard = 1;
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				drawCard1.setVisible(false);
				drawCard2.setVisible(false);
				drawCard3.setVisible(false);
				shadowPanel.setVisible(false);
				if (curr_turn.equals("PlayerA")) {
					player1.drawCard(choosenDrawCard);
					player1.fillTopThree();
					drawCard = player1.getTopThree();
					cardHand = player1.getPlayerHand();
				} else {
					player2.drawCard(choosenDrawCard);
					player2.fillTopThree();
					drawCard = player2.getTopThree();
					cardHand = player2.getPlayerHand();
				}
				drawCard1 = new Hand(true, drawCard.get(0));
				drawCard2 = new Hand(true, drawCard.get(1));
				drawCard3 = new Hand(true, drawCard.get(2));
				setHands();
			}
          });
		contentPane.add(drawCard1);

		drawCard2 = new Hand(true, drawCard.get(1));
		drawCard2.setBounds(491, 209, 103, 145);
		drawCard2.setVisible(false);
		drawCard2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
				choosenDrawCard = 2;
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				drawCard1.setVisible(false);
				drawCard2.setVisible(false);
				drawCard3.setVisible(false);
				shadowPanel.setVisible(false);
				if (curr_turn.equals("PlayerA")) {
					player1.drawCard(choosenDrawCard);
					player1.fillTopThree();
					drawCard = player1.getTopThree();
				} else {
					player2.drawCard(choosenDrawCard);
					player2.fillTopThree();
					drawCard = player2.getTopThree();
				}
				drawCard1 = new Hand(true, drawCard.get(0));
				drawCard2 = new Hand(true, drawCard.get(1));
				drawCard3 = new Hand(true, drawCard.get(2));
				setHands();
			}
          });
		contentPane.add(drawCard2);

		drawCard3 = new Hand(true, drawCard.get(2));
		drawCard3.setBounds(609, 209, 103, 145);
		drawCard3.setVisible(false);
		drawCard3.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
				choosenDrawCard = 3;
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				drawCard1.setVisible(false);
				drawCard2.setVisible(false);
				drawCard3.setVisible(false);
				shadowPanel.setVisible(false);
				if (curr_turn.equals("PlayerA")) {
					player1.drawCard(choosenDrawCard);
					player1.fillTopThree();
					drawCard = player1.getTopThree();
				} else {
					player2.drawCard(choosenDrawCard);
					player2.fillTopThree();
					drawCard = player2.getTopThree();
				}				
				drawCard1 = new Hand(true, drawCard.get(0));
				drawCard2 = new Hand(true, drawCard.get(1));
				drawCard3 = new Hand(true, drawCard.get(2));
				setHands();
			}
          });
		contentPane.add(drawCard3);
		
		shadowPanel = new JPanel();
		shadowPanel.setBounds(0, 0, 1086, 563);
		shadowPanel.setBackground(new Color(36, 36, 36, 230));
		shadowPanel.setVisible(false);
		contentPane.add(shadowPanel);
		
		JPanel avatarA = new CharIcon("src/main/java/com/aetherwars/gui/charicon1.png");
		avatarA.setBackground(Color.WHITE);
		avatarA.setBounds(9, 155, 120, 120);
		contentPane.add(avatarA);
		
		JPanel avatarB = new CharIcon("src/main/java/com/aetherwars/gui/charicon2.png");
		avatarB.setBackground(Color.WHITE);
		avatarB.setBounds(956, 155, 120, 120);
		contentPane.add(avatarB);
		
		JPanel boardA1 = new Board("src/main/java/com/aetherwars/gui/Piglin Brute.png", true, "A");
		boardA1.setBounds(139, 81, 103, 125);
		contentPane.add(boardA1);
		
		JPanel boardA3 = new Board("", false, "C");
		boardA3.setBounds(139, 216, 103, 125);
		contentPane.add(boardA3);
		
		JPanel boardA2 = new Board("", false, "B");
		boardA2.setBounds(252, 81, 103, 125);
		contentPane.add(boardA2);
		
		JPanel boardA4 = new Board("", false, "D");
		boardA4.setBounds(252, 216, 103, 125);
		contentPane.add(boardA4);
		
		JPanel boardA5 = new Board("", false, "E");
		boardA5.setBounds(365, 150, 103, 125);
		contentPane.add(boardA5);
		
		drawPhase = new Phase("DRAW", 223, 20);
		drawPhase.setBackground(Color.GREEN);
		drawPhase.setBorder(new LineBorder(new Color(0, 0, 0)));
		drawPhase.setBounds(57, 384, 223, 20);
		contentPane.add(drawPhase);
		
		planPhase = new Phase("PLAN", 223, 20);
		planPhase.setBackground(Color.ORANGE);
		planPhase.setBorder(new LineBorder(new Color(0, 0, 0)));
		planPhase.setBounds(279, 384, 223, 20);
		contentPane.add(planPhase);
		
		attackPhase = new Phase("ATTACK", 223, 20);
		attackPhase.setBackground(Color.ORANGE);
		attackPhase.setBorder(new LineBorder(new Color(0, 0, 0)));
		attackPhase.setBounds(501, 384, 223, 20);
		contentPane.add(attackPhase);
		
		endPhase = new Phase("END", 223, 20);
		endPhase.setBackground(Color.ORANGE);
		endPhase.setBorder(new LineBorder(new Color(0, 0, 0)));
		endPhase.setBounds(723, 384, 223, 20);
		contentPane.add(endPhase);
		
		JPanel nextRound = new JPanel();
		nextRound.setLayout(null);
		nextRound.setBackground(Color.LIGHT_GRAY);
		JLabel phase = new JLabel("NEXT>>", SwingConstants.CENTER);
		phase.setVerticalAlignment(SwingConstants.TOP);
		phase.setBounds(0,2,73,20);
		phase.setFont(new Font("Cascadia Code", 1, 14));
		nextRound.add(phase);
		System.out.println(curr_phase);
        nextRound.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (curr_phase == "DRAW") {
                    next_phase = "PLAN";
					drawPhase.setBackground(Color.ORANGE);
					planPhase.setBackground(Color.GREEN);
				} else if (curr_phase == "PLAN") {
                    next_phase = "ATTACK";
					planPhase.setBackground(Color.ORANGE);
					attackPhase.setBackground(Color.GREEN);
                } else if (curr_phase == "ATTACK") {
                    next_phase = "END";
					attackPhase.setBackground(Color.ORANGE);
					endPhase.setBackground(Color.GREEN);
                } else if (curr_phase == "END") {
                    next_phase = "DRAW";
					endPhase.setBackground(Color.ORANGE);
					drawPhase.setBackground(Color.GREEN);
					if (curr_turn == "PlayerA") {
						curr_turn = "PlayerB";
					} else {
						curr_turn = "PlayerA";
						curr_round++;
					}
                }
				curr_phase = next_phase;
			}
          });
		nextRound.setBorder(new LineBorder(new Color(0, 0, 0)));
		nextRound.setBounds(956, 384, 73, 20);
		contentPane.add(nextRound);

		JPanel hands1 = new Hand(false, null);
		hands1.setBounds(14, 408, 103, 145);
		contentPane.add(hands1);
		
		JPanel hands2 = new Hand(false, null);
		hands2.setBounds(119, 408, 103, 145);
		contentPane.add(hands2);
		
		JPanel hands3 = new Hand(false, null);
		hands3.setBounds(224, 408, 103, 145);
		contentPane.add(hands3);
		
		JPanel hands4 = new Hand(false, null);
		hands4.setBounds(329, 408, 103, 145);
		contentPane.add(hands4);
		
		JPanel hands5 = new Hand(false, null);
		hands5.setBounds(434, 408, 103, 145);
		contentPane.add(hands5);

		List<Card> cardHand = player1.getPlayerHand();
		JPanel deck = new DeckShuffle(player1.getSisaDeck());
		deck.setBounds(1011, 414, 65, 60);
		contentPane.add(deck);
		deck.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
				if (curr_phase == "DRAW"){
					//show pop up
					System.out.println("Deck clicked");
					shadowPanel.setVisible(true);
					drawCard1.setVisible(true);
					drawCard2.setVisible(true);
					drawCard3.setVisible(true);
				}
			}
          });

		setHands();
		JPanel mana = new Mana();
		mana.setBounds(1011, 479, 65, 60);
		contentPane.add(mana);
				
		JPanel boardB1 = new Board("", false, "A");
		boardB1.setBounds(843, 81, 103, 125);
		contentPane.add(boardB1);
		
		JPanel boardB2 = new Board("", false, "B");
		boardB2.setBounds(730, 81, 103, 125);
		contentPane.add(boardB2);
		
		JPanel boardB4 = new Board("", false, "D");
		boardB4.setBounds(730, 216, 103, 125);
		contentPane.add(boardB4);
		
		JPanel boardB3 = new Board("src/main/java/com/aetherwars/gui/Skeleton.png", true, "C");
		boardB3.setBounds(843, 216, 103, 125);
		contentPane.add(boardB3);
		
		JPanel boardB5 = new Board("", false, "E");
		boardB5.setBounds(619, 148, 103, 125);
		contentPane.add(boardB5);
		
		JPanel healthBarA = new HealthBar(player1.getHealth(), "A");
		healthBarA.setBounds(10, 10, 480, 20);
		contentPane.add(healthBarA);
		
		JPanel healthBarB = new HealthBar(player2.getHealth(), "B");
		healthBarB.setBackground(Color.CYAN);
		healthBarB.setBounds(596, 10, 480, 20);
		contentPane.add(healthBarB);
		
		JPanel round = new JPanel();
		round.setBounds(506, 10, 73, 60);
		round.setLayout(null);
		JLabel turn = new JLabel("Turn", SwingConstants.CENTER);
		turn.setBounds(0,2,73,25);
		turn.setFont(new Font("Cascadia Code", 0, 16));
		JLabel turnNumber = new JLabel("1", SwingConstants.CENTER);
		turnNumber.setBounds(0,25,73,25);
		turnNumber.setFont(new Font("Cascadia Code", 0, 16));
		round.add(turn);
		round.add(turnNumber);
		contentPane.add(round);
		
		JLabel playerAName = new JLabel(player1.getName(), SwingConstants.LEFT);
		playerAName.setForeground(Color.CYAN);
		playerAName.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		playerAName.setBounds(20, 33, 73, 37);
		contentPane.add(playerAName);
		
		JLabel playerBName = new JLabel(player2.getName(), SwingConstants.RIGHT);
		playerBName.setForeground(Color.CYAN);
		playerBName.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		playerBName.setBounds(992, 33, 73, 37);
		contentPane.add(playerBName);
		contentPane.repaint();
	}

	public void setBorderHand(int index){
		if (index == 0){
			hands1.setBorder(new LineBorder(Color.BLUE));
			hands2.setBorder(null);
			hands3.setBorder(null);
			hands4.setBorder(null);
			hands5.setBorder(null);
		} else if (index == 1){
			hands1.setBorder(null);
			hands2.setBorder(new LineBorder(Color.BLUE));
			hands3.setBorder(null);
			hands4.setBorder(null);
			hands5.setBorder(null);
		}else if (index == 2){
			hands1.setBorder(null);
			hands2.setBorder(null);
			hands3.setBorder(new LineBorder(Color.BLUE));
			hands4.setBorder(null);
			hands5.setBorder(null);
		}else if (index == 3){
			hands1.setBorder(null);
			hands2.setBorder(null);
			hands3.setBorder(null);
			hands4.setBorder(new LineBorder(Color.BLUE));
			hands5.setBorder(null);
		}else if (index == 4){
			hands1.setBorder(null);
			hands2.setBorder(null);
			hands3.setBorder(null);
			hands4.setBorder(null);
			hands5.setBorder(new LineBorder(Color.BLUE));
		}
	}

	public void setHands() {
		if (cardHand.size() == 0) {
			hands1 = new Hand(false, null);
			hands1.setBounds(14, 408, 103, 145);
			contentPane.add(hands1);
			
			hands2 = new Hand(false, null);
			hands2.setBounds(119, 408, 103, 145);
			contentPane.add(hands2);
			
			hands3 = new Hand(false, null);
			hands3.setBounds(224, 408, 103, 145);
			contentPane.add(hands3);
			
			hands4 = new Hand(false, null);
			hands4.setBounds(329, 408, 103, 145);
			contentPane.add(hands4);
			
			hands5 = new Hand(false, null);
			hands5.setBounds(434, 408, 103, 145);
			contentPane.add(hands5);	
		}
		else if (cardHand.size() == 1) {
			hands1 = new Hand(true, cardHand.get(0));
			hands1.setBounds(14, 408, 103, 145);
			contentPane.add(hands1);
			
			hands2 = new Hand(false, null);
			hands2.setBounds(119, 408, 103, 145);
			contentPane.add(hands2);
			
			hands3 = new Hand(false, null);
			hands3.setBounds(224, 408, 103, 145);
			contentPane.add(hands3);
			
			hands4 = new Hand(false, null);
			hands4.setBounds(329, 408, 103, 145);
			contentPane.add(hands4);
			
			hands5 = new Hand(false, null);
			hands5.setBounds(434, 408, 103, 145);
			contentPane.add(hands5);
		}
		else if (cardHand.size() == 2) {
			hands1 = new Hand(true, cardHand.get(0));
			hands1.setBounds(14, 408, 103, 145);
			contentPane.add(hands1);
			
			hands2 = new Hand(true, cardHand.get(1));
			hands2.setBounds(119, 408, 103, 145);
			contentPane.add(hands2);
			
			hands3 = new Hand(false, null);
			hands3.setBounds(224, 408, 103, 145);
			contentPane.add(hands3);
			
			hands4 = new Hand(false, null);
			hands4.setBounds(329, 408, 103, 145);
			contentPane.add(hands4);
			
			hands5 = new Hand(false, null);
			hands5.setBounds(434, 408, 103, 145);
			contentPane.add(hands5);
		}
		else if (cardHand.size() == 3) {
			hands1 = new Hand(true, cardHand.get(0));
			hands1.setBounds(14, 408, 103, 145);
			contentPane.add(hands1);
			
			hands2 = new Hand(true, cardHand.get(1));
			hands2.setBounds(119, 408, 103, 145);
			contentPane.add(hands2);
			
			hands3 = new Hand(true, cardHand.get(2));
			hands3.setBounds(224, 408, 103, 145);
			contentPane.add(hands3);
			
			hands4 = new Hand(false, null);
			hands4.setBounds(329, 408, 103, 145);
			contentPane.add(hands4);
			
			hands5 = new Hand(false, null);
			hands5.setBounds(434, 408, 103, 145);
			contentPane.add(hands5);
		}
		else if (cardHand.size() == 4) {
			hands1 = new Hand(true, cardHand.get(0));
			hands1.setBounds(14, 408, 103, 145);
			contentPane.add(hands1);
			
			hands2 = new Hand(true, cardHand.get(1));
			hands2.setBounds(119, 408, 103, 145);
			contentPane.add(hands2);
			
			hands3 = new Hand(true, cardHand.get(2));
			hands3.setBounds(224, 408, 103, 145);
			contentPane.add(hands3);
			
			hands4 = new Hand(true, cardHand.get(3));
			hands4.setBounds(329, 408, 103, 145);
			contentPane.add(hands4);
			
			hands5 = new Hand(false, null);
			hands5.setBounds(434, 408, 103, 145);
			contentPane.add(hands5);
		}
		else if (cardHand.size() == 5) {
			hands1 = new Hand(true, cardHand.get(0));
			hands1.setBounds(14, 408, 103, 145);
			contentPane.add(hands1);
			
			hands2 = new Hand(true, cardHand.get(1));
			hands2.setBounds(119, 408, 103, 145);
			contentPane.add(hands2);
			
			hands3 = new Hand(true, cardHand.get(2));
			hands3.setBounds(224, 408, 103, 145);
			contentPane.add(hands3);
			
			hands4 = new Hand(true, cardHand.get(3));
			hands4.setBounds(329, 408, 103, 145);
			contentPane.add(hands4);
			
			hands5 = new Hand(true, cardHand.get(4));
			hands5.setBounds(434, 408, 103, 145);
			contentPane.add(hands5);
		}		
		cardFileName = "src/main/resources/com/aetherwars/" + cardHand.get(0).getImagePath();

		JPanel cardDescPic = new CardDescPhoto(cardFileName);
		cardDescPic.setBounds(569, 408, 111, 145);
		contentPane.add(cardDescPic);		

		JPanel charName = new CardDesc("CardInfo", cardHand.get(0));
		charName.setBounds(690, 414, 146, 139);
		contentPane.add(charName);

		JPanel charDesc = new CardDesc("CardDesc", cardHand.get(0));
		charDesc.setBounds(837, 414, 146, 139);
		contentPane.add(charDesc);

		hands1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
				cardFileName = "src/main/resources/com/aetherwars/" + cardHand.get(0).getImagePath();
				setBorderHand(0);
				JPanel cardDescPic = new CardDescPhoto(cardFileName);
				cardDescPic.setBounds(569, 408, 111, 145);
				contentPane.add(cardDescPic,0);	
				
				JPanel charName = new CardDesc("CardInfo", cardHand.get(0));
				charName.setBounds(690, 414, 146, 139);
				contentPane.add(charName,0);
						
				JPanel charDesc = new CardDesc("CardDesc", cardHand.get(0));
				charDesc.setBounds(837, 414, 146, 139);
				contentPane.add(charDesc,0);

				contentPane.revalidate();
    			contentPane.repaint();
			}
        });

		hands2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
				cardFileName = "src/main/resources/com/aetherwars/" + cardHand.get(1).getImagePath();
				setBorderHand(1);
				JPanel cardDescPic = new CardDescPhoto(cardFileName);
				cardDescPic.setBounds(569, 408, 111, 145);
				contentPane.add(cardDescPic,0);	

				JPanel charName = new CardDesc("CardInfo", cardHand.get(1));
				charName.setBounds(690, 414, 146, 139);
				contentPane.add(charName,0);
						
				JPanel charDesc = new CardDesc("CardDesc", cardHand.get(1));
				charDesc.setBounds(837, 414, 146, 139);
				contentPane.add(charDesc,0);
					
				contentPane.revalidate();
    			contentPane.repaint();
			}
        });

		hands3.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
				cardFileName = "src/main/resources/com/aetherwars/" + cardHand.get(2).getImagePath();	
				setBorderHand(2);
				JPanel cardDescPic = new CardDescPhoto(cardFileName);
				cardDescPic.setBounds(569, 408, 111, 145);
				contentPane.add(cardDescPic,0);	
				
				JPanel charName = new CardDesc("CardInfo", cardHand.get(2));
				charName.setBounds(690, 414, 146, 139);
				contentPane.add(charName,0);
						
				JPanel charDesc = new CardDesc("CardDesc", cardHand.get(2));
				charDesc.setBounds(837, 414, 146, 139);
				contentPane.add(charDesc,0);

				contentPane.revalidate();
    			contentPane.repaint();
			}
        });

		hands4.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
				cardFileName = "src/main/resources/com/aetherwars/" + cardHand.get(3).getImagePath();
				setBorderHand(3);	
				JPanel cardDescPic = new CardDescPhoto(cardFileName);
				cardDescPic.setBounds(569, 408, 111, 145);
				contentPane.add(cardDescPic,0);	
				
				JPanel charName = new CardDesc("CardInfo", cardHand.get(2));
				charName.setBounds(690, 414, 146, 139);
				contentPane.add(charName,0);
						
				JPanel charDesc = new CardDesc("CardDesc", cardHand.get(2));
				charDesc.setBounds(837, 414, 146, 139);
				contentPane.add(charDesc,0);

				contentPane.revalidate();
    			contentPane.repaint();
			}
        });

		hands5.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
				cardFileName = "src/main/resources/com/aetherwars/" + cardHand.get(4).getImagePath();
				setBorderHand(4);	
				JPanel cardDescPic = new CardDescPhoto(cardFileName);
				cardDescPic.setBounds(569, 408, 111, 145);
				contentPane.add(cardDescPic,0);	
				
				JPanel charName = new CardDesc("CardInfo", cardHand.get(2));
				charName.setBounds(690, 414, 146, 139);
				contentPane.add(charName,0);
						
				JPanel charDesc = new CardDesc("CardDesc", cardHand.get(2));
				charDesc.setBounds(837, 414, 146, 139);
				contentPane.add(charDesc,0);

				contentPane.revalidate();
    			contentPane.repaint();
			}
        });
		
		JPanel deck = new DeckShuffle(player1.getSisaDeck());
		deck.setBounds(1011, 414, 65, 60);
		contentPane.add(deck);
		
		JPanel mana = new Mana();
		mana.setBounds(1011, 479, 65, 60);
		contentPane.add(mana);
				
		JPanel boardB1 = new Board("", false, "A");
		boardB1.setBounds(843, 81, 103, 125);
		contentPane.add(boardB1);
		
		JPanel boardB2 = new Board("", false, "B");
		boardB2.setBounds(730, 81, 103, 125);
		contentPane.add(boardB2);
		
		JPanel boardB4 = new Board("", false, "D");
		boardB4.setBounds(730, 216, 103, 125);
		contentPane.add(boardB4);
		
		JPanel boardB3 = new Board("src/main/java/com/aetherwars/gui/Skeleton.png", true, "C");
		boardB3.setBounds(843, 216, 103, 125);
		contentPane.add(boardB3);
		
		JPanel boardB5 = new Board("", false, "E");
		boardB5.setBounds(619, 148, 103, 125);
		contentPane.add(boardB5);
		
		JPanel healthBarA = new HealthBar(player1.getHealth(), "A");
		healthBarA.setBounds(10, 10, 480, 20);
		contentPane.add(healthBarA);
		
		JPanel healthBarB = new HealthBar(player2.getHealth(), "B");
		healthBarB.setBackground(Color.CYAN);
		healthBarB.setBounds(596, 10, 480, 20);
		contentPane.add(healthBarB);
		
		JPanel round = new JPanel();
		round.setBounds(506, 10, 73, 60);
		round.setLayout(null);
		JLabel turn = new JLabel("Turn", SwingConstants.CENTER);
		turn.setBounds(0,2,73,25);
		turn.setFont(new Font("Cascadia Code", 0, 16));
		JLabel turnNumber = new JLabel("1", SwingConstants.CENTER);
		turnNumber.setBounds(0,25,73,25);
		turnNumber.setFont(new Font("Cascadia Code", 0, 16));
		round.add(turn);
		round.add(turnNumber);
		contentPane.add(round);
		
		JLabel playerAName = new JLabel(player1.getName(), SwingConstants.LEFT);
		playerAName.setForeground(Color.CYAN);
		playerAName.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		playerAName.setBounds(20, 33, 73, 37);
		contentPane.add(playerAName);
		
		JLabel playerBName = new JLabel(player2.getName(), SwingConstants.RIGHT);
		playerBName.setForeground(Color.CYAN);
		playerBName.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		playerBName.setBounds(992, 33, 73, 37);
		contentPane.add(playerBName);
		contentPane.repaint();
	}
}
