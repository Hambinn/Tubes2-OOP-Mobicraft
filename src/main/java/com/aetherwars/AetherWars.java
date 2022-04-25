package com.aetherwars;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import com.aetherwars.util.*;
import com.aetherwars.gui.*;
import com.aetherwars.model.*;
import com.aetherwars.player.Player;
import com.aetherwars.board.*;
import com.aetherwars.spell.*;
import com.aetherwars.deck.*;
import javax.swing.JFrame;

public class AetherWars {

  // public static void start() {
  //   CardCollection cardCollection = new CardCollection();
  //   List<Card> morphsCards = cardCollection.getMorphSpellCollection();
  //   List<Card> charCards = cardCollection.getCharacterCollection();
  //   List<Card> potionsCards = cardCollection.getPtnSpellCollection();
  //   List<Card> swapsCards = cardCollection.getSwapSpellCollection();
  //   Player player1 = new Player("Steve", charCards, morphsCards, potionsCards, swapsCards);
  //   Player player2 = new Player("John", charCards, morphsCards, potionsCards, swapsCards);
  //   try {
  //     MainGUI frame = new MainGUI(player1, player2);
  //     frame.setVisible(true);
  //   } catch (Exception e) {
  //     e.printStackTrace();
  //   }
  // }
	public static void main(String[] args) {
    java.awt.EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
          CardCollection cardCollection = new CardCollection();
          List<Card> morphsCards = cardCollection.getMorphSpellCollection();
          List<Card> charCards = cardCollection.getCharacterCollection();
          List<Card> potionsCards = cardCollection.getPtnSpellCollection();
          List<Card> swapsCards = cardCollection.getSwapSpellCollection();
          Player player1 = new Player("Steve", charCards, morphsCards, potionsCards, swapsCards);
          Player player2 = new Player("John", charCards, morphsCards, potionsCards, swapsCards);    
          MainGUI frame = new MainGUI(player1, player2);         
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.setLocationRelativeTo(null);
          frame.setVisible(true);
      }
  });
  }
}
// public class AetherWars extends Application {
//   private static final String CHARACTER_CSV_FILE_PATH = "card/data/character.csv";

//   public void loadCards() throws IOException, URISyntaxException {
//     File characterCSVFile = new File(getClass().getResource(CHARACTER_CSV_FILE_PATH).toURI());
//     CSVReader characterReader = new CSVReader(characterCSVFile, "\t");
//     characterReader.setSkipHeader(true);
//     List<String[]> characterRows = characterReader.read();
//     for (String[] row : characterRows) {
//       Character c = new Character(row[1], row[3], Type.valueOf(row[2]));
//       System.out.println(c);
//     }
//   }

//   @Override
//   public void start(Stage stage) {
//     Text text = new Text();
//     text.setText("Loading...");
//     text.setX(50);
//     text.setY(50);

//     Group root = new Group();
//     root.getChildren().add(text);

//     Scene scene = new Scene(root, 1280, 720);

//     stage.setTitle("Minecraft: Aether Wars");
//     stage.setScene(scene);
//     stage.show();

//     try {
//       this.loadCards();
//       text.setText("Minecraft: Aether Wars!");
//     } catch (Exception e) {
//       text.setText("Failed to load cards: " + e);
//     }
//   }

