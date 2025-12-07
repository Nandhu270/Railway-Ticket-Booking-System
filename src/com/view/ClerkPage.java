package com.view;

import com.Administrator.Administrator;
import model.Booking;
import model.Train;

import java.util.ArrayList;
import java.util.Scanner;

public class ClerkPage {

    private Scanner input = new Scanner(System.in);
    public Administrator adm = new Administrator();

    private int showAccess(){
        System.out.println("1.Book a Ticket");
        System.out.println("2.Update Booking");
        System.out.println("3.Cancel Booking");
        System.out.println("4.Exit");
        System.out.print("Enter Your Choice: ");
        int choice = input.nextInt();
        return  choice;
    }

    private void invoice(Train t, int u_seat,String name, String cls_type){
        System.out.println("\n---------------INVOICE---------------");
        System.out.println("Name: "+name);
        System.out.println("Train No: "+t.getTrain_No());
        System.out.println("Source: "+t.getSource());
        System.out.println("Destination: "+t.getDestination());
        System.out.println("Class Type: "+cls_type);
        System.out.println("Number of Tickets: "+u_seat);
        System.out.println("Total Price Ticket: "+u_seat*t.getFare());
        System.out.println("Thank You!...Visit Again!...\n");
    }

    private void bookTicket(){
        input.nextLine();
        System.out.print("Enter Your Name: ");
        String name = input.nextLine();
        System.out.print("Enter the TrainNo to Book: ");
        String train_no = input.nextLine();
        System.out.print("Enter the Date(YYYY-MM-DD): ");
        String date = input.nextLine();
        System.out.print("Enter the Seats: ");
        int seats = input.nextInt();
        System.out.print("Enter the Class Type(A,B,C): ");
        String class_type = input.next().toUpperCase();
        ArrayList<Train> trains = adm.getTrains();
        Train t = trains.stream().filter(train-> train.getTrain_No().equals(train_no) && train.getDate().equals(date)).findFirst().orElse(null);
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        if(t!=null){
            int seat = t.getSeats();
            if(seats > seat) {
                System.out.println("Only"+seat+"is Available");
                return;
            }
            if(!class_type.equals("A") && !class_type.equals("B") && !class_type.equals("C")){
                System.out.println("Please Choose the Correct Class Type");
                return;
            }
            t.setSeats(seat-seats);
            Booking book = new Booking(name, train_no, seats, date, class_type);
            adm.addBooking(book);
            System.out.println("Ticket Booked SuccessFully!....");
            invoice(t,seats,name,class_type);
        }else System.out.println("Train Not Found!...");
    }

    private void updateBook(){
        input.nextLine();
        System.out.print("Enter Your Name: ");
        String name = input.nextLine();
        ArrayList<Booking> books = adm.getBookings();
        Booking b = books.stream().filter(book -> book.getName().toLowerCase().trim().equals(name.toLowerCase().trim())).findFirst().orElse(null);
        if(b==null){
            System.out.println("Passenger not Found in this Name");
            return;
        }
        ArrayList<Train> trains = adm.getTrains();
        Train t = trains.stream().filter(train -> train.getTrain_No().equals(b.getTrain_No())).findFirst().orElse(null);
        if(t==null){
            System.out.println("Train not Found!...");
            return;
        }
        int seat = t.getSeats();
        t.setSeats(seat + b.getSeats());
        int availableSeat = t.getSeats();
        System.out.print("Enter the Seats: ");
        int requestedSeats = input.nextInt();
        System.out.print("Enter the Class Type(A,B,C): ");
        String class_type = input.next().toUpperCase();
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        if(requestedSeats > availableSeat){
            System.out.println("Only "+availableSeat+"is Available");
            return;
        }
        if(!class_type.equals("A") && !class_type.equals("B") && !class_type.equals("C")){
            System.out.println("Please Choose the Correct Class Type");
            return;
        }
        t.setSeats(availableSeat - requestedSeats);
        b.setSeats(requestedSeats);
        b.setClassType(class_type);
        System.out.println("Ticket Updated SuccessFully!....");
        invoice(t,requestedSeats,name,class_type);
    }

    private void cancelBook(){
        input.nextLine();
        System.out.print("Enter your Name to cancel Ticket: ");
        String name = input.nextLine().toLowerCase().trim();
        ArrayList<Booking> books = adm.getBookings();
        ArrayList<Train> trains = adm.getTrains();
        Booking b = books.stream().filter(booking -> booking.getName().equalsIgnoreCase(name.trim())).findFirst().orElse(null);
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        if(b!=null){
            Train t = trains.stream().filter(train -> train.getTrain_No()==b.getTrain_No()).findFirst().orElse(null);
            t.setSeats(t.getSeats() + b.getSeats());
            adm.addArchivedBooking(b);
            boolean removed = books.remove(b);
            if(removed) System.out.println("Booking Deleted Successfully!...");
            else  System.out.println("Failed to delete booking from list!...");
        }else{
            System.out.println("Booking Not Found in this Name!...");
        }
    }

    public void Administrator(){
        int choice;
        do{
            choice = showAccess();
            switch (choice){
                case 1: bookTicket();break;
                case 2: updateBook();break;
                case 3: cancelBook();break;
            }
        }while(choice<4);
    }
}
