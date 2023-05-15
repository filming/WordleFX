package me.filming.wordlefx;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;

public class Game {
    ArrayList<String> wordlist;
    String gameWord;
    boolean wordGuessed;
    boolean gameStatus;

    public Game(){
        wordlist = new ArrayList<String>();

        try{
            File wordlistFile = new File("storage/wordlist.txt");
            Scanner scanner = new Scanner(wordlistFile);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                wordlist.add(data);
            }
            scanner.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }

        gameWord = "";
        wordGuessed = false;
        gameStatus = true;
    }

    public boolean getWordGuessed(){
        return wordGuessed;
    }

    public boolean getGameStatus(){
        return gameStatus;
    }

    public String getGameWord(){
        return gameWord;
    }

    public void checkGuess(String guess){
        String response = "";

        if (guess.equals(gameWord)){
            gameStatus = false;
            wordGuessed = true;
        }

        HashMap<Character, Integer> gameWordCharOccurrences = new HashMap<Character, Integer>();





    }

    public void newGame(){
        Random rand = new Random();
        int upperbound = wordlist.size();

        gameWord = wordlist.get(rand.nextInt(upperbound));
    }
}
