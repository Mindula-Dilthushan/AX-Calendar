package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.BirthdayDAO;
import entity.Birthday;

import java.util.List;

public class BirthdayDAOImpl implements BirthdayDAO {

    @Override
    public boolean save(Birthday birthday) throws Exception {
        return CrudUtil.execute("INSERT INTO birthday VALUES(?,?,?)",
                birthday.getFirstName(),
                birthday.getLastName(),
                birthday.getBirthday()
        );
    }

    @Override
    public boolean update(Birthday birthday) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public Birthday get(String s) throws Exception {
        return null;
    }

    @Override
    public List<Birthday> getAll() throws Exception {
        return null;
    }
}
