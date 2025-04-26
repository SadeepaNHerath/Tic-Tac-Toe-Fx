package edu.icet.tictactoe.controller;

import java.awt.Desktop;
import java.net.URI;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HomeWindowController {

    @FXML
    private JFXButton btnVsComputer;

    @FXML
    private JFXButton btnVsPlayer;

    @FXML
    private AnchorPane homrWindow;

    @FXML
    private ImageView icnFacebook;

    @FXML
    private ImageView icnLinkedIn;

    @FXML
    private ImageView icnWeb;

    private static Stage stage;

    public static void getStage(Stage primaryStage) {
        stage = primaryStage;
    }

    @FXML
    void btnVsComputerOnAction(ActionEvent event) throws Exception {
        changeScene("/view/computer_mode.fxml");
    }

    @FXML
    void btnVsPlayerOnAction(ActionEvent event) throws Exception{
        changeScene("/view/person_mode.fxml");
    }

    @FXML
    void icnFacebookClick(MouseEvent event) {
        openWebpage("https://www.facebook.com/SadeepaNHerath?mibextid=ZbWKwL");
    }

    @FXML
    void icnLinkedInClick(MouseEvent event) {
        openWebpage("https://www.linkedin.com/public-profile/settings?lipi=urn%3Ali%3Apage%3Ad_flagship3_profile_self_edit_contact-info%3BEtl0xFBlTOGEQPW1D%2FsH6A%3D%3D");
    }

    @FXML
    void icnWebClick(MouseEvent event) {
        openWebpage("https://sadeepanherath.github.io/Tic-Tac-Toe/");
    }

    private void openWebpage(String url) {
        try {
            URI uri = new URI(url);
            Desktop.getDesktop().browse(uri);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void changeScene(String fxmlFile) throws Exception {
        Parent root = FXMLLoader.load(HomeWindowController.class.getResource(fxmlFile));
        stage.getScene().setRoot(root);
    }
}