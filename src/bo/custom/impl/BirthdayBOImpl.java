package bo.custom.impl;

import bo.custom.BirthdayBO;
import dao.DaoFactory;
import dao.custom.BirthdayDAO;
import dto.BirthdayDTO;
import entity.Birthday;

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
}
