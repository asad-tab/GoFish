/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.HashSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author abdullahirum
 */
public class GoFishTest {
    
    public GoFishTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

     /**
     * Test of generateGoFishDeckOfCards method, of class GoFish.
     */
    @Test
    public void testGenerateGoFishDeckOfCards() {
        System.out.println("generateGoFishDeckOfCards");
        GoFish instance = new GoFish();
        ArrayList<Card> result = instance.generateGoFishDeckOfCards();
        // check the size is correct
        assertEquals(52, result.size());  
    }   
}
