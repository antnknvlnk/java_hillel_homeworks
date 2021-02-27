package lesson_one;

public class User extends AllUsers{
    private String fName;
    private String sName;
    private int age;
    private String mail;
    private String pass;
    public final String role = "USER";

    public User(String fName, String sName, int age, String mail, String pass) {
        this.fName = fName;
        this.sName = sName;
        this.age = age;
        this.mail = mail;
        this.pass = pass;
    }

    @Override
    public String getfName() {
        return fName;
    }

    @Override
    public void setfName(String fName) {
        this.fName = fName;
    }

    @Override
    public String getsName() {
        return sName;
    }

    @Override
    public void setsName(String sName) {
        this.sName = sName;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String getMail() {
        return mail;
    }

    @Override
    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String getPass() {
        return pass;
    }

    @Override
    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String getRole() {
        return role;
    }
}