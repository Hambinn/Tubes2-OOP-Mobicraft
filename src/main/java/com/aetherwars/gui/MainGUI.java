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
	private int indexCardClicked;
	private int curr_round;
	private String cardFileName;
	private int choosenDrawCard;
	private String curr_turn;
	private String next_phase;
	private String curr_phase;
	private JPanel contentPane;

	private JPanel drawPhase, planPhase, attackPhase, endPhase, drawPos;
	private JPanel drawCard1, drawCard2, drawCard3;
	private List<Card> drawCard;
	private Player player1, player2;
	private JPanel handBackground, drawBackground;
	private JPanel hands1, hands2, hands3, hands4, hands5;
	private JPanel boardA1, boardA2, boardA3, boardA4, boardA5;
	private JPanel boardB1, boardB2, boardB3, boardB4, boardB5;
	private Card cardClicked;
	private List<Card> cardHand;

	/**
	 * Create the frame.
	 */
	public MainGUI(Player player_1, Player player_2) {
		player1 = player_1;
		player2 = player_2;
		curr_phase = "DRAW";
		curr_round = 1;
		curr_turn = "PlayerA";
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 1100, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel drawPosText = new JLabel("Choose Card", SwingConstants.CENTER);
		drawPosText.setVerticalAlignment(SwingConstants.TOP);
		drawPosText.setBounds(0,2,178,24);
		drawPosText.setFont(new Font("Cascadia Code", 0, 14));

		drawPos = new JPanel();
		drawPos.setBackground(Color.ORANGE);
		drawPos.setBounds(453, 570, 180, 26);
		drawPos.add(drawPosText);
		contentPane.add(drawPos);

		setMessage("Ini Awal");
		
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

		indexCardClicked = -1;
		
		JPanel nextRound = new JPanel();
		nextRound.setLayout(null);
		nextRound.setBackground(Color.LIGHT_GRAY);
		JLabel phase = new JLabel("NEXT>>", SwingConstants.CENTER);
		phase.setVerticalAlignment(SwingConstants.TOP);
		phase.setBounds(0,2,73,20);
		phase.setFont(new Font("Cascadia Code", 1, 14));
		nextRound.add(phase);

		playerTurnSign(0);
		initialHand(player1);
		setInitialBoard();

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
						player1.nextRound();
						player2.nextRound();
					}
					if (curr_turn == "PlayerA"){
						initialHand(player1);
						playerTurnSign(0);
					} else {
						initialHand(player2);
						playerTurnSign(1);
					}
                }
				curr_phase = next_phase;
				setRound();
				contentPane.revalidate();
				contentPane.repaint();
			}
          });
		nextRound.setBorder(new LineBorder(new Color(0, 0, 0)));
		nextRound.setBounds(956, 384, 73, 20);
		contentPane.add(nextRound);

		setBoardPlan(player1, 0);

		// JPanel mana = new Mana(player);
		// mana.setBounds(1011, 479, 65, 60);
		// contentPane.add(mana,0);
		
		JPanel healthBarA = new HealthBar(player1.getHealth(), "A");
		healthBarA.setBounds(10, 10, 480, 20);
		contentPane.add(healthBarA);
		
		JPanel healthBarB = new HealthBar(player2.getHealth(), "B");
		healthBarB.setBackground(Color.CYAN);
		healthBarB.setBounds(596, 10, 480, 20);
		contentPane.add(healthBarB);
		
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

	public void playerTurnSign(int index){
		JPanel avatarA = new CharIcon("src/main/java/com/aetherwars/gui/charicon1.png");
		avatarA.setBackground(Color.WHITE);
		avatarA.setBounds(9, 155, 120, 120);
		
		JPanel avatarB = new CharIcon("src/main/java/com/aetherwars/gui/charicon2.png");
		avatarB.setBackground(Color.WHITE);
		avatarB.setBounds(956, 155, 120, 120);
		
		if (index == 0){
			avatarA.setBorder(new LineBorder(Color.GREEN));
			avatarB.setBorder(null);
		} else {
			avatarA.setBorder(null);
			avatarB.setBorder(new LineBorder(Color.GREEN));
		}
		contentPane.add(avatarA,0);
		contentPane.add(avatarB,0);
		contentPane.revalidate();
		contentPane.repaint();
	}

	public void initialHand(Player player){
		System.out.println(player.getName());

		JPanel deck = new DeckShuffle(player.getSisaDeck());
		deck.setBounds(1011, 414, 65, 60);
		contentPane.add(deck,0);

		cardHand = player.getPlayerHand();
		player.fillTopThree();
		drawCard = player.getTopThree();
		System.out.println(cardHand.get(0).getName());

		handBackground = new JPanel();
		handBackground.setBounds(12,405,550,160);
		handBackground.setBackground(Color.DARK_GRAY);
		contentPane.add(handBackground,0);
		setHands(player);
		setDrawCard();

		// player.getDeck().printDeck();

		System.out.println(player.getTopThree().get(0).getName());
		System.out.println(player.getTopThree().get(1).getName());
		System.out.println(player.getTopThree().get(2).getName());

		// JPanel hands1 = new Hand(false, null);
		// hands1.setBounds(14, 408, 103, 145);
		// contentPane.add(hands1);
		
		// JPanel hands2 = new Hand(false, null);
		// hands2.setBounds(119, 408, 103, 145);
		// contentPane.add(hands2);
		
		// JPanel hands3 = new Hand(false, null);
		// hands3.setBounds(224, 408, 103, 145);
		// contentPane.add(hands3);
		
		// JPanel hands4 = new Hand(false, null);
		// hands4.setBounds(329, 408, 103, 145);
		// contentPane.add(hands4);
		
		// JPanel hands5 = new Hand(false, null);
		// hands5.setBounds(434, 408, 103, 145);
		// contentPane.add(hands5);

		deck.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
				if (curr_phase == "DRAW"){
					//show pop up
					System.out.println("Deck clicked");
					drawPos.setBackground(Color.GREEN);
					showDrawCard();
					// drawBackground = new JPanel();
					// drawBackground.setBounds(370, 600, 350, 160);
					// drawBackground.setBackground(Color.DARK_GRAY);
					// contentPane.add(drawBackground,0);
				}
			}
          });

		contentPane.revalidate();
		contentPane.repaint();
	}

	public void setRound(){
		JPanel round = new JPanel();
		round.setBounds(500, 10, 85, 75);
		round.setLayout(null);
		JLabel turn = new JLabel("Turn", SwingConstants.CENTER);
		turn.setBounds(0,2,85,25);
		turn.setFont(new Font("Cascadia Code", 0, 16));
		JLabel turnNumber = new JLabel(Integer.toString(curr_round), SwingConstants.CENTER);
		turnNumber.setBounds(0,25,85,25);
		turnNumber.setFont(new Font("Cascadia Code", 0, 16));
		JLabel turnPlayer = new JLabel(curr_turn, SwingConstants.CENTER);
		turnPlayer.setBounds(0,45,85,25);
		turnPlayer.setFont(new Font("Cascadia Code", 0, 16));
		round.add(turn);
		round.add(turnNumber);
		round.add(turnPlayer);
		contentPane.add(round,0);
	}

	public void setInitialBoard(){
		boardA1 = new Board(null, false, "A");
		boardA1.setBounds(139, 81, 103, 125);
		contentPane.add(boardA1);
		
		boardA3 = new Board(null, false, "C");
		boardA3.setBounds(139, 216, 103, 125);
		contentPane.add(boardA3);
		
		boardA2 = new Board(null, false, "B");
		boardA2.setBounds(252, 81, 103, 125);
		contentPane.add(boardA2);
		
		boardA4 = new Board(null, false, "D");
		boardA4.setBounds(252, 216, 103, 125);
		contentPane.add(boardA4);
		
		boardA5 = new Board(null, false, "E");
		boardA5.setBounds(365, 150, 103, 125);
		contentPane.add(boardA5);

		boardB1 = new Board(null, false, "A");
		boardB1.setBounds(843, 81, 103, 125);
		contentPane.add(boardB1);
		
		boardB2 = new Board(null, false, "B");
		boardB2.setBounds(730, 81, 103, 125);
		contentPane.add(boardB2);

		boardB4 = new Board(null, false, "D");
		boardB4.setBounds(730, 216, 103, 125);
		contentPane.add(boardB4);
		
		boardB3 = new Board(null, false, "C");
		boardB3.setBounds(843, 216, 103, 125);
		contentPane.add(boardB3);
		
		boardB5 = new Board(null, false, "E");
		boardB5.setBounds(619, 148, 103, 125);
		contentPane.add(boardB5);
	}

	public void setBoardPlan(Player player, int index){
			boardA1.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (indexCardClicked != -1 && index == 0 && curr_phase == "PLAN" && curr_turn == "PlayerA"){
						boardA1 = new Board(cardClicked, true, "A");
						boardA1.setBounds(139, 81, 103, 125);
						contentPane.add(boardA1,0);
		
						cardHand.remove(indexCardClicked);
						handBackground = new JPanel();
						handBackground.setBounds(12,405,550,160);
						handBackground.setBackground(Color.DARK_GRAY);
						contentPane.add(handBackground,0);
						setHands(player);
						indexCardClicked = -1;
		
						contentPane.revalidate();
						contentPane.repaint();
					} else if (indexCardClicked == -1){
						setMessage("Tidak ada Kartu yang dipilih");
					} else if (index == 1){
						setMessage("Tidak bisa meletakkan pada board lawan");
					} else if (curr_phase != "PLAN"){
						setMessage("Letakkan kartu saat Plan Phase");
					}
	
				}
			});
	
			boardA2.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (indexCardClicked != -1 && index == 0 && curr_phase == "PLAN" && curr_turn == "PlayerA"){
						boardA2 = new Board(cardClicked, true, "A");
						boardA2.setBounds(252, 81, 103, 125);
						contentPane.add(boardA2,0);
		
						cardHand.remove(indexCardClicked);
						handBackground = new JPanel();
						handBackground.setBounds(12,405,550,160);
						handBackground.setBackground(Color.DARK_GRAY);
						contentPane.add(handBackground,0);
						setHands(player);
						indexCardClicked = -1;
		
						contentPane.revalidate();
						contentPane.repaint();
					} else if (indexCardClicked == -1){
						setMessage("Tidak ada Kartu yang dipilih");
					} else if (index == 1){
						setMessage("Tidak bisa meletakkan pada board lawan");
					} else if (curr_phase != "PLAN"){
						setMessage("Letakkan kartu saat Plan Phase");
					}
				}
			});
	
			boardA3.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (indexCardClicked != -1 && index == 0 && curr_phase == "PLAN" && curr_turn == "PlayerA"){
						boardA3 = new Board(cardClicked, true, "A");
						boardA3.setBounds(139, 216, 103, 125);
		
						cardHand.remove(indexCardClicked);
						handBackground = new JPanel();
						handBackground.setBounds(12,405,550,160);
						handBackground.setBackground(Color.DARK_GRAY);
						contentPane.add(handBackground,0);
						setHands(player);
						indexCardClicked = -1;
		
						contentPane.add(boardA3,0);
						contentPane.revalidate();
						contentPane.repaint();
					} else if (indexCardClicked == -1){
						setMessage("Tidak ada Kartu yang dipilih");
					} else if (index == 1){
						setMessage("Tidak bisa meletakkan pada board lawan");
					} else if (curr_phase != "PLAN"){
						setMessage("Letakkan kartu saat Plan Phase");
					}
				}
			});
	
			boardA4.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (indexCardClicked != -1 && index == 0 && curr_phase == "PLAN" && curr_turn == "PlayerA"){
						boardA4 = new Board(cardClicked, true, "A");
						boardA4.setBounds(252, 216, 103, 125);
		
						cardHand.remove(indexCardClicked);
						handBackground = new JPanel();
						handBackground.setBounds(12,405,550,160);
						handBackground.setBackground(Color.DARK_GRAY);
						contentPane.add(handBackground,0);
						setHands(player);
						indexCardClicked = -1;
		
						contentPane.add(boardA4,0);
						contentPane.revalidate();
						contentPane.repaint();
					} else if (indexCardClicked == -1){
						setMessage("Tidak ada Kartu yang dipilih");
					} else if (index == 1){
						setMessage("Tidak bisa meletakkan pada board lawan");
					} else if (curr_phase != "PLAN"){
						setMessage("Letakkan kartu saat Plan Phase");
					}
				}
			});
	
			boardA5.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (indexCardClicked != -1 && index == 0 && curr_phase == "PLAN" && curr_turn == "PlayerA"){
						boardA5 = new Board(cardClicked, true, "A");
						boardA5.setBounds(365, 150, 103, 125);
		
						cardHand.remove(indexCardClicked);
						handBackground = new JPanel();
						handBackground.setBounds(12,405,550,160);
						handBackground.setBackground(Color.DARK_GRAY);
						contentPane.add(handBackground,0);
						setHands(player);
						indexCardClicked = -1;
						
						contentPane.add(boardA5,0);
						contentPane.revalidate();
						contentPane.repaint();
					} else if (indexCardClicked == -1){
						setMessage("Tidak ada Kartu yang dipilih");
					} else if (index == 1){
						setMessage("Tidak bisa meletakkan pada board lawan");
					} else if (curr_phase != "PLAN"){
						setMessage("Letakkan kartu saat Plan Phase");
					}
				}
			});
		
	}

	public void setMessage(String message){
		JPanel msgLabel = new JPanel();
		msgLabel.setBounds(365,345,355,30);
		msgLabel.setBackground(Color.ORANGE);
		msgLabel.setBorder(new LineBorder(Color.BLACK));
		contentPane.add(msgLabel,0);
		
		JLabel msg = new JLabel(message, SwingConstants.CENTER);
		msg.setBounds(365,345,355,30);
		msg.setFont(new Font("Cascadia Code", 0, 10));
		contentPane.add(msg,0);
		contentPane.revalidate();
		contentPane.repaint();
	}

	public void setCardHand(boolean h1, boolean h2, boolean h3, boolean h4, boolean h5){
		if (h1 == false){
			hands1 = new Hand(false, null);
			hands1.setBounds(14, 408, 103, 145);
			contentPane.add(hands1,0);
		} else if (h1 == true){
			hands1 = new Hand(true, cardHand.get(0));
			hands1.setBounds(14, 408, 103, 145);
			contentPane.add(hands1,0);
		}
		
		if (h2 == false){
			hands2 = new Hand(false, null);
			hands2.setBounds(119, 408, 103, 145);
			contentPane.add(hands2,0);
		} else if (h2 == true){
			hands2 = new Hand(true, cardHand.get(1));
			hands2.setBounds(119, 408, 103, 145);
			contentPane.add(hands2,0);
		}

		if (h3 == false){
			hands3 = new Hand(false, null);
			hands3.setBounds(224, 408, 103, 145);
			contentPane.add(hands3,0);
		} else if (h3 == true){
			hands3 = new Hand(true, cardHand.get(2));
			hands3.setBounds(224, 408, 103, 145);
			contentPane.add(hands3,0);
		}

		if (h4 == false){
			hands4 = new Hand(false, null);
			hands4.setBounds(329, 408, 103, 145);
			contentPane.add(hands4,0);
		} else if (h4 == true){
			hands4 = new Hand(true,  cardHand.get(3));
			hands4.setBounds(329, 408, 103, 145);
			contentPane.add(hands4,0);
		}

		if (h5 == false){
			hands5 = new Hand(false, null);
			hands5.setBounds(434, 408, 103, 145);
			contentPane.add(hands5,0);
		} else if (h5 == true){
			hands5 = new Hand(true,cardHand.get(4));
			hands5.setBounds(434, 408, 103, 145);
			contentPane.add(hands5,0);
		}
	}

	public void setBorderHand(int index){
		if (index == 0){
			hands1.setBorder(new LineBorder(Color.GREEN));
			hands2.setBorder(null);
			hands3.setBorder(null);
			hands4.setBorder(null);
			hands5.setBorder(null);
		} else if (index == 1){
			hands1.setBorder(null);
			hands2.setBorder(new LineBorder(Color.GREEN));
			hands3.setBorder(null);
			hands4.setBorder(null);
			hands5.setBorder(null);
		}else if (index == 2){
			hands1.setBorder(null);
			hands2.setBorder(null);
			hands3.setBorder(new LineBorder(Color.GREEN));
			hands4.setBorder(null);
			hands5.setBorder(null);
		}else if (index == 3){
			hands1.setBorder(null);
			hands2.setBorder(null);
			hands3.setBorder(null);
			hands4.setBorder(new LineBorder(Color.GREEN));
			hands5.setBorder(null);
		}else if (index == 4){
			hands1.setBorder(null);
			hands2.setBorder(null);
			hands3.setBorder(null);
			hands4.setBorder(null);
			hands5.setBorder(new LineBorder(Color.GREEN));
		}
	}

	public void showDrawCard(){
		setDrawCard();
		drawCard1.setVisible(true);
		drawCard2.setVisible(true);
		drawCard3.setVisible(true);
	}

	public void setDrawCard() {
		if (curr_turn == "PlayerA"){
			player1.fillTopThree();
			drawCard = player1.getTopThree();
			drawCard1 = new Hand(true, drawCard.get(0));
			drawCard1.setBounds(373, 606, 103, 145);
			drawCard2 = new Hand(true, drawCard.get(1));
			drawCard2.setBounds(491, 606, 103, 145);
			drawCard3 = new Hand(true, drawCard.get(2));
			drawCard3.setBounds(609, 606, 103, 145);
			drawCard1.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					choosenDrawCard = 1;
					try {
						Thread.sleep(300);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					drawCard1.setVisible(false);
					drawCard2.setVisible(false);
					drawCard3.setVisible(false);
					player1.drawCard(choosenDrawCard);
					setHands(player1);
					drawPos.setBackground(Color.ORANGE);
					JPanel deck = new DeckShuffle(player1.getSisaDeck());
					deck.setBounds(1011, 414, 65, 60);
					contentPane.add(deck,0);
					System.out.println("\nSetelah Draw");
				}
			  });
			drawCard2.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					choosenDrawCard = 2;
					try {
						Thread.sleep(300);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					drawCard1.setVisible(false);
					drawCard2.setVisible(false);
					drawCard3.setVisible(false);
					player1.drawCard(choosenDrawCard);
					setHands(player1);
					drawPos.setBackground(Color.ORANGE);
	
					JPanel deck = new DeckShuffle(player1.getSisaDeck());
					deck.setBounds(1011, 414, 65, 60);
					contentPane.add(deck,0);
				}
			  });
			drawCard3.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					choosenDrawCard = 3;
					try {
						Thread.sleep(300);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					drawCard1.setVisible(false);
					drawCard2.setVisible(false);
					drawCard3.setVisible(false);
					player1.drawCard(choosenDrawCard);
					setHands(player1);
					drawPos.setBackground(Color.ORANGE);
	
					JPanel deck = new DeckShuffle(player1.getSisaDeck());
					deck.setBounds(1011, 414, 65, 60);
					contentPane.add(deck,0);	
				}
			  });
		}
		else{
			player2.fillTopThree();
			drawCard = player2.getTopThree();
			drawCard1 = new Hand(true, drawCard.get(0));
			drawCard1.setBounds(373, 606, 103, 145);
			drawCard2 = new Hand(true, drawCard.get(1));
			drawCard2.setBounds(491, 606, 103, 145);
			drawCard3 = new Hand(true, drawCard.get(2));
			drawCard3.setBounds(609, 606, 103, 145);
			drawCard1.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					choosenDrawCard = 1;
					try {
						Thread.sleep(300);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					drawCard1.setVisible(false);
					drawCard2.setVisible(false);
					drawCard3.setVisible(false);
					player2.drawCard(choosenDrawCard);
					setHands(player2);
					drawPos.setBackground(Color.ORANGE);
					JPanel deck = new DeckShuffle(player2.getSisaDeck());
					deck.setBounds(1011, 414, 65, 60);
					contentPane.add(deck,0);
					System.out.println("\nSetelah Draw");
				}
			  });
			drawCard2.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					choosenDrawCard = 2;
					try {
						Thread.sleep(300);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					drawCard1.setVisible(false);
					drawCard2.setVisible(false);
					drawCard3.setVisible(false);
					player2.drawCard(choosenDrawCard);
					setHands(player2);
					drawPos.setBackground(Color.ORANGE);
	
					JPanel deck = new DeckShuffle(player2.getSisaDeck());
					deck.setBounds(1011, 414, 65, 60);
					contentPane.add(deck,0);
				}
			  });
			drawCard3.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					choosenDrawCard = 3;
					try {
						Thread.sleep(300);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					drawCard1.setVisible(false);
					drawCard2.setVisible(false);
					drawCard3.setVisible(false);
					player2.drawCard(choosenDrawCard);
					setHands(player2);
					drawPos.setBackground(Color.ORANGE);
	
					JPanel deck = new DeckShuffle(player2.getSisaDeck());
					deck.setBounds(1011, 414, 65, 60);
					contentPane.add(deck,0);
				}
			  });
		}
		drawCard1.setVisible(false);
		drawCard2.setVisible(false);
		drawCard3.setVisible(false);
		contentPane.add(drawCard1, 0);
		contentPane.add(drawCard2, 0);
		contentPane.add(drawCard3, 0);
	}

	public void setHands(Player player) {
		cardHand = player.getPlayerHand();
		if (cardHand.size() == 0) {
			setCardHand(false, false, false, false, false);
		}
		else if (cardHand.size() == 1) {
			setCardHand(true, false, false, false, false);
		}
		else if (cardHand.size() == 2) {
			setCardHand(true, true, false, false, false);
		}
		else if (cardHand.size() == 3) {
			setCardHand(true, true, true, false, false);
		}
		else if (cardHand.size() == 4) {
			setCardHand(true, true, true, true, false);
		}
		else if (cardHand.size() == 5) {
			setCardHand(false, true, true, true, true);
		}	
		if (cardHand.size() > 0){
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
		}	


		hands1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
				if (cardHand.size()>= 1){
					cardFileName = "src/main/resources/com/aetherwars/" + cardHand.get(0).getImagePath();
					indexCardClicked = 0;
					cardClicked = cardHand.get(0);
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

					setMessage("-");
				} else {
					setMessage("Tidak ada kartu ditemukan");
				}

			}
        });

		hands2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
				if (cardHand.size() >= 2 ){
					cardFileName = "src/main/resources/com/aetherwars/" + cardHand.get(1).getImagePath();
					indexCardClicked = 1;
					cardClicked = cardHand.get(1);
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

					setMessage("-");
				} else {
					setMessage("Tidak ada kartu ditemukan");
				}
			}
        });

		hands3.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
				if (cardHand.size() >= 3){
					cardFileName = "src/main/resources/com/aetherwars/" + cardHand.get(2).getImagePath();
					indexCardClicked = 2;
					cardClicked = cardHand.get(2);	
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

					setMessage("-");
				} else {
					setMessage("Tidak ada kartu ditemukan");
				}
			}
        });

		hands4.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
				if (cardHand.size() >= 4){
					cardFileName = "src/main/resources/com/aetherwars/" + cardHand.get(3).getImagePath();
					indexCardClicked = 3;
					cardClicked = cardHand.get(3);
					setBorderHand(3);	
					JPanel cardDescPic = new CardDescPhoto(cardFileName);
					cardDescPic.setBounds(569, 408, 111, 145);
					contentPane.add(cardDescPic,0);	
					
					JPanel charName = new CardDesc("CardInfo", cardHand.get(3));
					charName.setBounds(690, 414, 146, 139);
					contentPane.add(charName,0);
							
					JPanel charDesc = new CardDesc("CardDesc", cardHand.get(3));
					charDesc.setBounds(837, 414, 146, 139);
					contentPane.add(charDesc,0);
	
					contentPane.revalidate();
					contentPane.repaint();

					setMessage("-");
				} else {
					setMessage("Tidak ada kartu ditemukan");
				}
			}
        });

		hands5.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
				if (cardHand.size() >= 5){
					cardFileName = "src/main/resources/com/aetherwars/" + cardHand.get(4).getImagePath();
					indexCardClicked = 4;
					cardClicked = cardHand.get(4);
					setBorderHand(4);	
					JPanel cardDescPic = new CardDescPhoto(cardFileName);
					cardDescPic.setBounds(569, 408, 111, 145);
					contentPane.add(cardDescPic,0);	
					
					JPanel charName = new CardDesc("CardInfo", cardHand.get(4));
					charName.setBounds(690, 414, 146, 139);
					contentPane.add(charName,0);
							
					JPanel charDesc = new CardDesc("CardDesc", cardHand.get(4));
					charDesc.setBounds(837, 414, 146, 139);
					contentPane.add(charDesc,0);
	
					contentPane.revalidate();
					contentPane.repaint();

					setMessage("-");
				} else {
					setMessage("Tidak ada kartu ditemukan");
				}

			}
        });
	
		
		JPanel mana = new Mana(player);
		mana.setBounds(1011, 479, 65, 60);
		contentPane.add(mana,0);

		System.out.println(player.getMana());
				
		// JPanel boardB1 = new Board(null, false, "A");
		// boardB1.setBounds(843, 81, 103, 125);
		// contentPane.add(boardB1);
		
		// JPanel boardB2 = new Board(null, false, "B");
		// boardB2.setBounds(730, 81, 103, 125);
		// contentPane.add(boardB2);
		
		// JPanel boardB4 = new Board(null, false, "D");
		// boardB4.setBounds(730, 216, 103, 125);
		// contentPane.add(boardB4);
		
		// JPanel boardB3 = new Board(null, false, "C");
		// boardB3.setBounds(843, 216, 103, 125);
		// contentPane.add(boardB3);
		
		// JPanel boardB5 = new Board(null, false, "E");
		// boardB5.setBounds(619, 148, 103, 125);
		// contentPane.add(boardB5);
		
		JPanel healthBarA = new HealthBar(player1.getHealth(), "A");
		healthBarA.setBounds(10, 10, 480, 20);
		contentPane.add(healthBarA);
		
		JPanel healthBarB = new HealthBar(player2.getHealth(), "B");
		healthBarB.setBackground(Color.CYAN);
		healthBarB.setBounds(596, 10, 480, 20);
		contentPane.add(healthBarB);

		setRound();
		
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
		contentPane.revalidate();
		contentPane.repaint();
	}
}
