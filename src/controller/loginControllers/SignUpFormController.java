package controller.loginControllers;

import bo.BoFactory;
import bo.custom.LoginBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import dto.LoginDTO;
import javafx.event.ActionEvent;
import util.Util;

public class SignUpFormController {

    public JFXTextField txtUser;
    public JFXPasswordField txtPassword, txtConfirmPassword;
    public JFXButton btnSignUp;

    LoginBO loginBO = BoFactory.getInstance().getBo(BoFactory.BOType.LOGIN);
    Util util = new Util();

    public void btnSignUpOnAction(ActionEvent actionEvent) throws Exception {

        String newUser = txtUser.getText();
        String newPassword = txtPassword.getText();
        String confirmPassword = txtConfirmPassword.getText();

        if (newUser.isEmpty() || (confirmPassword.isEmpty() || (newPassword.isEmpty()))) {
            System.out.println("Please Fill The Blanks Fieds...");
        }else {
            if (newPassword.equals(confirmPassword)) {
                try {
                    boolean isSavedNewPw = loginBO.saveLogin(
                            new LoginDTO(
                                    newUser,
                                    confirmPassword
                            ));
                } catch (Exception e) {
                }
                System.out.println("Login Save");
                util.newFxmlFileLording(btnSignUp, "mainForms/DashBoardForm.fxml");
            }
            else {
                System.out.println("Login Not Save");
            }
        }
    }
}
