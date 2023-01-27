//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class OptionMenu {
    Scanner menuInput;
    DecimalFormat moneyFormat;
    HashMap<Integer, Account> data;

    public OptionMenu() {
        this.menuInput = new Scanner(System.in);
        this.moneyFormat = new DecimalFormat("'$'###,##0.00");
        this.data = new HashMap();
    }

    public void getLogin() throws IOException {
        boolean logged = false;

        while(!logged) {
            try {
                System.out.print("\nEnter your customer number: ");
                int customerNumber = this.menuInput.nextInt();
                System.out.print("\nEnter your PIN number: ");
                int pin = this.menuInput.nextInt();
                Iterator it = this.data.entrySet().iterator();

                while(it.hasNext()) {
                    Map.Entry entry = (Map.Entry)it.next();
                    Account account = (Account)entry.getValue();
                    if (this.data.containsKey(customerNumber) && pin == account.getPinNumber()) {
                        this.getAccountType(account);
                        logged = true;
                        break;
                    }
                }

                if (!logged) {
                    System.out.println("\nWrong Customer Number or Pin Number");
                }
            } catch (InputMismatchException var7) {
                System.out.println("\nInvalid Character(s). Only Numbers.");
            }
        }

    }

    public void getAccountType(Account var1) {
        boolean isLogged = false;

        while(!isLogged) {
            try {
                System.out.println("\nSelect the account you want to access: ");
                System.out.println(" Type 1 - Checkings Account");
                System.out.println(" Type 2 - Savings Account");
                System.out.println(" Type 3 - Exit");
                System.out.print("\nChoice: ");
                int optionSelected = this.menuInput.nextInt();
                switch (optionSelected) {
                    case 1:
                        this.getChecking(var1);
                        break;
                    case 2:
                        this.getSaving(var1);
                        break;
                    case 3:
                        isLogged = true;
                        break;
                    default:
                        System.out.println("\nInvalid Choice.");
                }
            } catch (InputMismatchException var4) {
                System.out.println("\nInvalid Choice.");
                this.menuInput.next();
            }
        }

    }

    public void getChecking(Account ac) {
        boolean isLogged = false;

        while(!isLogged) {
            try {
                System.out.println("\nCheckings Account: ");
                System.out.println(" Type 1 - View Balance");
                System.out.println(" Type 2 - Withdraw Funds");
                System.out.println(" Type 3 - Deposit Funds");
                System.out.println(" Type 4 - Transfer Funds");
                System.out.println(" Type 5 - Exit");
                System.out.print("\nChoice: ");
                int optionSelected = this.menuInput.nextInt();
                switch (optionSelected) {
                    case 1:
                        DecimalFormat decimalFormat = this.moneyFormat;
                        System.out.println("\nCheckings Account Balance: " + decimalFormat.format(ac.getCheckingBalance()));
                        break;
                    case 2:
                        ac.getCheckingWithdrawInput();
                        break;
                    case 3:
                        ac.getCheckingDepositInput();
                        break;
                    case 4:
                        ac.getTransferInput("Checkings");
                        break;
                    case 5:
                        isLogged = true;
                        break;
                    default:
                        System.out.println("\nInvalid Choice.");
                }
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("\nInvalid Choice.");
                this.menuInput.next();
            }
        }

    }

    public void getSaving(Account ac) {
        boolean isLogged = false;

        while(!isLogged) {
            try {
                System.out.println("\nSavings Account: ");
                System.out.println(" Type 1 - View Balance");
                System.out.println(" Type 2 - Withdraw Funds");
                System.out.println(" Type 3 - Deposit Funds");
                System.out.println(" Type 4 - Transfer Funds");
                System.out.println(" Type 5 - Exit");
                System.out.print("Choice: ");
                int optionSelected = this.menuInput.nextInt();
                switch (optionSelected) {
                    case 1:
                        DecimalFormat decimalFormat = this.moneyFormat;
                        System.out.println("\nSavings Account Balance: " + decimalFormat.format(ac.getSavingBalance()));
                        break;
                    case 2:
                        ac.getsavingWithdrawInput();
                        break;
                    case 3:
                        ac.getSavingDepositInput();
                        break;
                    case 4:
                        ac.getTransferInput("Savings");
                        break;
                    case 5:
                        isLogged = true;
                        break;
                    default:
                        System.out.println("\nInvalid Choice.");
                }
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("\nInvalid Choice.");
                this.menuInput.next();
            }
        }

    }

    public void createAccount() throws IOException {
        int inputValue = 0;
        boolean alreadyExisting = false;

        while(!alreadyExisting) {
            try {
                System.out.println("\nEnter your customer number ");
                inputValue = this.menuInput.nextInt();
                Iterator it = this.data.entrySet().iterator();

                while(it.hasNext()) {
                 Map.Entry var4 = (Map.Entry)it.next();
                    if (!this.data.containsKey(inputValue)) {
                        alreadyExisting = true;
                    }
                }

                if (!alreadyExisting) {
                    System.out.println("\nThis customer number is already registered");
                }
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("\nInvalid Choice.");
                this.menuInput.next();
            }
        }

        System.out.println("\nEnter PIN to be registered");
        int pinValue = this.menuInput.nextInt();
        this.data.put(inputValue, new Account(inputValue, pinValue));
        System.out.println("\nYour new account has been successfuly registered!");
        System.out.println("\nRedirecting to login.............");
        this.getLogin();
    }

    public void mainMenu() throws IOException {
       this.data.put(952141, new Account(952141, 191904, 1000.0, 5000.0));
        this.data.put(123, new Account(123, 123, 20000.0, 50000.0));
        boolean isLogged = false;

        while(!isLogged) {
            try {
                System.out.println("\n Type 1 - Login");
                System.out.println(" Type 2 - Create Account");
                System.out.print("\nChoice: ");
                int optionSelected = this.menuInput.nextInt();
                switch (optionSelected) {
                    case 1:
                        this.getLogin();
                        isLogged = true;
                        break;
                    case 2:
                        this.createAccount();
                        isLogged = true;
                        break;
                    default:
                        System.out.println("\nInvalid Choice.");
                }
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("\nInvalid Choice.");
                this.menuInput.next();
            }
        }

        System.out.println("\nThank You for using this ATM.\n");
        this.menuInput.close();
        System.exit(0);
    }
}
