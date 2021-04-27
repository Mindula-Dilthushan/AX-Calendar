package dao;

import dao.custom.impl.LoginDAOImpl;

public class DaoFactory {

    private static DaoFactory daoFactory;

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        return (daoFactory == null) ?
                (daoFactory = new DaoFactory()) : (daoFactory);
    }

    public enum DAOType {
        LOGIN
    }

    public <T> T getDao(DAOType type) {
        switch (type) {
            case LOGIN:
                return (T) new LoginDAOImpl();
            default:
                return null;
        }
    }

}
