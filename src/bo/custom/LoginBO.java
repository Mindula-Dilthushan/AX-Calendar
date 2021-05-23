//Mindula Dilthushan
//AX Calendar v1.0.0
package bo.custom;

import dto.LoginDTO;

public interface LoginBO {
    public boolean saveLogin(LoginDTO loginDTO)throws Exception;
    public LoginDTO getLogin(String id)throws Exception;

}
