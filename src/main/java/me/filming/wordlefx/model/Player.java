package me.filming.wordlefx.model;

import me.filming.wordlefx.model.Game;

import java.util.ArrayList;

public class Player {
    Game game;
    int remainingGuesses;
    ArrayList<String> playerGuesses;

    public Player(Game initGame){
        game = initGame;
        remainingGuesses = 0;
        playerGuesses = new ArrayList<String>();
    }

    public int getRemainingGuesses(){
        return remainingGuesses;
    }

    public ArrayList<String> getPlayerGuesses(){
        return playerGuesses;
    }

    public void makeGuess(String guess){
        String response = game.checkGuess(guess);
        playerGuesses.add(response);
        remainingGuesses -= 1;
    }
}
