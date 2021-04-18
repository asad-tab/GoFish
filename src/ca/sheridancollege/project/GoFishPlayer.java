/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author abdullahirum
 */
public class GoFishPlayer extends Player{
    private GroupOfCards hand;
    
    public GoFishPlayer(String name)
    {
        super(name);
    }
    
    @Override
    public void play() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void receiveCards(ArrayList<Card> cards) {
        if(hand == null) {
            hand = new GroupOfCards(cards.size());
        }
        hand.addCards(cards);
    }
    
    public ArrayList<Card> requestCards(int book) {
        // check if there is
        return hand.getBook(book);
    }
    
    public int countBooks() {
        return hand.countCompleteBooks();
    }
    
    public void showHand() {
        hand.printCards();
    }
    
    public Book getMissingBook() {
        return hand.getMissingBook();
    }
    
}
