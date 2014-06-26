package model.beans;


import java.sql.Date;

/**
 * Created by lushta on 07.06.14.
 */
public class User {
    private int id;
    private String surname;
    private String first_name;
    private String patronymic;
    private Date date_of_birth;
    private String address;
    private String phone_number;
    private int role_id;
    private String login;
    private String password;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public int getRole_id() { return role_id; }

    public void setRole_id(int role_id) { this.role_id = role_id; }

    public String getLogin() { return login; }

    public void setLogin(String login) { this.login = login; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", first_name='" + first_name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", date_of_birth=" + date_of_birth +
                ", address='" + address + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", role_id=" + role_id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
