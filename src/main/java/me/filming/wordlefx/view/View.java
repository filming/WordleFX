package me.filming.wordlefx.view;

import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import me.filming.wordlefx.controller.TextFieldRowController;
import me.filming.wordlefx.model.Game;
import me.filming.wordlefx.model.Player;

public class View extends Pane {
    private TextFieldRow row1;
    private TextFieldRow row2;
    private TextFieldRow row3;
    private TextFieldRow row4;
    private TextFieldRow row5;
    private TextFieldRow row6;

    public View(Game initGame, Player initPlayer){
        // set default settings
        setPrefSize(800, 600);
        setStyle("-fx-background-color: #24252F");

        // creating inner boarder
        Rectangle innerBorder = new Rectangle(40, 40, 720, 520);
        innerBorder.setFill(Color.rgb(55,56,66));

        getChildren().add(innerBorder);

        // creating row 6
        row6 = new TextFieldRow(60, 460);
        TextFieldRowController row6Controller = new TextFieldRowController(initGame, initPlayer, row6, null);
        row6.setController(row6Controller);

        // creating row 5
        row5 = new TextFieldRow(60, 380);
        TextFieldRowController row5Controller = new TextFieldRowController(initGame, initPlayer, row5, row6);
        row5.setController(row5Controller);

        // creating row 4
        row4 = new TextFieldRow(60, 300);
        TextFieldRowController row4Controller = new TextFieldRowController(initGame, initPlayer, row4, row5);
        row4.setController(row4Controller);

        // creating row 3
        row3 = new TextFieldRow(60, 220);
        TextFieldRowController row3Controller = new TextFieldRowController(initGame, initPlayer, row3, row4);
        row3.setController(row3Controller);

        // creating row 2
        row2 = new TextFieldRow(60, 140);
        TextFieldRowController row2Controller = new TextFieldRowController(initGame, initPlayer, row2, row3);
        row2.setController(row2Controller);

        // creating row 1
        row1 = new TextFieldRow(60, 60);
        TextFieldRowController row1Controller = new TextFieldRowController(initGame, initPlayer, row1, row2);
        row1.setController(row1Controller);

        getChildren().addAll(row1, row2, row3, row4, row5, row6);
    }
}
