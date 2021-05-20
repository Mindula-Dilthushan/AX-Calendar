package util;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.net.URL;

public class Util {

    public void setAnchor(AnchorPane anchorPane,String Location) throws Exception{
        anchorPane.getChildren().clear();
        AnchorPane load = FXMLLoader.load(this.getClass().getResource("/view/" + Location));
        anchorPane.getChildren().addAll(load.getChildren());
    }
    public void newFxmlFileLording(JFXButton btn,String Location){
        try{
            Stage exit_stage = (Stage) btn.getScene().getWindow();
            exit_stage.close();
            URL resource = this.getClass().getResource("/view/" + Location);
            Parent load = FXMLLoader.load(resource);
            Scene scene= new Scene(load);
            Stage stage= new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(scene);
            stage.show();
        }catch (Exception e){
        }
    }
}
