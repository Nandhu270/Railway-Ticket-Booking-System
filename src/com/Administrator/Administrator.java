package com.Administrator;

import model.Booking;
import model.Train;
import model.User;

import java.util.ArrayList;

public class Administrator {
    private static ArrayList<Train> trains = new ArrayList<>();
    private static ArrayList<Booking> bookings = new ArrayList<>();
    private static ArrayList<User> users = new ArrayList<>();

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
        this.getBookings().add(bookings);
    }

    public void addUsers(User user){
        this.users.add(user);
    }

    public static ArrayList<User> getUsers() {
        return users;
    }
}
