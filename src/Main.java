import com.Administrator.Administrator;
import com.view.AdminPage;
import com.view.ClerkPage;
import com.view.UserPage;
import model.Train;
import model.Booking;
import model.User;

import java.util.ArrayList;
import java.util.Scanner;


public class Main{

    private static final Scanner input = new Scanner(System.in);
    private static final Administrator adm = new Administrator();

    public static void adminLogin(){
        System.out.print("Enter admin UserName: ");
        String u_name = input.next();
        System.out.print("Enter the Password: ");
        String password = input.next();

        if(u_name.equals("admin") && password.equals("123")){
            AdminPage adminPage = new AdminPage();
            adminPage.Administration();
        }else{
            System.out.println("Please Enter the Correct UserName or Password!..`");
        }


    }

    public static void ClerkLogin(){
        System.out.print("Enter the Clerk Username: ");
        String u_name = input.next();
        System.out.print("Enter the Password: ");
        String password = input.next();
        if(u_name.equals("clerk") && password.equals("123")){
            ClerkPage clerkPage = new ClerkPage();
            clerkPage.Administrator();
        }else System.out.println("Enter the Valid Username and Password!...");
    }

    public static void userRegister(){
        input.nextLine();
        System.out.print("Enter Your User Name: ");
        String u_name = input.nextLine();
        System.out.print("Enter Your Name: ");
        String name = input.nextLine();
        System.out.print("Enter Your Password: ");
        String password = input.nextLine();
        System.out.print("Enter Your Phone Number: ");
        String ph_number = input.nextLine();
        User user = new User(u_name,name,password,ph_number);
        ArrayList<User> reg_user = adm.getUsers();
        boolean match = reg_user.stream().anyMatch(u->u.getU_Name().equals(u_name));
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        if(!match) {
            adm.addUsers(user);
            System.out.println("User Registered Successfully!...");
        }
        else{
            System.out.println("User Already Found!...");
        }
    }

    public static void userLogin(){
        input.nextLine();
        System.out.print("Enter Your User Name: ");
        String u_name = input.nextLine();
        System.out.print("Enter Your Password: ");
        String password = input.nextLine();
        ArrayList<User> users = adm.getUsers();
        User user_val = users.stream().filter(u -> u.getU_Name().equals(u_name)).findFirst().orElse(null);
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        if(user_val!=null){
            if(user_val.getPassword().equals(password)){
                UserPage user = new UserPage();
                adm.setLoggedUser(u_name);
                user.Administrator();
            }else System.out.println("Password is Wrong!...");
        }else{
            System.out.println("User Doesn't Exist!...");
        }
    }

    public static void UserLogin(){
        int choice;
        do{
            System.out.println("1.User Register");
            System.out.println("2.User Login");
            System.out.println("3.Exit");
            System.out.print("Enter your Choice: ");
            choice = input.nextInt();
            switch (choice){
                case 1: userRegister();break;
                case 2: userLogin();break;
            }
        }while (choice<3);
    }

    public static void main(String[] args) {

        adm.addTrain(new Train("101", "Shatabdi", "Chennai", "Bangalore", "2025-11-13", 120, 450.0));
        adm.addTrain(new Train("102", "Express", "Mumbai", "Delhi", "2025-11-13", 90, 600.0));
        adm.addTrain(new Train("103", "SuperFast", "Hyderabad", "Chennai", "2025-11-15", 75, 350.0));
        adm.addTrain(new Train("104", "JanShatabdi", "Delhi", "Jaipur", "2025-11-16", 110, 300.0));
        adm.addTrain(new Train("105", "InterCity", "Bangalore", "Mysore", "2025-11-17", 80, 150.0));
        adm.addTrain(new Train("106", "Duronto", "Kolkata", "Mumbai", "2025-11-18", 140, 850.0));
        adm.addTrain(new Train("107", "GaribRath", "Chennai", "Hyderabad", "2025-11-13", 200, 400.0));
        adm.addTrain(new Train("108", "Delhi Express", "Mumbai", "Delhi", "2025-11-13", 90, 600.0));

        adm.addBooking(new Booking("Nandha", "101", 5,  "2025-11-13", "A"));
        adm.addBooking(new Booking("Rahul",  "102", 2,  "2025-11-14", "B"));
        adm.addBooking(new Booking("Meera",  "103", 4,  "2025-11-15", "A"));
        adm.addBooking(new Booking("Arun",   "104", 1,  "2025-11-16", "C"));
        adm.addBooking(new Booking("Sita",   "105", 3,  "2025-11-17", "A"));
        adm.addBooking(new Booking("Vikram", "106", 6,  "2025-11-18", "B"));
        adm.addBooking(new Booking("Laksh",  "107", 2,  "2025-11-19", "A"));

        adm.addUsers(new User("Nandha", "Nandha", "123", "7402137149"));
        adm.addUsers(new User("Kishore", "kish123", "pass001", "9876543210"));
        adm.addUsers(new User("Priya", "priya07", "p@ssword", "9123456780"));
        adm.addUsers(new User("Rahul", "rahul_k", "rahul2024", "9090909090"));
        adm.addUsers(new User("Sangeetha", "sangi", "sang!55", "8001234567"));
        adm.addUsers(new User("Vignesh", "vicky_v", "vignesh12", "9500012345"));
        adm.addUsers(new User("Harish", "harishh", "hari#123", "9797979797"));
        adm.addUsers(new User("Meena", "meena_m", "meen@456", "8222334455"));
        adm.addUsers(new User("Arun", "arun_a", "arunArun", "7550123456"));
        adm.addUsers(new User("Divya", "divya_d", "divya789", "8070605040"));
        adm.addUsers(new User("Siva", "siva_s", "siv@321", "9008007006"));


        System.out.println("Welcome Railway to Railway Ticket Booking Console!......");
        boolean flg = true;
        while(flg){
            System.out.println("1.Admin Login\n2.Clerk Login\n3.User\n4.Exit");
            System.out.print("Enter Your Choice: ");
            int login_var = input.nextInt();
            switch(login_var){
                case 1 : adminLogin();break;
                case 2 : ClerkLogin();break;
                case 3 : UserLogin();break;
                default : flg = false;break;
            }
        }
    }
}