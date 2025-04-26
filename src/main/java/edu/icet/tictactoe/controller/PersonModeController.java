package edu.icet.tictactoe.controller;

import java.awt.Desktop;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import edu.icet.tictactoe.model.ScoreBoard;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class PersonModeController implements Initializable {

    @FXML
    private JFXButton btn1;

    @FXML
    private JFXButton btn2;

    @FXML
    private JFXButton btn3;

    @FXML
    private JFXButton btn4;

    @FXML
    private JFXButton btn5;

    @FXML
    private JFXButton btn6;

    @FXML
    private JFXButton btn7;

    @FXML
    private JFXButton btn8;

    @FXML
    private JFXButton btn9;

    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXButton btnRestart;
    
    @FXML
    private JFXButton btnResetScore;
    
    @FXML
    private JFXButton btnSwitchFirst;

    @FXML
    private ImageView icnFacebook;

    @FXML
    private ImageView icnLinkedInClick;

    @FXML
    private ImageView icnWeb;

    @FXML
    private Label lblPlayer;
    
    @FXML
    private Label lblPlayerXScore;
    
    @FXML
    private Label lblPlayerOScore;
    
    @FXML
    private Label lblDrawScore;

    private static Stage stage;
    private String currentPlayer = "X";
    private boolean isGameActive = true;
    private final ScoreBoard scoreBoard = new ScoreBoard();
    private ArrayList<JFXButton> btnList;

    public static void getStage(Stage primaryStage) {
        stage = primaryStage;
    }

    @FXML
    void btnBackOnAction(ActionEvent event) throws Exception{
        changeScene("/view/home_window.fxml");
    }
    
    @FXML
    void btnResetScoreOnAction(ActionEvent event) {
        scoreBoard.resetScores();
        updateScoreDisplay();
    }
    
    @FXML
    void btnSwitchFirstOnAction(ActionEvent event) {
        currentPlayer = "O";
        lblPlayer.setText("Player " + currentPlayer + " Turn");
        restartGame();
    }

    @FXML
    void btn1Click(ActionEvent event) {
        makeMove(btn1);
    }

    @FXML
    void btn2Click(ActionEvent event) {
        makeMove(btn2);
    }

    @FXML
    void btn3Click(ActionEvent event) {
        makeMove(btn3);
    }

    @FXML
    void btn4Click(ActionEvent event) {
        makeMove(btn4);
    }

    @FXML
    void btn5Click(ActionEvent event) {
        makeMove(btn5);
    }

    @FXML
    void btn6Click(ActionEvent event) {
        makeMove(btn6);
    }

    @FXML
    void btn7Click(ActionEvent event) {
        makeMove(btn7);
    }

    @FXML
    void btn8Click(ActionEvent event) {
        makeMove(btn8);
    }

    @FXML
    void btn9Click(ActionEvent event) {
        makeMove(btn9);
    }
    
    private void makeMove(JFXButton btn) {
        if (!isGameActive || !btn.getText().isEmpty()) {
            return;
        }
        
        btnList.remove(btn);
        btn.setText(currentPlayer);
        
        if (checkForWin()) {
            handleGameWon();
        } else if (isAllButtonsClicked()) {
            handleGameDraw();
        } else {
            switchPlayer();
        }
    }
    
    private boolean checkForWin() {
        // Check rows
        if (checkLine(btn1, btn2, btn3) || checkLine(btn4, btn5, btn6) || checkLine(btn7, btn8, btn9) ||
            // Check columns
            checkLine(btn1, btn4, btn7) || checkLine(btn2, btn5, btn8) || checkLine(btn3, btn6, btn9) ||
            // Check diagonals
            checkLine(btn1, btn5, btn9) || checkLine(btn3, btn5, btn7)) {
            return true;
        }
        return false;
    }
    
    private boolean checkLine(JFXButton b1, JFXButton b2, JFXButton b3) {
        return !b1.getText().isEmpty() && b1.getText().equals(b2.getText()) && b1.getText().equals(b3.getText());
    }
    
    private void switchPlayer() {
        currentPlayer = Objects.equals(currentPlayer, "X") ? "O" : "X";
        lblPlayer.setText("Player " + currentPlayer + " Turn");
    }

    @FXML
    void btnRestartOnAction(ActionEvent event) {
        restartGame();
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
        Parent pane = FXMLLoader.load(PersonModeController.class.getResource(fxmlFile));
        stage.getScene().setRoot(pane);
    }

    private void handleGameWon() {
        isGameActive = false;
        
        if (currentPlayer.equals("X")) {
            scoreBoard.incrementPlayerScore();
        } else {
            scoreBoard.incrementComputerScore();
        }
        
        updateScoreDisplay();
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText("Congratulations!");
        alert.setContentText("Player " + currentPlayer + " has won the game!");
        alert.showAndWait();
        restartGame();
    }

    private void handleGameDraw() {
        isGameActive = false;
        scoreBoard.incrementDrawScore();
        updateScoreDisplay();
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText("Game Finished!");
        alert.setContentText("It's a draw!");
        alert.showAndWait();
        restartGame();
    }

    private boolean isAllButtonsClicked() {
        return btnList.isEmpty();
    }

    private void updateScoreDisplay() {
        if (lblPlayerXScore != null && lblPlayerOScore != null && lblDrawScore != null) {
            lblPlayerXScore.setText(Integer.toString(scoreBoard.getPlayerScore()));
            lblPlayerOScore.setText(Integer.toString(scoreBoard.getComputerScore()));
            lblDrawScore.setText(Integer.toString(scoreBoard.getDrawScore()));
        }
    }

    private void restartGame() {
        isGameActive = true;
        createButtonList();
        for (JFXButton btn : btnList) {
            btn.setText("");
        }
    }

    private void createButtonList() {
        btnList = new ArrayList<>(Arrays.asList(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        createButtonList();
        updateScoreDisplay();
    }
}