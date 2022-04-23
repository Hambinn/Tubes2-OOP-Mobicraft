package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel avatarA = new CharIcon("charicon1.png");
		avatarA.setBackground(Color.WHITE);
		avatarA.setBounds(9, 155, 120, 120);
		contentPane.add(avatarA);
		
		JPanel avatarB = new CharIcon("charicon2.png");
		avatarB.setBackground(Color.WHITE);
		avatarB.setBounds(956, 155, 120, 120);
		contentPane.add(avatarB);
		
		JPanel boardA1 = new Board("Piglin Brute.png", true, "A");
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
		
		JPanel drawPhase = new Phase("DRAW", 223, 20);
		drawPhase.setBackground(Color.ORANGE);
		drawPhase.setBorder(new LineBorder(new Color(0, 0, 0)));
		drawPhase.setBounds(57, 384, 223, 20);
		contentPane.add(drawPhase);
		
		JPanel planPhase = new Phase("PLAN", 223, 20);
		planPhase.setBackground(Color.ORANGE);
		planPhase.setBorder(new LineBorder(new Color(0, 0, 0)));
		planPhase.setBounds(279, 384, 223, 20);
		contentPane.add(planPhase);
		
		JPanel attackPhase = new Phase("ATTACK", 223, 20);
		attackPhase.setBackground(Color.ORANGE);
		attackPhase.setBorder(new LineBorder(new Color(0, 0, 0)));
		attackPhase.setBounds(501, 384, 223, 20);
		contentPane.add(attackPhase);
		
		JPanel endPhase = new Phase("END", 223, 20);
		endPhase.setBackground(Color.ORANGE);
		endPhase.setBorder(new LineBorder(new Color(0, 0, 0)));
		endPhase.setBounds(723, 384, 223, 20);
		contentPane.add(endPhase);
		
		JPanel nextRound = new Phase("NEXT>>", 73, 20);
		nextRound.setBackground(Color.LIGHT_GRAY);
		nextRound.setBorder(new LineBorder(new Color(0, 0, 0)));
		nextRound.setBounds(956, 384, 73, 20);
		contentPane.add(nextRound);
		
		JPanel hands1 = new Hand(true, "Potion of Bargaining.png");
		hands1.setBounds(14, 408, 103, 145);
		contentPane.add(hands1);
		
		JPanel hands2 = new Hand(true, "Skeleton.png");
		hands2.setBounds(119, 408, 103, 145);
		contentPane.add(hands2);
		
		JPanel hands3 = new Hand(true, "Piglin Brute.png");
		hands3.setBounds(224, 408, 103, 145);
		contentPane.add(hands3);
		
		JPanel hands4 = new Hand(false, "");
		hands4.setBounds(329, 408, 103, 145);
		contentPane.add(hands4);
		
		JPanel hands5 = new Hand(false,"");
		hands5.setBounds(434, 408, 103, 145);
		contentPane.add(hands5);
		
		JPanel cardDescPic = new CardDescPhoto("Piglin Brute.png");
		cardDescPic.setBounds(569, 408, 111, 145);
		contentPane.add(cardDescPic);
		
		JPanel charName = new CardDesc("CardInfo");
		charName.setBounds(690, 414, 146, 139);
		contentPane.add(charName);
		
		JPanel charDesc = new CardDesc("CardDesc");
		charDesc.setBounds(837, 414, 146, 139);
		contentPane.add(charDesc);
		
		JPanel deck = new DeckShuffle(36);
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
		
		JPanel boardB3 = new Board("Skeleton.png", true, "C");
		boardB3.setBounds(843, 216, 103, 125);
		contentPane.add(boardB3);
		
		JPanel boardB5 = new Board("", false, "E");
		boardB5.setBounds(619, 148, 103, 125);
		contentPane.add(boardB5);
		
		JPanel healthBarA = new HealthBar(77, "A");
		healthBarA.setBounds(10, 10, 480, 20);
		contentPane.add(healthBarA);
		
		JPanel healthBarB = new HealthBar(33, "B");
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
		
		JLabel playerAName = new JLabel("Player A");
		playerAName.setForeground(Color.CYAN);
		playerAName.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		playerAName.setBounds(20, 33, 73, 37);
		contentPane.add(playerAName);
		
		JLabel playerBName = new JLabel("Player B");
		playerBName.setForeground(Color.CYAN);
		playerBName.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		playerBName.setBounds(992, 33, 73, 37);
		contentPane.add(playerBName);
	}
}
