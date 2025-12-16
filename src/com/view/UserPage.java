package com.view;

import com.Administrator.Administrator;
import model.Booking;
import model.Train;
import model.User;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UserPage {

     private Scanner input = new Scanner(System.in);
     private Administrator adm = new Administrator();

    private int showInfo(){
        System.out.println("1.View Profile");
        System.out.println("2.Edit Profile");
        System.out.println("3.Search Train");
        System.out.println("4.View personal booking history");
        System.out.println("5.Exit");
        System.out.print("Enter Your Choice: ");
        int choice = input.nextInt();
        return choice;
    }

    private String getloggedUser(){
        return adm.getLoggedUser();
    }

    private void viewProfile(){
        String logged_user = getloggedUser();
        ArrayList<User> users = adm.getUsers();
        User user = users.stream().filter(u->u.getU_Name().equals(logged_user)).findFirst().orElse(null);
        try{
            Thread.sleep(1000);
        }catch (Exception  e){
            System.out.println(e.getMessage());
        }
        if(user!=null){
            System.out.println("UserName: "+user.getU_Name());
            System.out.println("Name: "+user.getName());
            System.out.println("Phone Number: "+user.getPh_Number());
            System.out.println("Password: "+user.getPassword());
        }else{
            System.out.println("User Not Found with this UserName!...");
        }
    }

    private void editProfile(){
        input.nextLine();
        System.out.print("Enter Your Name: ");
        String name = input.nextLine();
        System.out.print("Enter Your Phone Number: ");
        String ph_number = input.nextLine();
        String logged_user = getloggedUser();
        ArrayList<User> users = adm.getUsers();
        User user = users.stream().filter(u->u.getU_Name().equals(logged_user)).findFirst().orElse(null);
        try{
            Thread.sleep(1000);
        }catch (Exception  e){
            System.out.println(e.getMessage());
        }
        if(user!=null){
            user.setName(name);
            user.setPh_Number(ph_number);
            System.out.println("User Details Updated SuccessFully!....");
        }else{
            System.out.println("User Not Found with this UserName!...");
        }
    }

    private void searchTrain(){
        input.nextLine();
        System.out.print("Enter the Source: ");
        String source = input.nextLine();
        System.out.print("Enter the Destination: ");
        String destination = input.nextLine();
        System.out.print("Enter the Date(YYYY-MM-DD): ");
        String date = input.next();
        ArrayList<Train> trains = adm.getTrains();
        ArrayList<Train> train = trains.stream().filter(t->t.getSource().equalsIgnoreCase(source.trim()) && t.getDestination().equalsIgnoreCase(destination.trim()) && t.getDate().equals(date)).collect(Collectors.toCollection(ArrayList::new));
        System.out.println("Train_No\tName\tSource\tDestination\tDate\tAvailable Seats\tFare");
        for (Train i : train){
            System.out.println(i.getTrain_No()+"\t"+i.getName()+"\t"+i.getSource()+"\t"+i.getDestination()+"\t"+i.getDate()+"\t"+i.getSeats()+"\t"+i.getFare());
        }
        System.out.println();
    }

    private void viewPersonalBooking(){
        String user = getloggedUser();
        ArrayList<User> users = adm.getUsers();
        User u_name = users.stream().filter(u->u.getU_Name().equals(user)).findFirst().orElse(null);
        if(u_name==null){
            System.out.println("User Not Found!...");
            return;
        }
        String name = u_name.getName();
        ArrayList<Booking> bookings = adm.getBookings();
        ArrayList<Booking> archived = adm.getArchivedBooking();
        ArrayList<Booking> personalBook = bookings.stream().filter(booking -> booking.getName().equals(name)).collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Booking> archivedBook = archived.stream().filter(arch -> arch.getName().equals(name)).collect(Collectors.toCollection(ArrayList::new));

        try{
            Thread.sleep(1000);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        if(personalBook.isEmpty()){
            System.out.println("\nNo Personal Booking Found!....");
        }else{
            System.out.println("\nCurrent Bookings: ");
            System.out.println("\nName\tTrain No\tSeats Booked\tDate\tClassType");
            for(Booking i : personalBook){
                System.out.println(i.getName()+"\t"+i.getTrain_No()+"\t"+i.getSeats()+"\t"+i.getDate()+"\t"+i.getClassType());
            }
            System.out.println();
        }
        if(archivedBook.isEmpty()){
            System.out.println("\nNo Archived Booking Found!....\n");
        }else{
            System.out.println("\nArchived Bookings: ");
            System.out.println("\nName\tTrain No\tSeats Booked\tDate\tClassType");
            for(Booking i : archivedBook){
                System.out.println(i.getName()+"\t"+i.getTrain_No()+"\t"+i.getSeats()+"\t"+i.getDate()+"\t"+i.getClassType());
            }
            System.out.println();
        }
    }

    public void Administrator(){
        int choice;
        do{
            choice = showInfo();
            switch (choice){
                case 1: viewProfile();break;
                case 2: editProfile();break;
                case 3: searchTrain();break;
                case 4: viewPersonalBooking();break;
            }
        }while (choice<5);
    }

}
