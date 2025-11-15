package model;

public class Train {
    private String train_No;
    private String name;
    private String source;
    private String destination;
    private String date;
    private int seats;
    private double fare;

    public Train(String train_No, String name, String source, String destination,String date, int seats, double fare) {
        this.train_No = train_No;
        this.name = name;
        this.source = source;
        this.destination = destination;
        this.date = date;
        this.seats = seats;
        this.fare = fare;
    }

    public String getTrain_No() {
        return train_No;
    }

    public void setTrain_No(String train_No) {
        this.train_No = train_No;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    @Override
    public String toString() {
        return "Train{" +
                "train_No='" + train_No + '\'' +
                ", name='" + name + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", date='" + date + '\'' +
                ", seats=" + seats +
                ", fare=" + fare +
                '}';
    }
}
