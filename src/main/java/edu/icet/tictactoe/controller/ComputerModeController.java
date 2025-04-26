package edu.icet.tictactoe.controller;

import java.awt.Desktop;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import edu.icet.tictactoe.model.GameDifficulty;
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

public class ComputerModeController implements Initializable {

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
    private JFXButton btnSwitchPlayer;
    
    @FXML
    private JFXButton btnEasy;
    
    @FXML
    private JFXButton btnMedium;
    
    @FXML
    private JFXButton btnHard;

    @FXML
    private ImageView icnFacebook;

    @FXML
    private ImageView icnLinkedIn;

    @FXML
    private ImageView icnWeb;

    @FXML
    private Label lblPlayer;
    
    @FXML
    private Label lblPlayerScore;
    
    @FXML
    private Label lblComputerScore;
    
    @FXML
    private Label lblDrawScore;

    private static Stage stage;

    private String currentPlayer = "X";
    private String playerSymbol = "X";
    private String computerSymbol = "O";
    private final Random random = new Random();
    private final ScoreBoard scoreBoard = new ScoreBoard();
    private GameDifficulty difficulty = GameDifficulty.EASY;
    private boolean isGameActive = true;
    private boolean computerStarts = false;

    private ArrayList<JFXButton> btnList = new ArrayList<>();

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
    void btnSwitchPlayerOnAction(ActionEvent event) {
        computerStarts = !computerStarts;
        restartGame();
        
        if (computerStarts) {
            currentPlayer = computerSymbol;
            lblPlayer.setText("Computer Turn");
            comTurn();
        } else {
            currentPlayer = playerSymbol;
            lblPlayer.setText("Your Turn");
        }
    }
    
    @FXML
    void btnEasyOnAction(ActionEvent event) {
        difficulty = GameDifficulty.EASY;
        updateDifficultyButtons();
    }
    
    @FXML
    void btnMediumOnAction(ActionEvent event) {
        difficulty = GameDifficulty.MEDIUM;
        updateDifficultyButtons();
    }
    
    @FXML
    void btnHardOnAction(ActionEvent event) {
        difficulty = GameDifficulty.HARD;
        updateDifficultyButtons();
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
            if (currentPlayer.equals(computerSymbol)) {
                comTurn();
            }
        }
    }
    
    private void switchPlayer() {
        currentPlayer = Objects.equals(currentPlayer, playerSymbol) ? computerSymbol : playerSymbol;
        if (currentPlayer.equals(playerSymbol)) {
            lblPlayer.setText("Your Turn");
        } else {
            lblPlayer.setText("Computer Turn");
        }
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
        Parent pane = FXMLLoader.load(ComputerModeController.class.getResource(fxmlFile));
        stage.getScene().setRoot(pane);
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

    private void handleGameWon() {
        isGameActive = false;
        
        if (currentPlayer.equals(playerSymbol)) {
            scoreBoard.incrementPlayerScore();
        } else {
            scoreBoard.incrementComputerScore();
        }
        
        updateScoreDisplay();
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText("Game Finished!");
        
        if (currentPlayer.equals(playerSymbol)) {
            alert.setContentText("You have won the game!");
        } else {
            alert.setContentText("Computer has won the game!");
        }
        
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
        lblPlayerScore.setText(Integer.toString(scoreBoard.getPlayerScore()));
        lblComputerScore.setText(Integer.toString(scoreBoard.getComputerScore()));
        lblDrawScore.setText(Integer.toString(scoreBoard.getDrawScore()));
    }
    
    private void updateDifficultyButtons() {
        btnEasy.setStyle("-fx-background-color: " + (difficulty == GameDifficulty.EASY ? "#2E7D32" : "#689F38") + "; -fx-background-radius: 5px;");
        btnMedium.setStyle("-fx-background-color: " + (difficulty == GameDifficulty.MEDIUM ? "#FFA000" : "#FFB300") + "; -fx-background-radius: 5px;");
        btnHard.setStyle("-fx-background-color: " + (difficulty == GameDifficulty.HARD ? "#D32F2F" : "#EF5350") + "; -fx-background-radius: 5px;");
    }

    private void restartGame() {
        isGameActive = true;
        createButtonList();
        for (JFXButton btn : btnList) {
            btn.setText("");
        }
        
        if (computerStarts) {
            currentPlayer = computerSymbol;
            lblPlayer.setText("Computer Turn");
            comTurn();
        } else {
            currentPlayer = playerSymbol;
            lblPlayer.setText("Your Turn");
        }
    }

    private void createButtonList() {
        btnList = new ArrayList<>(Arrays.asList(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9));
    }

    private void comTurn() {
        if (!isGameActive) return;
        
        JFXButton selectedButton;
        
        switch (difficulty) {
            case HARD:
                selectedButton = makeStrategicMove();
                break;
            case MEDIUM:
                // 70% strategic, 30% random
                selectedButton = (random.nextInt(10) < 7) ? makeStrategicMove() : makeRandomMove();
                break;
            case EASY:
            default:
                selectedButton = makeRandomMove();
                break;
        }
        
        if (selectedButton != null) {
            selectedButton.fire();
        }
    }
    
    private JFXButton makeRandomMove() {
        if (btnList.isEmpty()) return null;
        int index = random.nextInt(btnList.size());
        return btnList.get(index);
    }
    
    private JFXButton makeStrategicMove() {
        // Try to win
        JFXButton winMove = findWinningMove(computerSymbol);
        if (winMove != null) return winMove;
        
        // Block opponent from winning
        JFXButton blockMove = findWinningMove(playerSymbol);
        if (blockMove != null) return blockMove;
        
        // Take center if available
        if (btn5.getText().isEmpty()) return btn5;
        
        // Take corners
        ArrayList<JFXButton> corners = new ArrayList<>(Arrays.asList(btn1, btn3, btn7, btn9));
        for (JFXButton corner : corners) {
            if (corner.getText().isEmpty()) return corner;
        }
        
        // Take any available space
        return makeRandomMove();
    }
    
    private JFXButton findWinningMove(String symbol) {
        // Check for potential winning moves
        
        // Check rows
        JFXButton result = checkPotentialWin(btn1, btn2, btn3, symbol);
        if (result != null) return result;
        
        result = checkPotentialWin(btn4, btn5, btn6, symbol);
        if (result != null) return result;
        
        result = checkPotentialWin(btn7, btn8, btn9, symbol);
        if (result != null) return result;
        
        // Check columns
        result = checkPotentialWin(btn1, btn4, btn7, symbol);
        if (result != null) return result;
        
        result = checkPotentialWin(btn2, btn5, btn8, symbol);
        if (result != null) return result;
        
        result = checkPotentialWin(btn3, btn6, btn9, symbol);
        if (result != null) return result;
        
        // Check diagonals
        result = checkPotentialWin(btn1, btn5, btn9, symbol);
        if (result != null) return result;
        
        result = checkPotentialWin(btn3, btn5, btn7, symbol);
        if (result != null) return result;
        
        return null;
    }
    
    private JFXButton checkPotentialWin(JFXButton b1, JFXButton b2, JFXButton b3, String symbol) {
        // If two cells have the symbol and the third is empty, return the empty one
        if (b1.getText().equals(symbol) && b2.getText().equals(symbol) && b3.getText().isEmpty()) return b3;
        if (b1.getText().equals(symbol) && b3.getText().equals(symbol) && b2.getText().isEmpty()) return b2;
        if (b2.getText().equals(symbol) && b3.getText().equals(symbol) && b1.getText().isEmpty()) return b1;
        
        return null;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        createButtonList();
        updateScoreDisplay();
        updateDifficultyButtons();
        if (computerStarts) {
            currentPlayer = computerSymbol;
            lblPlayer.setText("Computer Turn");
            comTurn();
        }
    }
}