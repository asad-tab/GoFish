/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author tabassua
 */
public class GoFish extends Game {
    private static final String NAME = "GoFish";
    private GoFishPlayer user = new GoFishPlayer("user");
    private GoFishPlayer bot = new GoFishPlayer("bot");
    private final List<Player> players = new ArrayList<>(Arrays.asList(user, bot));
    private GroupOfCards pile; // the pile of cards that will be dealt to the users

    
    public GoFish() {
        super(NAME);
    }

    @Override
    public void play() {
        // get the user name
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, would you like to play GoFish? y/n");
        String input = scanner.next();
        if(input.equals("y")) {
            System.out.println("Welcome to GoFish. The computer will now shuffle the deck and give you and the bot 5 cards each.");
            
            //create a deck of cards
            ArrayList<Card> deck = generateGoFishDeckOfCards();
            this.pile = new GroupOfCards(deck.size());
            this.pile.setCards(deck);
            
            // now shuffle the deck
            this.pile.shuffle();
            
            // hand out five to the player and to the bot
            user.receiveCards(pile.dole5());
            bot.receiveCards(pile.dole5());
            
            // show the user his deck
            user.showHand();
            
            while(!pile.isEmpty()) {
                // ask the user whick book he would like to ask the bot for
                System.out.println("Which book would you like to ask from your opponent? i.e. 0-12 , where 0 is ace and 12 is king");
                int requestBook = scanner.nextInt();

                // request that book from the opponent
                ArrayList<Card> requestedBook = bot.requestCards(requestBook);
                if(requestedBook.isEmpty()) {
                    System.out.println("GoFish!");
                    // pick a card from the pile 
                    user.receiveCards(new ArrayList<Card>(Arrays.asList(pile.dole1())));
                } else {
                    // add the requested cards to user pile
                    user.receiveCards(requestedBook);
                }
                System.out.println("Your new hand:");
                user.showHand();

                System.out.println("Opponent's turn...");

                // the bot will request for a book in his hand that is not complete. if all books are complete, he will ask for a book which he doesn't have
                Book botRequestedBook = bot.getMissingBook();
                ArrayList<Card> requestedBookFromUser = user.requestCards(botRequestedBook.getNumVal());
                if(requestedBookFromUser.isEmpty()) {
                    System.out.println("GoFish!");
                    // pick a card from the pile 
                    user.receiveCards(new ArrayList<Card>(Arrays.asList(pile.dole1())));
                } else {
                    // add the requested cards to user pile
                    user.receiveCards(requestedBookFromUser);
                }
                System.out.println("Your new hand:");
                user.showHand();
            }
            
            // check whoever has the most books
            int userBookCount = user.countBooks();
            int botBookCount = bot.countBooks();
            
            if(userBookCount > botBookCount) {
                System.out.println("You WIN!!!");
            } else if(userBookCount == botBookCount) {
                System.out.println("It's a draw");
            } else {
                System.out.println("You lose.");
            }
            
        } else {
            //end game
            return;
        }
        
    }

    @Override
    public void declareWinner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void main(String[] args) {
        // start the game here
        Game game = new GoFish();
        game.play();
    }
     
    public ArrayList<Card> generateGoFishDeckOfCards() {
        ArrayList<Card> deck = new ArrayList<>();
        // creating ace book
        GoFishCard aceHeart = new GoFishCard(Suite.hearts, Book.ace);
        deck.add(aceHeart);
        GoFishCard aceClub = new GoFishCard(Suite.clubs, Book.ace);
        deck.add(aceClub);
        GoFishCard aceSpade = new GoFishCard(Suite.spades, Book.ace);
        deck.add(aceSpade);
        GoFishCard aceDiamonds = new GoFishCard(Suite.diamonds, Book.ace);
        deck.add(aceDiamonds);
        
        // creating one book
        GoFishCard oneHeart = new GoFishCard(Suite.hearts, Book.one);
        deck.add(oneHeart);
        GoFishCard oneClub = new GoFishCard(Suite.clubs, Book.one);
        deck.add(oneClub);
        GoFishCard oneSpade = new GoFishCard(Suite.spades, Book.one);
        deck.add(oneSpade);
        GoFishCard oneDiamonds = new GoFishCard(Suite.diamonds, Book.one);
        deck.add(oneDiamonds);
        
        // creating two book
        GoFishCard twoHeart = new GoFishCard(Suite.hearts, Book.two);
        deck.add(twoHeart);
        GoFishCard twoClub = new GoFishCard(Suite.clubs, Book.two);
        deck.add(twoClub);
        GoFishCard twoSpade = new GoFishCard(Suite.spades, Book.two);
        deck.add(twoSpade);
        GoFishCard twoDiamonds = new GoFishCard(Suite.diamonds, Book.two);
        deck.add(twoDiamonds);
        
        // creating three book
        GoFishCard threeHeart = new GoFishCard(Suite.hearts, Book.three);
        deck.add(threeHeart);
        GoFishCard threeClub = new GoFishCard(Suite.clubs, Book.three);
        deck.add(threeClub);
        GoFishCard threeSpade = new GoFishCard(Suite.spades, Book.three);
        deck.add(threeSpade);
        GoFishCard threeDiamonds = new GoFishCard(Suite.diamonds, Book.three);
        deck.add(threeDiamonds);
        
        // creating four book
        GoFishCard fourHeart = new GoFishCard(Suite.hearts, Book.four);
        deck.add(fourHeart);
        GoFishCard fourClub = new GoFishCard(Suite.clubs, Book.four);
        deck.add(fourClub);
        GoFishCard fourSpade = new GoFishCard(Suite.spades, Book.four);
        deck.add(fourSpade);
        GoFishCard fourDiamonds = new GoFishCard(Suite.diamonds, Book.four);
        deck.add(fourDiamonds);
        
        // creating five book
        GoFishCard fiveHeart = new GoFishCard(Suite.hearts, Book.five);
        deck.add(fiveHeart);
        GoFishCard fiveClub = new GoFishCard(Suite.clubs, Book.five);
        deck.add(fiveClub);
        GoFishCard fiveSpade = new GoFishCard(Suite.spades, Book.five);
        deck.add(fiveSpade);
        GoFishCard fiveDiamonds = new GoFishCard(Suite.diamonds, Book.five);
        deck.add(fiveDiamonds);
        
        // creating six book
        GoFishCard sixHeart = new GoFishCard(Suite.hearts, Book.six);
        deck.add(sixHeart);
        GoFishCard sixClub = new GoFishCard(Suite.clubs, Book.six);
        deck.add(sixClub);
        GoFishCard sixSpade = new GoFishCard(Suite.spades, Book.six);
        deck.add(sixSpade);
        GoFishCard sixDiamonds = new GoFishCard(Suite.diamonds, Book.six);
        deck.add(sixDiamonds);
        
        // creating seven book
        GoFishCard sevenHeart = new GoFishCard(Suite.hearts, Book.seven);
        deck.add(sevenHeart);
        GoFishCard sevenClub = new GoFishCard(Suite.clubs, Book.seven);
        deck.add(sevenClub);
        GoFishCard sevenSpade = new GoFishCard(Suite.spades, Book.seven);
        deck.add(sevenSpade);
        GoFishCard sevenDiamonds = new GoFishCard(Suite.diamonds, Book.seven);
        deck.add(sevenDiamonds);
        
        // creating eight book
        GoFishCard eightHeart = new GoFishCard(Suite.hearts, Book.eight);
        deck.add(eightHeart);
        GoFishCard eightClub = new GoFishCard(Suite.clubs, Book.eight);
        deck.add(eightClub);
        GoFishCard eightSpade = new GoFishCard(Suite.spades, Book.eight);
        deck.add(eightSpade);
        GoFishCard eightDiamonds = new GoFishCard(Suite.diamonds, Book.eight);
        deck.add(eightDiamonds);
        
        // creating nine book
        GoFishCard nineHeart = new GoFishCard(Suite.hearts, Book.nine);
        deck.add(nineHeart);
        GoFishCard nineClub = new GoFishCard(Suite.clubs, Book.nine);
        deck.add(nineClub);
        GoFishCard nineSpade = new GoFishCard(Suite.spades, Book.nine);
        deck.add(nineSpade);
        GoFishCard nineDiamonds = new GoFishCard(Suite.diamonds, Book.nine);
        deck.add(nineDiamonds);
        
        // creating ten book
        GoFishCard tenHeart = new GoFishCard(Suite.hearts, Book.ten);
        deck.add(tenHeart);
        GoFishCard tenClub = new GoFishCard(Suite.clubs, Book.ten);
        deck.add(tenClub);
        GoFishCard tenSpade = new GoFishCard(Suite.spades, Book.ten);
        deck.add(tenSpade);
        GoFishCard tenDiamonds = new GoFishCard(Suite.diamonds, Book.ten);
        deck.add(tenDiamonds);
        
        // creating queen book
        GoFishCard queenHeart = new GoFishCard(Suite.hearts, Book.queen);
        deck.add(queenHeart);
        GoFishCard queenClub = new GoFishCard(Suite.clubs, Book.queen);
        deck.add(queenClub);
        GoFishCard queenSpade = new GoFishCard(Suite.spades, Book.queen);
        deck.add(queenSpade);
        GoFishCard queenDiamonds = new GoFishCard(Suite.diamonds, Book.queen);
        deck.add(queenDiamonds);
        
        // creating king book
        GoFishCard kingHeart = new GoFishCard(Suite.hearts, Book.king);
        deck.add(kingHeart);
        GoFishCard kingClub = new GoFishCard(Suite.clubs, Book.king);
        deck.add(kingClub);
        GoFishCard kingSpade = new GoFishCard(Suite.spades, Book.king);
        deck.add(kingSpade);
        GoFishCard kingDiamonds = new GoFishCard(Suite.diamonds, Book.king);
        deck.add(kingDiamonds);
        
        return deck;
    }
    
}
