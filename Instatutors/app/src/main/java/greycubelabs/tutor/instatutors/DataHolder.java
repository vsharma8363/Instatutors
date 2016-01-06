package greycubelabs.tutor.instatutors;

/**
 * Created by viksurf on 1/6/2016.
 */
public class DataHolder {

    private String UserName;

    private String Password;

    private boolean isTutor;

    public DataHolder(String UserName, String Password, Boolean isTutor) {
        this.UserName = UserName;
        this.Password = Password;
        this.isTutor = false;
    }

    public String getUserName() {
        return UserName;
    }

    public String Password() {return Password;}

    public Boolean isTutor() {return isTutor;}

}
