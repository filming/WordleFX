package me.filming.wordlefx.view;

import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import me.filming.wordlefx.controller.TextFieldRowController;

public class View extends Pane {

    public View(){
        // set default settings
        setPrefSize(800, 600);
        setStyle("-fx-background-color: #24252F");

        // creating inner boarder
        Rectangle innerBorder = new Rectangle(40, 40, 720, 520);
        innerBorder.setFill(Color.rgb(55,56,66));

        getChildren().add(innerBorder);

        // creating row 1
        TextFieldRow row1 = new TextFieldRow(60, 60);
        TextFieldRowController row1Controller = new TextFieldRowController(row1);
        row1.setController(row1Controller);
        getChildren().add(row1);


        // creating row 2
        TextFieldRow row2 = new TextFieldRow(60, 140);
        TextFieldRowController row2Controller = new TextFieldRowController(row2);
        row2.setController(row2Controller);
        getChildren().add(row2);

        // creating row 3
        TextFieldRow row3 = new TextFieldRow(60, 220);
        TextFieldRowController row3Controller = new TextFieldRowController(row3);
        row3.setController(row3Controller);
        getChildren().add(row3);

        // creating row 4
        TextFieldRow row4 = new TextFieldRow(60, 300);
        TextFieldRowController row4Controller = new TextFieldRowController(row4);
        row4.setController(row4Controller);
        getChildren().add(row4);

        // creating row 5
        TextFieldRow row5 = new TextFieldRow(60, 380);
        TextFieldRowController row5Controller = new TextFieldRowController(row5);
        row5.setController(row5Controller);
        getChildren().add(row5);

        // creating row 6
        TextFieldRow row6 = new TextFieldRow(60, 460);
        TextFieldRowController row6Controller = new TextFieldRowController(row6);
        row6.setController(row6Controller);
        getChildren().add(row6);
    }
}
