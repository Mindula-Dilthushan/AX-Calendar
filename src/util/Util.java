package util;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class Util {

    public void setAnchor(AnchorPane anchorPane,String Location) throws Exception{

        anchorPane.getChildren().clear();
        AnchorPane load = FXMLLoader.load(this.getClass().getResource("/view/" + Location));
        anchorPane.getChildren().addAll(load.getChildren());
    }
}
