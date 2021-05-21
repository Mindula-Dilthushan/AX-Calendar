package controller.mainFormsControllers;

import com.jfoenix.controls.JFXButton;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import util.Util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class DashBoardFormController {

    public Pane lblWorkPane,lblBirthdayPane,lblPersonalPane;
    public JFXButton btnPersonal,btnWork,btnBirthday;
    public Label lblTime,lblDate;
    public AnchorPane lordAnchor;
    public JFXButton btnExit;
    public JFXButton btnHome;
    public Pane lblHome;

    //Property Injection
    Util util = new Util();

    public void initialize(){
        setDisablePaneColor();
        generateDate();
        util.btnEffect(btnExit);

        try {
            util.setAnchor(lordAnchor, "mainForms/HomeForm.fxml");
        } catch (Exception e) {
        }
    }
    public void btnHomeOnAction(ActionEvent actionEvent) {
        lblPersonalPane.setVisible(false);
        lblWorkPane.setVisible(false);
        lblBirthdayPane.setVisible(false);
        lblHome.setVisible(true);

        try {
            util.setAnchor(lordAnchor, "mainForms/HomeForm.fxml");
        } catch (Exception e) {
        }
    }
    public void btnPersonalOnAction(ActionEvent actionEvent) {
        lblPersonalPane.setVisible(true);
        lblWorkPane.setVisible(false);
        lblBirthdayPane.setVisible(false);
        lblHome.setVisible(false);
        try {
            util.setAnchor(lordAnchor, "mainForms/PersonalForm.fxml");
        } catch (Exception e) {
        }
    }

    public void btnWorkOnAction(ActionEvent actionEvent) {
        lblPersonalPane.setVisible(false);
        lblWorkPane.setVisible(true);
        lblBirthdayPane.setVisible(false);
        lblHome.setVisible(false);
        try {
            util.setAnchor(lordAnchor, "mainForms/WorkForm.fxml");
        } catch (Exception e) {
        }
    }

    public void btnBirthdayOnAction(ActionEvent actionEvent) {
        lblPersonalPane.setVisible(false);
        lblWorkPane.setVisible(false);
        lblBirthdayPane.setVisible(true);
        lblHome.setVisible(false);
        try {
            util.setAnchor(lordAnchor, "mainForms/BirthdayForm.fxml");
        } catch (Exception e) {
        }
    }
    private void setDisablePaneColor(){
        lblPersonalPane.setVisible(false);
        lblWorkPane.setVisible(false);
        lblBirthdayPane.setVisible(false);
        lblHome.setVisible(false);
    }
    public void generateDate() {
        lblDate.setText(LocalDate.now().toString());
        Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
            lblTime.setText(LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void btnExitOnAction(ActionEvent actionEvent) {
        btnExit.setOnAction((e) -> {
                ButtonType ok = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
                ButtonType no = new ButtonType("NO", ButtonBar.ButtonData.CANCEL_CLOSE);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure ?", ok, no);
                Optional<ButtonType> result = alert.showAndWait();
                    if (result.orElse(no) == ok) {
                        Stage exit_stage = (Stage) btnExit.getScene().getWindow();
                        exit_stage.close();
                    } else {
                        System.out.println("ok");
                    }
        });
    }


}
