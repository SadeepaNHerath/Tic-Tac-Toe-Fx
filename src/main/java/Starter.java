import controller.ComputerModeController;
import controller.HomeWindowController;
import controller.PersonModeController;
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
        primaryStage = stage ;
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("view/home_window.fxml"))));
        stage.getIcons().add(new Image(getClass().getResourceAsStream("img/logo.png")));
        stage.setResizable(false);
        stage.setTitle("Tic Tac Toe");
        stage.show();
        HomeWindowController.getStage(primaryStage);
        ComputerModeController.getStage(primaryStage);
        PersonModeController.getStage(primaryStage);
    }

}
