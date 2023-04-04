/**
 * Maximilian L. Schulten
 * The main class that houses GUI and the instances of the necessary classes
 */
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import java.util.*;
import javafx.scene.paint.*;


public class Guillotine extends Application {
  // Field that holds stage
  private Stage primaryStage;
  
  /**
   * Method that iterates through all cards in the line and updates them
   */
  public void updateCenter(VBox v, Line line) {
    // Clears the VBox
    v.getChildren().clear();
    // Iterates over the list of cards and add them to the center of the pane
    for (Card element : line.getLine()) {
      // Adds an asterisk if the card has special and stylizes each button upon initialization 
      if(element.getSpecial()) {
        Button b = new Button(element.getName() + ", " + element.getGroup() + ": " + element.getPoints() + "*");
        // Makes all buttons the same size, makes the text wrap, and adds it to the VBox
        b.setPrefWidth(200);
        b.wrapTextProperty().setValue(true);
        v.getChildren().addAll(b);
      } else {
        Button b = new Button(element.getName() + ", " + element.getGroup() + ": " + element.getPoints());
        // Makes all buttons the same size, makes the text wrap, and adds it to the VBox
        b.setPrefWidth(200);
        b.wrapTextProperty().setValue(true);
        v.getChildren().addAll(b);
      }
    }
  }
  
  /**
   * Method that iterates through all cards in a player's line and updates them
   */
  public void updatePlayerCards(VBox v, Player p, Line line) {
    // Clears the VBox
    v.getChildren().clear();
    // Iterates over the list of cards and add them to the center of the pane
    for (Card element : p.getCards()) {
      // Checks for special instructions of the card
      if(element.getSpecial()) {
        // Creates new button in local varible so it's style can be changed
        Button b = new Button(element.getName() + ", " + element.getGroup() + ": " + element.getPoints() + "*");
        // Makes all buttons the same size, makes the text wrap, and adds it to the VBox
        b.setPrefWidth(100);
        b.wrapTextProperty().setValue(true);
        v.getChildren().addAll(b);
      } else {
        // Creates new button in local varible so it's style can be changed
        Button b = new Button(element.getName() + ", " + element.getGroup() + ": " + element.getPoints());
        // Makes all buttons the same size, makes the text wrap, and adds it to the VBox
        b.setPrefWidth(100);
        b.wrapTextProperty().setValue(true);
        v.getChildren().addAll(b);
      }
    }
  }
  
  /** 
   * Overrides the start method of Application to create the GUI for Guillotine.
   * @param primaryStage the JavaFX main window
   */
  public void start(Stage primaryStage) {
    
    // Gets the parameters given by the user when the game is launched
    Parameters params = getParameters();
    List<String> list = params.getRaw();
    
    // Creates a new line on start
    Line line;
    
    // Checks if the user gave any input and if not uses 20 
    if (list.isEmpty()) 
      // Creating a new line by instantiating the nested class Line
      line = new Line(20);
    else 
      // Generates a line with 20 cards by default
      line = new Line(Integer.valueOf(list.get(0)));
  
    /**
     * Creating the two players
     */
    Player p1 = new Player();
  
    Player p2 = new Player();

    
    /**
     * Creating the points counter for both players
     */
    Text p1Points = new Text("Points: 0");
    
    Text p2Points = new Text("Points: 0");

    
    // Creating the layout
    BorderPane pane = new BorderPane();
    
    // Creating a VBox to place buttons, point counter, and possesed cards in for player 1 & 2 
    VBox p1VBox = new VBox(3);
    
    VBox p2VBox = new VBox(3);
    
    // Create a VBox for the line of cards 
    VBox lineVBox = new VBox(1);
    
    /**
     * Create a VBox for the players' cards
     */
    VBox p1Cards = new VBox(1);
    
    VBox p2Cards = new VBox(1);
    
    // First updates the center
    updateCenter(lineVBox, line);
    
    /**
     * Creating all action buttons for both players and
     * sets their action event handlers for when they are pressed.
     */
    Button p1LeadBack1 = new Button("Move the lead card back 1 place.");
    p1LeadBack1.setOnAction(e -> {
      // Ensures a player can't make a turn when it isn't their turn
      if (p1.getIsMyTurn()) {
        p1LeadBack1.setDisable(true);
        line.getLine().moveBack(1);
        updateCenter(lineVBox, line);
      }
    });
    
    Button p2LeadBack1 = new Button("Move the lead card back 1 place.");
    p2LeadBack1.setOnAction(e -> {
      // Ensures a player can't make a turn when it isn't their turn
      if (p2.getIsMyTurn()) {
        p2LeadBack1.setDisable(true);
        line.getLine().moveBack(1);
        updateCenter(lineVBox, line);
      }
    });
    
    Button p1LeadBack2 = new Button("Move the lead card back 2 places.");
    p1LeadBack2.setOnAction(e -> {
      // Ensures a player can't make a turn when it isn't their turn
      if (p1.getIsMyTurn()) {
        p1LeadBack2.setDisable(true);
        line.getLine().moveBack(2);
        updateCenter(lineVBox, line);
      }
    });
    
    Button p2LeadBack2 = new Button("Move the lead card back 2 places.");
    p2LeadBack2.setOnAction(e -> {
      // Ensures a player can't make a turn when it isn't their turn
      if (p2.getIsMyTurn()) {
        p2LeadBack2.setDisable(true);
        line.getLine().moveBack(2);
        updateCenter(lineVBox, line);
      }
    });
    
    Button p1LeadBack3 = new Button("Move the lead card back 3 places.");
    p1LeadBack3.setOnAction(e -> {
      // Ensures a player can't make a turn when it isn't their turn
      if (p1.getIsMyTurn()) {
        p1LeadBack3.setDisable(true);
        line.getLine().moveBack(3);
        updateCenter(lineVBox, line);
      }
    });
    
    Button p2LeadBack3 = new Button("Move the lead card back 3 places.");
    p2LeadBack3.setOnAction(e -> {
      // Ensures a player can't make a turn when it isn't their turn
      if (p2.getIsMyTurn()) {
        p2LeadBack3.setDisable(true);
        line.getLine().moveBack(3);
        updateCenter(lineVBox, line);
      }
    });
  
    Button p1LeadBack4 = new Button("Move the lead card back 4 places.");
    p1LeadBack4.setOnAction(e -> {
      // Ensures a player can't make a turn when it isn't their turn
      if (p1.getIsMyTurn()) {
        p1LeadBack4.setDisable(true);
        line.getLine().moveBack(4);
        updateCenter(lineVBox, line);
      }
    });
    
    Button p2LeadBack4 = new Button("Move the lead card back 4 places.");
    p2LeadBack4.setOnAction(e -> {
      // Ensures a player can't make a turn when it isn't their turn
      if (p2.getIsMyTurn()) {
        p2LeadBack4.setDisable(true);
        line.getLine().moveBack(4);
        updateCenter(lineVBox, line);
      }
    });
    
    Button p1FirstToLast = new Button("Move the lead card to the end of the line.");
    p1FirstToLast.setOnAction(e -> {
      // Ensures a player can't make a turn when it isn't their turn
      if (p1.getIsMyTurn()) {
        p1FirstToLast.setDisable(true);
        line.getLine().moveFirstToLast();
      }
    });
    
    Button p2FirstToLast = new Button("Move the lead card to the end of the line.");
    p2FirstToLast.setOnAction(e -> {
      // Ensures a player can't make a turn when it isn't their turn
      if (p2.getIsMyTurn()) {
        p2FirstToLast.setDisable(true);
        line.getLine().moveFirstToLast();
        updateCenter(lineVBox, line);
      }
    });
    
    Button p1LastToFirst = new Button("Move the last card in the line to the front.");
    p1LastToFirst.setOnAction(e -> {
      // Ensures a player can't make a turn when it isn't their turn
      if (p1.getIsMyTurn()) {
        p1LastToFirst.setDisable(true);
        line.getLine().moveLastToFirst();
        updateCenter(lineVBox, line);
      }
    });
  
    Button p2LastToFirst = new Button("Move the last card in the line to the front.");
    p2LastToFirst.setOnAction(e -> {
      // Ensures a player can't make a turn when it isn't their turn
      if (p2.getIsMyTurn()) {
        p2LastToFirst.setDisable(true);
        line.getLine().moveLastToFirst();
        updateCenter(lineVBox, line);
      }
    });
  
    Button p1Reverse = new Button("Reverse the entire line of cards.");
    p1Reverse.setOnAction(e -> {
      // Ensures a player can't make a turn when it isn't their turn
      if (p1.getIsMyTurn()) {
        p1Reverse.setDisable(true);
        line.getLine().reverseList();
        updateCenter(lineVBox, line);
      }
    });
    
    Button p2Reverse = new Button("Reverse the entire line of cards.");
    p2Reverse.setOnAction(e -> {
      // Ensures a player can't make a turn when it isn't their turn
      if (p2.getIsMyTurn()) {
        p2Reverse.setDisable(true);
        line.getLine().reverseList();
        updateCenter(lineVBox, line);
      }
    });
    
    Button p1Reverse5 = new Button("Reverse the first 5 cards of the line.");
    p1Reverse5.setOnAction(e -> {
      // Ensures a player can't make a turn when it isn't their turn
      if (p1.getIsMyTurn()) {
        p1Reverse5.setDisable(true);
        line.getLine().reverseFirstK(5);
        updateCenter(lineVBox, line);
      }
    });
    
    Button p2Reverse5 = new Button("Reverse the first 5 cards of the line.");
    p1Reverse5.setOnAction(e -> {
      // Ensures a player can't make a turn when it isn't their turn
      if (p1.getIsMyTurn()) {
        p1Reverse5.setDisable(true);
        line.getLine().reverseFirstK(5);
        updateCenter(lineVBox, line);
      }
    });
    
    Button p1Skip = new Button("Skip my turn.");
    p1Skip.setOnAction(e -> {
      // Ensures a player can't make a turn when it isn't their turn
      if (p1.getIsMyTurn()) {
        p1Skip.setDisable(true);
        p1.endTurn();
        p2.setTurn(true);
        updateCenter(lineVBox, line);
      }
    });
    
    Button p2Skip = new Button("Skip my turn.");
    p2Skip.setOnAction(e -> {
      // Ensures a player can't make a turn when it isn't their turn
      if (p2.getIsMyTurn()) {
        p2Skip.setDisable(true);
        p2.endTurn();
        p1.setTurn(true);
        updateCenter(lineVBox, line);
      }
    });
    
    Button p1Take = new Button("Take the leading card.");
    p1Take.setOnAction(e -> {
      // Ensures a player can't make a turn when it isn't their turn
      if (p1.getIsMyTurn()) {
        // Adds the card take, ends the players turn, updates all sets of cards and the player's points
        p1.getCards().addToFront(line.getLine().removeFromFront());
        p1.endTurn();
        p2.setTurn(true);
        updateCenter(lineVBox, line);
        p1Points.setText("Points: " + p1.getPoints());
        updatePlayerCards(p1Cards, p1, line);
      }
    });
    
    Button p2Take = new Button("Take the leading card.");
    p2Take.setOnAction(e -> {
      // Ensures a player can't make a turn when it isn't their turn
      if (p2.getIsMyTurn()) {
        // Adds the card take, ends the players turn, updates all sets of cards and the player's points
        p2.getCards().addToFront(line.getLine().removeFromFront());
        p2.endTurn();
        p1.setTurn(true);
        updateCenter(lineVBox, line);
        p2Points.setText("Points: " + p2.getPoints());
        updatePlayerCards(p2Cards, p2, line);
      }
    });
    
    /**
     * Place elements inside the VBoxes for their respective player
     */
    p1VBox.getChildren().addAll(new Text("Player 1"), p1Points, p1LeadBack1, p1LeadBack2, p1LeadBack3, p1LeadBack4, p1FirstToLast, p1LastToFirst, p1Reverse, p1Reverse5, p1Skip, p1Take, p1Cards);
    
    p2VBox.getChildren().addAll(new Text("Player 2"), p2Points, p2LeadBack1, p2LeadBack2, p2LeadBack3, p2LeadBack4, p2FirstToLast, p2LastToFirst, p2Reverse, p2Reverse5, p2Skip, p2Take, p2Cards);
    
    /**
     * Places the vertical arrangements in the border pane
     */
    pane.setLeft(p1VBox);
    pane.setRight(p2VBox);
    pane.setCenter(lineVBox);
    
    // Create a new scene
    Scene scene = new Scene(pane);
    
    // Sets the stage
    this.primaryStage = primaryStage;
    
    // Sets the scene 
    primaryStage.setScene(scene);
    
    // Shows the scene
    primaryStage.show();
    
    // Sets the title
    primaryStage.setTitle("Guillotine");
    
    // Sets it to be player 1's turn on launch
    p1.setTurn(true);
    
  }
  
  /**
   * The method to launch the program.
   * @param args  The command line arguments. The arguments are passed on to the JavaFX application. In this case the number of cards desired.
   */
  public static void main(String[] args) {
    // Ensures the game runs with 20 points by default
    try {
      // Ensures the input is a valid value, prints an error otherwise
      if (Integer.valueOf(args[0]) > 0 && Integer.valueOf(args[0]) < 41) 
        Application.launch(args);
      else
        System.out.println("Please enter a value between 1 and 40");
    } catch (ArrayIndexOutOfBoundsException e) {
      Application.launch(args);
    }
  }
  
  /**
   * Nested class representing the line of player cards.
   */
  private class Line {
    
    
    // Field that holds the line of cards
    private LinkedList<Card> line = new LinkedList<Card>();
    
    // Creates an array of all of the cards in the game 
    public Card[] allCards = {new Card("King Louis XIV", "Royal", 5, false), new Card("Marie Antoinette", "Royal", 5, false),
      new Card("Regent", "Royal", 4, false), new Card("Duke", "Royal", 3, false),  new Card("Baron", "Royal", 3, false),
      new Card("Count", "Royal", 2, true), new Card("Countess", "Royal", 2, true), new Card("Lord", "Royal", 2, true), 
      new Card("Lady", "Royal", 2, true), new Card("Cardinal", "Church", 5, false),  new Card("Archbishop", "Church", 4, false), 
      new Card("Nun", "Church", 3, false), new Card("Bishop", "Church", 2, false), new Card("Priest", "Church", 1, false), 
      new Card("Priest", "Church", 1, false), new Card("Heretic", "Church", 0, true), new Card("Governor", "Civic", 4, false),
      new Card("Mayor", "Civic", 3, false), new Card("Councilman", "Civic", 3, false), 
      new Card("Judge", "Civic", 2, false), new Card("Judge", "Civic", 2, false), new Card("Tax Collector", "Civic", 0, true),
      new Card("Sheriff", "Civic", 1, false), new Card("Sheriff", "Civic", 1, false), new Card("Palace Guard", "Military", 0, true),
      new Card("Palace Guard", "Military", 0, true), new Card("Palace Guard", "Military", 0, true),
      new Card("Palace Guard", "Military", 0, true), new Card("General", "Military", 4, false), new Card("Colonel", "Military", 3, false),
      new Card("Captain", "Military", 2, false), new Card("Lieutenant", "Military", 1, false), new Card("Lieutenant", "Military", 1, false),
      new Card("Tragic Figure", "Commoner", 0, true), new Card("Heroic Figure", "Commoner", -3, false),
      new Card("Student", "Commoner", -1, false), new Card("Student", "Commoner", -1, false), new Card("Student", "Commoner", -1, false), 
      new Card("Student", "Commoner", -1, false)};
    
    /**
     * Constructor that will fill the line variable with random cards/
     * @Param length takes the desired number of player cards in the line
     */
    public Line(int length) {
      
      // Array that holds all of the indecies used to repeat using to many cards of one kind, fills them with -1 because its a non 
      int[] used = new int[length];
      Arrays.fill(used, -1);
      
      // Index for the array of all cards, resets ever iteration of the loop
      int index = 0;
      
      // Counter used to count how many cards have been added
      int count = 0;
      
      // Creates an object to generate random numbers
      Random rand = new Random();
      
      // Loop that will keep randomly adding cards from the array of all cards to the line until we have 20 cards
      while(count < used.length) {
        index = rand.nextInt(40);
        boolean present = false;
        // Linear search the array of used indecies for the randomly generated index
        for(int i = 0; i < used.length; i++) {
          // Breaks the loop and sets present to true if the random index is found, meaning it has been used
          if(used[i] == index){
            present = true;
            break;
          }
        }
        // If the card has not already been added it is added and its index is saved
        if(!present) {
          line.addToFront(allCards[index]);
          used[count] = index;
          count++;
        }
      }
    }
    /**
     * Getter method for the LinkedList of cards: list
     * @return list of cards
     */
    public LinkedList<Card> getLine() {
      return line;
    }
  }
  
  /**
   * 
   * Nested class that represents all of the person cards in the game.
   */
  private class Card {
    
    // Field that holds the name of the card
    private String name;
     
    // Field that holds the point value of the card 
    private int points;
    
    // Field that holds the group of the card
    private String group;
    
    // Field that holds a boolean representing if the card has special instructions
    private boolean special = false;
    
    /**
     * Constructor for the Cards, sets fields
     * @Param name takes the name of the card being created
     * @Param group takes the group of the card being created
     * @Param points takes the point value of the card being created
     * @Param special takes whether the card has special instructions
     */
    public Card(String name, String group, int points, boolean special) {
      this.name = name;
      this.group = group;
      this.points = points;
      this.special = special;
    }
    
    /**
     * Getter method for the name of the card
     * @return the name of the card
     */
    public String getName(){
      return name;
    }
    
    /**
     * Getter method for the group of the card
     * @return the group of the card
     */
    public String getGroup(){
      return group;
    }
    
    /**
     * Getter method for the points of the card
     * @return the points of the card
     */
    public int getPoints(){
      return points;
    }
    
    /**
     * Getter method for the points of the card
     * @return the boolean special of the card
     */
    public boolean getSpecial(){
      return special;
    }
  }
  
  /**
   * Nested class that represents a player.
   */
  
  private class Player {
    
    // Field that holds an integer representing the player's points 
    private int points = 0;
    
    // Field that holds a boolean representing if its the player's turn
    private boolean isMyTurn;
    
    // Field that holds a linkedlist of all of the cards the player posseses
    private LinkedList<Card> myCards = new LinkedList<Card>();
    
    /**
     * Getter method for the player's points
     * @return # of points the player has 
     */
    public int getPoints() {
      return points;
    }
    
    /**
     * Getter method for the player's cards
     * @return the LinkedList of the player's cards 
     */
    public LinkedList<Card> getCards() {
      return myCards;
    }
    
    /**
     * Setter method for the player's points
     * @param points the desired point value
     */
    public void setPoints(int points) {
      this.points = points;
    }
    
    /**
      * Setter method for the player's turn
      * @param bool desired boolean value
      */
    public void setTurn(boolean bool) {
      this.isMyTurn = bool;
    }
     
    /**
     * Getter method for if its the player's turn
     * @return true if it's player's turn
     */
    public boolean getIsMyTurn() {
      return isMyTurn;
     }
    
    /**
     * Method that ends the player's turn,
     * and calculate's the players points
     */
    public void endTurn(){
      setTurn(false);
      calculatePoints();
    }
    
    /**
     * Method that calculates the players points
     */
    public void calculatePoints() {
      
      // Variable that holds the sum
      int sum = 0;
      
      // Iterates through every card and adds the points to the variable sum 
      for (Card card : myCards) {
        // If the card isn't special it sumply adds the points
        if(!card.getSpecial()) {
          sum += card.getPoints();
        } else if(card.getName().equals("Count")) {
          boolean there = false;
          // Checks the player's cards for the countess
          for(Card card1 : myCards) {
            if(card1.getName().equals("Countess")) {
              there = true;
              break;
            }
          }
          if(there)
            sum += 4;
          else 
            sum += 2;
        } else if(card.getName().equals("Countess")) {
          boolean there = false;
          // Checks the player's cards for the count
          for(Card card1 : myCards) {
            if(card1.getName().equals("Count")) {
              there = true;
              break;
            }
          }
          if(there)
            sum += 4;
          else 
            sum += 2;
        } else if(card.getName().equals("Lord")) {
          boolean there = false;
          // Checks the player's cards for the Lady
          for(Card card1 : myCards) {
            if(card1.getName().equals("Lady")) {
              there = true;
              break;
            }
          }
          if(there)
            sum += 4;
          else 
            sum += 2;
        } else if(card.getName().equals("Lady")) {
          boolean there = false;
          // Checks the player's cards for the Lord
          for(Card card1 : myCards) {
            if(card1.getName().equals("Lord")) {
              there = true;
              break;
            }
          }
          if(there)
            sum += 4;
          else 
            sum += 2;
        } else if(card.getName().equals("Heretic")) {
          int count = 0;
          // Checks the player's cards for the # of "Church" cards
          for(Card card1 : myCards) {
            if(card1.getGroup().equals("Church")) 
              count++;
          }
          sum += count;
        } else if(card.getName().equals("Tax Collector")) {
          int count = 0;
          // Checks the player's cards for the # of "Civic" cards
          for(Card card1 : myCards) {
            if(card1.getGroup().equals("Civic")) 
              count++;
          }
          sum += count;
        } else if(card.getName().equals("Palace Guard")) {
          int count = 0;
          // Checks the player's cards for the # of Palace Guards
          for(Card card1 : myCards) {
            if(card1.getName().equals("Palace Guard")) 
              count++;
          }
          sum += count;
        } else if(card.getName().equals("Tragic Figure")) {
          int count = 0;
          // Checks the player's cards for the # of "Commoner" cards
          for(Card card1 : myCards) {
            if(card1.getGroup().equals("Commoner")) 
              count++;
          }
          sum -= count;
        }
      }
      // Sets the player's points to the sum
      setPoints(sum);
    }
  }
}