package kly.edu.ChernobylTours.form;

public class ParticipantsForm {

    private String id;
    private String name;
    private String phone;
    private String email;
    private String passport;

    public ParticipantsForm(){}

    public ParticipantsForm(String id, String name, String phone, String email, String passport) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.passport = passport;
    }

    public ParticipantsForm(String name, String phone, String email, String passport) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.passport = passport;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

}
