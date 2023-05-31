package me.filming.wordlefx.model;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;

public class Game {
    private ArrayList<String> wordlist;
    private String gameWord;
    private boolean wordGuessed;
    private boolean gameStatus;


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

    public String checkGuess(String guess){
        String response = "";

        if (guess.equals(gameWord)){
            gameStatus = false;
            wordGuessed = true;
        }

        HashMap<Character, Integer> gameWordCharOccurrences = new HashMap<Character, Integer>();
        for (int i=0; i < gameWord.length(); i++){
            char currentChar = gameWord.charAt(i);

            if (gameWordCharOccurrences.containsKey(currentChar)){
                gameWordCharOccurrences.put(currentChar, gameWordCharOccurrences.get(currentChar) + 1);

            } else {
                gameWordCharOccurrences.put(currentChar, 1);
            }
        }

        for (int i=0; i < guess.length(); i++){
            char currentGuessChar = guess.charAt(i);

            if (!gameWordCharOccurrences.containsKey(currentGuessChar)){
                response += currentGuessChar + "R,";

            } else {
                char currentGameWordChar = gameWord.charAt(i);

                if ((currentGuessChar == currentGameWordChar) && (gameWordCharOccurrences.get(currentGuessChar) > 0)){
                    response += currentGuessChar + "G,";
                    gameWordCharOccurrences.put(currentGuessChar, gameWordCharOccurrences.get(currentGuessChar) - 1);

                } else if (gameWordCharOccurrences.get(currentGuessChar) > 0) {
                    response += currentGuessChar + "Y,";
                    gameWordCharOccurrences.put(currentGuessChar, gameWordCharOccurrences.get(currentGuessChar) - 1);

                } else {
                    response += currentGuessChar + "R,";
                }
            }
        }

        String formattedResponse = "";
        for (int i=0; i < response.length() - 1; i++){
            char currentChar = response.charAt(i);
            formattedResponse += currentChar;
        }

        return formattedResponse;
    }

    public void newGame(){
        Random rand = new Random();
        int upperbound = wordlist.size();

        gameWord = wordlist.get(rand.nextInt(upperbound));
        System.out.println(gameWord);
    }
}
