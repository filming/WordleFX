package me.filming.wordlefx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Wordle extends Application {
    public void start(Stage primaryStage){
        Pane gamePane = new Pane();

        Game game = new Game();
        game.newGame();

        Player player = new Player(game);

        View view = new View();
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
