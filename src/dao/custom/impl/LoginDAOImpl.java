package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.LoginDAO;
import entity.Login;

import java.sql.ResultSet;
import java.util.List;

public class LoginDAOImpl implements LoginDAO {

    @Override
    public boolean save(Login login) throws Exception {
        return CrudUtil.execute
                ("INSERT INTO login VALUES(?,?)", login.getUsername(),login.getPassword());
    }

    @Override
    public boolean update(Login login) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public Login get(String s) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM login WHERE id=?",s);
        if (resultSet.next()) {
            return new Login(
                    resultSet.getString(1),
                    resultSet.getString(2));
        } else {
            return null;
        }
    }

    @Override
    public List<Login> getAll() throws Exception {
        return null;
    }
}
