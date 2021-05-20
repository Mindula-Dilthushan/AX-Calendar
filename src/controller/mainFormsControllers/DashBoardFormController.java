package controller.mainFormsControllers;

import com.jfoenix.controls.JFXButton;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import util.Util;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DashBoardFormController {

    public Pane lblWorkPane,lblBirthdayPane,lblPersonalPane;
    public JFXButton btnPersonal,btnWork,btnBirthday;
    public Label lblTime,lblDate;
    public AnchorPane lordAnchor;


    Util util = new Util();

    public void initialize(){
        lblPersonalPane.setVisible(false);
        lblWorkPane.setVisible(false);
        lblBirthdayPane.setVisible(false);
        generateDate();
    }
    public void btnPersonalOnAction(ActionEvent actionEvent) {
        lblPersonalPane.setVisible(true);
        lblWorkPane.setVisible(false);
        lblBirthdayPane.setVisible(false);

        try {
            util.setAnchor(lordAnchor, "mainForms/PersonalForm.fxml");
        } catch (Exception e) {
        }
    }

    public void btnWorkOnAction(ActionEvent actionEvent) {
        lblPersonalPane.setVisible(false);
        lblWorkPane.setVisible(true);
        lblBirthdayPane.setVisible(false);

        try {
            util.setAnchor(lordAnchor, "mainForms/WorkForm.fxml");
        } catch (Exception e) {
        }
    }

    public void btnBirthdayOnAction(ActionEvent actionEvent) {
        lblPersonalPane.setVisible(false);
        lblWorkPane.setVisible(false);
        lblBirthdayPane.setVisible(true);

        try {
            util.setAnchor(lordAnchor, "mainForms/BirthdayForm.fxml");
        } catch (Exception e) {
        }
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
}
