package me.filming.wordlefx.controller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import me.filming.wordlefx.model.Game;
import me.filming.wordlefx.model.Player;
import me.filming.wordlefx.view.View;

public class Wordle extends Application {
    public void start(Stage primaryStage){
        Pane gamePane = new Pane();

        Game game = new Game();
        game.newGame();

        Player player = new Player(game);

        View view = new View(game, player);
        gamePane.getChildren().add(view);








        Scene scene = new Scene(new Pane(), 800, 600);
        primaryStage.setTitle("Wordle");
        primaryStage.setScene(new Scene(gamePane));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
