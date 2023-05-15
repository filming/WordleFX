package me.filming.wordlefx;

import java.util.ArrayList;

public class Game {
    ArrayList<String> wordList;
    String gameWord;
    boolean wordGuessed;
    boolean gameStatus;

    public Game(){
        wordList = new ArrayList<String>();
        gameWord = "";
        wordGuessed = false;
        gameStatus = false;
    }
}
