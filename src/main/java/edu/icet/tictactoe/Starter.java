package edu.icet.tictactoe;

import edu.icet.tictactoe.controller.ComputerModeController;
import edu.icet.tictactoe.controller.HomeWindowController;
import edu.icet.tictactoe.controller.PersonModeController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Starter extends Application {

    private Stage primaryStage;
    
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/home_window.fxml"));
        stage.setScene(new Scene(loader.load()));
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/img/logo.png")));
        stage.setResizable(false);
        stage.setTitle("Tic Tac Toe");
        stage.show();
        HomeWindowController.getStage(primaryStage);
        ComputerModeController.getStage(primaryStage);
        PersonModeController.getStage(primaryStage);
    }
}