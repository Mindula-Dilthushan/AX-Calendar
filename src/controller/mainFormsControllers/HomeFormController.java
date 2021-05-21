package controller.mainFormsControllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class HomeFormController {

    public JFXDatePicker datePicker;
    public JFXButton btnSaveDate;
    public Label lblDateDesc;

    public void btnSaveDateOnAction(ActionEvent actionEvent) {
        LocalDate savingGetDate = datePicker.getValue();
        lblDateDesc.setText(formatDate(savingGetDate.toString()));
    }

    public String formatDate(String Date){
        SimpleDateFormat simpleDateFormat = null;
        java.util.Date date = null;
        try {
            simpleDateFormat = new SimpleDateFormat("yy-MM-dd");
            date = simpleDateFormat.parse(Date);
            simpleDateFormat.applyPattern("EEEE d MMM yyyy");
        }catch (Exception e){
        }
        return simpleDateFormat.format(date);
    }
}
