/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author tabassua
 */
public class GoFish extends Game {
    private static final String NAME = "GoFish";
    private GoFishPlayer user = new GoFishPlayer("user");
    private GoFishPlayer bot = new GoFishPlayer("bot");
    private final List<Player> players = new ArrayList<>(Arrays.asList(user, bot));
    
    public GoFish() {
        super(NAME);
    }

    @Override
    public void play() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void declareWinner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
