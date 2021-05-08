package controller.loginControllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import util.Util;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SignInFormController {

    public JFXTextField txtUser;
    public JFXPasswordField txtPassword;
    public JFXButton btnSignIn;

    Util util = new Util();

    public void btnSignInOnAction(ActionEvent actionEvent) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/axcalendar?" + "user=root & password=1023");
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM login WHERE username =? AND password =?");
            ps.setString(1, txtUser.getText());
            ps.setString(2, txtPassword.getText());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("yes");
                util.newFxmlFileLording(btnSignIn,"mainForms/DashBoardForm.fxml/");
            } else {
                System.out.println("no");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
