//Mindula Dilthushan
//AX Calendar v1.0.0
package controller.loginControllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.AnchorPane;
import util.Util;

public class LoginFormController {

    public AnchorPane LoginMain;
    public Hyperlink linkSignUp,linkSignIn;

    //Property Injection
    Util util = new Util();

    public void initialize(){
        linkSignIn.setVisible(false);
        signInLoad();
    }

    public void linkSignUpOnAction(ActionEvent actionEvent) {
        linkSignIn.setVisible(true);
        linkSignUp.setVisible(false);
            try {
                util.setAnchor(LoginMain,"loginForms/SignUpForm.fxml");
            } catch (Exception e) {
            }
    }

    public void linkSignInOnAction(ActionEvent actionEvent) {
        linkSignIn.setVisible(false);
        linkSignUp.setVisible(true);
        signInLoad();
    }

    private void signInLoad(){
        try {
            util.setAnchor(LoginMain,"loginForms/SignInForm.fxml");
        } catch (Exception e) {
        }
    }
}
