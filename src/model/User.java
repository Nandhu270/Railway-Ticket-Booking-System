package model;

public class User {
    private String u_Name;
    private String name;
    private String password;
    private String ph_Number;

    public User(String u_Name,String name, String password, String ph_Number) {
        this.u_Name = u_Name;
        this.name = name;
        this.password = password;
        this.ph_Number = ph_Number;
    }

    public String getU_Name() {
        return u_Name;
    }

    public void setU_Name(String u_Name) {
        this.u_Name = u_Name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPh_Number() {
        return ph_Number;
    }

    public void setPh_Number(String ph_Number) {
        this.ph_Number = ph_Number;
    }

    @Override
    public String toString() {
        return "User{" +
                "u_Name='" + u_Name + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", ph_Number='" + ph_Number + '\'' +
                '}';
    }
}