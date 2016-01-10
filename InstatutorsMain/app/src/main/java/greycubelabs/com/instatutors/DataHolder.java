package greycubelabs.com.instatutors;

/**
 * Created by viksurf on 1/6/2016.
 */
public class DataHolder {

    private String UserName;

    private String Password;

    private String Description;

    private Boolean IsTutor;

    public DataHolder(String UserName, String Password, String Description, Boolean IsTutor) {
        this.UserName = UserName;
        this.Password = Password;
        this.Description = Description;
        this.IsTutor = IsTutor;
    }

    public String getUserName() {
        return UserName;
    }

    public String Password() {return Password;}

    public String Description() {return Description;}

    public Boolean IsTutor() {return IsTutor;}

}
