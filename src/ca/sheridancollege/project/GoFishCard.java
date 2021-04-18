/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

enum Suite {
    clubs("clubs"),
    hearts("hearts"),
    spades("spades"),
    diamonds("diamonds");
    
    private String name;

    Suite(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
}

enum Book {
    ace(0, "ace"),
    one(1, "one"),
    two(2, "two"),
    three(3, "three"),
    four(4, "four"),
    five(5, "five"),
    six(6, "six"),
    seven(7, "seven"),
    eight(8, "eight"),
    nine(9, "nine"),
    ten(10, "ten"),
    queen(11, "queen"),
    king(12, "king");
    
    private int numVal;
    private String name;

    Book(int numVal, String name) {
        this.numVal = numVal;
        this.name = name;
    }

    public int getNumVal() {
        return numVal;
    }
    
    public String getName() {
        return name;
    }
}

/**
 *
 * @author tabassua
 */
public class GoFishCard extends Card{
    Suite suite;
    Book book;
    
    public GoFishCard(Suite suite, Book book) {
        this.suite = suite;
        this.book = book;
    } 
    
    GoFishCard() {
    } 

    @Override
    public String toString() {
        return this.book.getName() + " of " + this.suite.getName();
    }
    
}
