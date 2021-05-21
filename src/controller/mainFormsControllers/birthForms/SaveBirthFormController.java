package controller.mainFormsControllers.birthForms;

import bo.BoFactory;
import bo.custom.BirthdayBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import dto.BirthdayDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class SaveBirthFormController {

    public JFXTextField txtFirstName, txtLastName;
    public JFXDatePicker datePicker;
    public Label lblGetBirthday;
    public JFXButton btnSave;
    public TableView tblBirth;
    public TableColumn colNo, colFirstName, colLastName, colBirth;

    //Property Injection
    private BirthdayBO birthdayBO = BoFactory.getInstance().getBo(BoFactory.BOType.BIRTHDAY);

    public void btnSaveOnAction(ActionEvent actionEvent) {

        LocalDate savingGetDate = datePicker.getValue();
        lblGetBirthday.setText(getDate(savingGetDate.toString()));

        String firstName = txtFirstName.getText();
        String lastName = txtLastName.getText();
        String getDate = lblGetBirthday.getText();

        if (firstName.isEmpty() || (lastName.isEmpty() || (getDate.isEmpty()))) {
            System.out.println("Please Fill The Blanks Fieds...");
        } else {
            try {
                boolean isSaveBirth = birthdayBO.saveBirthday(
                        new BirthdayDTO(
                                firstName,
                                lastName,
                                getDate
                        ));
            } catch (Exception e) {
            }
            clearText();
            System.out.println("Birthday Save");
        }
    }

    public String getDate(String Date) {
        SimpleDateFormat simpleDateFormat = null;
        java.util.Date date = null;
        try {
            simpleDateFormat = new SimpleDateFormat("yy-MM-dd");
            date = simpleDateFormat.parse(Date);
            simpleDateFormat.applyPattern("EEEE d MMM yyyy");
        } catch (Exception e) {
        }
        return simpleDateFormat.format(date);
    }

    private void clearText(){
        txtLastName.setText(null);
        txtFirstName.setText(null);
        lblGetBirthday.setText(null);
    }
}
