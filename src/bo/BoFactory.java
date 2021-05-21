package bo;

import bo.custom.impl.BirthdayBOImpl;
import bo.custom.impl.LoginBOImpl;

public class BoFactory {

    private static BoFactory boFactory;

    private BoFactory() {
    }

    public static BoFactory getInstance() {
        return (boFactory == null) ?
                (boFactory = new BoFactory()) : (boFactory);
    }

    public enum BOType {
        LOGIN,BIRTHDAY
    }

    public <T> T getBo(BOType type) {
        switch (type) {
            case LOGIN:
                return (T) new LoginBOImpl();
            case BIRTHDAY:
                return (T) new BirthdayBOImpl();
            default:
                return null;
        }
    }

}
