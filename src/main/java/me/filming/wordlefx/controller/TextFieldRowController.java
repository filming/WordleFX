package me.filming.wordlefx.controller;

import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import me.filming.wordlefx.model.Game;
import me.filming.wordlefx.model.Player;
import me.filming.wordlefx.view.TextFieldRow;
import me.filming.wordlefx.view.View;

import java.util.ArrayList;

public class TextFieldRowController {
    private Game game;
    private Player player;
    private View view;

    private Boolean wordSubmitted;
    private TextFieldRow nextRow;

    private TextField field1;
    private TextField field2;
    private TextField field3;
    private TextField field4;
    private TextField field5;

    private Boolean field1Backspace;
    private Boolean field2Backspace;
    private Boolean field3Backspace;
    private Boolean field4Backspace;
    private Boolean field5Backspace;

    private BooleanProperty isInternalChange;

    public TextFieldRowController(Game initGame, Player initPlayer, TextFieldRow initTextFieldRow, TextFieldRow initNextRow, View initView) {
        game = initGame;
        player = initPlayer;
        view = initView;

        wordSubmitted = false;
        nextRow = initNextRow;

        field1 = initTextFieldRow.getField1();
        field1.addEventFilter(MouseEvent.ANY, MouseEvent::consume);
        field2 = initTextFieldRow.getField2();
        field3 = initTextFieldRow.getField3();
        field4 = initTextFieldRow.getField4();
        field5 = initTextFieldRow.getField5();

        field1.addEventFilter(MouseEvent.ANY, MouseEvent::consume);
        field2.addEventFilter(MouseEvent.ANY, MouseEvent::consume);
        field3.addEventFilter(MouseEvent.ANY, MouseEvent::consume);
        field4.addEventFilter(MouseEvent.ANY, MouseEvent::consume);
        field5.addEventFilter(MouseEvent.ANY, MouseEvent::consume);

        field1Backspace = false;
        field2Backspace = false;
        field3Backspace = false;
        field4Backspace = false;
        field5Backspace = false;

        isInternalChange = new SimpleBooleanProperty(false);

        initializeListeners();
    }

    private void initializeListeners() {
        field1.textProperty().addListener((observable, oldValue, newValue) -> {

            if (!wordSubmitted){
                // making sure that current field contains 1 character
                if (newValue.length() > 1) {
                    field1.setText(newValue.substring(0, 1));
                }

                // only allowing alphabetical characters as valid input
                if (newValue.matches("[a-zA-Z]") ){
                    field1.setText(field1.getText().toUpperCase());
                    field2.requestFocus();
                } else {
                    field1.clear();
                }
            }
        });

        field1.setOnKeyPressed(keyEvent -> {
            if (wordSubmitted) {
                keyEvent.consume(); // Ignore the event if the word has been submitted
            }

            // disable tab usage
            if (keyEvent.getCode() == KeyCode.TAB){
                field1.requestFocus();
            }

            if (!wordSubmitted){

                // adding the ability to go to previous fields using backspace
                if (keyEvent.getCode().isLetterKey()){
                    field2Backspace = false;
                } else if (keyEvent.getCode() == KeyCode.BACK_SPACE) {
                    if (!field2Backspace){
                        field2Backspace = true;
                    } else {
                        field2Backspace = false;
                        field1.requestFocus();
                    }
                }

            }
        });

        field2.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!wordSubmitted){
                // making sure that current field contains 1 character
                if (newValue.length() > 1) {
                    field2.setText(newValue.substring(0, 1));
                }

                // only allowing alphabetical characters as valid input
                if (newValue.matches("[a-zA-Z]") ){
                    field2.setText(field2.getText().toUpperCase());
                    field3.requestFocus();
                } else {
                    field2.clear();
                }
            }
        });


        field2.setOnKeyPressed(keyEvent -> {
            // disable tab usage
            if (keyEvent.getCode() == KeyCode.TAB){
                field2.requestFocus();
            }

            if (!wordSubmitted){

                // adding the ability to go to previous fields using backspace
                if (keyEvent.getCode().isLetterKey()){
                    field2Backspace = false;
                } else if (keyEvent.getCode() == KeyCode.BACK_SPACE) {
                    if (!field2Backspace){
                        field2Backspace = true;
                    } else {
                        field2Backspace = false;
                        field1.requestFocus();
                    }
                }
            }
        });

        field3.textProperty().addListener((observable, oldValue, newValue) -> {

            if (!wordSubmitted){
                // making sure that current field contains 1 character
                if (newValue.length() > 1) {
                    field3.setText(newValue.substring(0, 1));
                }

                // only allowing alphabetical characters as valid input
                if (newValue.matches("[a-zA-Z]") ){
                    field3.setText(field3.getText().toUpperCase());
                    field4.requestFocus();
                } else {
                    field3.clear();
                }
            }
        });

        field3.setOnKeyPressed(keyEvent -> {
            // disable tab usage
            if (keyEvent.getCode() == KeyCode.TAB){
                field3.requestFocus();
            }

            if (!wordSubmitted){

                // adding the ability to go to previous fields using backspace
                if (keyEvent.getCode().isLetterKey()){
                    field3Backspace = false;
                } else if (keyEvent.getCode() == KeyCode.BACK_SPACE) {
                    if (!field3Backspace){
                        field3Backspace = true;
                    } else {
                        field3Backspace = false;
                        field2.requestFocus();
                    }
                }
            }
        });

        field4.textProperty().addListener((observable, oldValue, newValue) -> {

            if (!wordSubmitted){
                // making sure that current field contains 1 character
                if (newValue.length() > 1) {
                    field4.setText(newValue.substring(0, 1));
                }

                // only allowing alphabetical characters as valid input
                if (newValue.matches("[a-zA-Z]") ){
                    field4.setText(field4.getText().toUpperCase());
                    field5.requestFocus();
                } else {
                    field4.clear();
                }
            }
        });

        field4.setOnKeyPressed(keyEvent -> {
            // disable tab usage
            if (keyEvent.getCode() == KeyCode.TAB){
                field4.requestFocus();
            }

            if (!wordSubmitted){

                // adding the ability to go to previous fields using backspace
                if (keyEvent.getCode().isLetterKey()){
                    field4Backspace = false;
                } else if (keyEvent.getCode() == KeyCode.BACK_SPACE) {
                    if (!field4Backspace){
                        field4Backspace = true;
                    } else {
                        field4Backspace = false;
                        field3.requestFocus();
                    }
                }
            }
        });

        field5.textProperty().addListener((observable, oldValue, newValue) -> {

            if (!wordSubmitted){
                // making sure that current field contains 1 character
                if (newValue.length() > 1) {
                    field5.setText(newValue.substring(0, 1).toUpperCase());
                }

                // only allowing alphabetical characters as valid input
                if (newValue.length() == 1 && !isInternalChange.get()) {
                    isInternalChange.set(true);
                    if (newValue.matches("[a-zA-Z]")){
                        field5.setText(newValue.toUpperCase());
                    } else {
                        field5.clear();
                    }
                    isInternalChange.set(false);

                    System.out.println("Reached the end of the row");
                }
            }
        });

        field5.setOnKeyPressed(keyEvent -> {
            // disable tab usage
            if (keyEvent.getCode() == KeyCode.TAB){
                field5.requestFocus();
            }

            if (!wordSubmitted){

                // adding the ability to go to previous fields using backspace
                if (keyEvent.getCode().isLetterKey()){
                    field5Backspace = false;
                }
                else if (keyEvent.getCode() == KeyCode.BACK_SPACE) {
                    if (!field5Backspace){
                        field5Backspace = true;
                    } else {
                        field5Backspace = false;
                        field4.requestFocus();
                    }
                }
                else if (keyEvent.getCode() == KeyCode.ENTER){
                    if ((field1.getText().length() == 1) && (field2.getText().length() == 1) && (field3.getText().length() == 1) && (field4.getText().length() == 1) && (field5.getText().length() == 1)){
                        wordSubmitted = true;
                        Boolean finalRow = false;

                        // Move to the next row
                        if (nextRow != null) {
                            nextRow.getField1().requestFocus();
                        } else {
                            field5.getParent().requestFocus();
                            System.out.println("We are at the final row!");
                            finalRow = true;
                        }

                        // change colour of the current row's fields
                        String playerGuess = field1.getText() + field2.getText() + field3.getText() + field4.getText() + field5.getText();
                        playerGuess = playerGuess.toLowerCase();

                        String response = player.makeGuess(playerGuess);
                        String[] responseParts = response.split(",");

                        TextField[] fields = { field1, field2, field3, field4, field5 };

                        // create a visual delay of 0.3s between each colour field change
                        SequentialTransition sequentialTransition = new SequentialTransition();
                        for (int i = 0; i < fields.length; i++) {
                            PauseTransition delay = new PauseTransition(Duration.seconds(0.30));

                            TextField currentField = fields[i];
                            String currentPart = responseParts[i];

                            delay.setOnFinished(event -> {
                                if (currentPart.charAt(1) == 'G'){
                                    currentField.setStyle("-fx-highlight-fill: white; -fx-highlight-text-fill: black; -fx-control-inner-background: green; -fx-text-fill: white;");
                                } else if (currentPart.charAt(1) == 'Y'){
                                    currentField.setStyle("-fx-highlight-fill: white; -fx-highlight-text-fill: black; -fx-control-inner-background: #fd6303; -fx-text-fill: white;");
                                } else if (currentPart.charAt(1) == 'R'){
                                    currentField.setStyle("-fx-highlight-fill: white; -fx-highlight-text-fill: black; -fx-control-inner-background: #8d0606; -fx-text-fill: white;");
                                }

                            });

                            sequentialTransition.getChildren().add(delay);
                        }
                        sequentialTransition.play();

                        // check to see if word was guessed
                        if (playerGuess.equals(game.getGameWord())){
                            //field5.getParent().requestFocus();

                            // updating display panel
                            player.updateCorrectGuesses();

                            view.getGameMessage().setText("     YOU WIN!");
                            view.getGameMessage().setTextFill(Color.rgb(66, 126, 26));

                            view.getCorrectWordPrompt().setVisible(true);
                            view.getCorrectWord().setText("             " + game.getGameWord());

                            view.getCorrectAmount().setText("" + player.getCorrectGuessed());
                            view.getIncorrectAmount().setText("" + player.getIncorrectGuessed());
                        } else {
                            if (finalRow){
                                // ran out of guesses, lose
                                player.updateIncorrectGuesses();

                                view.getGameMessage().setText("    YOU LOSE!");
                                view.getGameMessage().setTextFill(Color.rgb(140, 12, 12));

                                view.getCorrectWordPrompt().setVisible(true);
                                view.getCorrectWord().setText("             " + game.getGameWord());

                                view.getCorrectAmount().setText("" + player.getCorrectGuessed());
                                view.getIncorrectAmount().setText("" + player.getIncorrectGuessed());
                            }
                        }
                    }
                }
            }
        });




    }
}
