package bo.custom;

import dto.LoginDTO;

public interface LoginBO {
    public boolean saveLogin(LoginDTO loginDTO)throws Exception;
    public LoginDTO getLogin(String id)throws Exception;

}
