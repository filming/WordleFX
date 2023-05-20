package me.filming.wordlefx.view;

import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import me.filming.wordlefx.controller.TextFieldRowController;

public class TextFieldRow extends Pane {
    TextField field1;
    TextField field2;
    TextField field3;
    TextField field4;
    TextField field5;
    TextFieldRowController controller;

    public TextFieldRow(int initX, int initY){
        field1 = new TextField();
        field1.setFont(Font.font("Verdana", FontWeight.BOLD, 26));
        field1.setAlignment(Pos.CENTER);
        field1.setPrefSize(60,60);
        field1.setTranslateX(initX);
        field1.setTranslateY(initY);

        field2 = new TextField();
        field2.setFont(Font.font("Verdana", FontWeight.BOLD, 26));
        field2.setAlignment(Pos.CENTER);
        field2.setPrefSize(60,60);
        field2.setTranslateX(initX + 80);
        field2.setTranslateY(initY);

        field3 = new TextField();
        field3.setFont(Font.font("Verdana", FontWeight.BOLD, 26));
        field3.setAlignment(Pos.CENTER);
        field3.setPrefSize(60,60);
        field3.setTranslateX(initX + 160);
        field3.setTranslateY(initY);

        field4 = new TextField();
        field4.setFont(Font.font("Verdana", FontWeight.BOLD, 26));
        field4.setAlignment(Pos.CENTER);
        field4.setPrefSize(60,60);
        field4.setTranslateX(initX + 240);
        field4.setTranslateY(initY);

        field5 = new TextField();
        field5.setFont(Font.font("Verdana", FontWeight.BOLD, 26));
        field5.setAlignment(Pos.CENTER);
        field5.setPrefSize(60,60);
        field5.setTranslateX(initX + 320);
        field5.setTranslateY(initY);

        getChildren().addAll(field1, field2, field3, field4, field5);
    }

    public void setController(TextFieldRowController controller) {
        this.controller = controller;
    }
    public TextField getField1() {
        return field1;
    }
    public TextField getField2() {
        return field2;
    }
    public TextField getField3() {
        return field3;
    }
    public TextField getField4() {
        return field4;
    }
    public TextField getField5() {
        return field5;
    }
}