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

    public Account(int customerNumber, int pin) {
        this.input = new Scanner(System.in);
        this.moneyFormat = new DecimalFormat("'$'###,##0.00");
        this.customerNumber = customerNumber;
        this.pinNumber = pin;
    }

    public Account(int customerNumber, int pin, double checkingBalance, double saving) {
        this.input = new Scanner(System.in);
        this.moneyFormat = new DecimalFormat("'$'###,##0.00");
        this.customerNumber = customerNumber;
        this.pinNumber = pin;
        this.checkingBalance = checkingBalance;
        this.savingBalance = saving;
    }

    public int setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
        return customerNumber;
    }

    public int getCustomerNumber() {
        return this.customerNumber;
    }

    public int setPinNumber(int pin) {
        this.pinNumber = pin;
        return pin;
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

    public double calcCheckingWithdraw(double checkingBalance) {
        this.checkingBalance -= checkingBalance;
        return this.checkingBalance;
    }

    public double calcSavingWithdraw(double savingBalance) {
        this.savingBalance -= savingBalance;
        return this.savingBalance;
    }

    public double calcCheckingDeposit(double checkingBalance) {
        this.checkingBalance += checkingBalance;
        return this.checkingBalance;
    }

    public double calcSavingDeposit(double savingBalance) {
        this.savingBalance += savingBalance;
        return this.savingBalance;
    }

    public void calcCheckTransfer(double value) {
        this.checkingBalance -= value;
        this.savingBalance += value;
    }

    public void calcSavingTransfer(double value) {
        this.savingBalance -= value;
        this.checkingBalance += value;
    }

    public void getCheckingWithdrawInput() {
        boolean isLogged = false;

        while(!isLogged) {
            try {
                System.out.println("\nCurrent Checkings Account Balance: " + this.moneyFormat.format(this.checkingBalance));
                System.out.print("\nAmount you want to withdraw from Checkings Account: ");
                double amount = this.input.nextDouble();
                if (this.checkingBalance - amount >= 0.0 && amount >= 0.0) {
                    this.calcCheckingWithdraw(amount);
                    System.out.println("\nCurrent Checkings Account Balance: " + this.moneyFormat.format(this.checkingBalance));
                    isLogged = true;
                } else {
                    System.out.println("\nBalance Cannot be Negative.");
                }
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("\nInvalid Choice.");
                this.input.next();
            }
        }

    }

    public void getsavingWithdrawInput() {
        boolean isLogged = false;

        while(!isLogged) {
            try {
                System.out.println("\nCurrent Savings Account Balance: " + this.moneyFormat.format(this.savingBalance));
                System.out.print("\nAmount you want to withdraw from Savings Account: ");
                double amount = this.input.nextDouble();
                if (this.savingBalance - amount >= 0.0 && amount >= 0.0) {
                    this.calcSavingWithdraw(amount);
                    System.out.println("\nCurrent Savings Account Balance: " + this.moneyFormat.format(this.savingBalance));
                    isLogged = true;
                } else {
                    System.out.println("\nBalance Cannot Be Negative.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Choice.");
                this.input.next();
            }
        }

    }

    public void getCheckingDepositInput() {
        boolean isLogged = false;

        while(!isLogged) {
            try {
                System.out.println("\nCurrent Checkings Account Balance: " + this.moneyFormat.format(this.checkingBalance));
                System.out.print("\nAmount you want to deposit from Checkings Account: ");
                double amount = this.input.nextDouble();
                if (this.checkingBalance + amount >= 0.0 && amount >= 0.0) {
                    this.calcCheckingDeposit(amount);
                    System.out.println("\nCurrent Checkings Account Balance: " + this.moneyFormat.format(this.checkingBalance));
                    isLogged = true;
                } else {
                    System.out.println("\nBalance Cannot Be Negative.");
                }
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("\nInvalid Choice.");
                this.input.next();
            }
        }

    }

    public void getSavingDepositInput() {
        boolean isLogged = false;

        while(!isLogged) {
            try {
                System.out.println("\nCurrent Savings Account Balance: " + this.moneyFormat.format(this.savingBalance));
                System.out.print("\nAmount you want to deposit into your Savings Account: ");
                double amount = this.input.nextDouble();
                if (this.savingBalance + amount >= 0.0 && amount >= 0.0) {
                    this.calcSavingDeposit(amount);
                    System.out.println("\nCurrent Savings Account Balance: " + this.moneyFormat.format(this.savingBalance));
                    isLogged = true;
                } else {
                    System.out.println("\nBalance Cannot Be Negative.");
                }
            } catch (InputMismatchException mismatchException) {
                System.out.println("\nInvalid Choice.");
                this.input.next();
            }
        }

    }

    public void getTransferInput(String value) {
        boolean isLogged = false;

        while(!isLogged) {
            try {
                int optionSelected;
                double amount;
                if (value.equals("Checkings")) {
                    System.out.println("\nSelect an account you wish to tranfers funds to:");
                    System.out.println("1. Savings");
                    System.out.println("2. Exit");
                    System.out.print("\nChoice: ");
                    optionSelected = this.input.nextInt();
                    switch (optionSelected) {
                        case 1:
                            System.out.println("\nCurrent Checkings Account Balance: " + this.moneyFormat.format(this.checkingBalance));
                            System.out.print("\nAmount you want to deposit into your Savings Account: ");
                            amount = this.input.nextDouble();
                            if (this.savingBalance + amount >= 0.0 && this.checkingBalance - amount >= 0.0 && amount >= 0.0) {
                                this.calcCheckTransfer(amount);
                                System.out.println("\nCurrent Savings Account Balance: " + this.moneyFormat.format(this.savingBalance));
                                System.out.println("\nCurrent Checkings Account Balance: " + this.moneyFormat.format(this.checkingBalance));
                                isLogged = true;
                                break;
                            }

                            System.out.println("\nBalance Cannot Be Negative.");
                            break;
                        case 2:
                            return;
                        default:
                            System.out.println("\nInvalid Choice.");
                    }
                } else if (value.equals("Savings")) {
                    System.out.println("\nSelect an account you wish to tranfers funds to: ");
                    System.out.println("1. Checkings");
                    System.out.println("2. Exit");
                    System.out.print("\nChoice: ");
                    optionSelected = this.input.nextInt();
                    switch (optionSelected) {
                        case 1:
                            System.out.println("\nCurrent Savings Account Balance: " + this.moneyFormat.format(this.savingBalance));
                            System.out.print("\nAmount you want to deposit into your savings account: ");
                            amount = this.input.nextDouble();
                            if (this.checkingBalance + amount >= 0.0 && this.savingBalance - amount >= 0.0 && amount >= 0.0) {
                                this.calcSavingTransfer(amount);
                                System.out.println("\nCurrent checkings account balance: " + this.moneyFormat.format(this.checkingBalance));
                                System.out.println("\nCurrent savings account balance: " + this.moneyFormat.format(this.savingBalance));
                                isLogged = true;
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
            } catch (InputMismatchException mismatchException) {
                System.out.println("\nInvalid Choice.");
                this.input.next();
            }
        }

    }
}
