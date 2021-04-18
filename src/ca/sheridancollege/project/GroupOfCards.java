/**
 * SYST 17796 Project Winter 2021 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * A concrete class that represents any grouping of cards for a Game.
 * HINT, you might want to subclass this more than once.
 * The group of cards has a maximum size attribute which is flexible for reuse.
 * @author dancye
 */
public class GroupOfCards 
{
   
    //The group of cards, stored in an ArrayList
    private ArrayList <Card> cards;
    private int size;//the size of the grouping
    
    public GroupOfCards(int givenSize)
    {
        size = givenSize;
        cards = new ArrayList<Card>();
    }
    
    /**
     * A method that will get the group of cards as an ArrayList
     * @return the group of cards.
     */
    public ArrayList<Card> showCards()
    {
        return cards;
    }
    
    public void shuffle()
    {
        Collections.shuffle(cards);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param givenSize the max size for the group of cards
     */
    public void setSize(int givenSize) {
        size = givenSize;
    }
    
    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
    
    public void addCards(ArrayList<Card> cards) {
        this.cards.addAll(cards);
    }
    
    public ArrayList<Card> dole5() {
        ArrayList<Card> returnSet = new ArrayList<>();
        // remove 5 cards to return
        int i = 0;
        while(!cards.isEmpty() && i < 5) {
            returnSet.add(cards.remove(0));
            i++;
        }
        return returnSet;
    }
    
    public Card dole1() {
        if(!cards.isEmpty()) {
            return cards.remove(0);
        }
        return null;
    }
    
    
    /**
     * 
     * @param book the desired book from this given group of cards
     * @return the set of cards that match the given book
     */
    public ArrayList<Card> getBook(int book) {
        ArrayList<Card> returnSet = new ArrayList<>();
        for(Card c: cards) {
            if(((GoFishCard)c).book.getNumVal() == book) {
                returnSet.add(c);
            }
        }
        // remove all cards that match book
        int i = 0;
        while(i < cards.size()) {
            Card c = cards.get(i);
            if(((GoFishCard)c).book.getNumVal() == book) {
                cards.remove(c);
            } else {
                i++;
            }
        }
        return returnSet;
    }
    
    public boolean isEmpty() {
        if(cards == null || cards.isEmpty()) {
            return true;
        } 
        return false;
    }
    
    public Book getMissingBook() {
        // find the count of all books in hand
        HashMap<Book, Integer> bookCounts = new HashMap<>();
        for(Card c: cards) {
            GoFishCard gfc = (GoFishCard)c;
            int currentCount = bookCounts.getOrDefault(gfc.book, 0);
            bookCounts.put(gfc.book, currentCount + 1);
        }

        // return first book that's not complete (has all 4 suites)
        Iterator it = bookCounts.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            if((Integer)pair.getValue() < 4) {
                return (Book)pair.getKey();
            }
            it.remove(); 
        }
        
        // coming here means that the current hand doesnt have any suite missing for any of its books
        // therefore we should return any books we don't have in our hand
        Set<Book> bookUniverse = new HashSet<>();
        bookUniverse.add(Book.ace); 
        bookUniverse.add(Book.one);
        bookUniverse.add(Book.two);
        bookUniverse.add(Book.three);
        bookUniverse.add(Book.four);
        bookUniverse.add(Book.five);
        bookUniverse.add(Book.six);
        bookUniverse.add(Book.seven);
        bookUniverse.add(Book.eight);
        bookUniverse.add(Book.nine);
        bookUniverse.add(Book.ten);
        bookUniverse.add(Book.queen);
        bookUniverse.add(Book.king);
        
        // remove every book from the set that we already have
        for(Card c: cards) {
            GoFishCard gfc = (GoFishCard)c;
            bookUniverse.remove(gfc.book);
        }
        
        Object[] arr = bookUniverse.toArray();
        return (Book)arr[0];
    }
    
    public int countCompleteBooks() {
        // find the count of all books in hand
        HashMap<Book, Integer> bookCounts = new HashMap<>();
        for(Card c: cards) {
            GoFishCard gfc = (GoFishCard)c;
            int currentCount = bookCounts.getOrDefault(gfc.book, 0);
            bookCounts.put(gfc.book, currentCount + 1);
        }

        // count the number of complete books
        int completeBookCount = 0;
        Iterator it = bookCounts.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            if((Integer)pair.getValue() == 4) {
                completeBookCount++;
            }
            it.remove(); 
        }
        return completeBookCount;
    }
    
    public void printCards() {
        for(Card c: cards) {
            System.out.print(c.toString() + " --- ");
        }
    }
     
}//end class
