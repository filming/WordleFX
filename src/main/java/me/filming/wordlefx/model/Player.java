package me.filming.wordlefx.model;

import me.filming.wordlefx.model.Game;

import java.util.ArrayList;

public class Player {
    Game game;
    int remainingGuesses;
    ArrayList<String> playerGuesses;

    private int correctGuessed;
    private int incorrectGuessed;

    public Player(Game initGame){
        game = initGame;
        remainingGuesses = 0;
        playerGuesses = new ArrayList<String>();
        correctGuessed = 0;
        incorrectGuessed = 0;
    }

    public int getRemainingGuesses(){
        return remainingGuesses;
    }

    public ArrayList<String> getPlayerGuesses(){
        return playerGuesses;
    }

    public String makeGuess(String guess){
        String response = game.checkGuess(guess);
        playerGuesses.add(response);
        remainingGuesses -= 1;

        return response;
    }

    public int getCorrectGuessed() {
        return correctGuessed;
    }

    public int getIncorrectGuessed() {
        return incorrectGuessed;
    }

    public void updateCorrectGuesses(){
        correctGuessed += 1;
    }
    public void updateIncorrectGuesses(){
        incorrectGuessed += 1;
    }
}
