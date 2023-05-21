package me.filming.wordlefx.controller;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import me.filming.wordlefx.view.TextFieldRow;

import java.util.ArrayList;

public class TextFieldRowController {
    TextField field1;
    TextField field2;
    TextField field3;
    TextField field4;
    TextField field5;


    Boolean field1Backspace;
    Boolean field2Backspace;
    Boolean field3Backspace;
    Boolean field4Backspace;
    Boolean field5Backspace;


    private BooleanProperty isInternalChange;

    public TextFieldRowController(TextFieldRow initTextFieldRow) {
        field1 = initTextFieldRow.getField1();
        field2 = initTextFieldRow.getField2();
        field3 = initTextFieldRow.getField3();
        field4 = initTextFieldRow.getField4();
        field5 = initTextFieldRow.getField5();

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
        });

        field1.setOnKeyPressed(keyEvent -> {
            // disable tab usage
            if (keyEvent.getCode() == KeyCode.TAB){
                field1.requestFocus();
            }

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
        });

        field2.textProperty().addListener((observable, oldValue, newValue) -> {
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
        });


        field2.setOnKeyPressed(keyEvent -> {
            // disable tab usage
            if (keyEvent.getCode() == KeyCode.TAB){
                field2.requestFocus();
            }

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
        });

        field3.textProperty().addListener((observable, oldValue, newValue) -> {
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
        });

        field3.setOnKeyPressed(keyEvent -> {
            // disable tab usage
            if (keyEvent.getCode() == KeyCode.TAB){
                field3.requestFocus();
            }

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
        });

        field4.textProperty().addListener((observable, oldValue, newValue) -> {
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
        });

        field4.setOnKeyPressed(keyEvent -> {
            // disable tab usage
            if (keyEvent.getCode() == KeyCode.TAB){
                field4.requestFocus();
            }

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
        });

        field5.textProperty().addListener((observable, oldValue, newValue) -> {
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
        });

        field5.setOnKeyPressed(keyEvent -> {
            // disable tab usage
            if (keyEvent.getCode() == KeyCode.TAB){
                field5.requestFocus();
            }

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
                    System.out.println("This is a valid entry.");
                }
            }
        });




    }
}
