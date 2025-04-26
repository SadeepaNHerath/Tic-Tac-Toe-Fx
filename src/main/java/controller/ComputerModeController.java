package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.ResourceBundle;

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
    private ImageView icnFacebook;

    @FXML
    private ImageView icnLinkedIn;

    @FXML
    private ImageView icnWeb;

    @FXML
    private Label lblPlayer;

    private static Stage stage;

    private String currentPlayer = "X";
    private final Random random=new Random();

    private final ArrayList<Button> btnList = new ArrayList<>();

    public static void getStage(Stage primaryStage) {
        stage = primaryStage;
    }

    @FXML
    void btnBackOnAction(ActionEvent event) throws Exception{
        changeScene("/view/home_window.fxml");
    }

    @FXML
    void btn1Click(ActionEvent event) {
        if (btn1.getText().isEmpty()){
            btnList.remove(btn1);
            btn1.setText(currentPlayer);
            if ( (btn2.getText().equals(currentPlayer) && btn3.getText().equals(currentPlayer)) || (btn5.getText().equals(currentPlayer) && btn9.getText().equals(currentPlayer)) || (btn4.getText().equals(currentPlayer) && btn7.getText().equals(currentPlayer))){
                showWinningAlert();
            } else if (isAllButtonsClicked()) {
                showDrawAlert();
            } else {
                currentPlayer = Objects.equals(currentPlayer, "X") ? "O" : "X";
                if (lblPlayer.getText().equals("Your Turn")){
                    lblPlayer.setText("Computer Turn");
                    comTurn();
                }else {
                    lblPlayer.setText("Your Turn");
                }
            }
        }
    }

    @FXML
    void btn2Click(ActionEvent event) {
        if (btn2.getText().isEmpty()){
            btnList.remove(btn2);
            btn2.setText(currentPlayer);
            if ( (btn1.getText().equals(currentPlayer) && btn3.getText().equals(currentPlayer)) || (btn5.getText().equals(currentPlayer) && btn8.getText().equals(currentPlayer)) ){
                showWinningAlert();
            } else if (isAllButtonsClicked()) {
                showDrawAlert();
            } else {
                currentPlayer = Objects.equals(currentPlayer, "X") ? "O" : "X";
                if (lblPlayer.getText().equals("Your Turn")){
                    lblPlayer.setText("Computer Turn");
                    comTurn();
                }else {
                    lblPlayer.setText("Your Turn");
                }
            }
        }
    }

    @FXML
    void btn3Click(ActionEvent event) {
        if (btn3.getText().isEmpty()){
            btnList.remove(btn3);
            btn3.setText(currentPlayer);
            if ( (btn1.getText().equals(currentPlayer) && btn2.getText().equals(currentPlayer)) || (btn5.getText().equals(currentPlayer) && btn7.getText().equals(currentPlayer)) || (btn6.getText().equals(currentPlayer) && btn9.getText().equals(currentPlayer))){
                showWinningAlert();
            } else if (isAllButtonsClicked()) {
                showDrawAlert();
            } else {
                currentPlayer = Objects.equals(currentPlayer, "X") ? "O" : "X";
                if (lblPlayer.getText().equals("Your Turn")){
                    lblPlayer.setText("Computer Turn");
                    comTurn();
                }else {
                    lblPlayer.setText("Your Turn");
                }
            }
        }
    }

    @FXML
    void btn4Click(ActionEvent event) {
        if (btn4.getText().isEmpty()){
            btnList.remove(btn4);
            btn4.setText(currentPlayer);
            if ( (btn5.getText().equals(currentPlayer) && btn6.getText().equals(currentPlayer)) || (btn1.getText().equals(currentPlayer) && btn7.getText().equals(currentPlayer)) ){
                showWinningAlert();
            } else if (isAllButtonsClicked()) {
                showDrawAlert();
            } else {
                currentPlayer = Objects.equals(currentPlayer, "X") ? "O" : "X";
                if (lblPlayer.getText().equals("Your Turn")){
                    lblPlayer.setText("Computer Turn");
                    comTurn();
                }else {
                    lblPlayer.setText("Your Turn");
                }
            }
        }
    }

    @FXML
    void btn5Click(ActionEvent event) {
        if (btn5.getText().isEmpty()){
            btnList.remove(btn5);
            btn5.setText(currentPlayer);
            if ( (btn4.getText().equals(currentPlayer) && btn6.getText().equals(currentPlayer)) || (btn1.getText().equals(currentPlayer) && btn9.getText().equals(currentPlayer)) || (btn3.getText().equals(currentPlayer) && btn7.getText().equals(currentPlayer)) || (btn2.getText().equals(currentPlayer) && btn8.getText().equals(currentPlayer)) ){
                showWinningAlert();
            } else if (isAllButtonsClicked()) {
                showDrawAlert();
            } else {
                currentPlayer = Objects.equals(currentPlayer, "X") ? "O" : "X";
                if (lblPlayer.getText().equals("Your Turn")){
                    lblPlayer.setText("Computer Turn");
                    comTurn();
                }else {
                    lblPlayer.setText("Your Turn");
                }
            }
        }
    }

    @FXML
    void btn6Click(ActionEvent event) {
        if (btn6.getText().isEmpty()){
            btnList.remove(btn6);
            btn6.setText(currentPlayer);
            if ( (btn4.getText().equals(currentPlayer) && btn5.getText().equals(currentPlayer)) || (btn3.getText().equals(currentPlayer) && btn9.getText().equals(currentPlayer)) ){
                showWinningAlert();
            } else if (isAllButtonsClicked()) {
                showDrawAlert();
            } else {
                currentPlayer = Objects.equals(currentPlayer, "X") ? "O" : "X";
                if (lblPlayer.getText().equals("Your Turn")){
                    lblPlayer.setText("Computer Turn");
                    comTurn();
                }else {
                    lblPlayer.setText("Your Turn");
                }
            }
        }
    }

    @FXML
    void btn7Click(ActionEvent event) {
        if (btn7.getText().isEmpty()){
            btnList.remove(btn7);
            btn7.setText(currentPlayer);
            if ( (btn1.getText().equals(currentPlayer) && btn4.getText().equals(currentPlayer)) || (btn8.getText().equals(currentPlayer) && btn9.getText().equals(currentPlayer)) || (btn5.getText().equals(currentPlayer) && btn3.getText().equals(currentPlayer))){
                showWinningAlert();
            } else if (isAllButtonsClicked()) {
                showDrawAlert();
            } else {
                currentPlayer = Objects.equals(currentPlayer, "X") ? "O" : "X";
                if (lblPlayer.getText().equals("Your Turn")){
                    lblPlayer.setText("Computer Turn");
                    comTurn();
                }else {
                    lblPlayer.setText("Your Turn");
                }
            }
        }
    }

    @FXML
    void btn8Click(ActionEvent event) {
        if (btn8.getText().isEmpty()){
            btnList.remove(btn8);
            btn8.setText(currentPlayer);
            if ( (btn7.getText().equals(currentPlayer) && btn9.getText().equals(currentPlayer)) || (btn5.getText().equals(currentPlayer) && btn2.getText().equals(currentPlayer)) ){
                showWinningAlert();
            } else if (isAllButtonsClicked()) {
                showDrawAlert();
            } else {
                currentPlayer = Objects.equals(currentPlayer, "X") ? "O" : "X";
                if (lblPlayer.getText().equals("Your Turn")){
                    lblPlayer.setText("Computer Turn");
                    comTurn();
                }else {
                    lblPlayer.setText("Your Turn");
                }
            }
        }
    }

    @FXML
    void btn9Click(ActionEvent event) {
        if (btn9.getText().isEmpty()){
            btnList.remove(btn9);
            btn9.setText(currentPlayer);
            if ( (btn7.getText().equals(currentPlayer) && btn8.getText().equals(currentPlayer)) || (btn3.getText().equals(currentPlayer) && btn6.getText().equals(currentPlayer)) || (btn1.getText().equals(currentPlayer) && btn5.getText().equals(currentPlayer))){
                showWinningAlert();
            } else if (isAllButtonsClicked()) {
                showDrawAlert();
            } else {
                currentPlayer = Objects.equals(currentPlayer, "X") ? "O" : "X";
                if (lblPlayer.getText().equals("Your Turn")){
                    lblPlayer.setText("Computer Turn");
                    comTurn();
                }else {
                    lblPlayer.setText("Your Turn");
                }
            }
        }
    }

    @FXML
    void btnRestartOnAction(ActionEvent event) throws Exception{
        restartGame();
    }

    @FXML
    void icnFacebookClick(MouseEvent event) {
        try {
            URI uri = new URI("https://www.facebook.com/SadeepaNHerath?mibextid=ZbWKwL");
            Desktop.getDesktop().browse(uri);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void icnLinkedInClick(MouseEvent event) {
        try {
            URI uri = new URI("https://www.linkedin.com/public-profile/settings?lipi=urn%3Ali%3Apage%3Ad_flagship3_profile_self_edit_contact-info%3BEtl0xFBlTOGEQPW1D%2FsH6A%3D%3D");
            Desktop.getDesktop().browse(uri);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void icnWebClick(MouseEvent event) {
        try {
            URI uri = new URI("https://sadeepanherath.github.io/Tic-Tac-Toe/");
            Desktop.getDesktop().browse(uri);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void changeScene(String fxmlFile) throws Exception {
        Parent pane = FXMLLoader.load(ComputerModeController.class.getResource(fxmlFile));
        stage.getScene().setRoot(pane);
    }

    private void showWinningAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText("Congratulations!");
        alert.setContentText("Player "+ currentPlayer + " has won the game!");
        alert.showAndWait();
        restartGame();
    }

    private boolean isAllButtonsClicked(){
        if ( (btn1.getText().isEmpty()) ||  (btn2.getText().isEmpty()) ||  (btn3.getText().isEmpty()) ||  (btn4.getText().isEmpty()) || (btn5.getText().isEmpty()) ||  (btn6.getText().isEmpty()) ||  (btn7.getText().isEmpty()) ||  (btn8.getText().isEmpty()) ||  (btn9.getText().isEmpty()) ){
            return false;
        }
        return true;
    }

    private void showDrawAlert(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText("Ooops!");
        alert.setContentText(" Game Draw! ");
        alert.showAndWait();
        restartGame();
    }

    private void restartGame(){
        crateButtonList();
        for (Button btn : btnList){
            btn.setText("");
        }
    }

    private void crateButtonList(){
        btnList.clear();
        btnList.add(btn1);
        btnList.add(btn2);
        btnList.add(btn3);
        btnList.add(btn4);
        btnList.add(btn5);
        btnList.add(btn6);
        btnList.add(btn7);
        btnList.add(btn8);
        btnList.add(btn9);
    }

    private void comTurn(){
        int num = random.nextInt(btnList.size());
        if (btnList.get(num).getText().isEmpty()){
            btnList.get(num).fire();
        }else {
            comTurn();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        restartGame();
    }
}
