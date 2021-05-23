//Mindula Dilthushan
//AX Calendar v1.0.0
package bo.custom.impl;

import bo.custom.BirthdayBO;
import dao.DaoFactory;
import dao.custom.BirthdayDAO;
import dto.BirthdayDTO;
import entity.Birthday;
import java.util.ArrayList;
import java.util.List;

public class BirthdayBOImpl implements BirthdayBO {

    //Property Injection
    private BirthdayDAO birthdayDAO = DaoFactory.getInstance().getDao(DaoFactory.DAOType.BIRTHDAY);

    @Override
    public boolean saveBirthday(BirthdayDTO birthdayDTO) throws Exception {
        return birthdayDAO.save(
                new Birthday(
                        birthdayDTO.getFirstName(),
                        birthdayDTO.getLastName(),
                        birthdayDTO.getBirthday()
                )
        );
    }

    @Override
    public ArrayList<BirthdayDTO> getAll() throws Exception {
        List<Birthday> birthdayList=birthdayDAO.getAll();
        ArrayList<BirthdayDTO> birthdayDTOArrayList= new ArrayList();
            for (Birthday birthday : birthdayList) {

                birthdayDTOArrayList.add(new BirthdayDTO(
                            birthday.getFirstName(),
                            birthday.getLastName(),
                            birthday.getBirthday()
                        )
                );
            }
            return birthdayDTOArrayList;
    }
}
