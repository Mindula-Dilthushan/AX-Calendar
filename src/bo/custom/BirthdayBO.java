//Mindula Dilthushan
//AX Calendar v1.0.0
package bo.custom;

import dto.BirthdayDTO;
import java.util.ArrayList;

public interface BirthdayBO {

    public boolean saveBirthday(BirthdayDTO birthdayDTO)throws Exception;
    public ArrayList<BirthdayDTO> getAll()throws Exception;
}
