package model;

public class Booking {
    private String name;
    private String train_No;
    private int seats;
    private String date;
    private String classType;

    public Booking(String name, String train_No, int seats, String date, String classType) {
        this.name = name;
        this.train_No = train_No;
        this.seats = seats;
        this.date = date;
        this.classType = classType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrain_No() {
        return train_No;
    }

    public void setTrain_No(String train_No) {
        this.train_No = train_No;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "name='" + name + '\'' +
                ", train_No='" + train_No + '\'' +
                ", seats='" + seats + '\'' +
                ", date='" + date + '\'' +
                ", classType='" + classType + '\'' +
                '}';
    }
}
