package bo.custom.impl;

import bo.custom.LoginBO;
import dao.DaoFactory;
import dao.custom.LoginDAO;
import dto.LoginDTO;
import entity.Login;

public class LoginBOImpl implements LoginBO {

    //Property Injection
    private LoginDAO loginDAO = DaoFactory.getInstance().getDao(DaoFactory.DAOType.LOGIN);

    @Override
    public boolean saveLogin(LoginDTO loginDTO) throws Exception {
        return loginDAO.save(new Login(loginDTO.getUsername(),loginDTO.getPassword()));
    }

    @Override
    public LoginDTO getLogin(String id) throws Exception {
        Login login=loginDAO.get(id);
        return new LoginDTO(login.getUsername(),login.getPassword());
    }
}
