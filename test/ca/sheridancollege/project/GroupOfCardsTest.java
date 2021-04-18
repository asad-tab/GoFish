/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author abdullahirum
 */
public class GroupOfCardsTest {
    
    // class under test
    GroupOfCards cutPlayer;
    
    //
    GroupOfCards cutDeck;
    
    // deck of cards
    ArrayList<Card> cards;
    
    public GroupOfCardsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        GoFish game = new GoFish();
        cards = game.generateGoFishDeckOfCards();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of showCards method, of class GroupOfCards.
     */
    @Test
    public void testShowCards() {
        System.out.println("shuffle");
        GroupOfCards instance = new GroupOfCards(cards.size());
        instance.setCards(cards);
        ArrayList<Card> testList = instance.showCards();
        
        // make sure the lists are the same as the one set
        for(int i = 0; i < testList.size(); i++) {
            if(cards.get(i) != testList.get(i)) {
                fail("The show cards test failed.");
            }
        }
        // passed
        return;
    }

    /**
     * Test of shuffle method, of class GroupOfCards.
     */
    @Test
    public void testShuffle() {
        System.out.println("shuffle");
        GroupOfCards instance = new GroupOfCards(cards.size());
        ArrayList<Card> originalList = new ArrayList<>();
        for(Card c : cards) {
           originalList.add(c);
        }
        instance.setCards(cards);
        instance.shuffle();
        
        // check the same should be same
        assertEquals(originalList.size(), instance.showCards().size());
        
        // make sure the orders are different
        for(int i = 0; i < originalList.size(); i++) {
            // at least one position should be different
            if(originalList.get(i) != instance.showCards().get(i)) {
                // pass
                return;
            }
        }
        fail("The shuffle test failed.");
    }

    /**
     * Test of getSize method, of class GroupOfCards.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        GroupOfCards instance = new GroupOfCards(cards.size());
        instance.setCards(cards);
        ArrayList<Card> testList = instance.showCards();
        assertEquals(testList.size(), cards.size());
    }

    /**
     * Test of setCards method, of class GroupOfCards.
     */
    @Test
    public void testSetCards() {
        System.out.println("setCards");
        GroupOfCards instance = new GroupOfCards(cards.size());
        instance.setCards(cards);
        
        // check the same should be same
        assertEquals(instance.showCards().size(), cards.size());
        
        // make sure the lists are equal
        for(int i = 0; i < instance.showCards().size(); i++) {
            
            if(instance.showCards().get(i) != cards.get(i)) {    
                fail("The setCards test failed.");
            }
        }
        return;
    }

    /**
     * Test of addCards method, of class GroupOfCards.
     */
    @Test
    public void testAddCards() {
        System.out.println("addCards");
        GoFishCard card1 = new GoFishCard(Suite.clubs, Book.ace);
        GoFishCard card2 = new GoFishCard(Suite.diamonds, Book.ace);
        
        ArrayList<Card> cards = new ArrayList<>(Arrays.asList(card1, card2));
        GroupOfCards instance = new GroupOfCards(cards.size());
        instance.addCards(cards);
        
        //check that the cards are added
        ArrayList<Card> instanceCards = instance.showCards();
        assertEquals(instanceCards.get(0), card1);
        assertEquals(instanceCards.get(1), card2);
    }

    /**
     * Test of dole5 method, of class GroupOfCards.
     * Test when there are exactly 5 cards in the deck
     */
    @Test
    public void testDole5() {
        System.out.println("dole5");
        GoFishCard card1 = new GoFishCard(Suite.clubs, Book.ace);
        GoFishCard card2 = new GoFishCard(Suite.diamonds, Book.ace);
        GoFishCard card3 = new GoFishCard(Suite.diamonds, Book.one);
        GoFishCard card4 = new GoFishCard(Suite.diamonds, Book.two);
        GoFishCard card5 = new GoFishCard(Suite.diamonds, Book.three);
        
        ArrayList<Card> cards = new ArrayList<>(Arrays.asList(card1, card2, card3, card4, card5));
        GroupOfCards instance = new GroupOfCards(cards.size());
        instance.addCards(cards);
        
        // make sure you get back what you expected
        ArrayList<Card> instanceCards = instance.dole5();
        assertEquals(instanceCards.get(0), card1);
        assertEquals(instanceCards.get(1), card2);
        assertEquals(instanceCards.get(2), card3);
        assertEquals(instanceCards.get(3), card4);
        assertEquals(instanceCards.get(4), card5);
        
        // the deck should be empty now
        assertEquals(instance.showCards().size(), 0);
        
    }
    
    /**
     * Test of dole5 method, of class GroupOfCards.
     * Test when there are more than 5 cards in the deck
     */
    @Test
    public void testDole5MoreThan5() {
        System.out.println("dole5 when more than 5");
        GoFishCard card1 = new GoFishCard(Suite.clubs, Book.ace);
        GoFishCard card2 = new GoFishCard(Suite.diamonds, Book.ace);
        GoFishCard card3 = new GoFishCard(Suite.diamonds, Book.one);
        GoFishCard card4 = new GoFishCard(Suite.diamonds, Book.two);
        GoFishCard card5 = new GoFishCard(Suite.diamonds, Book.three);
        GoFishCard card6 = new GoFishCard(Suite.diamonds, Book.four);
        
        ArrayList<Card> cards = new ArrayList<>(Arrays.asList(card1, card2, card3, card4, card5, card6));
        GroupOfCards instance = new GroupOfCards(cards.size());
        instance.addCards(cards);
        
        // make sure you get back what you expected
        ArrayList<Card> instanceCards = instance.dole5();
        assertEquals(instanceCards.get(0), card1);
        assertEquals(instanceCards.get(1), card2);
        assertEquals(instanceCards.get(2), card3);
        assertEquals(instanceCards.get(3), card4);
        assertEquals(instanceCards.get(4), card5);
        
        // the deck should have one remaining
        assertEquals(instance.showCards().size(), 1);
        
    }

    /**
     * Test of dole1 method, of class GroupOfCards.
     * When there is only one card
     */
    @Test
    public void testDole1() {
        System.out.println("dole1");
        GoFishCard card1 = new GoFishCard(Suite.clubs, Book.ace);
        
        ArrayList<Card> cards = new ArrayList<>(Arrays.asList(card1));
        GroupOfCards instance = new GroupOfCards(cards.size());
        instance.addCards(cards);
        
        // make sure you get back what you expected
        ArrayList<Card> instanceCards = new ArrayList<Card>(Arrays.asList(instance.dole1()));
        assertEquals(instanceCards.get(0), card1);
        
        // the deck should have one remaining
        assertEquals(instance.showCards().size(), 0);
    }

    /**
     * Test of getBook method, of class GroupOfCards.
     * Test here that cut returns all cards that match the given book and no more or less
     */
    @Test
    public void testGetBook() {
        System.out.println("getBook");
        Book book = Book.ace;
        GoFishCard card1 = new GoFishCard(Suite.clubs, Book.ace);
        GoFishCard card2 = new GoFishCard(Suite.diamonds, Book.ace);
        GoFishCard card3 = new GoFishCard(Suite.diamonds, Book.one);
        GoFishCard card4 = new GoFishCard(Suite.diamonds, Book.two);
        GoFishCard card5 = new GoFishCard(Suite.diamonds, Book.three);
        GoFishCard card6 = new GoFishCard(Suite.diamonds, Book.four);
        
        ArrayList<Card> cards = new ArrayList<>(Arrays.asList(card1, card2, card3, card4, card5, card6));
        GroupOfCards instance = new GroupOfCards(cards.size());
        instance.addCards(cards);
        
        // we will request the ace book and should get back 2 cards 
        ArrayList<Card> returnedSet = instance.getBook(book.getNumVal());
        
        // check that there are 2 aces
        assertEquals(((GoFishCard)returnedSet.get(0)).book, Book.ace);
        assertEquals(((GoFishCard)returnedSet.get(1)).book, Book.ace);
        
        assertEquals(returnedSet.size(), 2);
        
        // there should be 4 left in the original group of card
        assertEquals(instance.showCards().size(), 4);
        
    }
    
    /**
     * Test of getBook method, of class GroupOfCards.
     * Test here that cut returns all cards that match the given book and no more or less
     */
    @Test
    public void testGetBookWithLast() {
        System.out.println("getBook");
        Book book = Book.ace;
        GoFishCard card1 = new GoFishCard(Suite.clubs, Book.ace);
        GoFishCard card2 = new GoFishCard(Suite.diamonds, Book.ace);
        GoFishCard card3 = new GoFishCard(Suite.diamonds, Book.one);
        GoFishCard card4 = new GoFishCard(Suite.diamonds, Book.two);
        GoFishCard card5 = new GoFishCard(Suite.diamonds, Book.three);
        GoFishCard card6 = new GoFishCard(Suite.diamonds, Book.four);
        GoFishCard card7 = new GoFishCard(Suite.hearts, Book.ace);
        
        ArrayList<Card> cards = new ArrayList<>(Arrays.asList(card1, card2, card3, card4, card5, card6, card7));
        GroupOfCards instance = new GroupOfCards(cards.size());
        instance.addCards(cards);
        
        // we will request the ace book and should get back 3 cards 
        ArrayList<Card> returnedSet = instance.getBook(book.getNumVal());
        
        // check that there are 3 aces
        assertEquals(((GoFishCard)returnedSet.get(0)).book, Book.ace);
        assertEquals(((GoFishCard)returnedSet.get(1)).book, Book.ace);
        assertEquals(((GoFishCard)returnedSet.get(2)).book, Book.ace);
        
        assertEquals(returnedSet.size(), 3);
        
        // there should be 4 left in the original group of card
        assertEquals(instance.showCards().size(), 4);
        
    }

    /**
     * Test of isEmpty method, of class GroupOfCards.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        GroupOfCards instance = new GroupOfCards(0);
        instance.setCards(null);
        assertTrue(instance.isEmpty());
    }

    /**
     * Test of getMissingBook method, of class GroupOfCards.
     * This test if we have two complete books and one book which is incomplete i.e. less than 4
     */
    @Test
    public void testGetMissingBook() {
        System.out.println("getMissingBook");
        GoFishCard card1 = new GoFishCard(Suite.clubs, Book.ace);
        GoFishCard card2 = new GoFishCard(Suite.diamonds, Book.ace);
        GoFishCard card3 = new GoFishCard(Suite.hearts, Book.ace);
        GoFishCard card4 = new GoFishCard(Suite.spades, Book.ace);
        
        GoFishCard card5 = new GoFishCard(Suite.diamonds, Book.two);
        GoFishCard card6 = new GoFishCard(Suite.hearts, Book.two);
        GoFishCard card7 = new GoFishCard(Suite.spades, Book.two);
        GoFishCard card8 = new GoFishCard(Suite.clubs, Book.two);
        
        GoFishCard card9 = new GoFishCard(Suite.diamonds, Book.three);
        GoFishCard card10 = new GoFishCard(Suite.clubs, Book.three);
        
        
        ArrayList<Card> cards = new ArrayList<>(Arrays.asList(card1, card2, card3, card4, card5, card6, card7, card8, card9, card10));
        GroupOfCards instance = new GroupOfCards(cards.size());
        instance.addCards(cards);
        
        //we should get the 'three's book
        assertEquals(instance.getMissingBook(), Book.three);
    }
    
    /**
     * Test of getMissingBook method, of class GroupOfCards.
     * This test if all our books are complete, in that case we want to ask for any book we don't have in our hand
     */
    @Test
    public void testGetMissingBookCompleteBooks() {
        System.out.println("getMissingBook");
        GoFishCard card1 = new GoFishCard(Suite.clubs, Book.ace);
        GoFishCard card2 = new GoFishCard(Suite.diamonds, Book.ace);
        GoFishCard card3 = new GoFishCard(Suite.hearts, Book.ace);
        GoFishCard card4 = new GoFishCard(Suite.spades, Book.ace);
        
        GoFishCard card5 = new GoFishCard(Suite.diamonds, Book.two);
        GoFishCard card6 = new GoFishCard(Suite.hearts, Book.two);
        GoFishCard card7 = new GoFishCard(Suite.spades, Book.two);
        GoFishCard card8 = new GoFishCard(Suite.clubs, Book.two);
        
        GoFishCard card9 = new GoFishCard(Suite.diamonds, Book.three);
        GoFishCard card10 = new GoFishCard(Suite.clubs, Book.three);
        GoFishCard card11 = new GoFishCard(Suite.diamonds, Book.three);
        GoFishCard card12 = new GoFishCard(Suite.clubs, Book.three);
        
        
        ArrayList<Card> cards = new ArrayList<>(Arrays.asList(card1, card2, card3, card4, card5, card6, card7, card8, card9, card10, card11, card12));
        GroupOfCards instance = new GroupOfCards(cards.size());
        instance.addCards(cards);
        
        //we shouldn't get any of the existing books, rather the first book we done have i.e one
        assertNotEquals(instance.getMissingBook(), Book.three);
        assertNotEquals(instance.getMissingBook(), Book.ace);
        assertNotEquals(instance.getMissingBook(), Book.two);
    }

    /**
     * Test of countCompleteBooks method, of class GroupOfCards.
     */
    @Test
    public void testCountCompleteBooks() {
        System.out.println("countCompleteBooks");
        GoFishCard card1 = new GoFishCard(Suite.clubs, Book.ace);
        GoFishCard card2 = new GoFishCard(Suite.diamonds, Book.ace);
        GoFishCard card3 = new GoFishCard(Suite.hearts, Book.ace);
        GoFishCard card4 = new GoFishCard(Suite.spades, Book.ace);
        
        GoFishCard card5 = new GoFishCard(Suite.diamonds, Book.two);
        GoFishCard card6 = new GoFishCard(Suite.hearts, Book.two);
        GoFishCard card7 = new GoFishCard(Suite.spades, Book.two);
        GoFishCard card8 = new GoFishCard(Suite.clubs, Book.two);
        
        GoFishCard card9 = new GoFishCard(Suite.diamonds, Book.three);
        GoFishCard card10 = new GoFishCard(Suite.clubs, Book.three);
        GoFishCard card11 = new GoFishCard(Suite.diamonds, Book.three);
        GoFishCard card12 = new GoFishCard(Suite.clubs, Book.three);
        
        GoFishCard card13 = new GoFishCard(Suite.diamonds, Book.four);
        GoFishCard card14 = new GoFishCard(Suite.clubs, Book.four);
        GoFishCard card15 = new GoFishCard(Suite.diamonds, Book.four);
        
        
        ArrayList<Card> cards = new ArrayList<>(Arrays.asList(card14, card15, card1, card2, card3, card4, card5, card6, card7, card8, card9, card10, card11, card12, card13));
        GroupOfCards instance = new GroupOfCards(cards.size());
        instance.addCards(cards);
        
        // we should get 3 since as seen above, we have only 3 complete books, i.e. ace, two and three
        int count = instance.countCompleteBooks();
        assertEquals(count, 3);
    }

    /**
     * Test of printCards method, of class GroupOfCards.
     */
    @Ignore
    @Test
    public void testPrintCards() {
        System.out.println("printCards");
        return;
    }
    
}
