package lesson_three.entity;

public class Client {
    private String userID;
    private String surname;
    private String accountID;
    private float amount;

    public Client(String userID, String surname, String accountID, float amount) {
        this.userID = userID;
        this.surname = surname;
        this.accountID = accountID;
        this.amount = amount;
    }

    public Client() {}

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
