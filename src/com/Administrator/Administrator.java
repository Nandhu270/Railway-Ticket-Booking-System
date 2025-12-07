package com.Administrator;

import model.Booking;
import model.Train;
import model.User;

import java.util.ArrayList;

public class Administrator {
    private static ArrayList<Train> trains = new ArrayList<>();
    private static ArrayList<Booking> bookings = new ArrayList<>();
    private static ArrayList<User> users = new ArrayList<>();
    private static ArrayList<Booking> archivedBookings = new ArrayList<>();
    private static String loggedUser = "";

    public ArrayList<Train> getTrains() {
        return trains;
    }

    public void addTrain(Train trains) {
        this.trains.add(trains);
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public void addBooking(Booking bookings) {
        this.bookings.add(bookings);
    }

    public void addUsers(User user){
        this.users.add(user);
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void addArchivedBooking(Booking book){
        this.archivedBookings.add(book);
    }

    public ArrayList<Booking> getArchivedBooking(){
        return archivedBookings;
    }

    public void setLoggedUser(String loggedUser) {
        Administrator.loggedUser = loggedUser;
    }

    public String getLoggedUser() {
        return loggedUser;
    }
}
