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
            if (newValue.length() == 1 && !isInternalChange.get()) {
                field1.setText(field1.getText().toUpperCase());
                field2.requestFocus();
            }
        });

        field2.textProperty().addListener((observable, oldValue, newValue) -> {
            // making sure user only inputs 1 character
            if (newValue.length() > 1) {
                field2.setText(newValue.substring(0, 1));
            }

            if (newValue.length() == 1 && !isInternalChange.get()) {
                field2.setText(field2.getText().toUpperCase());
                field3.requestFocus();
            }
        });

        // allowing better use of backspace inputs
        field2.setOnKeyPressed(keyEvent -> {
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
            // making sure user only inputs 1 character
            if (newValue.length() == 1 && !isInternalChange.get()) {
                field3.setText(field3.getText().toUpperCase());
                field4.requestFocus();
            }
        });

        // allowing better use of backspace inputs
        field3.setOnKeyPressed(keyEvent -> {
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
            // making sure user only inputs 1 character
            if (newValue.length() > 1) {
                field4.setText(newValue.substring(0, 1));
            }

            if (newValue.length() == 1 && !isInternalChange.get()) {
                field4.setText(field4.getText().toUpperCase());
                field5.requestFocus();
            }
        });

        // allowing better use of backspace inputs
        field4.setOnKeyPressed(keyEvent -> {
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
            // making sure user only inputs 1 character
            if (newValue.length() > 1) {
                field5.setText(newValue.substring(0, 1));
            }

            if (newValue.length() == 1 && !isInternalChange.get()) {
                isInternalChange.set(true);
                field5.setText(field5.getText().toUpperCase());
                isInternalChange.set(false);

                System.out.println("Reached the end of the row");
            }
        });

        // allowing better use of backspace inputs
        field5.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode().isLetterKey()){
                field5Backspace = false;
            } else if (keyEvent.getCode() == KeyCode.BACK_SPACE) {
                if (!field5Backspace){
                    field5Backspace = true;
                } else {
                    field5Backspace = false;
                    field4.requestFocus();
                }
            }
        });


    }
}
