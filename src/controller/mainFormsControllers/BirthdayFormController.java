package controller.mainFormsControllers;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import util.Util;

public class BirthdayFormController {
    public AnchorPane anchorBirthMain;
    public JFXButton btnSaveBirth;
    public JFXButton btnSearchBirth;

    //Property Injection
    Util util = new Util();

    public void btnSaveBirthOnAction(ActionEvent actionEvent) {
        try {
            util.setAnchor(anchorBirthMain, "mainForms/birthForms/SaveBirthForm.fxml");
        } catch (Exception e) {
        }
    }

    public void btnSearchBirthOnAction(ActionEvent actionEvent) {
    }
}
