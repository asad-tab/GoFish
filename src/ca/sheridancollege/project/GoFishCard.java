/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

enum Suite {
    clubs,
    hearts,
    spades,
    diamonds
}

enum Book {
    ace,
    one,
    two,
    three,
    four,
    five,
    six,
    seven,
    eight,
    nine,
    ten,
    queen,
    king
}

/**
 *
 * @author tabassua
 */
public class GoFishCard extends Card{
    Suite suite;
    Book book;

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
