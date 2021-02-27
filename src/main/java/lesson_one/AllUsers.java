package lesson_one;

public class AllUsers {
    private String fName;
    private String sName;
    private int age;
    private String mail;
    private String pass;
    private String role;

    public AllUsers(String fName, String sName, int age, String mail, String pass) {
        this.fName = fName;
        this.sName = sName;
        this.age = age;
        this.mail = mail;
        this.pass = pass;
    }

    public AllUsers() {
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRole() {
        return role;
    }
}
