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
        boolean var1 = false;
        boolean var2 = false;
        boolean var3 = false;

        while(!var1) {
            try {
                System.out.print("\nEnter your customer number: ");
                int var8 = this.menuInput.nextInt();
                System.out.print("\nEnter your PIN number: ");
                int var9 = this.menuInput.nextInt();
                Iterator var4 = this.data.entrySet().iterator();

                while(var4.hasNext()) {
                    Map.Entry var5 = (Map.Entry)var4.next();
                    Account var6 = (Account)var5.getValue();
                    if (this.data.containsKey(var8) && var9 == var6.getPinNumber()) {
                        this.getAccountType(var6);
                        var1 = true;
                        break;
                    }
                }

                if (!var1) {
                    System.out.println("\nWrong Customer Number or Pin Number");
                }
            } catch (InputMismatchException var7) {
                System.out.println("\nInvalid Character(s). Only Numbers.");
            }
        }

    }

    public void getAccountType(Account var1) {
        boolean var2 = false;

        while(!var2) {
            try {
                System.out.println("\nSelect the account you want to access: ");
                System.out.println(" Type 1 - Checkings Account");
                System.out.println(" Type 2 - Savings Account");
                System.out.println(" Type 3 - Exit");
                System.out.print("\nChoice: ");
                int var3 = this.menuInput.nextInt();
                switch (var3) {
                    case 1:
                        this.getChecking(var1);
                        break;
                    case 2:
                        this.getSaving(var1);
                        break;
                    case 3:
                        var2 = true;
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

    public void getChecking(Account var1) {
        boolean var2 = false;

        while(!var2) {
            try {
                System.out.println("\nCheckings Account: ");
                System.out.println(" Type 1 - View Balance");
                System.out.println(" Type 2 - Withdraw Funds");
                System.out.println(" Type 3 - Deposit Funds");
                System.out.println(" Type 4 - Transfer Funds");
                System.out.println(" Type 5 - Exit");
                System.out.print("\nChoice: ");
                int var3 = this.menuInput.nextInt();
                switch (var3) {
                    case 1:
                        DecimalFormat var10001 = this.moneyFormat;
                        System.out.println("\nCheckings Account Balance: " + var10001.format(var1.getCheckingBalance()));
                        break;
                    case 2:
                        var1.getCheckingWithdrawInput();
                        break;
                    case 3:
                        var1.getCheckingDepositInput();
                        break;
                    case 4:
                        var1.getTransferInput("Checkings");
                        break;
                    case 5:
                        var2 = true;
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

    public void getSaving(Account var1) {
        boolean var2 = false;

        while(!var2) {
            try {
                System.out.println("\nSavings Account: ");
                System.out.println(" Type 1 - View Balance");
                System.out.println(" Type 2 - Withdraw Funds");
                System.out.println(" Type 3 - Deposit Funds");
                System.out.println(" Type 4 - Transfer Funds");
                System.out.println(" Type 5 - Exit");
                System.out.print("Choice: ");
                int var3 = this.menuInput.nextInt();
                switch (var3) {
                    case 1:
                        DecimalFormat var10001 = this.moneyFormat;
                        System.out.println("\nSavings Account Balance: " + var10001.format(var1.getSavingBalance()));
                        break;
                    case 2:
                        var1.getsavingWithdrawInput();
                        break;
                    case 3:
                        var1.getSavingDepositInput();
                        break;
                    case 4:
                        var1.getTransferInput("Savings");
                        break;
                    case 5:
                        var2 = true;
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

    public void createAccount() throws IOException {
        int var1 = 0;
        boolean var2 = false;

        while(!var2) {
            try {
                System.out.println("\nEnter your customer number ");
                var1 = this.menuInput.nextInt();
                Iterator var3 = this.data.entrySet().iterator();

                while(var3.hasNext()) {
                    Map.Entry var4 = (Map.Entry)var3.next();
                    if (!this.data.containsKey(var1)) {
                        var2 = true;
                    }
                }

                if (!var2) {
                    System.out.println("\nThis customer number is already registered");
                }
            } catch (InputMismatchException var5) {
                System.out.println("\nInvalid Choice.");
                this.menuInput.next();
            }
        }

        System.out.println("\nEnter PIN to be registered");
        int var6 = this.menuInput.nextInt();
        this.data.put(var1, new Account(var1, var6));
        System.out.println("\nYour new account has been successfuly registered!");
        System.out.println("\nRedirecting to login.............");
        this.getLogin();
    }

    public void mainMenu() throws IOException {
        this.data.put(952141, new Account(952141, 191904, 1000.0, 5000.0));
        this.data.put(123, new Account(123, 123, 20000.0, 50000.0));
        boolean var1 = false;

        while(!var1) {
            try {
                System.out.println("\n Type 1 - Login");
                System.out.println(" Type 2 - Create Account");
                System.out.print("\nChoice: ");
                int var2 = this.menuInput.nextInt();
                switch (var2) {
                    case 1:
                        this.getLogin();
                        var1 = true;
                        break;
                    case 2:
                        this.createAccount();
                        var1 = true;
                        break;
                    default:
                        System.out.println("\nInvalid Choice.");
                }
            } catch (InputMismatchException var3) {
                System.out.println("\nInvalid Choice.");
                this.menuInput.next();
            }
        }

        System.out.println("\nThank You for using this ATM.\n");
        this.menuInput.close();
        System.exit(0);
    }
}
