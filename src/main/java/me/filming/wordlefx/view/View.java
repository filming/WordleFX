package me.filming.wordlefx.view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
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

    private Label gameMessage;
    private Label correctWordPrompt;
    private Label correctWord;
    private Label correctAmount;
    private Label incorrectAmount;


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
        TextFieldRowController row6Controller = new TextFieldRowController(initGame, initPlayer, row6, null, this);
        row6.setController(row6Controller);

        // creating row 5
        row5 = new TextFieldRow(60, 380);
        TextFieldRowController row5Controller = new TextFieldRowController(initGame, initPlayer, row5, row6, this);
        row5.setController(row5Controller);

        // creating row 4
        row4 = new TextFieldRow(60, 300);
        TextFieldRowController row4Controller = new TextFieldRowController(initGame, initPlayer, row4, row5, this);
        row4.setController(row4Controller);

        // creating row 3
        row3 = new TextFieldRow(60, 220);
        TextFieldRowController row3Controller = new TextFieldRowController(initGame, initPlayer, row3, row4, this);
        row3.setController(row3Controller);

        // creating row 2
        row2 = new TextFieldRow(60, 140);
        TextFieldRowController row2Controller = new TextFieldRowController(initGame, initPlayer, row2, row3, this);
        row2.setController(row2Controller);

        // creating row 1
        row1 = new TextFieldRow(60, 60);
        TextFieldRowController row1Controller = new TextFieldRowController(initGame, initPlayer, row1, row2, this);
        row1.setController(row1Controller);

        getChildren().addAll(row1, row2, row3, row4, row5, row6);

        // create divider between view panels
        Rectangle divider = new Rectangle(460, 60, 20, 460);
        divider.setFill(Color.rgb(115,117,140));

        getChildren().add(divider);

        // create result panel
        Rectangle displayPanel = new Rectangle(500, 60, 240, 460);
        displayPanel.setFill(Color.rgb(241,146,49));

        //"     YOU WIN!" gameMessage.setTextFill(Color.rgb(66, 126, 26));
        //"    YOU LOSE!" gameMessage.setTextFill(Color.rgb(140, 12, 12));
        gameMessage = new Label("");
        gameMessage.setFont(Font.font("Arial", FontWeight.BOLD, 26));
        gameMessage.setTextFill(Color.rgb(66, 126, 26));
        gameMessage.setPrefWidth(Region.USE_COMPUTED_SIZE);
        gameMessage.setTranslateX(520);
        gameMessage.setTranslateY(80);

        correctWordPrompt = new Label("    Correct Word");
        correctWordPrompt.setFont(Font.font("Arial", FontWeight.BOLD, 22));
        correctWordPrompt.setPrefWidth(Region.USE_COMPUTED_SIZE);
        correctWordPrompt.setTranslateX(520);
        correctWordPrompt.setTranslateY(130);
        correctWordPrompt.setVisible(false);

        correctWord = new Label("");
        correctWord.setFont(Font.font("Arial", FontWeight.BOLD, 19));
        correctWord.setPrefWidth(Region.USE_COMPUTED_SIZE);
        correctWord.setTranslateX(520);
        correctWord.setTranslateY(160);

        Label correctLabel = new Label("Correct:");
        correctLabel.setFont(Font.font("Arial", FontWeight.BOLD, 22));
        correctLabel.setTextFill(Color.rgb(66, 126, 26));
        correctLabel.setPrefWidth(Region.USE_COMPUTED_SIZE);
        correctLabel.setTranslateX(520);
        correctLabel.setTranslateY(210);

        correctAmount = new Label("0");
        correctAmount.setFont(Font.font("Arial", FontWeight.BOLD, 22));
        correctAmount.setTextFill(Color.rgb(66, 126, 26));
        correctAmount.setPrefWidth(Region.USE_COMPUTED_SIZE);
        correctAmount.setTranslateX(610);
        correctAmount.setTranslateY(210);

        Label incorrectLabel = new Label("Incorrect:");
        incorrectLabel.setFont(Font.font("Arial", FontWeight.BOLD, 22));
        incorrectLabel.setTextFill(Color.rgb(140, 12, 12));
        incorrectLabel.setPrefWidth(Region.USE_COMPUTED_SIZE);
        incorrectLabel.setTranslateX(520);
        incorrectLabel.setTranslateY(250);

        incorrectAmount = new Label("0");
        incorrectAmount.setFont(Font.font("Arial", FontWeight.BOLD, 22));
        incorrectAmount.setTextFill(Color.rgb(140, 12, 12));
        incorrectAmount.setPrefWidth(Region.USE_COMPUTED_SIZE);
        incorrectAmount.setTranslateX(630);
        incorrectAmount.setTranslateY(250);

        getChildren().addAll(displayPanel, gameMessage, correctWordPrompt, correctWord, correctLabel, correctAmount, incorrectLabel, incorrectAmount);
    }

    public Label getGameMessage() {
        return gameMessage;
    }
    public Label getCorrectWord() {
        return correctWord;
    }
    public Label getCorrectAmount() {
        return correctAmount;
    }
    public Label getIncorrectAmount() {
        return incorrectAmount;
    }

    public Label getCorrectWordPrompt() {
        return correctWordPrompt;
    }
}
