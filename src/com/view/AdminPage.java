package com.view;

import com.Administrator.Administrator;
import model.Booking;
import model.Train;
import model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AdminPage {
    private Scanner input = new Scanner(System.in);
    private Administrator adm = new Administrator();

    private int ShowAccess(){
        System.out.println("1. Add train details");
        System.out.println("2. View All Train");
        System.out.println("3. View All Bookings");
        System.out.println("4. Filter bookings by train");
        System.out.println("5. Filter bookings by passenger");
        System.out.println("6. Filter bookings by date");
        System.out.println("7. View bookings within a date range");
        System.out.println("8. Update train details");
        System.out.println("9. Delete train details");
        System.out.println("10. View All User");
        System.out.println("11. Exit");
        System.out.print("Enter Your Choice: ");
        int Choice = input.nextInt();
        return Choice;
    }

    private void AddTrain(){
        input.nextLine();
        System.out.print("Enter Train No: ");
        String train_No = input.nextLine();
        System.out.print("Enter the Train Name: ");
        String train_Name = input.nextLine();
        System.out.print("Enter the Source: ");
        String source = input.nextLine();
        System.out.print("Enter the Destination: ");
        String destination = input.nextLine();
        System.out.print("Enter the Date(YYYY-MM-DD): ");
        String date = input.nextLine();
        System.out.print("Enter the number of Seats: ");
        int seats = input.nextInt();
        System.out.print("Enter the Fare: ");
        double fare = input.nextDouble();
        Train t = new Train(train_No,train_Name,source,destination,date,seats,fare);
        adm.addTrain(t);
        try{
            Thread.sleep(2000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("Train Added SuccessFully!...");
    }

    private void viewAllTrain(){
        ArrayList<Train> trains = adm.getTrains();
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("Train_No\tName\tSource\tDestination\tDate\tAvailable Seats\tFare");
        for (Train i : trains){
            System.out.println(i.getTrain_No()+"\t"+i.getName()+"\t"+i.getSource()+"\t"+i.getDestination()+"\t"+i.getDate()+"\t"+i.getSeats()+"\t"+i.getFare());
        }
        System.out.println();
    }

    public void viewAllBooking(){
        ArrayList<Booking> books = adm.getBookings();
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("\nName\tTrain No\tSeats Booked\tDate\tClassType");
        for(Booking i : books){
            System.out.println(i.getName()+"\t"+i.getTrain_No()+"\t"+i.getSeats()+"\t"+i.getDate()+"\t"+i.getClassType());
        }
    }

    private void filterByTrain(){
        input.nextLine();
        System.out.print("Enter the TrainNo: ");
        String train_no = input.nextLine();
        ArrayList<Train> trains = adm.getTrains();
        Train t = trains.stream().filter(train -> train.getTrain_No().equals(train_no)).findFirst().orElse(null);
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        if(t!=null){
            System.out.println("Train_No\tName\tSource\tDestination\tDate\tAvailable Seats\tFare");
            System.out.println(t.getTrain_No()+"\t"+t.getName()+"\t"+t.getSource()+"\t"+t.getDestination()+"\t"+t.getDate()+"\t"+t.getSeats()+"\t"+t.getFare()+"\n");
        } else System.out.println("Train Not Found!..\n");
    }

    private void filterByPassenger(){
        input.nextLine();
        System.out.print("Enter the Passenger Name: ");
        String cust = input.nextLine().toLowerCase().trim();
        ArrayList<Booking> bookings = adm.getBookings();
        Booking b = bookings.stream().filter(book -> book.getName().toLowerCase().trim().equals(cust)).findFirst().orElse(null);
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        if(b!=null){
            ArrayList<Train> trains = adm.getTrains();
            Train t = trains.stream().filter(train -> train.getTrain_No().equals(b.getTrain_No())).findFirst().orElse(null);
            System.out.println("Name\tTrain_No\tTrain_Name\tSource\tDestination\tDate\tFare");
            System.out.println(b.getName()+"\t"+t.getTrain_No()+"\t"+t.getName()+"\t"+t.getSource()+"\t"+t.getDestination()+"\t"+t.getDate()+"\t"+t.getFare()+"\n");
        }else System.out.println("Passenger Not Found!..\n");
    }

    private void filterByDate(){
        System.out.print("Enter the Date(YYYY-MM-DD): ");
        String date = input.next();
        ArrayList<Train> trains = adm.getTrains();
        ArrayList<Train> t = (ArrayList<Train>) trains.stream().filter(train -> train.getDate().equals(date)).collect(Collectors.toList());
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        if(t.size()!=0){
            System.out.println("Train_No\tName\tSource\tDestination\tDate\tAvailable Seats\tFare");
            for(Train i : t){
            System.out.println(i.getTrain_No()+"\t"+i.getName()+"\t"+i.getSource()+"\t"+i.getDestination()+"\t"+i.getDate()+"\t"+i.getSeats()+"\t"+i.getFare()+"\n");
            }
        }else System.out.println("Train Not Found in this Date!..\n");
    }

    private void filterByDateRange(){
        System.out.print("Enter the Start Date(YYYY-MM-DD): ");
        String d1 = input.next();
        LocalDate start = LocalDate.parse(d1);
        System.out.print("Enter the End Date(YYYY-MM-DD): ");
        String d2 = input.next();
        LocalDate end = LocalDate.parse(d2);
        ArrayList<Train> trains = adm.getTrains();
        ArrayList<Train> t = (ArrayList<Train>)trains.stream().filter(train -> {
            LocalDate d = LocalDate.parse(train.getDate());
            return !d.isBefore(start) && !d.isAfter(end);
        }).collect(Collectors.toList());
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        if(t.size()!=0){
            System.out.println("Train_No\tName\tSource\tDestination\tDate\tAvailable Seats\tFare");
            for(Train i : t){
                System.out.println(i.getTrain_No()+"\t"+i.getName()+"\t"+i.getSource()+"\t"+i.getDestination()+"\t"+i.getDate()+"\t"+i.getSeats()+"\t"+i.getFare()+"\n");
            }
        }else System.out.println("Train Not Found in this Date!..\n");
    }

    private void updateTrain(){
        input.nextLine();
        System.out.print("Enter Train No: ");
        String train_No = input.nextLine();
        System.out.print("Enter the Train Name: ");
        String train_Name = input.nextLine();
        System.out.print("Enter the Source: ");
        String source = input.nextLine();
        System.out.print("Enter the Destination: ");
        String destination = input.nextLine();
        System.out.print("Enter the Date(YYYY-MM-DD): ");
        String date = input.nextLine();
        System.out.print("Enter the number of Seats: ");
        int seats = input.nextInt();
        System.out.print("Enter the Fare: ");
        double fare = input.nextDouble();
        ArrayList<Train> trains = adm.getTrains();
        boolean updated = trains.stream().filter(train -> train.getTrain_No().equals(train_No)).findFirst().map(train -> {
            train.setTrain_No(train_No);
            train.setName(train_Name);
            train.setSource(source);
            train.setDestination(destination);
            train.setDate(date);
            train.setSeats(seats);
            train.setFare(fare);
            return true;
        }).orElse(false);
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println(e);
        }
        if(updated) System.out.println("Updated SuccessFully!...\n");
        else System.out.println("Train Not Found!...\n");
    }

    private void deleteTrain(){
        ArrayList<Train> trains = adm.getTrains();
        System.out.print("Enter the Train No to Delete: ");
        String train_no = input.next();
        boolean removed = trains.removeIf(train->train.getTrain_No().equals(train_no));
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        if(removed) System.out.println("Train Deleted SuccessFully!..\n");
        else System.out.println("Train Not Found!...\n");
    }

    private void viewAllUser(){
        ArrayList<User> users = adm.getUsers();
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("User_Name\tName\tPhone Number");
        for (User i : users){
            System.out.println(i.getU_Name()+"\t"+i.getName()+"\t"+i.getPh_Number());
        }
        System.out.println();
    }

    public void Administration(){
        int choice;
        do{
            choice = ShowAccess();
            switch (choice){
                case 1: AddTrain();break;
                case 2: viewAllTrain();break;
                case 3: viewAllBooking();break;
                case 4: filterByTrain();break;
                case 5: filterByPassenger();break;
                case 6: filterByDate();break;
                case 7: filterByDateRange();break;
                case 8: updateTrain();break;
                case 9: deleteTrain();break;
                case 10: viewAllUser();break;
            }
        }while (choice<11);
    }
}
