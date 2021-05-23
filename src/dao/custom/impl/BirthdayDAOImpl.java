package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.BirthdayDAO;
import entity.Birthday;
import java.sql.ResultSet;
import java.util.ArrayList;
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
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM birthday");
        ArrayList<Birthday> birthdayArrayList = new ArrayList<>();
        while (resultSet.next()) {
            birthdayArrayList.add(
                    new Birthday(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3)
                    )
            );
        }
        return birthdayArrayList;
    }
}
