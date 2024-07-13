package atm;

import java.util.Scanner;

public class AtmMenu {
    private Services services;
    private Scanner sc;
    
    public AtmMenu(){
        //creating objects with constructor 
        services = new Services();
        sc = new Scanner(System.in);
    }
    
    public void displayMenu(){
        boolean authenticated = false;
        //initially authenticated is false
        while(!authenticated){
        //means until not authenticated it runs
            System.out.println("Welcome to Rohans ATM");
            authenticated = services.authenticateUser();
            //a method in service class that take accNumbeer and pin and verify
            
            if(!authenticated){ //if not valid 
                System.out.println("Invalid details");
            }
        }
        //once the above loop exits this loops runs 
        while(true){
            System.out.println("\nATM Main Menu");
            System.out.println("1. View Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    services.getBalance();
                    break;
                case 2:
                    services.depositMoney();
                    break;
                case 3:
                    services.withDraw();
                    break;
                case 4:
                    System.out.println("Thank you for using Rohans ATM. Come Again!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
}
