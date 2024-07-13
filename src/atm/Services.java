
package atm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Services {

    private List<Account> accounts; //initialize List of accounts
    private Scanner sc; // initialize Scanner 
    private Account loggedAccount;

    public Services() { //constructor
        this.accounts = new ArrayList<>(); //create object and assign to accounts
        this.sc = new Scanner(System.in);
        createDummyAccount();
    }

    private void createDummyAccount() {

        //creates dummy account ...
        accounts.add(new Account("03810017511026", "1457", 5000));
        accounts.add(new Account("123456789", "1234", 5000));

    }

    public boolean authenticateUser() {
        System.out.println("Enter Account Number");
        String accNumber = sc.nextLine();
        System.out.println("Enter PIN:");
        String pin = sc.nextLine();

//        System.out.println(accounts);
        this.loggedAccount = authenticate(accNumber, pin); // returns the account that match credentials

        return loggedAccount != null; // returns false if there is no loggedAccount received

    }

    private Account authenticate(String accNumber, String pin) {
        for (Account account : accounts) { //foreach loop to check each in account List that match both number and pin
            if (account.getAccountNumber().equals(accNumber) && account.getPin().equals(pin)) {
                return account;
            }
        }

        return null;
    }

    public void depositMoney() {
        if (this.loggedAccount != null) {
            System.out.println("Enter the amount you want to deposit");
            double amt = sc.nextDouble();
            this.loggedAccount.deposit(amt);
            System.out.println("Amount deposited successfully !");
        }
    }

    public void getBalance() {
        if (this.loggedAccount != null) {
            System.out.println("Your total available balance is Rs " + this.loggedAccount.getBalance());
        }
    }

    public void withDraw() {
        if (this.loggedAccount != null) {
            System.out.println("Enter the amount you want to withdraw");
            double amt = sc.nextDouble();

            boolean didWithDraw = loggedAccount.withDraw(amt);

            if (didWithDraw) {
                System.out.println("Amount withdraw success");
            } else {    
                System.out.println("Insufficient Amount: Transaction Cancelled");
            }
        }
    }
}
