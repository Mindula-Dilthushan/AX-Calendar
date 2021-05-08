package controller.mainFormsControllers;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.layout.Pane;

public class DashBoardFormController {

    public Pane lblPersonalPane;
    public Pane lblWorkPane;
    public Pane lblBirthdayPane;
    public JFXButton btnPersonal,btnWork,btnBirthday;

    public void initialize(){
        lblPersonalPane.setVisible(false);
        lblWorkPane.setVisible(false);
        lblBirthdayPane.setVisible(false);
    }
    public void btnPersonalOnAction(ActionEvent actionEvent) {
        lblPersonalPane.setVisible(true);
        lblWorkPane.setVisible(false);
        lblBirthdayPane.setVisible(false);
    }

    public void btnWorkOnAction(ActionEvent actionEvent) {
        lblPersonalPane.setVisible(false);
        lblWorkPane.setVisible(true);
        lblBirthdayPane.setVisible(false);
    }

    public void btnBirthdayOnAction(ActionEvent actionEvent) {
        lblPersonalPane.setVisible(false);
        lblWorkPane.setVisible(false);
        lblBirthdayPane.setVisible(true);
    }
}
