//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Account {
    private int customerNumber;
    private int pinNumber;
    private double checkingBalance = 0.0;
    private double savingBalance = 0.0;
    Scanner input;
    DecimalFormat moneyFormat;

    public Account() {
        this.input = new Scanner(System.in);
        this.moneyFormat = new DecimalFormat("'$'###,##0.00");
    }

    public Account(int var1, int var2) {
        this.input = new Scanner(System.in);
        this.moneyFormat = new DecimalFormat("'$'###,##0.00");
        this.customerNumber = var1;
        this.pinNumber = var2;
    }

    public Account(int var1, int var2, double var3, double var5) {
        this.input = new Scanner(System.in);
        this.moneyFormat = new DecimalFormat("'$'###,##0.00");
        this.customerNumber = var1;
        this.pinNumber = var2;
        this.checkingBalance = var3;
        this.savingBalance = var5;
    }

    public int setCustomerNumber(int var1) {
        this.customerNumber = var1;
        return var1;
    }

    public int getCustomerNumber() {
        return this.customerNumber;
    }

    public int setPinNumber(int var1) {
        this.pinNumber = var1;
        return var1;
    }

    public int getPinNumber() {
        return this.pinNumber;
    }

    public double getCheckingBalance() {
        return this.checkingBalance;
    }

    public double getSavingBalance() {
        return this.savingBalance;
    }

    public double calcCheckingWithdraw(double var1) {
        this.checkingBalance -= var1;
        return this.checkingBalance;
    }

    public double calcSavingWithdraw(double var1) {
        this.savingBalance -= var1;
        return this.savingBalance;
    }

    public double calcCheckingDeposit(double var1) {
        this.checkingBalance += var1;
        return this.checkingBalance;
    }

    public double calcSavingDeposit(double var1) {
        this.savingBalance += var1;
        return this.savingBalance;
    }

    public void calcCheckTransfer(double var1) {
        this.checkingBalance -= var1;
        this.savingBalance += var1;
    }

    public void calcSavingTransfer(double var1) {
        this.savingBalance -= var1;
        this.checkingBalance += var1;
    }

    public void getCheckingWithdrawInput() {
        boolean var1 = false;

        while(!var1) {
            try {
                System.out.println("\nCurrent Checkings Account Balance: " + this.moneyFormat.format(this.checkingBalance));
                System.out.print("\nAmount you want to withdraw from Checkings Account: ");
                double var2 = this.input.nextDouble();
                if (this.checkingBalance - var2 >= 0.0 && var2 >= 0.0) {
                    this.calcCheckingWithdraw(var2);
                    System.out.println("\nCurrent Checkings Account Balance: " + this.moneyFormat.format(this.checkingBalance));
                    var1 = true;
                } else {
                    System.out.println("\nBalance Cannot be Negative.");
                }
            } catch (InputMismatchException var4) {
                System.out.println("\nInvalid Choice.");
                this.input.next();
            }
        }

    }

    public void getsavingWithdrawInput() {
        boolean var1 = false;

        while(!var1) {
            try {
                System.out.println("\nCurrent Savings Account Balance: " + this.moneyFormat.format(this.savingBalance));
                System.out.print("\nAmount you want to withdraw from Savings Account: ");
                double var2 = this.input.nextDouble();
                if (this.savingBalance - var2 >= 0.0 && var2 >= 0.0) {
                    this.calcSavingWithdraw(var2);
                    System.out.println("\nCurrent Savings Account Balance: " + this.moneyFormat.format(this.savingBalance));
                    var1 = true;
                } else {
                    System.out.println("\nBalance Cannot Be Negative.");
                }
            } catch (InputMismatchException var4) {
                System.out.println("\nInvalid Choice.");
                this.input.next();
            }
        }

    }

    public void getCheckingDepositInput() {
        boolean var1 = false;

        while(!var1) {
            try {
                System.out.println("\nCurrent Checkings Account Balance: " + this.moneyFormat.format(this.checkingBalance));
                System.out.print("\nAmount you want to deposit from Checkings Account: ");
                double var2 = this.input.nextDouble();
                if (this.checkingBalance + var2 >= 0.0 && var2 >= 0.0) {
                    this.calcCheckingDeposit(var2);
                    System.out.println("\nCurrent Checkings Account Balance: " + this.moneyFormat.format(this.checkingBalance));
                    var1 = true;
                } else {
                    System.out.println("\nBalance Cannot Be Negative.");
                }
            } catch (InputMismatchException var4) {
                System.out.println("\nInvalid Choice.");
                this.input.next();
            }
        }

    }

    public void getSavingDepositInput() {
        boolean var1 = false;

        while(!var1) {
            try {
                System.out.println("\nCurrent Savings Account Balance: " + this.moneyFormat.format(this.savingBalance));
                System.out.print("\nAmount you want to deposit into your Savings Account: ");
                double var2 = this.input.nextDouble();
                if (this.savingBalance + var2 >= 0.0 && var2 >= 0.0) {
                    this.calcSavingDeposit(var2);
                    System.out.println("\nCurrent Savings Account Balance: " + this.moneyFormat.format(this.savingBalance));
                    var1 = true;
                } else {
                    System.out.println("\nBalance Cannot Be Negative.");
                }
            } catch (InputMismatchException var4) {
                System.out.println("\nInvalid Choice.");
                this.input.next();
            }
        }

    }

    public void getTransferInput(String var1) {
        boolean var2 = false;

        while(!var2) {
            try {
                int var3;
                double var4;
                if (var1.equals("Checkings")) {
                    System.out.println("\nSelect an account you wish to tranfers funds to:");
                    System.out.println("1. Savings");
                    System.out.println("2. Exit");
                    System.out.print("\nChoice: ");
                    var3 = this.input.nextInt();
                    switch (var3) {
                        case 1:
                            System.out.println("\nCurrent Checkings Account Balance: " + this.moneyFormat.format(this.checkingBalance));
                            System.out.print("\nAmount you want to deposit into your Savings Account: ");
                            var4 = this.input.nextDouble();
                            if (this.savingBalance + var4 >= 0.0 && this.checkingBalance - var4 >= 0.0 && var4 >= 0.0) {
                                this.calcCheckTransfer(var4);
                                System.out.println("\nCurrent Savings Account Balance: " + this.moneyFormat.format(this.savingBalance));
                                System.out.println("\nCurrent Checkings Account Balance: " + this.moneyFormat.format(this.checkingBalance));
                                var2 = true;
                                break;
                            }

                            System.out.println("\nBalance Cannot Be Negative.");
                            break;
                        case 2:
                            return;
                        default:
                            System.out.println("\nInvalid Choice.");
                    }
                } else if (var1.equals("Savings")) {
                    System.out.println("\nSelect an account you wish to tranfers funds to: ");
                    System.out.println("1. Checkings");
                    System.out.println("2. Exit");
                    System.out.print("\nChoice: ");
                    var3 = this.input.nextInt();
                    switch (var3) {
                        case 1:
                            System.out.println("\nCurrent Savings Account Balance: " + this.moneyFormat.format(this.savingBalance));
                            System.out.print("\nAmount you want to deposit into your savings account: ");
                            var4 = this.input.nextDouble();
                            if (this.checkingBalance + var4 >= 0.0 && this.savingBalance - var4 >= 0.0 && var4 >= 0.0) {
                                this.calcSavingTransfer(var4);
                                System.out.println("\nCurrent checkings account balance: " + this.moneyFormat.format(this.checkingBalance));
                                System.out.println("\nCurrent savings account balance: " + this.moneyFormat.format(this.savingBalance));
                                var2 = true;
                                break;
                            }

                            System.out.println("\nBalance Cannot Be Negative.");
                            break;
                        case 2:
                            return;
                        default:
                            System.out.println("\nInvalid Choice.");
                    }
                }
            } catch (InputMismatchException var6) {
                System.out.println("\nInvalid Choice.");
                this.input.next();
            }
        }

    }
}
