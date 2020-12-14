package latihan;
import java.util.Scanner;
import java.io.*;

public class MainClass {
    public static void checkBalance() {
        System.out.println("\tYour current balance is : " + BalanceInquiry.getBalance());
    }
    public static void withdrawMoney() {
        if (BalanceInquiry.balance == 0){
            System.out.println("\tYour current balance is zero");
            System.out.println("\tAnda miskin?");
            System.out.println("\tMakanya kerja!");
        } else if (BalanceInquiry.balance <= 500) {
            System.out.println("\tDuwitmu ra cukup");
            System.out.println("\tNdang diisi lur");
        } else if (Withdraw.withdraw > BalanceInquiry.balance) {
            System.out.println("\tLha matane picek, ra cukup kuwi!");
            System.out.println("\tLiat dulu jumlahnya sianying");
        } else {
            BalanceInquiry.balance = BalanceInquiry.balance - Withdraw.withdraw;
            System.out.println("\tYawes nyoh " + Withdraw.withdraw);
        }
    }
    public static void depositMoney() {
        System.out.println("\tBerhasil deposit sejumlah : " + Deposit.getDeposit());
    }
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int select = 0;
        int choice = 0;

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println("\tSelamat Datang di Simple ATM");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println();

        do {
            try {
                do {
                    System.out.println("\tPlease select ATM Transactions");
                    System.out.println("\tPress [1] Deposit");
                    System.out.println("\tPress [2] Withdraw");
                    System.out.println("\tPress [3] Balance Inquiry");
                    System.out.println("\tPress [4] Exit");

                    System.out.println("\n\tMau ngapain?");
                    select = read.nextInt();

                    if (select > 4) {
                        System.out.println("\n\tSalah goblok");
                    } else {
                        switch(select) {
                            case 1 :
                            System.out.println("\n\tInput jumlah deposit");
                            Deposit.deposit = read.nextDouble();
                            BalanceInquiry.balance = BalanceInquiry.balance + Deposit.deposit;
                            depositMoney();
                            break;

                            case 2 :
                            System.out.println("\n\tPastikan saldo anda cukup");
                            System.out.println();
                            System.out.println("\n\tInput jumlah penarikan");
                            Withdraw.withdraw = read.nextDouble();
                            withdrawMoney();
                            break;

                            case 3 :
                            checkBalance();
                            break;

                            default :
                            System.out.println("\n\tBeres");
                            break;
                        }
                    }
                } while (select > 4);
                do {
                    try {
                        System.out.println("\n\tWould you like to try another transaction?");
                        System.out.println("\n\tPress [1] Yes \n\tPress [2] No");
                        System.out.println("\tSilahkan pilih");
                        choice = read.nextInt();

                        if (choice > 2) {
                            System.out.println("\n\tYang bener dong sayang");
                        }
                    } catch (Exception e) {
                        //TODO: handle exception
                        System.out.println("\tEROR! Angka doang!");
                        read = new Scanner(System.in);
                        System.out.println("\tPilih");
                        choice = read.nextInt();
                    }
                } while (choice > 2);
            } catch (Exception e) {
                //TODO: handle exception
                System.out.println("\tERROR! Angka doang!");
                read = new Scanner(System.in);
                System.out.println("\tPilih");
                choice = read.nextInt();
            }
        } while (choice <= 1);
        System.out.println("\n\tSuwun lur");
    }
}
